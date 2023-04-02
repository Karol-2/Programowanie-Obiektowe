package lab01;

import java.util.Scanner;

public class Zadanie1 {
    public static void main(String[] args) {

        System.out.println("Ten program liczy silnie dla podanej liczby n");
        System.out.println("Jeśli chcesz zakończyć działanie programu napisz \"exit\"");

        boolean isLooping = true;

        while (isLooping) {
            Scanner myObj = new Scanner(System.in);
            System.out.print("Podaj liczbe: ");
            String odpowiedz = myObj.nextLine();

            if (odpowiedz.equals("exit")) {
                isLooping = false;
            } else {
                int liczba = Integer.parseInt(odpowiedz);

                if (liczba < 0){
                    System.out.println("Liczba mniejsza od zera!");
                    continue;
                }

                long wynik = silnia(liczba);
                System.out.println("Silnia z " + liczba + " to: " + wynik);
            }
        }
    }

    public static long silnia(int liczba) {
        long wynik = 1;

        for (int i = 1; i <= liczba; i++) {
            wynik = wynik * i;
        }
        return wynik;
    }
}