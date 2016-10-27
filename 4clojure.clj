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
