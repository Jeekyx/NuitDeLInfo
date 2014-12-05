class CampaignsController < ApplicationController
  before_filter :fetch_user, except: [:index, :show]
  before_filter :fetch_model, except: [:index, :create]

  def index
    @campaigns = Campaign.all
    render json: { campaigns: JSON.parse(@campaigns.to_json(include: [:charity, :volunteers, :fluxes => {include: {:user => {include: :volunteer}}}])) }
  end

  def create
    @campaign = Campaign.new(model_params)
    @campaign.charity_id = @user.charity.id

    if @campaign.save
      render json: @campaign, status: :created
    else
      render json: @campaign.errors, status: :unprocessable_entity
    end
  end

  def show
    if @campaign != nil
      render json: @campaign
    else
      render nothing: true, status: :not_found
    end
  end

  def update
    if @campaign.update_attributes(model_params)
      head :no_content, status: :ok
    else
      render json: @campaign.errors, status: :unprocessable_entity
    end
  end

  def destroy
    if @campaign.destroy
      head :no_content, status: :ok
    else
      render json: @campaign.errors, status: :unprocessable_entity
    end
  end

  def fluxes
    render json: @campaign.fluxes
  end

  private
    def fetch_user
      token = request.headers['Auth-token']
      head :unauthorized unless token

      @user = User.find_by_token(token)
      head :unauthorized unless @user && @user.type.name == "Charity"
    end

    def fetch_model
      @campaign = Campaign.find_by_id(params[:id])
    end

    def model_params
      params.require(:campaign).permit(:name, :location, :description, :start_date, :end_date, :end_registration_date, :places)
    end
end
