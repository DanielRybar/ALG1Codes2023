## Dokumentace k semestrální práci
### Úloha 06 - Součet a součin polynomů
---
#### Specifikace
Cílem úlohy je vyhodnotit **součet a součin** dvou zadaných **polynomů**. Vstupní polynomy jsou zadány **stupněm a jednotlivými koeficienty**. Program má umožnit při jednom spuštění zpracování **libovolného počtu** dvojic polynomů. Pro každý polynom bude zadán stupeň a jeho koeficienty. Program se má ukončit v případě, že bude zadán **záporný stupeň** prvního polynomu.
Jelikož nemůžeme předvídat, jestli uživatel opravdu zadá celé číslo, když k tomu bude vyzván, přidal jsem do kódu i **validaci vstupu**. Narazil jsem také na chybu v ukázkovém kódu v zadání:
```
Stupen druheho polynomu:
3
Koeficienty druheho polynomu:
2 0 -5
Druhy polynom: 2x^3 - 5
```
Druhý polynom by měl být `2x^3 + 0x^2 - 5x + 0`, po úpravě tedy `2x^3 - 5x`. Tato hrubá nepřesnost v mém programu není.

#### Návrh řešení
V podstatě celou logiku aplikace - tedy součet a vynásobení polynomu jsem podle konvencí odsunul do **samostatné třídy** `Polynomial`. Tato třída obsahuje **parametrický konstruktor**, který přiřazuje do privátních atributů parametry předané při vytvoření instance. Obsahuje také dvě nejdůležitější metody - `addPolynomials` a `multiplyPolynomials`.
Ve třídě se také nachází metoda pro výpis polynomu - `toString`. Tato metoda slouží k vypsání daného objektu v řetězcové reprezentaci. Klíčové slovo `override` znamená, že v podstatě **přepisuji** implicitní metodu `toString`. Kdybych nechal kompilátor, aby použil původní metodu, tak by v tomto případě vypsala jen **adresu do paměti**, jelikož třída je **referenční datový typ**. Takže nejen z tohoto důvodu, ale i kvůli výslednému formátování, jsem ji musel přeimplementovat.

V hlavní metodě `Main` se již nachází samotné **načítání vstupů** od uživatele a jejich validace. Zajímavý je tady podprogram `validateNumber`, který zjišťuje, zda je na **vstupu skeneru číslo**, a pakliže není, tak nutí uživatele opakovat zadávání tak dlouho, dokud číslo nezadá.

##### Slovní popis vybraných algoritmů
*Součet polynomů*
```
- mám dva polynomy
- vysledny_stupen = určím stupně u obou a vyberu si ten vyšší (tak to funguje u sčítání polynomů)
- vysl_koeficienty = pole, do kterého uložím výsledné koeficienty (velikost bude vysledny_stupen + 1 -> např. pro polynom 3st. jsou 4 koeficienty)
- 1. cyklus - pro přidání koeficientu z polynomu1 do výsledného pole - iterace od 0 do stupně dílčího polynomu
- 2. cyklus - pro přidání koeficientu z polynomu1 do výsledného pole (přičte se již k přidaným koeficientům z polynomu1) - iterace od 0 do stupně dílčího polynomu
```
*Součin polynomů*
```
- mám dva polynomy
- vysledny_stupen = sečtu stupně u prvního a druhého polynomu (tak to funguje u násobení polynomů)
- vysl_koeficienty = pole, do kterého uložím výsledné koeficienty (velikost bude vysledny_stupen + 1 -> např. pro polynom 3st. jsou 4 koeficienty)
- při násobení 2 mnohočlenů platí pravidlo "každý s každým", budu tedy potřebovat 2 cykly v sobě (informace o indexech mnohočlenů)
- 1. cyklus (vnější) - informace o "poloze" koeficientů v 1. polynomu, iterační proměnná i
- 2. cyklus (vnitřní) - informace o "poloze" koeficientů v 2. polynomu, iterační proměnná j
    - vnitřek -> do pole na indexu i+j přičtu násobek odpovídajících mocnin polynomů
```
*Validace čísla*
```
- proměnnou cislo nastavím na 0
- proměnnou je_validni nastavím na false
- použiji cyklus s podmínkou na konci (do-while) - budu testovat, zda je následující položka ve skeneru typu int, a pokud ano, přiřadím ji do proměnné cislo a neguji podmínku - na konci se pak cyklus ukončí
- pokud ne, zobrazím uživateli chybovou zprávu, s podmínkou nebudu dělat nic a opakuji celý cyklus
```

#### Testování
| Číslo testu 	| Typ testu, popis vstupů                                	| Očekávaný výsledek                   	| Skutečný výsledek                    	| Prošel 	|
|-------------	|--------------------------------------------------------	|--------------------------------------	|--------------------------------------	|--------	|
| 1           	| **běžné hodnoty** (ze zadání) - 1. st., malé koeficienty    	| viz zadání                           	| odpovídá zadání                      	| ANO    	|
| 2           	| **běžné hodnoty** (ze zadání) - 0., 3. st, malé koeficienty 	| viz kapitola specifikace                 	| odpovídá specifikaci                 	| ANO    	|
| 3           	| **velké hodnoty** - 8. st., velké a nulové koeficienty      	| spočítáno v Matlabu                  	| odpovídá výsledku z Matlabu          	| ANO    	|
| 4           	| **limitní stav** - záporný stupeň polynomu, samé nuly      	| ukončení programu / prázdný výsledek 	| ukončení programu / prázdný výsledek 	| ANO    	|
| 5           	| **nevalidní vstup** - znak, řetězec, nesmysly              	| chybová hláška, opakované zadávání   	| chybová hláška, opakované zadávání   	| ANO    	|

#### Screenshoty testů
[Test 1](./img/test01.png)

[Test 2](./img/test02.png)

[Test 3](./img/test03.png)

[Test 4](./img/test04.png)

[Test 5](./img/test05.png)