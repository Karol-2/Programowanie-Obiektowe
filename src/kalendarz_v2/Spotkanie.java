package kalendarz_v2;

import java.time.LocalTime;

public class Spotkanie {
    private String opis;
    private String priorytet;
    private LocalTime poczatek;
    private LocalTime koniec;

    public static final LocalTime NAJWCZESNIEJSZA_GODZINA = LocalTime.of(7,0);

    public Spotkanie(String opis,String priorytet, LocalTime poczatek, LocalTime koniec){
        this.opis = opis;
        this.priorytet = priorytet;
        this.poczatek = poczatek;
        this.koniec = koniec;
    }
    public String dajOpis(){
        return this.opis;
    }
    public String dajPriorytet(){
        return this.priorytet;
    }
    public LocalTime dajPoczatekSpotkania(){
        return this.poczatek;
    }
    public LocalTime dajKoniecSpotkania(){
        return this.koniec;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\tOpis: ").append(dajOpis()).append('\n');
        sb.append("\tPriorytet: ").append(dajPriorytet()).append('\n');
        sb.append("\tPoczatek: ").append(dajPoczatekSpotkania()).append('\n');
        sb.append("\tKoniec: ").append(dajKoniecSpotkania());
        return sb.toString();
    }

}
