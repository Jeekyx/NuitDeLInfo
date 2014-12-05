class CreateRegistrations < ActiveRecord::Migration
  def change
    create_table :registrations do |t|
      t.integer :campaign_id
      t.integer :volunteer_id
      t.integer :status
      t.string :comment

      t.timestamps
    end
  end
end
