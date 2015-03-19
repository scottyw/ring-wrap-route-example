(defproject ring-wrap-routes-example "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/tools.namespace "0.2.4"]
                 [compojure "1.3.2"]
                 [ring/ring-mock "0.2.0"]]

  :repl-options {:init (do
                         (require ['clojure.tools.namespace.repl :refer :all])
                         (refresh))}
  :main ring-wrap-routes.core)
