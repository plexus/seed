# seed

Semantic transformations on Clojure files, for smarter Leiningen templates.

## Usage

``` clojure
(-> (of-file "core.clj")
    (set-ns 'new-lib.core)
    (add-require '[foo.bar :as bar])
    to-string)
```

## TODO

Look at https://github.com/weavejester/cljfmt

## License

Copyright © 2014 Arne Brasseur

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
