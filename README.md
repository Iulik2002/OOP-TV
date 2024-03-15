OOP_TV - etapa 2;
Cozmac Iulian 325 CD;
La fel ca la etaapa intai in clasa main am realizat workflow-ul principal al unui
user pe platforma creata si tot acolo am realizat citirea/scrierea din/in
fisierele json. Am o interfata CurrentPage care este implementata de fiecare
pagina de pe platforma creata. In directorul database imi iau datele de input,
adica realizez citirea acestora si in clasa Output am functii pentru inserarea 
outputului in fisierele json.

In directorul pages realizez practic tot ce poate face un usser pe site. Am 
paginile neautentificate si autentificate. 

Din clasa main in dependenta de cerintele usserului, ma mut pe fiecare pagina
posibila(in caz contrar afisez eroare) sau fac anumite operatii pe o anumita
pagina. Fiecare pagina a fost creata cu niste switch case-uri unde indic 
posibilitatile de pe o anumita pagina. 

Pentru paginile SeeDetails si Upgrades am realizat implementarea workflow-ului
in clase separate pentru a-mi usura munca si creearea unui cod cat mai lizibil
(ceea ce nu mia reusit in clasa MoviesPage :) ). In clasa MoviesPage am facut 
niste functii lambda cu ajutorul carora am facut sortarile.

Imi pare rau ca nu am scris comentarii in cod, am realizat tema pe ultima 
suta de metri si eram presat de timp. 