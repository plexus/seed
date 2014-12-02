(ns seed.core
  (:require [rewrite-clj.zip :as zip]
            [rewrite-clj.zip.indent :as zip-indent]))

(def of-file    zip/of-file)
(def of-string  zip/of-string)
(def to-string  zip/->root-string)

(defn set-ns [zipper name]
  (-> zipper
      (zip/find-value zip/next 'ns)
      zip/right
      (zip/replace name)))

(defn add-require [zipper require]
  (-> zipper
      (zip/find-value zip/next 'ns)
      (zip/find-value zip/next :require)
      zip/rightmost
      (zip/insert-right require)
      zip/right
      (zip/prepend-newline)
      (zip-indent/indent 12)
      ))
