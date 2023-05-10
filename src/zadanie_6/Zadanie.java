package zadanie_6;

import java.time.LocalTime;

public final class Zadanie extends Element{
    private String status;
    public Zadanie(String opis, LocalTime czasPoczatku, LocalTime czasZakonczenia, String status){
        this.opis = opis;
        this.czasPoczatku = czasPoczatku;
        this.czasZakonczenia = czasZakonczenia;
        this.status = status;
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
    public String dajStatus(){
        return this.status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\tOpis: ").append(this.opis).append('\n');
        sb.append("\tStatus: ").append(this.status).append('\n');
        sb.append("\tPoczatek: ").append(this.czasPoczatku).append('\n');
        sb.append("\tKoniec: ").append(this.czasZakonczenia);
        return sb.toString();
    }
}
