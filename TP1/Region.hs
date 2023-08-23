module Region ( Region, newR, foundR, linkR )--, tunelR, pathR, linksForR, connectedR, linkedR, delayR, availableCapacityForR, usedCapacityForR
    where

import Point
import City
import Quality
import Link
import Tunel

data Region = Reg [City] [Link] [Tunel]
instance Show Region where
    show (Reg cities links tunnels) =
        "Region:\n" ++
        "Cities: " ++ show cities ++ "\n" ++
        "Links: " ++ show links ++ "\n" ++
        "Tunnels: " ++ show tunnels

newR :: Region
foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
-- tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
-- connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
-- linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
-- delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
-- availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades

newR = Reg [] [] []
foundR (Reg cities x y) city = Reg (cities ++ [city]) x y
existeLink city1 city2 links = any (linksL city1 city2) links
-- linkR (Reg cities links _) city1 city2 qua1 | ((elem city1 cities) && (elem city2 cities)) && (not (existeLink city1 city2 links)) = (Reg cities (links++(newL city1 city2 qua1)) _)
linkR (Reg cities links z) city1 city2 qua1 | (elem city1 cities) && (elem city2 cities) && (not (existeLink city1 city2 links)) = Reg cities (links ++ [(newL city1 city2 qua1)]) z
                                            | otherwise = Reg cities links z
-- tunelR (Reg cities1 links1 tunels1) cities2 | all (`elem` cities1) cities2 = (Reg cities links1 (tunels++(newT (head cities2) (last cities2))))
-- tunelR (Reg cities1 links1 tunels1) cities2 | 

city1 = newC "A" (newP 24 25)
city2 = newC "B" (newP 24 25)
city3 = newC "C" (newP 24 25)
city4 = newC "D" (newP 24 25)
qua1 = newQ "adda" 4 2.5
link1 = newL city1 city2 qua1
link2 = newL city3 city4 qua1

region1 = Reg [city1, city2, city3, city4] [link1] []
