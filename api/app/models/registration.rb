class Registration < ActiveRecord::Base
  # Relations
  belongs_to :volunteer
  belongs_to :charity
end
