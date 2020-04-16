Am creat clasele:

Database:
- are un constructor privat Database() unde se face conexiunea cu baza de date
- metoda getObject() verifica daca conexiunea e inchisa sau obiectul e gol si face un obiect nou
- metoda closeConnection() inchide conexiunea

ArtistController
- in constructor ma conectez la baza de date
- cu metoda create() imi creez coloanele name si country in baza de date
- cu metoda findByName() fac un select care cauta artistul dupa nume si imi returneaza tara din care provine
- cu metoda findIdByName() caut dupa nume, id-ul artistului pentru a-i gasi mai usor albumele
  - aceasta metoda este foarte folositoare daca am adaugat foarte multe albume si vreau sa le gasesc
  
AlbumController
- in constructor ma conectez la baza de date
- cu metoda create() imi creez coloanele name, artistId si releaseYear country in baza de date
- cu metoda findByArtist() caut artistul dupa id si returnez numele si anul

Main
- cu metoda addData() apelez metodele din ArtistController si AlbumController pentru a introduce date in baza de date
- cu metoda printData() afisez datele introduse
