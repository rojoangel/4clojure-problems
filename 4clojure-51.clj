; 51 Destructuring
; (= [1 2 [3 4 5] [1 2 3 4 5]] (let [[a b & c :as d] __] [a b c d]))
[1 2 3 4 5]

; 52 Intro to Destructuring
; (= [2 4] (let [[a b c d e] [0 1 2 3 4]] __))
[c e]
