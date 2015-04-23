(ns ring-wrap-routes.core
  (:require [clojure.tools.namespace.repl :refer :all]
            [ring.mock.request :as ring-mock]
            [compojure.core :refer :all]))

(def handler1 (GET "/handler1" []
                (println " - In handler1")
                "body"))

(defn handler1-middleware
  [handler]
  (fn [req]
    (println " - In handler1-middleware")
    (handler req)))

(defn top-level-middleware
  [handler]
  (fn [req]
    (println " - In top-level-middleware")
    (handler req)))

(defn -main []
  (println "The middlewares are applied in the obvious order when thread-first is used")
  ((-> (-> handler1 handler1-middleware)
     top-level-middleware)
    (ring-mock/request :get "/handler1"))

  (println "wrap-routes applied only to the outer middleware causes it to be inserted inside the handler-specific middleware")
  ((wrap-routes (-> handler1 handler1-middleware)
     top-level-middleware)
    (ring-mock/request :get "/handler1"))

  (println "wrap-routes applied to both middlewares doesn't give thread-first semantics either")
  ((wrap-routes (wrap-routes handler1 handler1-middleware)
     top-level-middleware)
    (ring-mock/request :get "/handler1"))

  (println "wrap-routes applied only to the handler-specific middleware is the same as thread-first")
  ((-> (wrap-routes handler1 handler1-middleware)
     top-level-middleware)
    (ring-mock/request :get "/handler1")))
