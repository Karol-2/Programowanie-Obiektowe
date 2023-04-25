package zadanie3_oceny;

import java.util.Scanner;

public class Zad3 {
    public static void main(String[] args) {
        System.out.println("Ten program służy dodawaniu ocen, sprawdzaniu średniej, oraz znajdowaniu najwyższej i najniższej oceny");
        System.out.println("Program przyjmuje również wartości do dwóch miejsc po przecinku");
        GradeList gradeList = new GradeList();
        opcje(gradeList);

    }

    private static void opcje(GradeList gradeList){
        Scanner scan = new Scanner(System.in);
        boolean dzialanieProgramu = true;
        while (dzialanieProgramu){
            informacje();
            System.out.print("Podaj numer akcji: ");
            int wybor = scan.nextInt();

            switch (wybor) {
                case 1 -> dodawanieOceny(gradeList);
                case 2 -> liczenieSredniej(gradeList);
                case 3 -> podajNajwyzsza(gradeList);
                case 4 -> podajNajnizsza(gradeList);
                case 5-> dzialanieProgramu = false;
                default -> System.out.println("Zła wartość!");
            }
        }
    }
    private static void dodawanieOceny(GradeList gradeList){
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj ocenę: ");
        double ocena = scan.nextDouble();
        gradeList.dodajOcene(ocena);
    }
    private static void liczenieSredniej(GradeList gradeList){
        if (gradeList.srednia() == -1.0){
            System.out.println("BRAK OCEN!!!");
        }else{
            System.out.println("Średnia: " + gradeList.srednia());
        }
    }
    private static void podajNajwyzsza(GradeList gradeList){
        if (gradeList.najwyzszaOcena() == -1.0){
            System.out.println("BRAK OCEN!!!");
        }else{
            System.out.println("Najwyższa ocena to: " + gradeList.najwyzszaOcena());
        }
    }
    private static void podajNajnizsza(GradeList gradeList){
        if (gradeList.najnizszaOcena() == -1.0){
            System.out.println("BRAK OCEN!!!");
        }else{
            System.out.println("Najniższa ocena to: " + gradeList.najnizszaOcena());
        }
    }

    private static void informacje()
    {
        System.out.println("Wybierz jedną z opcji");
        System.out.println("1. Dodanie oceny");
        System.out.println("2. Wyliczenie średniej");
        System.out.println("3. Znalezienie najwyższej oceny");
        System.out.println("4. Znaleziene najniższej oceny");
        System.out.println("5. Wyjście");
    }
}
