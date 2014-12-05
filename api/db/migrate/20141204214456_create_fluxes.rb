class CreateFluxes < ActiveRecord::Migration
  def change
    create_table :fluxes do |t|
      t.integer :campaign_id
      t.integer :user_id
      t.string :message
      t.string :picture

      t.timestamps
    end
  end
end
