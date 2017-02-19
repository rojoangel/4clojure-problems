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

; 55 Count Occurrences
; (= (__ [1 1 2 3 2 1 1]) {1 4, 2 2, 3 1})
; (= (__ [:b :a :b :a :b]) {:a 2, :b 3})
; (= (__ '([1 2] [1 3] [1 3])) {[1 2] 1, [1 3] 2})

; recursive solution
(fn count-ocurrences [xs]
  (loop [xs (sort xs) result {}]
    (let [fst (first xs)
          equals-fst? #(= % (first xs))]
      (if (> (count xs) 0)
        (recur (drop-while equals-fst? xs) (assoc result fst (count (take-while equals-fst? xs))))
        result))))

; reduce solution
(fn count-ocurrences [xs]
  (reduce
   (fn [acc x]
     (if (acc x) ; this works for maps
       (assoc acc x (inc (acc x)))
       (assoc acc x 1)))
   {} xs))

 ; group-by solution
 (fn count-occurrences [xs]
   (into {} (map #(vector (first %) (count (last %))) (group-by identity xs))))

 ; group-by + destructuring solution
 (fn count-occurrences [xs]
   (into {} (map
             (fn [[key values]] (vector key (count values)))
             (group-by identity xs))))

; 56 Find Distinct Items
; (= (__ [1 2 1 3 1 2 4]) [1 2 3 4])
; (= (__ [:a :a :b :b :c :c]) [:a :b :c])
; (= (__ '([2 4] [1 2] [1 3] [1 3])) '([2 4] [1 2] [1 3]))
; (= (__ (range 50)) (range 50))

; reduce solution
(fn distinct-items [xs]
  (reduce (fn [acc x]
            (if (some #(= x %) acc)
              acc
              (conj acc x)))
          [] xs))

; 57 Simple Recursion
; (= __ ((fn foo [x] (when (> x 0) (conj (foo (dec x)) x))) 5))

; (conj (conj (conj (conj (conj nil 1) 2) 3) 4) 5)
'(5 4 3 2 1)

; 58 Function Composition
; (= [3 2 1] ((__ rest reverse) [1 2 3 4]))
; (= 5 ((__ (partial + 3) second) [1 2 3 4]))
; (= true ((__ zero? #(mod % 8) +) 3 5 7 9))
; (= "HELLO" ((__ #(.toUpperCase %) #(apply str %) take) 5
(fn [& fs]
  (reduce (fn [f g] (fn [& args] (f (apply g args)))) fs))

; 59 Juxtaposition
; (= [21 6 1] ((__ + max min) 2 3 5 1 6 4))
; (= ["HELLO" 5] ((__ #(.toUpperCase %) count) "hello"))
; (= [2 6 4] ((__ :a :c :b) {:a 2, :b 4, :c 6, :d 8 :e 10}))
(fn [& fns]
  (fn [& args]
    (map #(apply % args) fns)))

; 60 Sequence Reductions
; (= (take 5 (__ + (range))) [0 1 3 6 10])
; (= (__ conj [1] [2 3 4]) [[1] [1 2] [1 2 3] [1 2 3 4]])
; (= (last (__ * 2 [3 4 5])) (reduce * 2 [3 4 5]) 120)
(fn my-reduction
  ([f xs]
   (my-reduction f (first xs) (next xs))) ;; use next since it returns nil instead of '()
  ([f acc xs]
   (lazy-seq (cons acc
                   (if xs    ;; stop sequencing
                     (my-reduction f (f acc (first xs)) (next xs)))))))

; 61 Map Construction
; (= (__ [:a :b :c] [1 2 3]) {:a 1, :b 2, :c 3})
; (= (__ [1 2 3 4] ["one" "two" "three"]) {1 "one", 2 "two", 3 "three"})
; (= (__ [:foo :bar] ["foo" "bar" "baz"]) {:foo "foo", :bar "bar"})
(fn construct-map [ks vs]
  (into (sorted-map) (map vector ks vs)))

; 62 Re-implement Iterate
; (= (take 5 (__ #(* 2 %) 1)) [1 2 4 8 16])
; (= (take 100 (__ inc 0)) (take 100 (range)))
; (= (take 9 (__ #(inc (mod % 3)) 1)) (take 9 (cycle [1 2 3])))
(fn my-iterate [f x]
  (lazy-seq
   (cons x (my-iterate f (f x)))))

; 63 Group a Sequence
; (= (__ #(> % 5) [1 3 6 8]) {false [1 3], true [6 8]})
;(= (__ #(apply / %) [[1 2] [2 4] [4 6] [3 6]])
;   {1/2 [[1 2] [2 4] [3 6]], 2/3 [[4 6]]})
;(= (__ count [[1] [1 2] [3] [1 2 3] [2 3]])
;   {1 [[1] [3]], 2 [[1 2] [2 3]], 3 [[1 2 3]]})
(fn my-group-by [f xs]
  (reduce
   (fn accumulate [m v]
     (let [key (first v)
           value (second v)]
       (assoc m key (conj (get m key []) value))))
   {}
   (map vector (map f xs) xs)))

; 64 Intro to Reduce
; (= 15 (reduce __ [1 2 3 4 5]))
; (=  0 (reduce __ []))
; (=  6 (reduce __ 1 [2 3]))
+

; 65 Black Box Testing
; (= :map (__ {:a 1, :b 2}))
; (= :list (__ (range (rand-int 20))))
; (= :vector (__ [1 2 3 4 5 6]))
; (= :set (__ #{10 (rand-int 5)}))
; (= [:map :set :vector :list] (map __ [{} #{} [] ()]))
; triky solution
(fn black-box-testing [xs]
  ({{} :map #{} :set }(empty xs)
  (if (reversible? xs) :vector :list)))

(fn black-box-testing [xs]
  (cond
   (= 2 (:m (conj xs [:m 1] [:m 2])))
   :map
   (= (inc (count xs)) (count (conj xs [:m 1] [:m 1])))
   :set
   (= [:m 2] (first (conj xs [:m 1] [:m 2])))
   :list
   (= [:m 2] (last (conj xs [:m 1] [:m 2])))
   :vector))

; 66 Greatest Common Divisor
; (= (__ 2 4) 2)
; (= (__ 10 5) 5)
; (= (__ 5 7) 1)
; (= (__ 1023 858) 33)
(fn gcd [x y]
  (first
   (drop-while
    #(not (and (= 0 (mod y %)) (= 0 (mod x %))))
    (reverse (range 1 (inc (min x y)))))))

; 67 Prime Numbers
; (= (__ 2) [2 3])
; (= (__ 5) [2 3 5 7 11])
; (= (last (__ 100)) 541)
(fn prime-numbers [n]
  (take n
        (filter
         (fn [prime-candidate]
           (every? #(not (= 0 (mod prime-candidate %))) (range 2 prime-candidate))) ; range up to prime-candidate removing 0 & 1
         (drop 2 (range))))) ; infinite range removing 0 & 1
