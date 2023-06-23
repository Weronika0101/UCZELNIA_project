package Oceny_Obserwator;

import Uczelnia.Observer;

public interface Subject {
     void registerObserver(Observer observer);
     void removeObserver(Observer observer);
     void notifyObservers();
}
