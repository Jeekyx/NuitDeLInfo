Rails.application.routes.draw do

  devise_for :users, :controllers => {:registrations => "registrations", :sessions => "sessions"}

  resources :campaigns, only: [ :index, :show, :create, :update, :destroy ] do
    get 'fluxes'
  end

  resources :charities, only: [ :index, :show, :update ] do
    get 'campaigns'
    post 'campaigns' => 'charities#create_campaign'
  end

  resources :fluxes, only: [ :index, :show, :create, :update, :destroy ]

  resources :registrations, only: [ :index, :show, :create, :update, :destroy ]

  resources :volunteers, only: [ :index, :show, :update ] do
    get 'registrations'
    post 'registrations/:campaign_id' => 'volunteers#create_registration'

    post 'fluxes/:campaign_id' => 'volunteers#create_flux'
  end

  # Search routes
  get 'search'                     => 'search#index'
  get 'search/campaigns/registrable' => 'search#registrable_campaigns'
  get 'search/campaigns/finished'  => 'search#finished_campaigns'
  get 'search/campaigns/current'   => 'search#current_campaigns'

  # The priority is based upon order of creation: first created -> highest priority.
  # See how all your routes lay out with "rake routes".

  # You can have the root of your site routed with "root"
  # root 'welcome#index'

  # Example of regular route:
  #   get 'products/:id' => 'catalog#view'

  # Example of named route that can be invoked with purchase_url(id: product.id)
  #   get 'products/:id/purchase' => 'catalog#purchase', as: :purchase

  # Example resource route (maps HTTP verbs to controller actions automatically):
  #   resources :products

  # Example resource route with options:
  #   resources :products do
  #     member do
  #       get 'short'
  #       post 'toggle'
  #     end
  #
  #     collection do
  #       get 'sold'
  #     end
  #   end

  # Example resource route with sub-resources:
  #   resources :products do
  #     resources :comments, :sales
  #     resource :seller
  #   end

  # Example resource route with more complex sub-resources:
  #   resources :products do
  #     resources :comments
  #     resources :sales do
  #       get 'recent', on: :collection
  #     end
  #   end

  # Example resource route with concerns:
  #   concern :toggleable do
  #     post 'toggle'
  #   end
  #   resources :posts, concerns: :toggleable
  #   resources :photos, concerns: :toggleable

  # Example resource route within a namespace:
  #   namespace :admin do
  #     # Directs /admin/products/* to Admin::ProductsController
  #     # (app/controllers/admin/products_controller.rb)
  #     resources :products
  #   end
end
