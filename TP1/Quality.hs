module Quality ( Quality, newQ, capacityQ, delayQ )
   where

import Point
import City

data Quality = Qua String Int Float deriving (Eq, Show)

newQ :: String -> Int -> Float -> Quality
capacityQ :: Quality -> Int -- cuantos túneles puede tolerar esta conexión
delayQ :: Quality -> Float  -- la demora por unidad de distancia que sucede en las conexiones de este canal

newQ nombre capacity delay = Qua nombre capacity delay
capacityQ (Qua _ capacity _) = capacity
delayQ (Qua _ _ delay) = delay