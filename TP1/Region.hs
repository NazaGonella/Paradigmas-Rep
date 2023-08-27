
module Region ( Region, newR, foundR, linkR, tunelR, connectedR, linkedR, delayR, availableCapacityForR)
    where

import Point
import City
import Quality
import Link
import Tunel

import Data.List

data Region = Reg [City] [Link] [Tunel]
instance Show Region where
    show (Reg cities links tunnels) =
        "\n        +--------+" ++
        "\n=======   REGION   ===========================================================================\n" ++
        "        +--------+" ++
        "\n\nCities:  " ++ intercalate " | " (map show cities) ++ "\n" ++
        "\nLinks:    " ++ intercalate "  |  " (map show links) ++ "\n" ++
        "\nTunnels: " ++ intercalate "  |  " (map show tunnels) ++ "\n" ++
        "\n==============================================================================================\n"

-- Funciones Principales (P)
newR :: Region
foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades

-- Funciones Auxiliares (A)
estaContenido :: Eq a => [a] -> [a] -> Bool
estaContenido listaChica listaGrande = all (\x -> elem x listaGrande) listaChica --A
estanDosCitiesEnCities :: City -> City -> [City] -> Bool
estanDosCitiesEnCities city1 city2 cities = elem city1 cities && elem city2 cities --A
seccionarCities :: City -> City -> [City] -> [City]
seccionarCities inicio fin lista = takeWhile (\c -> c /= fin || c == inicio) (dropWhile (/= inicio) lista) ++ [fin] --A
estanLinkeadas :: [City] -> [Link] -> Bool
estanLinkeadas ciudades links = all (== True) [any (== True) (map (linksL x y) links) | (x, y) <- zip ciudades (tail ciudades)] --A
listadoLinksEntreCiudades :: [City] -> [Link] -> [Link]
listadoLinksEntreCiudades ciudades links = [link | (cityx, cityy) <- zip ciudades (tail ciudades), link <- links, linksL cityx cityy link] --A
contarTrues :: [Bool] -> Int
contarTrues boolList = length [b | b <- boolList, b] --A

newR = Reg [] [] [] --P

foundR (Reg cities links tunels) city --P
        | elem (nameC city) ((map nameC) cities) = error (nameC city ++ " ya se encuentra en la región.")
        | otherwise = Reg (cities ++ [city]) links tunels

linkR (Reg cities links tunels) city1 city2 qua1 --P
        | not (estanDosCitiesEnCities city1 city2 cities) = error "Alguna de las ciudades no se encuentra en la región."
        | estanLinkeadas [city1, city2] links = error "La conexión entre ambas ciudades ya existe."
        | otherwise = Reg cities (links ++ [newL city1 city2 qua1]) tunels

tunelR (Reg cities links tunels) cadenaCitiesPorConectar --P
        | not (estaContenido cadenaCitiesPorConectar cities) = error "Alguna de las ciudades no se encuentra en la región."
        | not (estanLinkeadas cadenaCitiesPorConectar links) = error "Algunas de las ciudades no están conectadas."
        | not (estaContenido listadoLinks links) = error "Alguno de los links entre las ciudades no se encuentra en la región."
        | connectedR (Reg cities links tunels) (head cadenaCitiesPorConectar) (last cadenaCitiesPorConectar) = error "El túnel entre ambas ciudades ya existe."
        | availableCapacityForR (Reg cities links tunels) (head cadenaCitiesPorConectar) (last cadenaCitiesPorConectar) <= 0 = error "No hay suficiente capacidad para construir el túnel."
        | any (<= 0) ((map capacityL) links) = error "Alguno de los links no tiene capacidad suficiente para el túnel."
        | otherwise = Reg cities links (tunels ++ [newT listadoLinks])
    where
        listadoLinks = listadoLinksEntreCiudades cadenaCitiesPorConectar links

connectedR (Reg cities links tunels) city1 city2 --P
        | not (estanDosCitiesEnCities city1 city2 cities) = False
        | all (==False) (map (connectsT city1 city2) tunels) = False
        | otherwise = True

linkedR (Reg cities links tunels) city1 city2 --P
        | not (estanDosCitiesEnCities city1 city2 cities) = error "Alguna de las ciudades no se encuentra en la región."
        | otherwise = estanLinkeadas cadenaCities links
    where
        cadenaCities = seccionarCities city1 city2 cities

delayR (Reg cities links tunels) city1 city2 --P
        | not (estanDosCitiesEnCities city1 city2 cities) = error "Alguna de las ciudades no se encuentra en la región."
        | otherwise = sum (map delayL listadoLinks)
    where
        cadenaCities = seccionarCities city1 city2 cities
        listadoLinks = listadoLinksEntreCiudades cadenaCities links

availableCapacityForR (Reg cities links tunels) city1 city2 
        = capacidadTotal - contarTrues [usesT x y | x <- listadoLinks, y <- tunels]
    where
        cadenaCities = seccionarCities city1 city2 cities
        listadoLinks = listadoLinksEntreCiudades cadenaCities links
        capacidadTotal = sum (map capacityL listadoLinks)
