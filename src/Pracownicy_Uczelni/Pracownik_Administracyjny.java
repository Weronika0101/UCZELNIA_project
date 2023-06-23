package Pracownicy_Uczelni;

import Uczelnia.Pracownik_Uczelni;

import java.util.Objects;


public class Pracownik_Administracyjny extends Pracownik_Uczelni {
    private int liczbaNadgodzin;
    private static final long serialVersionUID = 3720745685664722447L;
    // Scanner scan=new Scanner(System.in);

    public Pracownik_Administracyjny(String imie, String nazwisko, String PESEL, int wiek, String plec, String stanowisko, int stazPracy, double pensja, int liczbaNadgodzin) {
        super(imie, nazwisko, PESEL, wiek, plec, stanowisko, stazPracy, pensja);
        this.liczbaNadgodzin = liczbaNadgodzin;
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
        final Pracownik_Administracyjny other = (Pracownik_Administracyjny) obj;
        if (!Objects.equals(this.getPESEL(), other.getPESEL())) {
            return false;
        }
        return true;
    }*/

    public int getLiczbaNadgodzin() {
        return liczbaNadgodzin;
    }

    public void setLiczbaNadgodzin(int liczbaNadgodzin) {
        this.liczbaNadgodzin = liczbaNadgodzin;
    }
    public String toString(){
        System.out.println("----------------------------");
        System.out.println("PRACOWNIK ADMINISTRACYJNY");
        return"\n\nImie: "+getImie()+"\nNazwisko: "+getNazwisko()+"\nPESEL: "+getPESEL()+"\nWiek: "+getWiek()+"\nPłeć: "+getPlec()+"\nStanowisko:"+getStanowisko()+"\nStaż pracy: "+getStazPracy()+"\nPensja: "+getPensja()+ "\nLiczba nadgodzin: "+liczbaNadgodzin;
    }

}
