package zadanie7OfertyMieszkanDomy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Predicate;

public class ListaOfert {
    private ArrayList<Budynek> oferty;

    public ListaOfert(){
        this.oferty = new ArrayList<Budynek>();
        przykladoweDane();
    }

    public void dodajOferte(String ulica, int numerDomu,int numerMieszkania, String miejscowosc, String kodPocztowy,
                            Double powierzchnia,int numerPietra, Double cena, LocalDate dataObowiazywania){

        Mieszkanie mieszkanie = new Mieszkanie(ulica,numerDomu,numerMieszkania,miejscowosc,kodPocztowy,
                powierzchnia,numerPietra,cena,dataObowiazywania);
        oferty.add(mieszkanie);
    }
    public void dodajOferte(String ulica, int numerDomu, String miejscowosc, String kodPocztowy, Double powierzchnia,
                            Double cena, Double powierzchniaDzialki, LocalDate dataObowiazywania){

        Dom dom = new Dom(ulica,numerDomu,miejscowosc,kodPocztowy,powierzchnia,cena,powierzchniaDzialki,dataObowiazywania);
        oferty.add(dom);
    }
    public ArrayList<Budynek> pobierzOferty(Predicate<Budynek> checker){
        ArrayList<Budynek> wybraneOferty = new ArrayList<>();
        for (int i=0;i<oferty.size();i++)
        {
            Budynek oferta = oferty.get(i);
            if(checker.test(oferta)){
                wybraneOferty.add(oferta);
            }
        }
        return wybraneOferty;

    }
    private void przykladoweDane(){
        // mieszkania
       dodajOferte("Jesionowa",5,3,"Malbork","82-200",30.50,2,650_000.00,LocalDate.now());
       dodajOferte("Jesionowa",5,31,"Malbork","82-200",50.25,9,999_000.00,LocalDate.parse("2023-12-31"));
       dodajOferte("Aleja Rodła",21,13,"Malbork","82-200",40.50,5,1_600_000.00,LocalDate.parse("2023-07-31"));
       dodajOferte("Kołobrzeska",22,15,"Gdańsk","80-396",30.50,10,2_999_999.99,LocalDate.parse("2023-07-31"));
       dodajOferte("TEST",5,3,"TEGO MA NIE WIDAC","82-200",30.50,2,654_000.00,LocalDate.parse("2012-12-31"));

       // domy
       dodajOferte("Kościuszki",13,"Malbork","80-200",150.25,800_000.99,160.50,LocalDate.parse("2024-01-01"));
       dodajOferte("Batorego",27,"Malbork","80-200",200.20,1_850_000.00,250.50,LocalDate.parse("2023-11-01"));
       dodajOferte("17 Marca",6,"Malbork","80-200",250.60,2_980_000.00,300.45,LocalDate.parse("2023-11-01"));
       dodajOferte("Grunwaldzka",56,"Gdańsk","81-805",140.50,5_123_000.00,160.20,LocalDate.parse("2024-01-01"));
    }

}
