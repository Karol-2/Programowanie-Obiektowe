package zadanie7OfertyMieszkanDomy;
import java.time.LocalDate;

public sealed abstract class Budynek permits Mieszkanie, Dom {
    protected String ulica;
    protected int numerDomu;
    protected String miejscowosc;
    protected String kodPocztowy;
    protected Double powierzchnia;
    protected Double cena;
    protected LocalDate dataObowiazywania;

    protected abstract String dajUlice();
    protected abstract int dajNumerDomu();
    protected abstract String dajMiejscowosc();
    protected abstract String dajKodPocztowy();
    protected abstract Double dajPowierzchnie();
    protected abstract Double dajCene();

    protected abstract LocalDate dajDateObowiazywania();


}