class CreateCampaigns < ActiveRecord::Migration
  def change
    create_table :campaigns do |t|
      t.integer :charity_profile_id
      t.string :name
      t.string :location
      t.text :description
      t.date :start_date
      t.date :end_date
      t.date :end_registration_date
      t.integer :places

      t.timestamps
    end
  end
end
