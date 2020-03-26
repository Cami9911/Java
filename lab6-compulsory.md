# Java
Am construit clasele:

- RegularPolygon
  - permite creearea poligonului regulat
 
 - NodeShape
  - permite creearea altor poligoane
  
 - DrawingPanel
  - functia createOffscreenImage()
    - se face design-ul backgound-ului
  - functia init()
    - se apeleaza functionaliatile mouse-ului
  - functia drawShape()
  - se selecteaza numarul de laturi, marimea
  - verificam daca culoarea formelor e aceeasi cu cea din ConfigPanel pentru a putea fi selectata
  
- ControlPanel
  - se implementeaza butoanele save, load, reset si exit
 
- ConfigPanel
  - desenam poligonul
  - alegem numarul de laturi
  - alegem culoarea formelor
 
- MainFrame
  - creeaza componentele ecranului aplicatiei
  - pozitioneaza butoanele
