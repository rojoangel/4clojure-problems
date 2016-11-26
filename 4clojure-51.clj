; 51 Destructuring
; (= [1 2 [3 4 5] [1 2 3 4 5]] (let [[a b & c :as d] __] [a b c d]))
[1 2 3 4 5]

; 52 Intro to Destructuring
; (= [2 4] (let [[a b c d e] [0 1 2 3 4]] __))
[c e]

; 53 Longest Increasing Sub-Seq
; (= (__ [1 0 1 2 3 0 4 5]) [0 1 2 3])
; (= (__ [5 6 1 3 2 7]) [5 6])
; (= (__ [2 3 3 4 5]) [3 4 5])
; (= (__ [7 6 5 4]) [])
(fn [xs]
  (letfn [(group-consecutive [acc val]
                             (if (= (last (last acc)) (dec val))
                               (reverse (conj (butlast acc) (conj (last acc) val)))
                               (reverse (conj (reverse acc) (conj [] val)))))]
    (concat
      '() ; needed for the case where first returns nil
      (first (reverse (sort-by count (filter #(>= (count %) 2) (reduce group-consecutive [] xs))))))))

; 54 Partition a Sequence
; (= (__ 3 (range 9)) '((0 1 2) (3 4 5) (6 7 8)))
; (= (__ 2 (range 8)) '((0 1) (2 3) (4 5) (6 7)))
; (= (__ 3 (range 8)) '((0 1 2) (3 4 5)))
; tail recursion with vectors
(fn partition-sequence [i xs]
  (loop [xs xs result []]
    (if (>= (count xs) i)
      (recur (drop i xs) (conj result (take i xs)))
      result)))

; tail recursion with seq
(fn partition-sequence [i xs]
  (loop [xs xs
         result '()]
    (if (< (count xs) i)
      (reverse result)
      (recur (drop i xs)
             (conj result (take i xs))))))

(fn partition-sequence [i xs]
  (filter #(= i (count %))
          (reduce
           (fn [acc j]
             (if (= i (count (last acc)))
               (reverse (conj (reverse acc) (conj '() j)))
               (reverse (conj (reverse (butlast acc)) (reverse (conj (reverse (last acc)) j)))))) '() xs)))
