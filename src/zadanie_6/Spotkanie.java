package zadanie_6;

import java.time.LocalTime;

public final class Spotkanie extends Element{
    private String priorytet;
    public Spotkanie(String opis,String priorytet, LocalTime poczatek, LocalTime koniec){
        this.opis = opis;
        this.priorytet = priorytet;
        this.czasPoczatku = poczatek;
        this.czasZakonczenia = koniec;
    }
    public String dajOpis(){
        return super.opis;
    }
    public LocalTime dajGodzinePoczatku(){
        return super.czasPoczatku;
    }
    public LocalTime dajGodzineZakonczenia(){
        return super.czasZakonczenia;
    }
    public String dajPriorytet(){return this.priorytet;}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\tOpis: ").append(this.opis).append('\n');
        sb.append("\tPriorytet: ").append(this.priorytet).append('\n');
        sb.append("\tPoczatek: ").append(this.czasPoczatku).append('\n');
        sb.append("\tKoniec: ").append(this.czasZakonczenia);
        return sb.toString();
    }

}
