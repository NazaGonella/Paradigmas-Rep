module Region ( Region, newR, foundR, linkR, tunelR, connectedR, linkedR, delayR, availableCapacityForR)
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
tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades

newR = Reg [] [] []
foundR (Reg cities x y) city = Reg (cities ++ [city]) x y
existeLink city1 city2 links = any (linksL city1 city2) links
-- linkR (Reg cities links _) city1 city2 qua1 | ((elem city1 cities) && (elem city2 cities)) && (not (existeLink city1 city2 links)) = (Reg cities (links++(newL city1 city2 qua1)) _)
linkR (Reg cities links z) city1 city2 qua1 | (elem city1 cities) && (elem city2 cities) && (not (existeLink city1 city2 links)) = Reg cities (links ++ [(newL city1 city2 qua1)]) z
                                            | existeLink city1 city2 links = error "Ya existe este link."
                                            | otherwise = error "Al menos una ciudad no se encuentra en la región."
-- tunelR (Reg cities1 links1 tunels1) cities2 | all (`elem` cities1) cities2 = (Reg cities links1 (tunels++(newT (head cities2) (last cities2))))
estaContenido listaChica listaGrande = all (\x -> elem x listaGrande) listaChica
posiblesLinks xs = zipWith (\x y -> [x, y]) xs (tail xs)
existeLinkListas links [x,y] = existeLink x y links
tunelR (Reg cities1 links1 tunels1) cities2 | not (estaContenido cities2 cities1) = error "Alguna de las ciudades no se encuentra en la región."
                                            | all (==True) (map (existeLinkListas links1) (posiblesLinks cities2)) = (Reg cities1 links1 (tunels1++[newT links1])) -- incompleto
connectedR (Reg cities links tunels) city1 city2 | not ((elem city1 cities) && (elem city2 cities)) = False
                                                 | all (==False) (map (connectsT city1 city2) tunels) = False
                                                 | otherwise = True
linkedR (Reg cities links tunels) city1 city2 | not ((elem city1 cities) && (elem city2 cities)) = False
                                              | any (==True) (map (linksL city1 city2) links) = True
                                              | otherwise = False
delayR (Reg cities links tunels) city1 city2 = delayL (head (filter (linksL city1 city2) links))
availableCapacityForR (Reg cities links tunels) city1 city2 = capacityL (head (filter (linksL city1 city2) links))

city1 = newC "A" (newP 24 25)
city2 = newC "B" (newP 48 50)
city3 = newC "C" (newP 24 25)
city4 = newC "D" (newP 24 25)
city5 = newC "E" (newP 24 25)
qua1 = newQ "adda" 4 2.5
link1 = newL city1 city2 qua1
link2 = newL city3 city4 qua1
tunel1 = newT [link1, link2]
region1 = Reg [city1, city2] [link1, link2] [tunel1]
