(ns aoc-2024-clojure.solutions.day-01
  (:require [aoc-2024-clojure.utils :refer :all])
  (:require [clojure.string :refer [split]]))

(defn read-input [filename]
  (with-open [rdr (clojure.java.io/reader (str "./inputs/" filename ".txt"))]
    (reduce (fn [sequences line] (map conj sequences (map parse-int (split line #"\s+"))))
            '([] [])
            (line-seq rdr))))

(defn solve1 [filename]
  (let [[list1 list2] (map sort (read-input filename))]
    (reduce + (map #(abs (- %1 %2)) list1 list2))))

(defn solve2 [filename]
  (let [[freq1 freq2] (map frequencies (read-input filename))]
    (reduce + (map
               (fn [[key val]] (* key val (or (get freq2 key) 0)))
               freq1))))
