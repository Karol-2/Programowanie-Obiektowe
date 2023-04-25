package zadanie4_kalendarz;

import java.time.LocalTime;
import java.util.ArrayList;

public class Kalendarz {

    private ArrayList<Spotkanie>[] kalendarz;
    public Kalendarz(){
        this(7);
    }
    public Kalendarz( int liczbaDni){
        this.kalendarz = new ArrayList[liczbaDni];
        for (int i = 0; i < liczbaDni; i++) {
            kalendarz[i] = new ArrayList<Spotkanie>();
        }
    }

    public void dodajSpotkanie(String opis, String priorytet, LocalTime poczatek, LocalTime koniec, int dzien) {
        Spotkanie noweSpotkanie = new Spotkanie(opis, priorytet, poczatek, koniec);
        kalendarz[dzien].add(noweSpotkanie);

    }

    public void usunSpotkanie(int dzien, int numerSpotkania){
        kalendarz[dzien].remove(numerSpotkania);
    }
    public ArrayList<Spotkanie> pobierzSpotkania(int dzien) {
        return kalendarz[dzien];
    }
    public ArrayList<Spotkanie> pobierzSpotkaniaPriorytet(int dzien, String priorytet) {
       ArrayList<Spotkanie> spotkaniaPriorytetowe = new ArrayList<>();
       for (int i=0;i<kalendarz[dzien].size();i++)
       {
           Spotkanie spotkanie = kalendarz[dzien].get(i);
           if(priorytet.equals(spotkanie.dajPriorytet())){
               spotkaniaPriorytetowe.add(spotkanie);
           }
       }

        return spotkaniaPriorytetowe;
    }


}
