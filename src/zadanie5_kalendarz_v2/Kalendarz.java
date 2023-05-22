package zadanie5_kalendarz_v2;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.function.*;

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
    public ArrayList<Spotkanie> pobierzSpotkania(int dzien, Predicate<Spotkanie> checker) {
        ArrayList<Spotkanie> spotkaniaWybrane = new ArrayList<>();
        for (int i=0;i<kalendarz[dzien].size();i++)
        {
            Spotkanie spotkanie = kalendarz[dzien].get(i);
            if(checker.test(spotkanie)){
                spotkaniaWybrane.add(spotkanie);
            }
        }

        return spotkaniaWybrane;
    }


}
