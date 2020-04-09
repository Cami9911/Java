Am creat clasele:

Token:
-contine un number care va fi "piesa jocului"

Board:
- in constructoul Board se genereaza numere de la 0 la size-ul dat si fiecaruia i se atribuie cate un token
- prin metoda getBoard() se verifica daca s-a creat un board si il returneaza, iar in caz contrar il creeaza
- metoda checkBoard() verifica daca board-ul este gol
- metoda getToken() primeste o pozitie si returneaza elementul de pe pozitia respectiva
- getCurrentSize() returneaza numarul actual de token-uri

Player:
- metoda run() apeleaza chechBoard() ca sa verifica daca boardul e=are vreun element, dupa care genereaza o pozitie random
- metoda getToken() notifica daca a primit vreun semnal, asteapta sa isi faca treaba celalalt player, ia un token din board si il adauga la lista
- metoda hasWon() verifica daca diferenta dintre 2 numere conecutive este egala cu diferenta dintre ultimele doua numere

 
  
Game:
- se creeaza 2 jucatori si cate un thread pentru fiecare jucator
- fiecare thread da start jocului apeland functia run()
- cat timp tabla nu este goala, fiecare player joaca
- se apeleaza metoda hasWon() si se verifica conditia de castig
  - in caz afirmativ, jucatorul a castigat deorece s-a format progresia aritmetica
  - altfel, jocul continua
  - daca nu se formeaza nicio progresie, atunci este remiza (nimeni nu a castigat)
