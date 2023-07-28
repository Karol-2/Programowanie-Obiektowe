package zadanie7OfertyMieszkanDomy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Zadanie7 {

    public static void main(String[] args) {
        System.out.println("Ten program służy obsłudze ofert sprzedaży mieszkań i domów");
        ListaOfert oferty = new ListaOfert();
        wyborOpcji(oferty);
    }

    private static void wyborOpcji(ListaOfert oferty){
        Scanner scan = new Scanner(System.in);
        boolean dzialanieProgramu = true;
        while (dzialanieProgramu){
            opcje();
            System.out.print("Podaj numer akcji: ");
            int wybor = scan.nextInt();
            switch (wybor) {
                case 1 -> dodanieDomu(oferty);
                case 2 -> dodanieMieszkania(oferty);
                case 3 -> aktualneDomy(oferty);
                case 4 -> aktualneMieszkania(oferty);
                case 5 -> aktualneDomyFiltry(oferty);
                case 6 -> aktualneMieszkaniaFiltry(oferty);
                case 7 -> dzialanieProgramu = false;
                default -> System.out.println("Zła wartość!");
            }
        }
    }
    private static void dodanieDomu(ListaOfert oferty){
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj nazwę ulicy: ");
        String ulica = scan.nextLine();
        System.out.print("Podaj numer domu: ");
        int numerDomu = scan.nextInt();
        System.out.print("Podaj nazwę miejscowości: ");
        String miejscowosc = scan.nextLine();
        scan.nextLine();
        System.out.print("Podaj kod pocztowy: ");
        String kodPocztowy = scan.nextLine();
        System.out.print("Podaj powierzchnię: ");
        Double powierzchnia = scan.nextDouble();
        System.out.print("Podaj cenę: ");
        Double cena = scan.nextDouble();
        System.out.print("Podaj powierzchnię działki: ");
        Double powierzchniaDzialki = scan.nextDouble();
        scan.nextLine();
        System.out.print("Podaj datę obowiązywania oferty: ");
        String data = scan.nextLine();
        LocalDate dataObowiazywania = LocalDate.parse(data);
        oferty.dodajOferte(ulica,numerDomu,miejscowosc,kodPocztowy,powierzchnia,cena,powierzchniaDzialki,dataObowiazywania);
    }
    private static void dodanieMieszkania(ListaOfert oferty){
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj nazwę ulicy: ");
        String ulica = scan.nextLine();
        System.out.print("Podaj numer domu: ");
        int numerDomu = scan.nextInt();
        System.out.print("Podaj numer mieszkania: ");
        int numerMieszkania = scan.nextInt();
        System.out.print("Podaj nazwę miejscowości: ");
        scan.nextLine();
        String miejscowosc = scan.nextLine();
        System.out.print("Podaj kod pocztowy: ");
        String kodPocztowy = scan.nextLine();
        System.out.print("Podaj powierzchnię: ");
        Double powierzchnia = scan.nextDouble();
        System.out.print("Podaj numer piętra: ");
        int numerPietra = scan.nextInt();
        System.out.print("Podaj cenę: ");
        Double cena = scan.nextDouble();
        scan.nextLine();
        System.out.print("Podaj datę obowiązywania oferty: ");
        String data = scan.nextLine();
        LocalDate dataObowiazywania = LocalDate.parse(data);
        oferty.dodajOferte(ulica,numerDomu,numerMieszkania,miejscowosc,kodPocztowy,powierzchnia,numerPietra,cena,dataObowiazywania);
    }

    private static void aktualneDomy(ListaOfert oferty){
        ArrayList<Budynek> listaOfert = oferty.pobierzOferty((o) -> o instanceof Dom &&
                o.dataObowiazywania.isAfter(LocalDate.now().minusDays(1)));

        wyswietlWszystkie(listaOfert);
    }
    private static void aktualneMieszkania(ListaOfert oferty){
        ArrayList<Budynek> listaOfert = oferty.pobierzOferty((o) -> o instanceof Mieszkanie &&
                o.dataObowiazywania.isAfter(LocalDate.now().minusDays(1)));

        wyswietlWszystkie(listaOfert);
    }
    private static void aktualneDomyFiltry(ListaOfert oferty){
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj nazwę miejscowości: ");
        String miejscowosc = scan.nextLine();
        System.out.print("Podaj minimalną wielkość powierzchni: ");
        Double powierzchnia = scan.nextDouble();

        ArrayList<Budynek> listaOfert = oferty.pobierzOferty((o) -> o instanceof Dom &&
                o.dataObowiazywania.isAfter(LocalDate.now().minusDays(1)) &&
                o.dajMiejscowosc().equals(miejscowosc) &&
                o.dajPowierzchnie() >= powierzchnia);

        wyswietlWszystkie(listaOfert);
    }
    private static void aktualneMieszkaniaFiltry(ListaOfert oferty){
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj nazwę miejscowości: ");
        String miejscowosc = scan.nextLine();
        System.out.print("Podaj maksymalną cenę mieszkania: ");
        Double cena = scan.nextDouble();
        System.out.print("Podaj minimalne piętro mieszkania: ");
        int pietro = scan.nextInt();

        ArrayList<Budynek> listaOfert = oferty.pobierzOferty((o) -> o instanceof Mieszkanie &&
                o.dataObowiazywania.isAfter(LocalDate.now().minusDays(1)) &&
                o.dajMiejscowosc().equals(miejscowosc) &&
                o.dajCene() <= cena &&
               ((Mieszkanie) o).dajNumerPietra() >= pietro);


        wyswietlWszystkie(listaOfert);
    }
    private static void wyswietlWszystkie(ArrayList<Budynek> oferty) {
        System.out.println("Znalezione oferty: ");

        for (int i = 0; i < oferty.size(); i++) {
            if(oferty.get(i) instanceof Dom){
                System.out.println("Dom - " + (i+1));
            } else if(oferty.get(i) instanceof Mieszkanie){
                System.out.println("Mieszkanie - " + (i+1));
            } else {
                System.out.println("Oferta - " + (i+1));
            }
            System.out.println(oferty.get(i).toString());
        }
    }
    private static void opcje ()
    {
        System.out.println("=====================================================================");
        System.out.println("Wybierz jedną z opcji");
        System.out.println("1. Dodanie oferty sprzedaży domu");
        System.out.println("2. Dodanie oferty sprzedaży mieszkania");
        System.out.println("3. Wyświetlenie wszystkich aktualnych ofert domów");
        System.out.println("4. Wyświetlenie wszystkich aktualnych ofert mieszkań");
        System.out.println("5. Wyświetlenie wszystkich aktualnych ofert domów, z podaniem miejscowości i od podanej powierzchni");
        System.out.println("6. Wyświetlenie wszystkich aktualnych ofert mieszkań z podaniem miejscowości, do podanej wartości i od podanego piętra");
        System.out.println("7. Wyjście");
        System.out.println("=====================================================================");
    }


}
