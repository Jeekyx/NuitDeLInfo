class SearchController < ApplicationController

  def index
    name = params[:name]

    if name == nil || name == ""
      render nothing: true, status: :not_found
    else
      render json: {
        charities:  Charity.where("name like ?", "%#{name}%"),
        volunteers: Volunteer.where("name like ?", "%#{name}%").where("firstname like ?", "%#{name}%"),
        campaigns:  Campaign.where("name like ?", "%#{name}%")
      }
    end
  end

  def registrable_campaigns
    @campaigns = Campaign.where("end_registration_date > ?", Date.today.to_s)
    
    if params[:start_date] != nil
      @campaigns = @campaigns.where("start_date > ?", params[:start_date])
    end

    if params[:end_date] != nil
      @campaigns = @campaigns.where("end_date < ?", params[:end_date])
    end

    render json: { campaigns: JSON.parse(@campaigns.to_json(include: [:charity, :volunteers, :fluxes => {include: {:user => {include: :volunteer}}}])) }
  end

  def current_campaigns
    @campaigns = Campaign.where("? between start_date and end_date", Date.today.to_s)
    render json: { campaigns: JSON.parse(@campaigns.to_json(include: [:charity, :volunteers, :fluxes => {include: {:user => {include: :volunteer}}}])) }
  end

  def finished_campaigns
    @campaigns = Campaign.where("end_date < ?", Date.today.to_s)
    render json: { campaigns: JSON.parse(@campaigns.to_json(include: [:charity, :volunteers, :fluxes => {include: {:user => {include: :volunteer}}}])) }
  end

end
