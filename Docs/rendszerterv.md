# Rendszerterv
## 1. A rendszer célja
Az alkalmazás célja egy változatos és szórakoztató szerencsejáték szimuláció biztosítása, amelyben a felhasználók különböző játékokat próbálhatnak ki. A fő cél az, hogy az alkalmazás vonzó alternatívát nyújtson a szerencsejáték függőséggel küzdők számára, segítve őket abban, hogy inkább biztonságos környezetben játszanak. A rendszer céljai közé tartozik továbbá a játékosok nyereség/veszteség arányának nyomon követése, az elemzések és statisztikák biztosítása a játékokról, valamint a felhasználói élmény folyamatos javítása és a felhasználói visszajelzések gyűjtése a fejlesztési folyamat során.
## 2. Projektterv

### 2.1 Projektszerepkörök, felelőségek:
  * Üzleti szereplő:
	  -   Megrendelő:
		  -  Troll Ede
     
### 2.2 Projektmunkások és felelőségek:
   * Frontend és backend:
     - Bodnár Máté
     - Herbák Marcell
   * Tesztelés:
     - Bodnár Máté
     - Herbák Marcell
     
### 2.3 Ütemterv:

|Funkció                  | Feladat                                | Prioritás | Becslés (nap) | Aktuális becslés (nap) | Eltelt idő (nap) | Becsült idő (nap) |
|-------------------------|----------------------------------------|-----------|---------------|------------------------|------------------|---------------------|
|Rendszerterv             |Megírás                                 |         1 |             1 |                      1 |                1 |                   1 |
|Program                  |Prototípus elkészítése                  |         2 |             3 |                      3 |                2 |                   1 |
|Program                  |Tesztelés                               |         3 |             1 |                      1 |                1 |                   1 |

### 2.4 Mérföldkövek:
   *   05.10. Projekt elkezdése
   *   05.11. Alap prototípus elkészítése
   *   05.12. Végleges prototípus elkészítése
   *   05.12. Tesztelés
   *   05.13. Bemutatás és átadás

## 3. Üzleti folyamatok modellje

### 3.1 Üzleti szereplők
Az alkalmazás regisztráció vagy bejelentkezés után válik elérhetővé, bárki tud regiszrálni. Minden felhasználó ugyanolyan jogkörrel rendelkezik.

### 3.2 Üzleti folyamatok
Az alkalmazás indulását követően a felhasználónak be kell jelentkeznie a funkciók eléréséhez.
- Általános folyamatok:
     - Regisztrálni az oldalra a megfelelő adatok magadásával.
     - Bejelentkezni az oldalra a regisztráció során megadott megfelelő adatokkal.
     - Bármikor kilépni az alkalmazásból.
     - Játék kiválasztása.
- Pénzfeldobó játék folyamatok:
	- Tét megtétele.
	- Tipp módosítása.
	- Legutóbbi dobások megtekintése.
	- Tipp elfogadása és részvétel a "sorsolásban".
- Kockadobó játék folyamatok:
  - Tét megtétele.
  - Páros/Páratlan számok tippelése.
  - Kisebb, egyenlő mint 3 vagy nagyobb mint 3 számok tippelése.
  - Pontos szám tippelése.
  - Tipp elfogadása és részvétel a "sorsolásban".

## 4. Követelmények

### Funkcionális követelmények

| ID | Megnevezés               | Leírás                                                                                                                                                                                   |
|----|--------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| K1 | Bejelentkezési ablak     | A felhasználónak egyes funkciók elérése előtt azonosítania kell magát, mielőtt elérhetné azokat.                                                                                         |
| K2 | Regisztráció             | A felhasználó itt tudja regisztrálni magát.                                                                                                                                              |
| K3 | Játékmód választás       | A fehasználó kiválaszthatja, mely játékmódot szeretné játszani.                                                                                                                          |
| K4 | Pénzfeldobó játék        | A pénzfeldobó játékban a felhasználó megteheti tétjét, hogy a szimulált pénzérme a feje vagy írása mutat felfelé, és az alapján kapja vissza megtett tétjét, amelyet tud módosítani is.  |
| K5 | Kockadobó játék          | A kockadobó játékban a felhasználó megteheti tétjét, hogy a szimulált dobókocka különböző tulajdonságaira, és az alapján kapja vissza megtett tétjét, amelyet tud módosítani is.         |
 
### Nemfunkcionális követelmények

| ID | Megnevezés                             | Leírás                                                                                                              |
|----|----------------------------------------|---------------------------------------------------------------------------------------------------------------------|
| K6 | Átlátható, könnyen kezelhető felület   | A felületek könnyen használhatóak, átláthatóak legyenek, intuitívak, illetve ne legyenek zsúfoltak.                 |
| K7 | Tervezési minták használata            | Az alkalmazás forráskódja tartalmazzon legalább 2 tervezési mintát. Mi esetünkben ez a Stratégia és a Command lesz. |

### Támogatott eszközök

 * Bármely Java alkalmazás futtatásra képes eszköz. Például otthoni számítógép, laptop, tablet. Preferáltabb Windows alapú rendszer.

## 5. Funkcionális terv

### 5.1 Rendszerszereplők
 - Felhasználó
   - Tétet tehet meg, és játszhat a játékmódokkal
 - "Gép"
   - Sorsolja az eredményeket

### 5.2 Menühierarchiák
- Főoldal (Bejelentkezés és Regisztráció)
- Pénzfeldobó játék
- Dobókocka játék

## 6. Fizikai környezet

### Vásárolt szoftverkomponensek, valamint esetleges külső rendszerek
Nincsenek vásárolt szoftverkomponensek.
### Hardver topológia
Olyan számítógép alkalmas, amely Windows 10 vagy 11 operációs rendszerrel rendelkezik.
### Fizikai alrendszerek
Kliens gépek: A követelményeknek megfelelő, Windows 10 vagy 11 operációs rendszerrel rendelkező PC-k.
Szerver (Host) gép: Az adatbázis rendszer és a háttérfolyamatokat ellátó szolgáltatáshoz szükséges összetevők itt találhatóak. A kliens gép ezzel kommunikál.
### Fejlesztő eszközök
 - IntelliJ IDEA
 - Visual Studio Code
 - XAMPP (MySQL)


## 8. Architekturális terv

### Webszerver

-XAMPP.

### Adatbázis rendszer

- MySQL alapú adatbázis rendszer.

### A program elérése, kezelése

- Szükséges Swing, XAMPP, ami az installáció esetén egy szervergép.


## 9. Adatbázis terv

![dbterv](https://github.com/herbakmarcell/gambasim_progtech/assets/128597041/139356a1-df93-4e2a-9172-66dbd2bd8f31)

## 10. Implementációs terv
A projektet két részre oszlik: a frontendre és a backendre. A frontend Java Swing segítségével készül, míg a backend Java keretrendszerben.
A program kódjában használt nyelv elsősorban az angol.
A szerver és az adatbázist összekötő csomag  felelős az adatbázis kezeléséért.
Mind a frontend, mind a backend fejlesztéséhez szükség van a IntelliJ környezet telepítésére és konfigurálására a szükséges eszközökkel és kiegészítőkkel
együtt.
## 11. Tesztterv

A tesztelések célja a rendszer és komponensei funkcionalitásának teljes vizsgálata,
ellenőrzése a rendszer által megvalósított üzleti szolgáltatások verifikálása.
A teszteléseket a fejlesztői csapat minden tagja elvégzi.
Egy teszt eredményeit a tagok dokumentálják külön unit teszt függvényekbe és metódusokba tárolja.

A tesztelés során a szoftver megfelelő működését vizsgáljuk. Amennyiben az elvártnak megfelelő eredményt kapunk, a teszt eset sikeresnek tekinthető, ellenkező esetben a hibát megpróbáljuk elhárítani, ha a teszt nem direkt nem sikerül.

### Tesztesetek

#### Tesztelés módja: Unit Teszt

 | Teszteset      | Elvárt eredmény                                                                                            | 
 |----------------|------------------------------------------------------------------------------------------------------------| 
 | Regisztráció   | A felhasználó az adatok megadásával sikeresen regisztrálni tud.                                            |
 | Bejelentkezés  | A felhasználó az adatok megadásával sikeresen be tud jelentkezni.                                          |
 | Tét megtétele  | Ha a felhasználó megfelelő mennyiségű egyenleggel rendelkezik, meg tudja tenni tétjét a megfelelő játékra. |
 | Játék indítása | A játék elindul, és az eredmény és felhasználó tippje alapján közli az eredményt.                          |

## 12. Telepítési terv

**Fizikai telepítési terv**:
 - A felhasználónak szüksége van egy működő számítógépre, amely rendelkezik internet hozzáféréssel.
 - A szoftverünk működéséhez szükség van egy szerverre. A szervernek kapcsolódni kell egy hálózathoz, hogy elérhető legyen.

**Szoftver telepítési terv**:
 - A felhasználónak szüksége van egy Windows 10 vagy 11 operációs rendszerre, amely támogatja a Java alkalmazásokat.
 - A szoftverünk futtatható Windows szerveren.
 - Szükség van valamilyen adatbázis szerverre, például MySQL:
   - Szükséges telepíteni az XAMPP nevű szoftvert.
   - Az adatbázis konfigurálása az XAMPP segítségével történik.
 - A backend és frontend konfigurálásához szükség van az  IntelliJ fejlesztői környezetre.
   -  Szükséges csomagok a Java.
 - A fejlesztők számára az alkalmazás szabadon konfigurálható, fejleszthető.
 - Abban az esetben, ha a szükséges beállítások megtörténtek, a felhasználók számára az alkalmazás futtatható

## 13. Karbantartási terv
