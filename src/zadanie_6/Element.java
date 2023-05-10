package zadanie_6;

import java.time.LocalTime;

public sealed abstract class Element permits Zadanie,Spotkanie {
    protected LocalTime czasPoczatku;
    protected LocalTime czasZakonczenia;
    protected String opis;
    protected static final LocalTime NAJWCZESNIEJSZA_GODZINA = LocalTime.of(7,0);

    protected abstract String dajOpis();
    protected abstract LocalTime dajGodzinePoczatku();
    protected abstract LocalTime dajGodzineZakonczenia();

}
