class CreateCharities < ActiveRecord::Migration
  def change
    create_table :charities do |t|
      t.integer :user_id
      t.string :name
      t.text :description
      t.string :email
      t.string :website

      t.timestamps
    end
  end
end
