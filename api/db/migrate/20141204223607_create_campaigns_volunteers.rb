class CreateCampaignsVolunteers < ActiveRecord::Migration
  def change
    create_table :campaigns_volunteers do |t|
      t.integer :campaign_id
      t.integer :volunteer_id
    end
  end
end
