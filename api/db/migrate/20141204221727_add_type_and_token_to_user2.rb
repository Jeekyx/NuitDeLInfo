class AddTypeAndTokenToUser2 < ActiveRecord::Migration
  def change
    change_table :users do |t|
      t.integer :type_id
    end
  end
end
