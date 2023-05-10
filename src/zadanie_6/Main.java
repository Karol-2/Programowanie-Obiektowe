package zadanie_6;

import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Spotkanie spotkanie = new Spotkanie("dfdfdf","wysoki", LocalTime.parse("15:00"),LocalTime.parse("18:00"));
        System.out.println(spotkanie.dajGodzinePoczatku());
        System.out.println(spotkanie.dajGodzineZakonczenia());
        System.out.println(spotkanie.NAJWCZESNIEJSZA_GODZINA);
        System.out.println(spotkanie.dajPriorytet());
    }

}
