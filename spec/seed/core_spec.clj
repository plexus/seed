(ns seed.core-spec
  (:require [speclj.core :refer :all]
            [seed.core :refer :all]))

(let [template "(ns foo\n  (:require [foo.bar :as bar]))"
      zipper (of-string template)]

  (describe "seed.core/set-ns"

            (it "should set the namespace name"
                (should= "(ns hello.world\n  (:require [foo.bar :as bar]))"
                         (to-string (set-ns zipper 'hello.world))
                         )))

    (describe "seed.core/add-require"

            (it "should add a requirement to the list"
                (should= "(ns foo\n  (:require [foo.bar :as bar] \n            [baz :refer all]))"
                         (to-string (add-require zipper '[baz :refer all]))
                         ))))

(run-specs)
