class Charity < ActiveRecord::Base
  # Relations
  belongs_to :user
  has_many   :campaigns
end
