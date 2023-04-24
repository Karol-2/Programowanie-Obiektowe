import java.time.LocalTime;
import java.util.ArrayList;

public class Kalendarz {

    private ArrayList<Spotkanie>[] kalendarz;
    public Kalendarz(){
        this.kalendarz = new ArrayList[7];
        for (int i = 0; i < 7; i++) {
            kalendarz[i] = new ArrayList<Spotkanie>();
        }
    }

    public void dodajSpotkanie(String opis, String priorytet, LocalTime poczatek, LocalTime koniec, int dzien) {
        if(poczatek.isAfter(Spotkanie.najwczesniejszaGodzina)) {
            Spotkanie noweSpotkanie = new Spotkanie(opis, priorytet, poczatek, koniec);
            kalendarz[dzien].add(noweSpotkanie);
        }
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
           if(priorytet.equals(kalendarz[dzien].get(i).dajPriorytet())){
               spotkaniaPriorytetowe.add(kalendarz[dzien].get(i));
           }
       }

        return spotkaniaPriorytetowe;
    }


}
