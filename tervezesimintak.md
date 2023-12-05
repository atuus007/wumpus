# Tervezési minták egy OO programozási nyelvben. 
> MVC, mint modell-nézet-vezérlő minta és néhány másik tervezési minta

## I. Bevezetés
Napjainkban, ahol az alkalmazások komplexitása és mérete folyamatosan növekszik, elengedhetetlen, hogy a fejlesztők olyan tervezési mintákat alkalmazzanak, amelyek segítik a strukturált és rugalmas programfejlesztést. Hiszen egy alkalmazás sosem mondható késznek. Folyamatosan bővül, fejlődik, ezért jól karbantarthatónak, átláthatónak kell maradnia. Ehhez pedig általánosított, újrafelhasználhatósági módszerek kellenek, mellyel gyakori problémákra kapunk egyszerű, gyors megoldásokat. Erre pedig a megoldás a tervezési minták, amennyiben kódszinten tekintünk magára az alkalmazásra. Ha viszont távolabbról nézzük, az architektúrális minták is nagyban megkönnyítik az alkalmazások karbantarthatóságát, bővíthetőségét.



## II. Tervezési minták
A tervezési minták fő szerepkörét a bevezetésben részleteztem, de pár pontban itt is levezetem:
-	Újrafelhasználhatóság
-	Rugalmas fejlesztés
-	Karbantarthatóság
-	Standardizáció:
  Ezt külön nem részleteztem a bevezetésben. A Standardizáció, mint tulajdonsága a tervezési mintának azt jelenti, hogy meghatározott problémákra szabványosított megoldást tud kínál.

### Tervezési minták fajtái:
A tervezési minták több csoportból áll, viszont kiemelkedik a következő 3 csoport:
-	Létrehozási 
-	Strukturális 
-	Viselkedési

Ezen három kategória alkotja a GoF (Gang of Four) által definiált tervezési minták hármasát, melyek a "Design Patterns: Elements of Reusable Object-Oriented Software" című könyvben jelentek meg. Ezek a kategóriák jól körbeírják az objektumorientált szoftvertervezés különböző dimenzióit, és segítik a tervezőket azok különböző szempontjainak megértésében és kezelésében.

![image](https://github.com/vellt/wumpus/assets/61885011/a5e4a608-87fb-48ee-8dca-0d2440792be3)

#### Létrehozási (Creational) minták: 
Arra összpontosítanak, hogyan hozzunk létre objektumokat. Ez kulcsfontosságú a kódbázis inicializálásában és az objektumok létrehozásának módjában.
-	**Singleton minta** biztosítja, hogy egy osztályból csak egyetlen példány létezzen
-	**Factory minta** segít az objektumok létrehozásának elválasztásában a konkrét osztálytól.
-	**Builder minta** segítségével könnyen létrehozhatunk összetett objektumokat részletek szerint.

#### Strukturális (Structural) minták: 
Arra összpontosítanak, hogy az osztályok és objektumok hogyan rendeződjenek el egymáshoz képest. Ez segít az alkalmazás alapstruktúrájának megtervezésében.
-	**Adapter minta** segít két inkompatibilis interfész közötti kommunikációban
-	**Decorator minta** lehetővé teszi a funkcionalitás dinamikus kiterjesztését objektumokhoz.

#### Viselkedési (Behavioral) minták: 
Arra összpontosítanak, hogy az objektumok hogyan kommunikálnak egymással és hogyan adják meg a viselkedésüket. Ez fontos az alkalmazás viselkedési aspektusainak irányításában.
-	**Strategy minta** lehetővé teszi, hogy egy objektum változó algoritmussal viselkedjen
-	**Observer minta** segíti az egyik objektumot az események figyelésében és a változásokra való reagálásban
-	**Command minta** segít egy kérés kibővíthető és elválasztható reprezentálásában.


## III. Arhitektúrális minták:
Az architektúrális minták olyan koncepciók és elrendezések, amelyek segítenek az alkalmazások meghatározott feladatkörök struktúrális kialakításában, komponensek és kapcsolatok révén. 

### Az egyik ilyen kulcsfontosságú architektúrális minta a MVC (Modell-Nézet-Vezérlő).
Az MVC egy olyan szoftvertervezési minta, amely elválasztja az alkalmazás három alapvető részét: a Modellt (Model), a Nézetet (View) és a Vezérlőt (Controller). 
Ez a szétválasztás lehetővé teszi, hogy a változások az egyik részben ne befolyásolják szorosan a többit, ezáltal javítva a karbantarthatóságot és a fejleszthetőséget.

![image](https://github.com/vellt/wumpus/assets/61885011/03f4726f-c0fb-4bd3-9bee-3dd0b8ec6f16)

#### Szerepkörök jellemzése
-	**Modell**: A Modell reprezentálja az alkalmazás üzleti logikáját és adatmodelljét. Itt valósulnak meg az adatok kezelése és a belső műveletek.
-	**Nézet**: A Nézet a felhasználói interfészt (UI-t) kezeli, és felelős az adatok megjelenítéséért. A Nézet információt kér a Modelltől és megjeleníti azt a felhasználónak.
-	**Vezérlő**: A Vezérlő kapcsolatot biztosít a Modell és a Nézet között. Fogadja a felhasználói interakciókat (például gombok lenyomását), feldolgozza azokat, és irányítja a szükséges műveleteket a Modell és a Nézet felé.

#### Egyszerű példa: 
Egy webalkalmazás esetében a Modell tartalmazhatja az adatbázis-kezelő kódot, a Nézet lehet az HTML és a CSS, a Vezérlő pedig a szerveroldali kódot, amely kapcsolódik a Modellhez és elvégzi a szükséges műveleteket.



