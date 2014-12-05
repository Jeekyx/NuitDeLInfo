class VolunteersController < ApplicationController
  before_filter :fetch_user, except: [:index, :show]
  before_filter :fetch_model, except: [:index, :create]

  def index
    @volunteers = Volunteer.all
    render json: { volunteers: JSON.parse(@volunteers.to_json(include: [:campaigns, :registrations])) }
  end

  def create
    @volunteer = Volunteer.new(model_params)

    if @volunteer.save
      render json: @volunteer, status: :created
    else
      render json: @volunteer.errors, status: :unprocessable_entity
    end
  end

  def update
    if @volunteer.update_attributes(model_params)
      head :no_content, status: :ok
    else
      render json: @volunteer.errors, status: :unprocessable_entity
    end
  end

  def destroy
    if @volunteer.destroy
      head :no_content, status: :ok
    else
      render json: @volunteer.errors, status: :unprocessable_entity
    end
  end

  def create_registration
    @registration = @user.volunteer.registrations.new
    @registration.campaign_id = params[:campaign_id]
    @registration.status = 0

    if @registration.save
      render json: @registration, status: :created
    else
      render json: @registration.errors, status: :unprocessable_entity
    end
  end

  def create_flux
    flux_params = params.require(:flux).permit(:picture, :message)
    @flux = @user.fluxes.new(flux_params)
    @flux.campaign_id = params[:campaign_id]

    if @flux.save
      render json: @flux, status: :created
    else
      render json: @flux.errors, status: :unprocessable_entity
    end
  end

  private
    def fetch_user
      token = request.headers['Auth-token']
      head :unauthorized unless token

      @user = User.find_by_token(token)
      head :unauthorized unless @user && @user.type.name == "Volunteer" && @user.volunteer.id == params[:volunteer_id].to_i
    end

    def fetch_model
      @volunteer = Volunteer.find_by_id(params[:id])
    end

    def model_params
      params.require(:volunteer).permit(:name, :firstname, :address, :email)
    end
end
