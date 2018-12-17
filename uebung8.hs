fib :: Int -> Int
fib 0 = 0
fib 1 = 1
fib n = fib (n-1) + fib (n-2)

pow :: (Int, Int) -> Int
pow _ 0 = 1
pow _ 1 = a
pow a b = a * pow a (b-1)

isDiv :: (Int, Int) -> Bool
isDiv 0 _ = True
isDiv _ 0 = False
isDiv a b | a < b = False
isDiv a b = isDiv (a-b) b

sumUp :: [Int] -> Int
sumUp [] = 0
sumUp (x:xs) = x + sumUp xs
