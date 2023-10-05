# Algoritmizace  a programování 1

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
```
Rybar1-D-5391@a2-02-mti MINGW64 ~
$ git config --global user.name "Daniel Rybar"

Rybar1-D-5391@a2-02-mti MINGW64 ~
$ git config --global user.email "daniel.rybar1@tul.cz"
```

### Větvení
- implicitní je větev **main**, lepší je commitovat do jiné větve a když je to hotové, tak vytvořit **Pull request** a sjednotit větve

### Issues
- oznámení (pokud je hotovo), do Asignees přidat vyučující a odeslat
- finální obsah je v **main**