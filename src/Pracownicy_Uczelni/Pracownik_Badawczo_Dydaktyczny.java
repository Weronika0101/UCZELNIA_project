package Pracownicy_Uczelni;

import Uczelnia.Pracownik_Uczelni;

import java.util.Objects;

public class Pracownik_Badawczo_Dydaktyczny extends Pracownik_Uczelni {
    private int punktacjazDorobku;
    private static final long serialVersionUID = 6679563588983870396L;

    public Pracownik_Badawczo_Dydaktyczny(String imie, String nazwisko, String PESEL, int wiek, String plec, String stanowisko, int stazPracy, double pensja, int punktacjazDorobku) {
        super(imie, nazwisko, PESEL, wiek, plec, stanowisko, stazPracy, pensja);
        this.punktacjazDorobku = punktacjazDorobku;
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
        final Pracownik_Badawczo_Dydaktyczny other = (Pracownik_Badawczo_Dydaktyczny) obj;
        if (!Objects.equals(this.getPESEL(), other.getPESEL())) {
            return false;
        }
        return true;
    }*/

    public int getPunktacjazDorobku() {
        return punktacjazDorobku;
    }

    public void setPunktacjazDorobku(int punktacjazDorobku) {
        this.punktacjazDorobku = punktacjazDorobku;
    }
    public String toString(){
        System.out.println("----------------------------");
        System.out.println("PRACOWNIK BADAWCZO-DYDAKTYCZNY");
        return"\n\nImie: "+getImie()+"\nNazwisko: "+getNazwisko()+"\nPESEL: "+getPESEL()+"\nWiek: "+getWiek()+"\nPłeć: "+getPlec()+"\nStanowisko:"+getStanowisko()+"\nStaż pracy: "+getStazPracy()+"\nPensja: "+getPensja()+"\nPunktacja z dorobku: "+punktacjazDorobku;
    }
}
