package zadanie2_walec;

public class Walec {

    private double wysokosc;
    private double promien;
    public Walec(){}
    public Walec (double promien, double wysokosc){
        this.promien = promien;
        this.wysokosc = wysokosc;
    }

    public void zmienPromien(double wartosc){
        this.promien = wartosc;

    }
    public void zmienWysokosc(double wartosc)
    {
        this.wysokosc = wartosc;

    }

    public double dajWysokosc(){
        return this.wysokosc;
    }
    public double dajPromien(){
        return this.promien;
    }

    public double polePodstawy(){
        double polePod;
        polePod = Math.pow(this.promien, 2) * Math.PI;
        return polePod;
    }

    public double poleBoczne(){
        double poleBoczne;
        poleBoczne = 2 * Math.PI * this.wysokosc * this.promien;
        return poleBoczne;
    }
    public double poleCalkowite(){
        double poleCalowite;
        poleCalowite = 2 * this.polePodstawy() + this.poleBoczne();
        return poleCalowite;
    }
    public double objetosc(){
        double objetosc;
        objetosc = this.polePodstawy() * this.wysokosc;
        return objetosc;
    }

}
