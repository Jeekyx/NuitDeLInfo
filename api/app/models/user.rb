class User < ActiveRecord::Base
  # Include default devise modules. Others available are:
  # :confirmable, :lockable, :timeoutable and :omniauthable
  devise :database_authenticatable, :registerable,
         :recoverable, :rememberable, :trackable, :validatable

  # Relations
  belongs_to :type
  has_one    :charity
  has_one    :volunteer
  has_many   :fluxes

  after_create :set_token_and_profile


  private
    def set_token_and_profile
      self.token = loop do
        random_token = SecureRandom.urlsafe_base64(nil, false)
        break random_token unless User.exists?(token: random_token)
      end

      if self.type.name == "Volunteer"
        self.volunteer = Volunteer.new
      else
        self.charity = Charity.new
      end

      self.save
    end
end
