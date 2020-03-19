# Java

Am creat o functie Resident (cu get-erele si set-erele corespunzatoare proprietatii "name" + constructorul) si mi-am facut 4 obiecte 
de acest tip pe care le-am adaugat intr-un ArrayList.
Apoi am sortat obiectele crescator in functie de nume si le-am afisat.

Am creat o functie Hospital (cu get-erele si set-erele corespunzatoare proprietatilor "name" si "capacity" + constructorul) si 3 obiecte
de acest tip pe care le-am adaugat intr-un TreeSet.
In clasa Hospital am suprascris functia compareTo pentru a ma asigura ca obiectele Hospital sunt comparabile.

Am creeat un Map cu cheia resident si valorile hospitals pe care l-am implementat cu LinkedHashMap.
Am creear un Map cu cheia hospital si valorile residents pe care l-am implementat cu HashMap.

In lista cu rezidenti am pus toate obiectele intr-un stream si le filtram in fctie de conditia : mapul resPrefMap sa contina obiectele
ho,h2, date sub forma unei liste la cheia resident. Prin filtrare, pastreaza in stream doar rezidentii corecti, dupa care ii afiseaza.

In lista cu spitale am pus toate obiectele intr-un stream si le-am filtrat astfel incat sa verifice daca pe pozitia 0 am obiectul cerut
si sa imi afiseze numele spitalelor
