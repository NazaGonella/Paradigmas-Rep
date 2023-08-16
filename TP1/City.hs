module City ( City, newC, nameC, distanceC )
   where

import Point

data City = Cit String Point deriving (Eq, Show)

newC :: String -> Point -> City
nameC :: City -> String
distanceC :: City -> City -> Float

newC nombre punto = Cit nombre punto
nameC (Cit nombre punto) = nombre
distanceC (Cit nombre1 punto1) (Cit nombre2 punto2) = difP punto1 punto2