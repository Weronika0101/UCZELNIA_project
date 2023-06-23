package Uczelnia;

import Osoba.Osoba;

import java.io.Serializable;
import java.util.Objects;

public abstract class Pracownik_Uczelni extends Osoba implements Serializable {
    private String stanowisko;
    private int stazPracy;
    private double pensja;
    private static final long serialVersionUID = -9035833905367976738L;


    public Pracownik_Uczelni(String imie, String nazwisko, String PESEL, int wiek, String plec, String stanowisko, int stazPracy, double pensja) {
        super(imie, nazwisko, PESEL, wiek, plec);
        this.stanowisko = stanowisko;
        this.stazPracy = stazPracy;
        this.pensja = pensja;
    }
    public int hashCode()
    {
        return this.getPESEL().hashCode();
    }
    @Override
    public boolean equals(Object obj)
    {
        Pracownik_Uczelni other  = (Pracownik_Uczelni) obj;

        if(getPESEL().equals(other.getPESEL())) return true;
        else return false;
    }
   /* public int hashCode(){
        return Integer.parseInt(getPESEL());
    }
    public boolean equals(Object obj){
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pracownik_Uczelni other = (Pracownik_Uczelni) obj;
        if (!Objects.equals(this.getPESEL(), other.getPESEL())) {
            return false;
        }
        return true;
    }*/

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public int getStazPracy() {
        return stazPracy;
    }

    public void setStazPracy(int stazPracy) {
        this.stazPracy = stazPracy;
    }

    public double getPensja() {
        return pensja;
    }

    public void setPensja(double pensja) {
        this.pensja = pensja;
    }
    public String toString(){
        return "\n\nImie: "+getImie()+"\nNazwisko: "+getNazwisko()+"\nPESEL: "+getPESEL()+"\nWiek: "+getWiek()+"\nPłeć: "+getPlec()+"\nStanowisko:"+stanowisko+"\nStaż pracy: "+stazPracy+"\nPensja: "+pensja;
    }
}
