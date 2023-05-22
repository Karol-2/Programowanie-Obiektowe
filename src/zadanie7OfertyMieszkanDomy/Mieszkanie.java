package zadanie7OfertyMieszkanDomy;

import java.time.LocalDate;

public final class Mieszkanie extends Budynek {
    private int numerMieszkania;
    private int numerPietra;

    public Mieszkanie(String ulica, int numerDomu,int numerMieszkania, String miejscowosc,
               String kodPocztowy, Double powierzchnia,int numerPietra, Double cena, LocalDate dataObowiazywania){
        this.ulica = ulica;
        this.numerDomu = numerDomu;
        this.numerMieszkania = numerMieszkania;
        this.miejscowosc = miejscowosc;
        this.kodPocztowy = kodPocztowy;
        this.powierzchnia = powierzchnia;
        this.cena = cena;
        this.numerPietra = numerPietra;
        this.dataObowiazywania = dataObowiazywania;
    }
    public String dajUlice(){
        return this.ulica;
    }
    public int dajNumerDomu(){
        return this.numerDomu;
    }
    public int dajNumerMieszkania(){
        return this.numerMieszkania;
    }
    public int dajNumerPietra(){
        return this.numerPietra;
    }
    public String dajMiejscowosc(){
        return this.miejscowosc;
    }
    public String dajKodPocztowy(){
        return this.kodPocztowy;
    }
    public Double dajPowierzchnie(){
        return this.powierzchnia;
    }
    public Double dajCene(){
        return this.cena;
    }
    public LocalDate dajDateObowiazywania(){
        return this.dataObowiazywania;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\tMiejscowość: ").append(this.miejscowosc).append('\n');
        sb.append("\tUlica: ").append(this.ulica).append('\n');
        sb.append("\tNumer Domu: ").append(this.numerDomu).append('\n');
        sb.append("\tNumer Piętra: ").append(this.numerPietra).append('\n');
        sb.append("\tNumer Mieszkania: ").append(this.numerMieszkania).append('\n');
        sb.append("\tKod Pocztowy: ").append(this.kodPocztowy).append('\n');
        sb.append("\tPowierzchnia: ").append(this.powierzchnia).append('\n');
        sb.append("\tCena: ").append(this.cena).append('\n');
        sb.append("\tData Obowiązywania Oferty: ").append(this.dataObowiazywania);
        return sb.toString();
    }
}
