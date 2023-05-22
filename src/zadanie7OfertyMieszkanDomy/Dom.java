package zadanie7OfertyMieszkanDomy;

import java.time.LocalDate;

public final class Dom extends Budynek{
    private Double powierzchniaDzialki;

    public Dom(String ulica, int numerDomu, String miejscowosc,
               String kodPocztowy, Double powierzchnia, Double cena, Double powierzchniaDzialki, LocalDate dataObowiazywania){
        this.ulica = ulica;
        this.numerDomu = numerDomu;
        this.miejscowosc = miejscowosc;
        this.kodPocztowy = kodPocztowy;
        this.powierzchnia = powierzchnia;
        this.cena = cena;
        this.powierzchniaDzialki = powierzchniaDzialki;
        this.dataObowiazywania = dataObowiazywania;
    }
    public String dajUlice(){
        return this.ulica;
    }
    public int dajNumerDomu(){
        return this.numerDomu;
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
    public Double dajPowierzchnieDzialki(){
        return this.powierzchniaDzialki;
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
        sb.append("\tKod Pocztowy: ").append(this.kodPocztowy).append('\n');
        sb.append("\tPowierzchnia: ").append(this.powierzchnia).append('\n');
        sb.append("\tPowierzchnia Działki: ").append(this.powierzchniaDzialki).append('\n');
        sb.append("\tCena: ").append(this.cena).append('\n');
        sb.append("\tData Obowiązywania Oferty: ").append(this.dataObowiazywania);
        return sb.toString();
    }

}
