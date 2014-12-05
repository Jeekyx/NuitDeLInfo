class Volunteer < ActiveRecord::Base
  # Relations
  belongs_to              :user
  has_many                :registrations
  has_and_belongs_to_many :campaigns
end
