; 1 Nothing but the Truth
; (= __ true)
(= true true)

;2 Simple Math
; (= (- 10 (* 2 3)) __)
(= (- 10 (* 2 3)) 4)

;3 Intro to Strings
; (= __ (.toUpperCase "hello world"))
(= "HELLO WORLD" (.toUpperCase "hello world"))

;4 Intro to Lists
; (= (list __) '(:a :b :c))
(= (list :a :b :c) '(:a :b :c))

;5 Lists: conj
; (= __ (conj '(2 3 4) 1))
; (= __ (conj '(3 4) 2 1))
(= '(1 2 3 4) (conj '(2 3 4) 1))
(= '(1 2 3 4) (conj '(3 4) 2 1))

; 6 Intro to Vectors
; (= [__] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))
(= [:a :b :c] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))

; 7 Vectors: conj
; (= __ (conj [1 2 3] 4))
; (= __ (conj [1 2] 3 4))
(= [1 2 3 4] (conj [1 2 3] 4))
(= [1 2 3 4] (conj [1 2] 3 4))

; 8 Intro to Sets
; (= __ (set '(:a :a :b :c :c :c :c :d :d)))
; (= __ (clojure.set/union #{:a :b :c} #{:b :c :d}))
(= #{:a :b :c :d} (set '(:a :a :b :c :c :c :c :d :d)))
(= #{:a :b :c :d} (clojure.set/union #{:a :b :c} #{:b :c :d}))

; 9 Sets: conj
; (= #{1 2 3 4} (conj #{1 4 3} __))
(= #{1 2 3 4} (conj #{1 4 3} 2))

; 10 Intro to Maps
; (= __ ((hash-map :a 10, :b 20, :c 30) :b))
; (= __ (:b {:a 10, :b 20, :c 30}))
(= 20 ((hash-map :a 10, :b 20, :c 30) :b))
(= 20 (:b {:a 10, :b 20, :c 30}))

; 11 Maps: conj
; (= {:a 1, :b 2, :c 3} (conj {:a 1} __ [:c 3]))
(= {:a 1, :b 2, :c 3} (conj {:a 1} [:b 2] [:c 3]))

; 12 Intro to Sequences
; (= __ (first '(3 2 1)))
; (= __ (second [2 3 4]))
; (= __ (last (list 1 2 3)))
(= 3 (first '(3 2 1)))
(= 3 (second [2 3 4]))
(= 3 (last (list 1 2 3)))

; 13 Sequences: rest
; (= __ (rest [10 20 30 40]))
(= [20 30 40] (rest [10 20 30 40]))

; 14 Intro to Functions
; (= __ ((fn add-five [x] (+ x 5)) 3))
; (= __ ((fn [x] (+ x 5)) 3))
; (= __ (#(+ % 5) 3))
; (= __ ((partial + 5) 3))
(= 8 ((fn add-five [x] (+ x 5)) 3))
(= 8 ((fn [x] (+ x 5)) 3))
(= 8 (#(+ % 5) 3))
(= 8 ((partial + 5) 3))

; 15 Double Down
; (= (__ 2) 4)
; (= (__ 3) 6)
; (= (__ 11) 22)
; (= (__ 7) 14)
(= ((partial * 2) 2) 4)
(= (#(* % 2) 3) 6)
(= ((fn [x] (* x 2)) 11) 22)
(= ((fn double [x] (* x 2)) 7) 14)

; 16 Hello world
; (= (__ "Dave") "Hello, Dave!")
; (= (__ "Jenn") "Hello, Jenn!")
; (= (__ "Rhea") "Hello, Rhea!")
(= (format "Hello %s!" "Dave") "Hello, Dave!")
(= ((fn [x] (str "Hello, " x "!")) "Jenn") "Hello, Jenn!")
(= (#(str "Hello, " % "!") "Rhea") "Hello, Rhea!")

; 17 Sequences: map
; (= __ (map #(+ % 5) '(1 2 3)))
(= '(6 7 8) (map #(+ % 5) '(1 2 3)))

; 18 Sequences: filter
; (= __ (filter #(> % 5) '(3 4 5 6 7)))
(= '(6 7) (filter #(> % 5) '(3 4 5 6 7)))

; 19 Last Element
; (= (__ [1 2 3 4 5]) 5)
; (= (__ '(5 4 3)) 3)
; (= (__ ["b" "c" "d"]) "d")
(= (#(first (reverse %)) [1 2 3 4 5]) 5)
(= (#(first (reverse %)) '(5 4 3)) 3)
(= (#(first (reverse %)) ["b" "c" "d"]) "d")

; 20 Penultimate Element
; (= (__ (list 1 2 3 4 5)) 4)
; (= (__ ["a" "b" "c"]) "b")
; (= (__ [[1 2] [3 4]]) [1 2])
(= (#(nth (reverse %) 1) (list 1 2 3 4 5)) 4)
(= (#(nth (reverse %) 1) ["a" "b" "c"]) "b")
(= (#(nth (reverse %) 1) [[1 2] [3 4]]) [1 2])

; 21 Nth Element
; (= (__ '(4 5 6 7) 2) 6)
; (= (__ [:a :b :c] 0) :a)
; (= (__ [1 2 3 4] 1) 2)
; (= (__ '([1 2] [3 4] [5 6]) 2) [5 6])
(= (#(first (nthnext %1 %2)) '(4 5 6 7) 2) 6)
(= (#(first (nthnext %1 %2)) [:a :b :c] 0) :a)
(= (#(first (nthnext %1 %2)) [1 2 3 4] 1) 2)
(= (#(first (nthnext %1 %2)) '([1 2] [3 4] [5 6]) 2) [5 6])

; 22 Count a Sequence
; (= (__ '(1 2 3 3 1)) 5)
; (= (__ "Hello World") 11)
; (= (__ [[1 2] [3 4] [5 6]]) 3)
; (= (__ '(13)) 1)
; (= (__ '(:a :b :c)) 3)
(= (reduce (fn [acc, x] (+ acc 1)) 0 '(1 2 3 3 1)) 5)
(= (reduce (fn [acc, x] (inc acc)) 0 "Hello World") 11)
(= (reduce (fn [acc, x] (inc acc)) 0 [[1 2] [3 4] [5 6]]) 3)
(= (reduce (fn [acc, x] (inc acc)) 0 '(13)) 1)
(= (reduce (fn [acc, x] (inc acc)) 0 '(:a :b :c)) 3)

; 23 Reverse a Sequence
; (= (__ [1 2 3 4 5]) [5 4 3 2 1])
; (= (__ (sorted-set 5 7 2 7)) '(7 5 2))
; (= (__ [[1 2][3 4][5 6]]) [[5 6][3 4][1 2]])
(= (reduce (fn [acc, x] (conj acc x)) '() [1 2 3 4 5]) [5 4 3 2 1])
(= (reduce (fn [acc, x] (conj acc x)) '() (sorted-set 5 7 2 7)) '(7 5 2))
(= (reduce (fn [acc, x] (conj acc x)) '() [[1 2][3 4][5 6]]) [[5 6][3 4][1 2]])

; 24 Sum It All Up
; (= (__ [1 2 3]) 6)
; (= (__ (list 0 -2 5 5)) 8)
; (= (__ #{4 2 1}) 7)
; (= (__ '(0 0 -1)) -1)
; (= (__ '(1 10 3)) 14)
(= (reduce + [1 2 3]) 6)
(= (reduce + (list 0 -2 5 5)) 8)
(= (reduce + #{4 2 1}) 7)
(= (reduce + '(0 0 -1)) -1)
(= (reduce + '(1 10 3)) 14)

; 25 Find the odd numbers
; (= (__ #{1 2 3 4 5}) '(1 3 5))
; (= (__ [4 2 1 6]) '(1))
; (= (__ [2 2 4 6]) '())
; (= (__ [1 1 1 3]) '(1 1 1 3))
(= (filter odd? #{1 2 3 4 5}) '(1 3 5))
(= (filter odd? [4 2 1 6]) '(1))
(= (filter odd? [2 2 4 6]) '())
(= (filter odd? [1 1 1 3]) '(1 1 1 3))

; 26 Fibonacci Sequence
; (= (__ 3) '(1 1 2))
; (= (__ 6) '(1 1 2 3 5 8))
; (= (__ 8) '(1 1 2 3 5 8 13 21))
(= (#(take % ((fn fib [i j] (lazy-seq (cons i (fib j (+ i j))))) 1 1)) 3) '(1 1 2))
(= (#(take % ((fn fib [i j] (lazy-seq (cons i (fib j (+ i j))))) 1 1)) 6) '(1 1 2 3 5 8))
(= (#(take % ((fn fib [i j] (lazy-seq (cons i (fib j (+ i j))))) 1 1)) 8) '(1 1 2 3 5 8 13 21))

; 27 Palindrome Detector
; (false? (__ '(1 2 3 4 5)))
; (true? (__ "racecar"))
; (true? (__ [:foo :bar :foo]))
; (true? (__ '(1 1 3 3 1 1)))
; (false? (__ '(:a :b :c)))
(false? ((fn [xs] (= (reverse xs) (vec xs))) '(1 2 3 4 5)))
(true? (#(= (reverse %) (vec %)) "racecar"))
(true? (#(= (reverse %) (vec %)) [:foo :bar :foo]))
(true? (#(= (reverse %) (vec %)) '(1 1 3 3 1 1)))
(false? (#(= (reverse %) (vec %)) '(:a :b :c)))

; 28 Flatten a Sequence
; (= (__ '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))
; (= (__ ["a" ["b"] "c"]) '("a" "b" "c"))
; (= (__ '((((:a))))) '(:a))
(fn my-flatten [xs]
  (loop [xs' xs
         acc nil]
    (if (empty? xs')
      acc
      (let [x (first xs')]
        (if (coll? x)
          (recur (next xs') (concat acc (my-flatten x)))
          (recur (next xs') (conj (vec acc) x)))))))

(fn my-flatten [xs]
  (loop [xs' xs
         acc nil]
    (if (empty? xs')
      acc
      (let [x (first xs')]
        (recur (next xs')
               (if (coll? x)
                 (concat acc (my-flatten x))
                 (conj (vec acc) x)))))))

; 29 Get the Caps
; (= (__ "HeLlO, WoRlD!") "HLOWRD")
; (empty? (__ "nothing"))
; (= (__ "$#A(*&987Zf") "AZ")
(= ((fn [xs] (apply str (filter #(Character/isUpperCase %) xs))) "HeLlO, WoRlD!") "HLOWRD")
(empty? ((fn [xs] (apply str (filter #(Character/isUpperCase %) xs))) "nothing"))
(= ((fn [xs] (apply str (filter #(Character/isUpperCase %) xs))) "$#A(*&987Zf") "AZ")

; 30 Compress a Sequence
; (= (apply str (__ "Leeeeeerrroyyy")) "Leroy")
; (= (__ [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))
; (= (__ [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))
(= (apply str ((fn [xs] (reduce #(if (= %2 (last %1)) %1 (conj %1 %2)) [] xs)) "Leeeeeerrroyyy")) "Leroy")
(= ((fn compress-seq [xs] (reduce (fn [acc x] (if (= x (last acc)) acc (conj acc x))) [] xs)) [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))
(= ((fn [xs] (reduce #(if (= %2 (last %1)) %1 (conj %1 %2)) [] xs)) [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))

; 31 Pack a Sequence
; (= (__ [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3)))
; (= (__ [:a :a :b :b :c]) '((:a :a) (:b :b) (:c)))
; (= (__ [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4])))
(fn compress-seq [xs] (reduce (fn [acc x] (if (= x (last (last acc)))
                                            (reverse (conj (reverse (butlast acc)) (conj (last acc) x)))
                                            (reverse (conj (reverse acc) (conj nil x))))) nil xs))

;32 Duplicate a Sequence
; (= (__ [1 2 3]) '(1 1 2 2 3 3))
; (= (__ [:a :a :b :b]) '(:a :a :a :a :b :b :b :b))
; (= (__ [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))
; (= (__ [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))
(fn duplicate-a-seq [xs] (reduce (fn [acc x] (conj acc x x)) [] xs))

; 33 Replicate a Sequence
; (= (__ [1 2 3] 2) '(1 1 2 2 3 3))
; (= (__ [:a :b] 4) '(:a :a :a :a :b :b :b :b))
; (= (__ [4 5 6] 1) '(4 5 6))
; (= (__ [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4]))
; (= (__ [44 33] 2) [44 44 33 33])
(fn [xs i]
  (mapcat (fn [x] (repeat i x)) xs))
(fn [xs i]
  (mapcat #(repeat i %) xs))

; 34 Implement range
; (= (__ 1 4) '(1 2 3))
; (= (__ -2 2) '(-2 -1 0 1))
; (= (__ 5 8) '(5 6 7))
(fn my-range [i j]
  (loop [current i acc nil]
    (if (>= current j)
      acc
      (recur (inc current) (conj (vec acc) current)))))
(fn [i j]
  (take-while #(< % j) (iterate inc i)))

; 35 Local bindings
; (= __ (let [x 5] (+ 2 x)))
; (= __ (let [x 3, y 10] (- y x)))
; (= __ (let [x 21] (let [y 3] (/ x y))))
7

; 36 Let it Be
; (= 10 (let __ (+ x y)))
; (= 4 (let __ (+ y z)))
; (= 1 (let __ z))
[x 7 y 3 z 1]

; 37 Regular Expressions
; (= __ (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))
(= "ABC" (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))

; 38 Maximum value
; (= (__ 1 8 3 4) 8)
; (= (__ 30 20) 30)
; (= (__ 45 67 11) 67)
(fn
  [& nums]
  (reduce #(if (> %1 %2) %1 %2) nums))

(fn
  [& nums]
  (first (reverse (sort nums))))

(comp first reverse sort list)

(comp last sort list)

; 39 Interleave Two Seqs
; (= (__ [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c))
; (= (__ [1 2] [3 4 5 6]) '(1 3 2 4))
; (= (__ [1 2 3 4] [5]) [1 5])
; (= (__ [30 20] [25 15]) [30 25 20 15])
(fn my-interleave
  [xs ys]
  (loop [xs xs
         ys ys
         interleaved []]
    (if (or (not (seq xs)) (not (seq ys)))
      interleaved
      (let [[x & xs'] xs
            [y & ys'] ys]
        (recur xs' ys' (conj (conj interleaved x) y))))))

#(mapcat vector %1 %2)

; 40 Interpose a Seq
; (= (__ 0 [1 2 3]) [1 0 2 0 3])
; (= (apply str (__ ", " ["one" "two" "three"])) "one, two, three")
; (= (__ :z [:a :b :c :d]) [:a :z :b :z :c :z :d])
#(butlast (interleave %2 (repeat %1)))

(fn
  [i xs]
  (butlast (interleave xs (repeat i))))
