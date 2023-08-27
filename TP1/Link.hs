module Link ( Link, newL, linksL, connectsL, capacityL, delayL)
   where

import Point
import City
import Quality
import Distribution.FieldGrammar (List)

data Link = Lin City City Quality deriving (Eq, Show)

newL :: City -> City -> Quality -> Link -- genera un link entre dos ciudades distintas
connectsL :: City -> Link -> Bool   -- indica si esta ciudad es parte de este link
linksL :: City -> City -> Link -> Bool -- indica si estas dos ciudades distintas estan conectadas mediante este link
capacityL :: Link -> Int 
delayL :: Link -> Float     -- la demora que sufre una conexion en este canal

newL city1 city2 quality = Lin city1 city2 quality
connectsL city (Lin city1 city2 _) | city == city1 = True
                                   | city == city2 = True
                                   | otherwise = False
linksL cityA cityB (Lin city1 city2 _) | cityA == city1 && cityB == city2 = True
                                       | cityB == city1 && cityA == city2 = True
                                       | otherwise = False
capacityL (Lin _ _ quality) = capacityQ quality
delayL (Lin city1 city2 quality) = (distanceC city1 city2) * (delayQ quality)