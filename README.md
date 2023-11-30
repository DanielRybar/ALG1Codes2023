# Algoritmizace  a programování 1

* [PODMÍNKY ZÁPOČET](./src/zapocet/zapocet.md)
* [DOKUMENTACE K SEM. PRÁCI](./src/semestralProject/U06PolySumAndProductRybarDocumentation.md)
* [PŘEHLED KE ZKOUŠCE](./src/assignments07_multidimensional_arrays/ALG1-Algoritmy-a-primitiva.pdf)

## Konfigurace repozitáře
### Klonování repozitáře
1) Nový NetBeans projekt
2) Team - Git - Initialize Repo
3) Team - Remote - Pull

- pro autentizaci - nutné generovat **token** (nikoli použít heslo)
- Github Settings -> Developer Settings
- pokud je projekt **verzovaný**, u ikonky kávy je **váleček**

### Uložení a odeslání změn
- commit (+ commit message)
- push

### Globální konfigurace (jméno a email)
```bash
Rybar1-D-5391@a2-02-mti MINGW64 ~
$ git config --global user.name "Daniel Rybar"

Rybar1-D-5391@a2-02-mti MINGW64 ~
$ git config --global user.email "daniel.rybar1@tul.cz"
```

### Větvení
- implicitní je větev **main**, lepší je commitovat do jiné větve a když je to hotové, tak vytvořit **Pull request** a sjednotit větve

#### Přepnutí větví
- vylistování vzdálených větví
```bash
git branch -r
```
- přepnutí
```bash
git checkout -b local_branch_name origin/remote_branch_name
```

### Issues
- oznámení (pokud je hotovo), do Asignees přidat vyučující a odeslat
- finální obsah je v **main**

## Java
- verze **17**
- **NetBeans 12.6**

### Zvolení implicitní main class v NB
- pravé tlačítko na projekt - Properties - Run - MainClass
- spuštění aktuálně otevřeného kódu - **Shift+F6** (nemusí být main)

### Zkompilovaný *.jar soubor
- **Clean+Build**, potom bude v */projekt/dist/projekt.jar*
```powershell
java -jar "C:\Users\Rybar1-D-5391\Documents\NetBeansProjects\2324ALG1\dist\2324ALG1.jar"
```

### Spouštění z terminálu
- kompilace (vznikne soubor **HelloWorld.class**, uvnitř bude zkompilovaný bytecode)
```powershell
C:\Users\Rybar1-D-5391\Documents>"C:\Program Files\Java\jdk-17.0.2\bin\javac" Hello_World.java
```
- spuštění
```powershell
C:\Users\Rybar1-D-5391\Documents>"C:\Program Files\Java\jdk-17.0.2\bin\java" HelloWorld <argumenty>
Hello, World!
```