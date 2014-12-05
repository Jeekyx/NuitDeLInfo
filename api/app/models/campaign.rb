class Campaign < ActiveRecord::Base
  # Relations
  belongs_to              :charity
  has_many                :registrations
  has_many                :fluxes
  has_and_belongs_to_many :volunteers
end
