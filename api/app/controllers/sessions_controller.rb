class SessionsController < DeviseController
  # Prevent CSRF attacks by raising an exception.
  # For APIs, you may want to use :null_session instead.
  protect_from_forgery with: :null_session

  respond_to :json

  prepend_before_filter :require_no_authentication, :only => [:create ]
  
  before_filter :ensure_params_exist
 
  
  def create
    resource = User.find_for_database_authentication(email: params[:user][:email])
    return invalid_login_attempt unless resource
 
    if resource.valid_password?(params[:user][:password])
      sign_in("user", resource)

      resource.token = loop do
        random_token = SecureRandom.urlsafe_base64(nil, false)
        break random_token unless User.exists?(token: random_token)
      end
      resource.save

      render json: resource.to_json(include: :type), status: :created
      return
    end
    invalid_login_attempt
  end
  
  def destroy
    sign_out(resource_name)
  end
 
  protected
    def ensure_params_exist
      return unless params[:user].blank?
      render json: { success: false, message: "Missing fields" }, status: :unprocessable_entity
    end
   
    def invalid_login_attempt
      render json: { success: false, message: "Email or password incorrect"}, status: :unauthorized
    end
  end
