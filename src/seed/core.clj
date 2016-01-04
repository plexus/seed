(ns seed.core
  (:require [rewrite-clj.zip :as zip :refer [find-value next]]))

(def of-file    zip/of-file)
(def of-string  zip/of-string)
(def to-string  zip/root-string)

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
      (zip/prepend-space 12)))

(defn project-add-dependency [zloc dep]
  "Given a leiningen project.clj zipper, insert a dependency vector."
  (-> zloc
      (find-value next :dependencies)
      zip/next
      zip/down
      zip/rightmost
      (zip/insert-right dep)
      (zip/append-space 16)
      (zip/append-newline)))
