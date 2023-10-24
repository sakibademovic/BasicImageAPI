# BasicImageAPI

Korištena tehnologija uključuje najnoviju verziju Spring Boot 3.2.0 i Java 21, te PostgreSQL bazu podataka.

Prvi korak je bio definiranje modela Image, čiji objekt predstavlja zapis o fotografiji. Za ovu svrhu korištena je biblioteka Lombok koja automatski generira gettere, settere i konstruktore za našu klasu, što značajno smanjuje količinu repetitivnog koda. Hibernate validatori su korišteni za provjeru ispravnosti polja (npr. @NotBlank, @URL, @Min), što nam osigurava da će svaka instanca Image klase biti validna i da neće narušiti integritet baze podataka.

Osim osnovnih polja poput imena, opisa, autora, URL-a slike i dimenzija slike, dodane su i specifične anotacije poput @ElementCollection, što omogućuje mapiranje kolekcije jednostavnih tipova. U ovom slučaju, koristili smo je za mapiranje liste tagova. Mogao sam koristiti @ManyToMany odnos između Image i Tag entiteta, ali to bi bilo pretjerano za potrebe ovog zadatka. Odnos ManyToMany bi kreirao dodatnu tabelu i dodao složenost. Odabir @ElementCollection ima nekoliko prednosti: jednostavniji je za korištenje, ne zahtijeva kreiranje dodatne klase za Tag, ne kreira dodatnu tabelu za relaciju, a također ostaje u skladu s našim domenskim modelom.

Indeksi su dodani na ključna polja kao što su ime, autor, datum kreiranja i datum modifikacije. To će omogućiti brže pretraživanje i sortiranje zapisa fotografije po ovim poljima. Što se tiče polja "tags" za indeksiranje ovog polja je korištenje Postgresovog GIN index.

Error handling u aplikaciji sprovedeno je kroz centralizirani pristup koristeći Springovu @ControllerAdvice anotaciju. Ova anotacija koristi se kako bi se rukovalo errorima na razini cijele aplikacije iz jednog, centraliziranog mjesta.

Za implementacija filtriranja smo koristili ANTLR, moćan parser za jezike, u ovom slučaju koristili smo ga za prepoznavanje upita za filtriranje. ANTLR je odabran zbog svoje fleksibilnosti i robusnosti u prepoznavanju složenih, ugniježđenih upita.

Omogućio je vemo jednostavno parsiranje upita kao što su : filtrt = tag eq 'Car' and ( author eq 'bera' or ( author eq 'emin' and name eq 'slika15' ) ). 

Filtriranje je urađeno tako da kroz male izmjene u ANTLR gramatici možemo podrzati još polja koja možemo pretraživati kao i dodatne operatore.
