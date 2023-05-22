package zadanie_6;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Zadanie6 {

    public static void main(String[] args) {
        System.out.println("Ten program służy obliczaniu do obsługi kalendarza spotkań i zadańw danym tygodniu");
        System.out.println("Spotkania mogą odbyć się po godzinie: " + Element.NAJWCZESNIEJSZA_GODZINA);
        Kalendarz kalendarz = new Kalendarz();
        wyborOpcji(kalendarz);
    }

    private static void wyborOpcji(Kalendarz kalendarz){
        Scanner scan = new Scanner(System.in);
        boolean dzialanieProgramu = true;
        while (dzialanieProgramu){
            opcje();
            System.out.print("Podaj numer akcji: ");
            int wybor = scan.nextInt();
            switch (wybor) {
                case 1 -> dodanieSpotkanie(kalendarz);
                case 2 -> dodanieZadanie(kalendarz);
                case 3 -> usuwanieSpotkania(kalendarz);
                case 4 -> usuwanieZadania(kalendarz);
                case 5 -> spotkaniaDnia(kalendarz);
                case 6 -> zadaniaDnia(kalendarz);
                case 7 -> spotkaniaPriorytet(kalendarz);
                case 8 -> zadaniaStatus(kalendarz);
                case 9 -> spotkaniaPriorytetZCzasem(kalendarz);
                case 10 -> zadaniaStatusZCzasem(kalendarz);
                case 11 -> dzialanieProgramu = false;
                default -> System.out.println("Zła wartość!");
            }
        }
    }
    private static void dodanieSpotkanie(Kalendarz kalendarz){
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj numer dnia: ");
        int dzien = scan.nextInt();
        scan.nextLine();
        System.out.print("Podaj opis spotkania: ");
        String opis = scan.nextLine();
        System.out.print("Podaj priorytet spotkania: ");
        String priorytet = scan.nextLine();
        System.out.print("Podaj czas rozpoczęcia: ");
        String rozpoczecie = scan.nextLine();
        if(LocalTime.parse(rozpoczecie).isBefore(Spotkanie.NAJWCZESNIEJSZA_GODZINA)){
            System.out.println("ERROR: Podana godzina jest przed godziną rozpoczęcia pracy, podaj inną godzinę!");
            return;
        }
        System.out.print("Podaj czas zakończenia: ");
        String zakonczenie = scan.nextLine();
        if(LocalTime.parse(zakonczenie).isBefore(LocalTime.parse(rozpoczecie))){
            System.out.println("ERROR: Podana godzina jest przed godziną rozpoczęcia, podaj inną godzinę!");
            return;
        }
        LocalTime czasRozpoczecia = LocalTime.parse(rozpoczecie);
        LocalTime czasZakonczenia = LocalTime.parse(zakonczenie);
        kalendarz.dodajWydarzenie(opis,priorytet,czasRozpoczecia,czasZakonczenia,dzien);
    }
    private static void dodanieZadanie(Kalendarz kalendarz){
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj numer dnia: ");
        int dzien = scan.nextInt();
        scan.nextLine();
        System.out.print("Podaj opis zadania: ");
        String opis = scan.nextLine();
        System.out.print("Podaj status zadania: ");
        String status = scan.nextLine();
        System.out.print("Podaj czas rozpoczęcia: ");
        String rozpoczecie = scan.nextLine();
        if(LocalTime.parse(rozpoczecie).isBefore(Spotkanie.NAJWCZESNIEJSZA_GODZINA)){
            System.out.println("ERROR: Podana godzina jest przed godziną rozpoczęcia pracy, podaj inną godzinę!");
            return;
        }
        System.out.print("Podaj czas zakończenia: ");
        String zakonczenie = scan.nextLine();
        if(LocalTime.parse(zakonczenie).isBefore(LocalTime.parse(rozpoczecie))){
            System.out.println("ERROR: Podana godzina jest przed godziną rozpoczęcia, podaj inną godzinę!");
            return;
        }
        LocalTime czasRozpoczecia = LocalTime.parse(rozpoczecie);
        LocalTime czasZakonczenia = LocalTime.parse(zakonczenie);
        kalendarz.dodajWydarzenie(dzien,opis,status,czasRozpoczecia,czasZakonczenia);
    }

    private static void usuwanieSpotkania(Kalendarz kalendarz){
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj numer dnia: ");
        int dzien = scan.nextInt();
        ArrayList<Element> spotkania = kalendarz.pobierzWydarzenia(dzien,(s)-> s instanceof Spotkanie);
        wyswietlWszystkie(spotkania);
        System.out.print("Podaj numer spotkania do usuniecia: ");
        int numerSpotkania = scan.nextInt();
        int aktualneSpotkanie = 0;
        ArrayList<Element> wszystkieWydarzenia = kalendarz.pobierzWydarzenia(dzien,(s)-> true);

        for (int i = 0; i < wszystkieWydarzenia.size(); i++){
            if (wszystkieWydarzenia.get(i) instanceof Spotkanie) {

                if (aktualneSpotkanie == numerSpotkania) {
                    kalendarz.usunWydarzenie(dzien,i);
                    System.out.println("Spotkanie zostało usunięte.");
                    break;
                }
                aktualneSpotkanie++;
            }
        }

    }
    private static void usuwanieZadania(Kalendarz kalendarz){
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj numer dnia: ");
        int dzien = scan.nextInt();
        ArrayList<Element> wydarzenia = kalendarz.pobierzWydarzenia(dzien,(s)-> s instanceof Zadanie);
        wyswietlWszystkie(wydarzenia);
        System.out.print("Podaj numer zadania do usuniecia: ");
        int numerZadania = scan.nextInt();
        int aktualneZadanie = 0;
        ArrayList<Element> wszystkieWydarzenia = kalendarz.pobierzWydarzenia(dzien,(s)-> true);

        for (int i = 0; i < wszystkieWydarzenia.size(); i++){
            if (wszystkieWydarzenia.get(i) instanceof Zadanie) {

                if (aktualneZadanie == numerZadania) {
                    kalendarz.usunWydarzenie(dzien,i);
                    System.out.println("Zadanie zostało usunięte.");

                    break;
                }
                aktualneZadanie++;
            }
        }
    }

    private static void spotkaniaDnia(Kalendarz kalendarz){
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj numer dnia: ");
        int dzien = scan.nextInt();
        ArrayList<Element> wydarzenia = kalendarz.pobierzWydarzenia(dzien,(s)-> s instanceof Spotkanie);
        wyswietlWszystkie(wydarzenia);

    }
    private static void zadaniaDnia(Kalendarz kalendarz){
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj numer dnia: ");
        int dzien = scan.nextInt();
        ArrayList<Element> wydarzenia = kalendarz.pobierzWydarzenia(dzien,(s)-> s instanceof Zadanie);
        wyswietlWszystkie(wydarzenia);

    }
    private static void spotkaniaPriorytet(Kalendarz kalendarz) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj numer dnia: ");
        int dzien = scan.nextInt();
        scan.nextLine();
        System.out.print("Podaj priorytet: ");
        String priorytet = scan.nextLine();
        ArrayList<Element> spotkania = kalendarz.pobierzWydarzenia(dzien, (s) -> (
                s instanceof Spotkanie) && ((Spotkanie) s).dajPriorytet().equals(priorytet));
        wyswietlWszystkie(spotkania);

    }
    private static void zadaniaStatus (Kalendarz kalendarz){
            Scanner scan = new Scanner(System.in);
            System.out.print("Podaj numer dnia: ");
            int dzien = scan.nextInt();
            scan.nextLine();
            System.out.print("Podaj status: ");
            String status = scan.nextLine();
            ArrayList<Element> zadania =kalendarz.pobierzWydarzenia(dzien, (s) -> (
                    s instanceof Zadanie) && ((Zadanie) s).dajStatus().equals(status));
            wyswietlWszystkie(zadania);
    }


        private static void spotkaniaPriorytetZCzasem (Kalendarz kalendarz){
            Scanner scan = new Scanner(System.in);
            System.out.print("Podaj numer dnia: ");
            int dzien = scan.nextInt();
            scan.nextLine();
            System.out.print("Podaj godzinę od której pokazać spotkania: ");
            String godzina = scan.nextLine();
            System.out.print("Podaj priorytet: ");
            String priorytet = scan.nextLine();
            ArrayList<Element> spotkania = kalendarz.pobierzWydarzenia(dzien, (s) -> (
                            s instanceof Spotkanie &&
                    s.dajGodzinePoczatku().isAfter(LocalTime.parse(godzina).minusMinutes(1))
                            && ((Spotkanie) s).dajPriorytet().equals(priorytet)));
            wyswietlWszystkie(spotkania);
        }
    private static void zadaniaStatusZCzasem (Kalendarz kalendarz){
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj numer dnia: ");
        int dzien = scan.nextInt();
        scan.nextLine();
        System.out.print("Podaj godzinę do której pokazać zadania: ");
        String godzina = scan.nextLine();
        System.out.print("Podaj status: ");
        String status = scan.nextLine();
        ArrayList<Element> spotkania = kalendarz.pobierzWydarzenia(dzien, (s) -> (
                s instanceof Zadanie &&
                        s.dajGodzineZakonczenia().isBefore(LocalTime.parse(godzina).plusMinutes(1))
                        && ((Zadanie) s).dajStatus().equals(status)));
        wyswietlWszystkie(spotkania);
    }

    private static void wyswietlWszystkie(ArrayList<Element> elementy) {
            System.out.println("Znalezione wydarzenia: ");

            for (int i = 0; i < elementy.size(); i++) {
                System.out.println("wydarzenie - " + i);
                System.out.println(elementy.get(i).toString());
            }
        }
        private static void opcje ()
        {
            System.out.println("=====================================================================");
            System.out.println("Wybierz jedną z opcji");
            System.out.println("1. Dodanie spotkania na dany dzień");
            System.out.println("2. Dodanie zadania na dany dzień");
            System.out.println("3. Usunięcie wybranego spotkania w dany dzień");
            System.out.println("4. Usunięcie wybranego zadania w dany dzień");
            System.out.println("5. Wyświetlenie wszystkich spotkań danego dnia");
            System.out.println("6. Wyświetlenie wszystkich zadań danego dnia");
            System.out.println("7. Wyświetlenie wszystkich spotkań danego dnia o danym priorytecie");
            System.out.println("8. Wyświetlenie wszystkich zadań danego dnia o danym statusie");
            System.out.println("9. Wyświetlenie wszystkich spotkań danego dnia o wybranym priorytecie i zaczynajace sie nie wczesniej niz");
            System.out.println("10. Wyświetlenie wszystkich zadań danego dnia o wybranym stausie i konczace sie nie pozniej niz");
            System.out.println("11. Wyjście");
            System.out.println("=====================================================================");
        }
    }
