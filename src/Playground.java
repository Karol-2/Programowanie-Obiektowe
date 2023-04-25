import zadanie2_walec.Walec;

import java.util.Scanner;

public class Playground {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double promien, wysokosc;
        int wybor = 0;

        System.out.print("Podaj promień walca: ");
        promien = input.nextDouble();

        System.out.print("Podaj wysokość walca: ");
        wysokosc = input.nextDouble();

        Walec walec = new Walec(promien, wysokosc); // walec zmienna referencyjna

        boolean dzialanie = true;

        while (dzialanie) {
            System.out.println("\nWybierz opcję:");
            System.out.println("1. Wyświetl wartości zmiennych instancji obiektu klasy zadanie2_walec.Walec");
            System.out.println("2. Zmień wartości zmiennych instancji obiektu klasy zadanie2_walec.Walec");
            System.out.println("3. Wylicz i wyświetl pole powierzchni i objętość obiektu klasy zadanie2_walec.Walec");
            System.out.println("4. Wyjdź z programu");

            wybor = input.nextInt();

            switch (wybor) {
                case 1:
                    System.out.println("\nPromień: " + walec.dajPromien());
                    System.out.println("Wysokość: " + walec.dajWysokosc());
                    break;
                case 2:
                    System.out.print("\nPodaj nowy promień: ");
                    promien = input.nextDouble();
                    System.out.print("Podaj nową wysokość: ");
                    wysokosc = input.nextDouble();
                    walec.zmienPromien(promien);
                    walec.zmienWysokosc(wysokosc);
                    break;
                case 3:
                    System.out.println("\nPole powierzchni podstawy: " + walec.polePodstawy());
                    System.out.println("Pole boczne: " + walec.poleBoczne());
                    System.out.println("Pole całkowite: " + walec.poleCalkowite());
                    System.out.println("Objętość: " + walec.objetosc());
                    break;
                case 4:
                    System.out.println("\nProgram został zakończony.");
                    dzialanie = false;
                    break;
                default:
                    System.out.println("\nNieprawidłowa opcja. Wybierz ponownie.");
                    break;
            }
        }
    }
}
