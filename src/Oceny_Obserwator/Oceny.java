package Oceny_Obserwator;

import Uczelnia.Observer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Oceny implements Subject, Serializable {

    ArrayList<Observer> ObserverList=new ArrayList<>();
    private Date date = new Date();
    private int ocena;

    @Override
    public void registerObserver(Observer observer) {
        ObserverList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        ObserverList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(int i = 0; i<ObserverList.size(); i++)
            ObserverList.get(i).update(date,ocena);

    }
    public void setMeasurements(Date date, int ocena){
        this.ocena=ocena;
        this.date=date;
        measurementsChanged();

    }
    public void measurementsChanged(){
        notifyObservers();
    }
}
