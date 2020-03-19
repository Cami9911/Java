# Java
Am creat o clasa Catalog cu proprietatile name si path, set-ere, get-ere, constructor si metoda findById care verifica daca id-ul dat este
acelasi cu id-ul documentului.

Am creat o clasa Document cu proprietatile name, id si location, set-ere, get-ere, constructor, un HashMap pentru tag-uri si o functie care
adauga tag-urile in map.

Am creat clasa CataloUtil care contine urmatoarele metode:
- save: salveaza catalogul intr-un fisier extern, utilizand serialization
- load: deschide fisierul catalog.ser si il incarca (il citeste)
- view: daca path-ul incepe cu "http" deschide fisierul in browser, daca nu il deschide local

In Main am urmatoarele metode:
- testCreateSave: creeaza un fisier si il salveaza intr-un path pe care i-l dau
- testLoadView: deschide fisierul creat
Am facut un obiect de tipul Main cu care am apelat cele 2 functii
