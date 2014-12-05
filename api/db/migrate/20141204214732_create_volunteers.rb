class CreateVolunteers < ActiveRecord::Migration
  def change
    create_table :volunteers do |t|
      t.integer :user_id
      t.string :name
      t.string :firstname
      t.string :address
      t.string :email
      t.integer :points

      t.timestamps
    end
  end
end
