import Point
import City
import Quality
import Link
import Tunel
import Region

cityA = newC "CBA" (newP 100 100)
cityB = newC "CABA" (newP 150 60)
cityC = newC "Mendoza" (newP 20 60)
cityD = newC "Ushuaia" (newP 100 0)
cityE = newC "Salta" (newP 70 150)
cityF = newC "Montevideo" (newP 160 80)
cityG = newC "Punta del Este" (newP 200 80)
cityH = newC "Asunción" (newP 150 250)
cityI = newC "Santiago" (newP 0 60)

cities = [cityA, cityB, cityC, cityD, cityE, cityF, cityG, cityH, cityI]

quality1 = newQ "Q1" 4 2.5
quality2 = newQ "Q2" 7 5.0
quality3 = newQ "Q3" 15 4.5

-- Túneles:
-- Córdoba --> Mendoza --> Ushuaia
-- CABA --> Córdoba
argentina :: Region
argentina = tunelR (tunelR 
                (linkR (linkR (linkR (linkR (linkR (linkR 
                    (foundR (foundR (foundR (foundR 
                    (foundR newR cityA) 
                    cityB) cityC) cityD) cityE)
                cityA cityD quality3) cityD cityC quality3) cityC cityE quality3) cityE cityB quality2) cityA cityB quality3) cityA cityC quality3)
            [cityA, cityC, cityD]) [cityB, cityA]

-- Túneles:
-- CABA --> Córdoba --> Mendoza --> Santiago
-- CABA --> Montevideo
conosur :: Region
conosur = tunelR (tunelR 
                (linkR (linkR (linkR (linkR (linkR 
                    (foundR (foundR (foundR (foundR (foundR (foundR 
                    (foundR newR cityA) 
                    cityB) cityC) cityD) cityF) cityH) cityI)
                cityB cityA quality3) cityA cityC quality3) cityC cityI quality3) cityI cityD quality2) cityB cityF quality2)
            [cityB, cityA, cityC, cityI]) [cityB, cityF]