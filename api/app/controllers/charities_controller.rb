class CharitiesController < ApplicationController
  before_filter :fetch_model, except: [:index, :create]

  def index
    @charities = Charity.all
    render json: { charities: JSON.parse(@charities.to_json(include: [:campaigns])) }
  end

  def update
    if @charity.update_attributes(model_params)
      head :no_content, status: :ok
    else
      render json: @charity.errors, status: :unprocessable_entity
    end
  end

  def destroy
    if @charity.destroy
      head :no_content, status: :ok
    else
      render json: @charity.errors, status: :unprocessable_entity
    end
  end

  private
    def fetch_model
      @charity = Charity.find_by_id(params[:id])
    end

    def model_params
      params.require(:charity).permit(:name, :decription, :email, :website, :logo)
    end
end
