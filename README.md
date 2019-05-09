# ukf.wapj.JEEWebAppSkelet
### Moje riešenie:
- Rozšíril som DB o kategórie (one-to-many vzťah)
- V aplikácii som vytvoril Category entitu, DAO pre túto entitu a namapoval som vzťahy
- Zmenil som vzhľad stránky
  - Namiesto PrimeFaces som použil BootsFaces (komponenty) a Bootstrap (layout)
  - Pridal som Morris.js grafy (iba cez CDN), dáta pre tieto grafy musia byť v JSON, takže som ešte pridal Gson dependency
  - Aplikácia obsahuje navigáciu, cez ktorú sa vieme dostať na úvodnú stránku a stránky pre knihy, autorov, a kategórie
  - Na tabuľky som aplikoval DataTables, ktoré umožňuje stránkovanie, zoradenie a vyhľadávanie údajov
- Každá entita má vlastnú stránku na ktorej sa dá cez formulár pridať nový záznam (knihám sa dá cez selectOneMenu pridať autor a kategória

### Screenshoty
![image](https://user-images.githubusercontent.com/31664842/57442199-c2edf880-724b-11e9-8537-57b9d0638c04.png)
![image](https://user-images.githubusercontent.com/31664842/57442245-d9944f80-724b-11e9-9bf9-414daed1a101.png)
![image](https://user-images.githubusercontent.com/31664842/57442309-fb8dd200-724b-11e9-851c-7b44aed1183f.png)
