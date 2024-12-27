(ns aoc-2024-clojure.core
  (:require aoc-2024-clojure.solutions.day-01))

(defn two-digit-num
  [num]
  (if (< (count num) 2)
    (str "0" num)
    (str num)))

(defn -main
  "Execute the solution to the given day's given problem."
  [day problem & args]
  (println (apply
            (deref (resolve (symbol
                             (str "aoc-2024-clojure.solutions.day-" (two-digit-num day))
                             (str "solve" problem))))
            args)))
