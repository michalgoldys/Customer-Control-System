# Customer-Control-System
/**
*Aplikacja wspomagająca zarządzanie bazą klientów branży telemetrycznej.
*Powstała na wzór oraz potrzeby rynku firm telemetrycznych, oraz pojawiających się problemów z zarządzaniem kontrahentami.
*
*Umożliwia ewidencję kontrahentów, ich ilości poszczególnych abonamentów, zgłoszeń technicznych wraz z ich opisami i datą.
*Dodatkowo umozliwia wyszukiwanie oraz sortowanie wedle danych kolumn z podziałem na strony wyszukiwania.
*
*Posiada możliwość oznaczania klientów jako aktywnych/nieaktywnych z automatycznym przy tej czynności wstawianiem daty,
*oraz późniejszą walidacją możliwości i zapobiegania ponownemu oznaczeniu kontahenta jako niekatywny.
*
*Posiada panel użytkowników, dzięki czemu istnieje możliwość tworzenia kont oraz nadawanie uprawnień (admin, user),
*gdzie user może przeglądać wpisy, a admin je edytować. Dodatkowo user ma możliwość dodawania zdarzeń technicznych 
*wraz z datą.
*
*Hasła kodowane są za pomocą BCrypt. 
*
*Wszystko zapisywane jest do bazy danych MySQL która tworzona jest (jeżeli nie istnieje) przy uruchomieniu programu, wraz
*z domyślnym użytkownikiem administracyjnym (admin). 
*
* @author Michal Goldys
*/