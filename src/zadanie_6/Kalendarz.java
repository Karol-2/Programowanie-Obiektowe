package zadanie_6;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.function.Predicate;

public class Kalendarz {


    private ArrayList<Element>[] kalendarz;
    public Kalendarz(){
        this(7);
    }
    public Kalendarz(int liczbaDni){
        this.kalendarz = new ArrayList[liczbaDni];
        for (int i = 0; i < liczbaDni; i++) {
            kalendarz[i] = new ArrayList<Element>();
        }
        dodajOsiem();
    }

    public void dodajWydarzenie(String opis, String priorytet, LocalTime poczatek, LocalTime koniec, int dzien) {
        Spotkanie noweSpotkanie = new Spotkanie(opis, priorytet, poczatek, koniec);
        kalendarz[dzien].add(noweSpotkanie);

    }
    public void dodajWydarzenie(int dzien,String opis, String status, LocalTime poczatek, LocalTime koniec){
        Zadanie noweZadanie = new Zadanie (opis, poczatek, koniec,status);
        kalendarz[dzien].add(noweZadanie);
    }


    public void usunWydarzenie(int dzien, int numerSpotkania){
        kalendarz[dzien].remove(numerSpotkania);
    }
    public ArrayList<Element> pobierzWydarzenia(int dzien, Predicate<Element> checker) {
       ArrayList<Element> elementyWybrane = new ArrayList<>();
       for (int i=0;i<kalendarz[dzien].size();i++)
       {
           Element element = kalendarz[dzien].get(i);
           if(checker.test(element)){
               elementyWybrane.add(element);
           }
       }

        return elementyWybrane;
    }
    public void dodajOsiem(){
        dodajWydarzenie("spotkanie1","wysoki",LocalTime.parse("12:00"),LocalTime.parse("14:00"),1);
        dodajWydarzenie("spotkanie2","niski",LocalTime.parse("10:00"),LocalTime.parse("11:00"),1);
        dodajWydarzenie("spotkanie3","wysoki",LocalTime.parse("15:00"),LocalTime.parse("16:00"),1);
        dodajWydarzenie("spotkanie4","wysoki",LocalTime.parse("16:30"),LocalTime.parse("20:00"),1);

        dodajWydarzenie(1,"zadanie1","zrobione",LocalTime.parse("10:00"),LocalTime.parse("14:00"));
        dodajWydarzenie(1,"zadanie2","zaczete",LocalTime.parse("11:00"),LocalTime.parse("11:30"));
        dodajWydarzenie(1,"zadanie3","zaczete",LocalTime.parse("13:00"),LocalTime.parse("15:00"));
        dodajWydarzenie(1,"zadanie4","zrobione",LocalTime.parse("16:00"),LocalTime.parse("17:40"));
    }


}
