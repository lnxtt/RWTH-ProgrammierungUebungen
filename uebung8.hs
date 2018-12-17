fib :: Int -> Int
fib  a | a < 2 = a
fib n = fib (n-1) + fib (n-2)

pow :: Int -> Int -> Int
pow _ 0 = 1
pow a 1 = a
pow a b = a * pow a (b-1)

isDiv :: Int -> Int -> Bool
isDiv 0 _ = True
isDiv _ 0 = False
isDiv a b | a < b = False
isDiv a b = isDiv (a-b) b

sumUp :: [Int] -> Int
sumUp [] = 0
sumUp (x:xs) = x + sumUp xs

multList :: [Int] -> [Int] -> [Int]
multList _ [] = []
multList [] _ = []
multList (x:xs) (y:xy) = ((x * y): multList xs xy)

binRep :: Int -> (Int,[Int])
binRep a
     | a < 0 = (1, getBinaryNumber ((-1)*a))
     | a == 0 = (0, getBinaryNumber a)
     | otherwise = (0, getBinaryNumber a)

getBinaryNumber :: Int -> [Int]
getBinaryNumber a | a < 2 = [a]
getBinaryNumber a
              | getModWithTwo a == 0 = getBinaryNumber (div a 2) ++ [0]
              | otherwise = getBinaryNumber (div a 2) ++ [1]

getModWithTwo :: Int -> Int
getModWithTwo a = a - (2*(div a 2))
