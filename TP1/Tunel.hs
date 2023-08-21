module Tunel ( Tunel, newT, connectsT, usesT, delayT)
   where

import Point
import City
import Quality
import Link

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
connectsT :: City -> City -> Tunel -> Bool -- inidca si este tunel conceta estas dos ciudades distintas
usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel

newT sl = Tun sl
connectsT city1 city2 (Tun links) | head (citiesL (head links)) == city1 && last (citiesL (last links)) == city2 = True
                                  | head (citiesL (head links)) == city2 && last (citiesL (last links)) == city1 = True
                                  | otherwise = False
usesT link1 (Tun links) = elem link1 links
delayT (Tun links) = sum (map delayL links)
