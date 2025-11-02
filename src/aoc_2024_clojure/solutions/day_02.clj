(ns aoc-2024-clojure.solutions.day-02
  (:require [aoc-2024-clojure.utils :refer :all])
  (:require [clojure.string :refer [split]])
  (:require [clojure.math :refer [signum]]))

(defn parse-line [line]
  (map parse-int (split line #"\s+")))

(defn read-input [filename]
  (with-open [rdr (clojure.java.io/reader (str "./inputs/" filename ".txt"))]
    (map parse-line (reduce conj [] (line-seq rdr)))))

(defn is-report-safe
  ([report]
   (is-report-safe report nil))
  ([report last-diff]
    (if (<= (count report) 1) 
      1
      (let [diff (- (nth report 0) (nth report 1))]
        (if (or 
             (= diff 0)
             (> (abs diff) 3)
             (and (not (nil? last-diff)) (not= (signum last-diff) (signum diff))))
          0 
          (recur (drop 1 report) diff))))))

(defn solve1 [filename]
  (reduce #(+ %1 (is-report-safe %2)) 0 (read-input filename)))
