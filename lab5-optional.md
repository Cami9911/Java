# Java
Clasa Shell
- adauga toate comenzile intr-un ArrayList si contine si un get

Clasa Command
- este abstracta
- contine proprietatile name, arguments si functia abstracta execute implementata in clasele LoadCommand, ListCommand si ViewCommand

LoadCommand
- suprascrie functia execute
  - verifica sa se primeasca doar un argument (inafara de numele comenzii), daca nu arunca o exceptie customizata
  - daca argumentul nu incepe cu "c:" se arunca o exceptie
  - de asemenea, arunca o exceptie customizata daca argumentul este invalid

ListCommand
- suprascrie functia execute care: 
  - verifica sa se primeasca doar un argument (inafara de numele comenzii), daca nu arunca o exceptie customizata
  - afiseaza numele, id-ul si locatia documentelor
  
 ViewCommand
 - suprascrie functia execute care: 
  - verifica sa se primeasca doar un argument (inafara de numele comenzii), daca nu arunca o exceptie customizata
  - vizualizeaza fisierele
  
 clasa Document
 -are proprietatile name, id si location, set-ere, get-ere, constructor, un HashMap pentru tag-uri si o functie care adauga tag-urile in map.

calsa CatalogUtil
-functia saveText
  - am creeat un obiect de tipul FileWriter
  - am creeat un obiect de tipul PrintWriter care permite scrierea intr-un fisier 
  - cu printWriter scriu toate informatiile de care am nevoie in fisier

-functia loadText
  - citesc ce am in buffer
  - am creat un document cu parametrii id, nume, locatie pe care le citesc din fisier linie cu linie
  - adaug in document tag urile intr-un map care contine o cheie si o valoare
  - cu functia "catalog.add(document)" adaug toate documentele in catalog
  
 -functia view
  - daca path-ul incepe cu "http" deschide fisierul in browser, daca nu il deschide local
  
  Main
  - citesc comenzile de la tastatura
  - verific toate exceptile
  - execut comenzile
  
  clasa ArgumentLipsaExceptii
  - arunca o exceptie customizata daca un argument este lipsa
  
  clasa ExceptieArgumentInvalid
  - arunca o exceptie customizata daca un argument este invalid
