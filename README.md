
![nyelogo_vonallal](https://github.com/vellt/rft/assets/61885011/6785177f-835d-4d23-ad74-198c7a76ac96)


# Programozási Technológiák - BPI1116L

## 🎮 WUMPUS
A félév során a hallgatóknak önállóan kell lefejleszteni egy Java parancssoros labirintus játékot

## ‼️ Főbb paraméterek a projekttel kapcsolatban
- Tudjon nevet bekérni
- Játékállapotot tudjon adatbázisba írni, és olvasni
- Pályát tudjon beolvasni vagy készíteni és beolvasni
- Pálya elemei: W -- fal, H -- hős, U -- wumpusz, P -- verem, G -- arany, _ -- üres
- Mind a fájlbeolvasásnál, mind a szerkesztés vége jelzése után validálni kell az inputot a helyes darabszámokra is. ❌
- játékban:
  - A HŐS minden pillanatában legyen olyan tulajdonsága, hogy merre néz; valamint, hogy hány nyila van (a nyilak száma kezdetben megegyezik a wumpuszok számával)
  - A HŐS-nek legyenek ilyan akciói: lép, fordul jobbra, fordul balra, lő, aranyat felszed
  - A lövés hatása: a nyíl egyenesen, a hős nézési irányába indul, a falakon nem tud átmenni -- ott megsemmisül, de ha előtte eltalálja a wumpuszt,
  - akkor az lekerül a pályáról, egy sikolyt hallatva (ezt nem kell most implementálni) ❌
  - A verembe lépve, elveszit egy nyilat
  - A wumpuszra lépve meghal a hős
  - A felszedés hatása, hogy már birtokolja az aranyat a hős
  - Legyen olyan akció is, hogy "felad", akkor kilépünk a játékból
  - Legyen olyan akció is, hogy "halasztás", akkor elmentjük a játékállást, társítva a felhasználói névvel
  - Ha a hős teljesítette a küldetést, akkor
    - elmentjük a felhasználónevet és a pontszámot -- ezt az 1. fázisban még nem kell
    - kiírjuk, hogy ennyi-meg-ennyi lépéssel teljesítetted a pályát, ügyes vagy, s visszalépünk az alapmenübe
- Elvárások a védéssel kapcsolatban:
  - A Maven projekt az alábbi konfigurációkat tartalmazza:
    - Plugin-ek:
      - org.apache.maven.plugins.maven-jar-plugin - annak érdekében, hogy felkonfiguráljuk az alkalmazásunk belépési pontját (Main Class)
      - org.apache.maven.plugins.maven-assembly-plugin - annak érdekében, hogy egy függõségeket tartalmazó, futtatható JAR fájl jöjjön létre az alkalmazás build-elése eredményeként
      - org.jacoco.jacoco-maven-plugin - annak érdekében, hogy a megírt Egység tesztek kód lefedettségét tudjuk mérni
      - org.apache.maven.plugins.maven-checkstyle-plugin - annak érdekében, hogy a projekten elkövetett kód formázási hibákat és egyéb rossz praktikák automatikus detektáljunk
    - Függõségek:
      - JUnit5
      - Mockito
      - Logback
  - Az alkalmazás Objektum Orientált modellezésének megkezdése
    - Az alkalmazásunkhoz szükséges VO (Value Object) osztályok létrehozása
      - (ügyelve és figyelembe véve a "best practice"-eket: Object methods overriding, Immutability, stb)
      - betartva a Clean Code szabályaitű
  - Egység tesztek 80% lefedettséget biztosítanak üzleti logikát tartalmazó osztályokra (tehát például VO osztályokra nem szükséges egységteszteket írni)
  - A teljes játék funkcionalitás lefejlesztésre került (lehetséges egy játékot végig játszani elejétõl a végéig)
  - A projekt a mvn clean install parancs futtatására hiba nélkül fordul
  - Az alkalmazás egy adatbázisba lementi a játékosok nevét és azt, hogy hányszor nyertek
    - Az alkalmazás képes megjeleníteni parancssorban egy high score táblázatot (melyik játékos hány meccset nyert) ❌
  - Opcionális (plusz pontért): egy aktuálisan folyamatban lévõ játék állást az alkalmazás képes egy XML fájlba kimenteni és késõbb visszatölteni (tehát a játékos onnan folytathatja a játékot, ahol korábban abba hagyta) ❌
<br>

<p align="center">
 📝 <a href="https://github.com/vellt/wumpus/blob/master/tervezesimintak.md" target="_blank">Beadandó</a> &nbsp&nbsp&nbsp&nbsp&nbsp
 ✅ <a href="https://github.com/vellt/wumpus/tree/master/src/test/java/hu/nye/progtech/gamelogic" target="_blank">Tesztek</a> &nbsp&nbsp&nbsp&nbsp&nbsp
 ⛔ <a href="https://github.com/vellt/wumpus/blob/master/.gitignore" target="_blank">Gitignore</a> &nbsp&nbsp&nbsp&nbsp&nbsp
 ⚙️ <a href="https://github.com/vellt/wumpus/tree/master/src/main/java/hu/nye/progtech" target="_blank">Játék logika</a>&nbsp&nbsp&nbsp&nbsp&nbsp
 📋 <a href="https://github.com/vellt/wumpus/blob/master/wumpus.log" target="_blank">Logok</a>&nbsp&nbsp&nbsp&nbsp&nbsp
 📌 <a href="https://github.com/vellt/wumpus/blob/master/pom.xml" target="_blank">Pom.xml</a>
 
</p>

<br>
<br>


<p align="center">
  <img align="center" src= 'https://github.com/vellt/rft/assets/61885011/6f3f64c5-d96e-4800-8179-ea5076484cd0' width='20%' >
</p>

<br>
