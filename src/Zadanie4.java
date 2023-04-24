import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Zadanie4 {

    public static void main(String[] args) {
        System.out.println("Ten program służy obliczaniu do obsługi kalendarza spotkań w danym tygodniu");
        System.out.println("Najwcześniejsza godzina spotkania - " + Spotkanie.najwczesniejszaGodzina);
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
        System.out.print("Podaj numer dnia:(0-6) ");
        int dzien = scan.nextInt();

        scan.nextLine();
        System.out.print("Podaj opis spotkania: ");
        String opis = scan.nextLine();
        System.out.print("Podaj priorytet spotkania: ");
        String priorytet = scan.nextLine();
        System.out.print("Podaj czas rozpoczęcia: ");
        String rozpoczecie = scan.nextLine();
        System.out.print("Podaj czas zakończenia: ");
        String zakonczenie = scan.nextLine();
        LocalTime czasRozpoczecia = LocalTime.parse(rozpoczecie);
        LocalTime czasZakonczenia = LocalTime.parse(zakonczenie);
        kalendarz.dodajSpotkanie(opis,priorytet,czasRozpoczecia,czasZakonczenia,dzien);

    }
    private static void usuwanie(Kalendarz kalendarz){
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj numer dnia:(0-6) ");
        int dzien = scan.nextInt();
        ArrayList<Spotkanie> spotkania = kalendarz.pobierzSpotkania(dzien);
        szczegolySpotkania(spotkania);
        System.out.print("Podaj numer spotkania do usuniecia: ");
        int numerSpotkania = scan.nextInt();

        kalendarz.usunSpotkanie(dzien,numerSpotkania);

    }

    private static void spotkaniaDnia(Kalendarz kalendarz){
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj numer dnia:(0-6) ");
        int dzien = scan.nextInt();
        ArrayList<Spotkanie> spotkania = kalendarz.pobierzSpotkania(dzien);
        szczegolySpotkania(spotkania);

    }
    private static void spotkaniaPriorytet(Kalendarz kalendarz){
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj numer dnia:(0-6) ");
        int dzien = scan.nextInt();
        scan.nextLine();
        System.out.print("Podaj priorytet: ");
        String priorytet = scan.nextLine();
        ArrayList<Spotkanie> spotkania = kalendarz.pobierzSpotkaniaPriorytet(dzien,priorytet);
        szczegolySpotkania(spotkania);

    }
    private static void szczegolySpotkania(ArrayList<Spotkanie> spotkania){
        System.out.println("Znalezione spotkania: ");
        for (int i=0;i<spotkania.size();i++){
            System.out.println("Spotkanie - " + i);
            System.out.println("\tPriorytet: " + spotkania.get(i).dajPriorytet());
            System.out.println("\tOpis: " + spotkania.get(i).dajOpis());
            System.out.println("\tGodzina początkowa: " + spotkania.get(i).dajPoczatekSpotkania());
            System.out.println("\tGodzina końcowa: " + spotkania.get(i).dajKoniecSpotkania());
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
