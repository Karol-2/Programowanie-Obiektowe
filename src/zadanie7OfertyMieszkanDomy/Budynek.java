package zadanie7OfertyMieszkanDomy;
import java.time.LocalDate;

public sealed abstract class Budynek permits Mieszkanie, Dom {
    String ulica;
    int numerDomu;
    String miejscowosc;
    String kodPocztowy;
    Double powierzchnia;
    Double cena;
    LocalDate dataObowiazywania;

    protected abstract String dajUlice();
    protected abstract int dajNumerDomu();
    protected abstract String dajMiejscowosc();
    protected abstract String dajKodPocztowy();
    protected abstract Double dajPowierzchnie();
    protected abstract Double dajCene();

    protected abstract LocalDate dajDateObowiazywania();


}