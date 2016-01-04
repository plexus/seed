(defproject seed "0.1.0-SNAPSHOT"
  :description "Semantic Clojure code transforms"
  :url "https://github.com/plexus/seed"
  :license {:name "Mozilla Public License 2.0"
            :url "https://www.mozilla.org/en-US/MPL/2.0/"}

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [rewrite-clj "0.4.12"]]

  :plugins [[speclj "3.1.0"]]

  :test-paths ["spec"]

  :profiles {:dev
             {:dependencies [[speclj "3.1.0"]]}})
