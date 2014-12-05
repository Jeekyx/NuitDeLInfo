class Flux < ActiveRecord::Base
  # Relations
  belongs_to :user
  belongs_to :campaign
end
