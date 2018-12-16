fib :: Integer -> Integer
fib 0 = 0
fib 1 = 1
fib n = fib (n-1) + fib (n-2)

pow :: (Interger, Integer) -> Integer
pow a 0 = 1
pow a 1 = a
pow a b = a * pow a (b-1)

sumUp :: [Int] -> Int
sumUp [] = 0
sumUp (x:xs) = x + sumUp xs