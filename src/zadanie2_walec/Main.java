package zadanie2_walec;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        System.out.println("Ten program służy obliczaniu pól i objętości walca oraz zmian wartości zmiennych");
        System.out.println("Program przyjmuje tylko wartości do dwóch miejsc po przecinku");
        Walec walec = new Walec();
        wyborOpcji(walec);
    }

    private static void wyborOpcji(Walec walec){
        Scanner scan = new Scanner(System.in);
        boolean dzialanieProgramu = true;
        while (dzialanieProgramu){
            opcje();
            System.out.print("Podaj numer akcji: ");
            int wybor = scan.nextInt();

            switch (wybor) {
                case 1 -> wyswietlZmienne(walec);
                case 2 -> zmianaWartosci(walec);
                case 3 -> wyswietlObliczenia(walec);
                case 4 -> dzialanieProgramu = false;
                default -> System.out.println("Zła wartość!");
            }
        }
    }

    private static void wyswietlZmienne(Walec walec){
        System.out.println("Promień = " + walec.dajPromien());
        System.out.println("Wysokość = " + walec.dajWysokosc());
    }
    private static void zmianaWartosci(Walec walec){
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj nowy promień: ");
        double r = scan.nextDouble();
        walec.zmienPromien(r);
        System.out.println("Podaj nową wysokość: ");
        double h = scan.nextDouble();
        walec.zmienWysokosc(h);
    }
    private static void wyswietlObliczenia(Walec walec){
        System.out.println("Pole boczne = " + walec.poleBoczne());
        System.out.println("Pole podstawy = " + walec.polePodstawy());
        System.out.println("Pole całkowite = " + walec.poleCalkowite());
        System.out.println("Objętość = " + walec.objetosc());
    }
    private static void opcje()
    {
        System.out.println("Wybierz jedną z opcji");
        System.out.println("1. Wyświetlenie wartości zmiennych");
        System.out.println("2. Zmiana wartości zmiennych");
        System.out.println("3. Wyliczenie pól i objętości");
        System.out.println("4. Wyjście");
    }


}
