package kalendarz_v2;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Zadanie4 {

    public static void main(String[] args) {
        System.out.println("Ten program służy obliczaniu do obsługi kalendarza spotkań w danym tygodniu");
        System.out.println("Spotkania mogą odbyć się po godzinie: " + Spotkanie.NAJWCZESNIEJSZA_GODZINA);
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
                case 1 -> dodanie(kalendarz);
                case 2 -> usuwanie(kalendarz);
                case 3 -> spotkaniaDnia(kalendarz);
                case 4 -> spotkaniaPriorytet(kalendarz);
                case 5 -> dzialanieProgramu = false;
                default -> System.out.println("Zła wartość!");
            }
        }
    }
    private static void dodanie(Kalendarz kalendarz){
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
        kalendarz.dodajSpotkanie(opis,priorytet,czasRozpoczecia,czasZakonczenia,dzien);
    }
    private static void usuwanie(Kalendarz kalendarz){
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj numer dnia: ");
        int dzien = scan.nextInt();
        ArrayList<Spotkanie> spotkania = kalendarz.pobierzSpotkania(dzien);
        wyswietlSpotkania(spotkania);
        System.out.print("Podaj numer spotkania do usuniecia: ");
        int numerSpotkania = scan.nextInt();
        kalendarz.usunSpotkanie(dzien,numerSpotkania);

    }

    private static void spotkaniaDnia(Kalendarz kalendarz){
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj numer dnia: ");
        int dzien = scan.nextInt();
        ArrayList<Spotkanie> spotkania = kalendarz.pobierzSpotkania(dzien);
        wyswietlSpotkania(spotkania);

    }
    private static void spotkaniaPriorytet(Kalendarz kalendarz){
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj numer dnia: ");
        int dzien = scan.nextInt();
        scan.nextLine();
        System.out.print("Podaj priorytet: ");
        String priorytet = scan.nextLine();
        ArrayList<Spotkanie> spotkania = kalendarz.pobierzSpotkania(dzien,priorytet);
        wyswietlSpotkania(spotkania);

    }
    private static void wyswietlSpotkania(ArrayList<Spotkanie> spotkania){
        System.out.println("Znalezione spotkania: ");
        for (int i=0;i<spotkania.size();i++){
            System.out.println("Spotkanie - "+ i);
            System.out.println(spotkania.get(i).toString());
        }
    }
    private static void opcje()
    {
        System.out.println("=====================================================================");
        System.out.println("Wybierz jedną z opcji");
        System.out.println("1. Dodanie spotkania na dany dzień");
        System.out.println("2. Usunięcie wybranego spotkania w dany dzień");
        System.out.println("3. Wyświetlenie wszystkich spotkań danego dnia");
        System.out.println("4. Wyświetlenie wszystkich spotkań danego dnia o danym priorytecie");
        System.out.println("5. Wyjście");
        System.out.println("=====================================================================");
    }
}
