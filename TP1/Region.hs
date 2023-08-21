module Region ( Region, newR, foundR, linkR, tunelR, pathR, linksForR, connectedR, linkedR, delayR, availableCapacityForR, usedCapacityForR )
    where

import Point
import City
import Quality
import Link
import Tunel

data Region = Reg [City] [Link] [Tunel]
newR :: Region
foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades

newR cities links tunels = Reg cities links tunels
foundR (Reg cities _ _) city = Reg (cities ++ [city]) _ _
linkR (Reg cities links _) city1 city2 qua1 | ((elem city1 cities) && (elem city2 cities)) && (not (or (map (linksL city1 city2 links) links))) = (Reg cities (links++(newL city1 city2 qua1)) _)
tunelR (Reg cities1 links1 tunels1) cities2 | all (`elem` cities1) cities2 = (Reg cities links1 (tunels++(newT (head cities2) (last cities2))))
