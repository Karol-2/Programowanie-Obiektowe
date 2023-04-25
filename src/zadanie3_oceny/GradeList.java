package zadanie3_oceny;

import java.util.ArrayList;
public class GradeList {
    private ArrayList<Double> lista = new ArrayList<>();

    public GradeList(){}

    public void dodajOcene(double ocena){
        this.lista.add(ocena);
    }

    public double najwyzszaOcena(){
        if (this.lista.size()==0){
            return -1.0;
        }
        double najwyzsza = this.lista.get(0);

        for(int i=0;i<this.lista.size();i++){
            if(this.lista.get(i) > najwyzsza){
                najwyzsza = this.lista.get(i);
            }
        }
        return najwyzsza;
    }

    public double srednia(){
        if (this.lista.size()==0){
            return -1.0;
        }
        double suma = 0;

        for(int i=0;i<this.lista.size();i++){
            suma += this.lista.get(i);
        }
        return suma / this.lista.size();
    }

    public double najnizszaOcena(){
        if (this.lista.size()==0){
            return -1.0;
        }
        double najnizsza = this.lista.get(0);

        for(int i=0;i<this.lista.size();i++){
            if(this.lista.get(i) < najnizsza){
                najnizsza = this.lista.get(i);
            }
        }
        return najnizsza;
    }


}
