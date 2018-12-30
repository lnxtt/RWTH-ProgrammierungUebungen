--2)
data VariableName = X | Y deriving Show

getValue :: VariableName -> Int
getValue X = 5
getValue Y = 13

data Expression = Constant Int | Variable VariableName | Add Expression Expression | Multiply Expression Expression deriving Show

evaluate :: Expression -> Int
evaluate (Constant x) = x
evaluate (Variable x) = getValue x
evaluate (Add x y) = (evaluate x) + (evaluate y)
evaluate (Multiply x y) = (evaluate x) * (evaluate y)

tryOptimize :: Expression -> Expression
tryOptimize (Multiply (Constant x) (Constant y)) = Constant (x * y)
tryOptimize (Add (Constant x) (Constant y)) = Constant (x + y)
tryOptimize x = x

evaluatePartially :: Expression -> Expression
evaluatePartially (Add x y) = tryOptimize (Add (evaluatePartially x) (evaluatePartially y))
evaluatePartially (Multiply x y) = tryOptimize (Multiply (evaluatePartially x) (evaluatePartially y))
evaluatePartially x = x

exampleExpression :: Expression
exampleExpression = Add (Add (Constant 20) (Constant 17)) (Add (Variable X) (Multiply (Add (Constant 14) (Constant 7)) (Constant 2)))


--6)
data Optional a = Empty | Present a deriving Show

mapOptional :: (a -> b) -> Optional a -> Optional b
mapOptional _ Empty = Empty
mapOptional (f) (Present a) = Present (f (a))

filterOptional :: (a -> Bool) -> Optional a -> Optional a
filterOptional _ Empty = Empty
filterOptional (f) (Present x) | (f x) == True = (Present x)
                             | (f x) == False = Empty

foldOptional :: (a -> b) -> b -> Optional a -> b
foldOptional _ x Empty = x
foldOptional (f) _ (Present y) =(f y)

data Product = Article String Int deriving Show

isHumanEatable :: Product -> Bool
isHumanEatable (Article "Dog Food" _) = False
isHumanEatable _ = True

adjustPrice :: Product -> Product
adjustPrice (Article x y) | y < 1000 = (Article x (y*2))
                          | otherwise = (Article x y)


stringify :: Product -> String
stringify (Article x y) ="The Article named '" ++ x ++ "' costs " ++ (show y) ++ " cents"

toPriceTag :: Product -> String
toPriceTag x = stringifyO(adjustPriceO(filterHumanEatable x))


filterHumanEatable :: Product -> Optional Product
filterHumanEatable x =(filterOptional (isHumanEatable) (Present x))

adjustPriceO :: Optional Product -> Optional Product
adjustPriceO x = mapOptional(adjustPrice) (x)

stringifyO :: Optional Product -> String
stringifyO x = foldOptional (stringify) "This Article is unavailable." (x)


--8)
data Rosebush = Rose | Cut | Stalk Rosebush | Fork Rosebush Rosebush deriving Show

generate :: Rosebush
generate = Stalk (Fork (Stalk (Fork(Stalk(generate)) (Stalk (Rose)))) (Stalk (Stalk (Fork ( Stalk (Rose)) (Stalk (Stalk (Stalk (generate))))))))

cut :: Int -> Rosebush -> Rosebush
cut 0 x = Cut
cut x Rose = Rose
cut x (Stalk y) = Stalk (cut (x-1) y)
cut x (Fork y z) = Fork(cut (x-1) y) (cut (x-1) z)


-- given ----------------------------------------------------------------------------------------
spaces :: Int -> String
spaces 0 = ""
spaces n = " " ++ spaces (n-1)

dashes :: Int -> String
dashes 0 = ""
dashes n = "-" ++ dashes (n-1)

zipOutput :: [String] -> Int -> [String] -> Int -> [String]
zipOutput [] _ [] _           = []
zipOutput (x:xs) n1 [] n2     = (x ++ " " ++ (spaces n2)):(zipOutput xs n1 [] n2)
zipOutput [] n1 (y:ys) n2     = ((spaces n1) ++ " " ++ y):(zipOutput [] n1 ys n2)
zipOutput (x:xs) n1 (y:ys) n2 = (x ++ " " ++ y):(zipOutput xs n1 ys n2)

data Output = Output [String] Int Int

display :: Rosebush -> Output
display Rose = Output ["*"] 1 1
display Cut = Output ["X"] 1 1
display (Stalk p) = Output (line:o) i n
               where line = (spaces (i-1)) ++ "|" ++ (spaces (n-i))
                     Output o i n = display p
display (Fork p1 p2) = Output (line:(zipOutput o1 n1 o2 n2)) (n1+1) (n1+1+n2)
               where line = (spaces (i1-1)) ++ "+" ++ (dashes (n1-i1)) ++ "+"
                         ++ (dashes (i2-1)) ++ "+" ++ (spaces (n2-i2))
                     Output o1 i1 n1 = display p1
                     Output o2 i2 n2 = display p2

concatenate :: [String] -> String
concatenate []     = ""
concatenate (x:xs) = (concatenate xs) ++ x ++ "\n"

showMe rosebush = putStr (concatenate o)
                  where Output o _ _ = display rosebush