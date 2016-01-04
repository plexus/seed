(ns seed.core-spec
  (:require [speclj.core :refer :all]
            [seed.core :refer :all]))

(let [template "(ns foo\n  (:require [foo.bar :as bar]))"
      zipper (of-string template)]

  (describe "seed.core/set-ns"

    (it "should set the namespace name"
        (should= "(ns hello.world\n  (:require [foo.bar :as bar]))"
                 (to-string (set-ns zipper 'hello.world)))))

  (describe "seed.core/add-require"

    (it "should add a requirement to the list"
      (should= "(ns foo\n  (:require [foo.bar :as bar] \n            [baz :refer all]))"
               (to-string (add-require zipper '[baz :refer all]))))))

(let [template "(defproject seed \"0.1.0-SNAPSHOT\"
  :description \"Semantic Clojure code transforms\"

  :dependencies [[org.clojure/clojure \"1.7.0\"]
                 [rewrite-clj \"0.4.12\"]])"
      zloc (of-string template)]


  (describe "seed.core/project-add-dependency"

            (it "will append to the dependency vector"

                (should=
                 "(defproject seed \"0.1.0-SNAPSHOT\"
  :description \"Semantic Clojure code transforms\"

  :dependencies [[org.clojure/clojure \"1.7.0\"]
                 [rewrite-clj \"0.4.12\"]
                 [foo.bar \"1.2.3\"]])"
                 (to-string (project-add-dependency zloc '[foo.bar "1.2.3"]))
                 )
                ))

  )

(run-specs)
