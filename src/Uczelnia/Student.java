package Uczelnia;

import Kursy.Kursy;
import Oceny_Obserwator.Subject;
import Osoba.Osoba;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class Student extends Osoba implements Observer,Serializable {
    private Kursy k1;
    private String numerIndeksu;
    private boolean czyERASMUS;
    private int stopien;
    private boolean stacjonarne;
    private static final long serialVersionUID = 6679563588983870396L;
    private int ocena;
    private Subject grades;
    Date date=new Date();

    public Student(String imie, String nazwisko, String PESEL, int wiek, String plec, String numerIndeksu, boolean czyERASMUS,int stopien, boolean stacjonarne, Kursy k1,Subject grades) {
        super(imie, nazwisko, PESEL, wiek, plec);
        this.numerIndeksu = numerIndeksu;
        this.czyERASMUS = czyERASMUS;
        this.stopien = stopien;
        this.stacjonarne = stacjonarne;
        this.k1=k1;
        this.grades=grades;
        this.grades.registerObserver(this); // rejestrowanie kolejnego obserwatora
    }

    //Przesłonięta metoda z interfejsu Observer
    @Override
    public void update(Date date, int ocena) {
        this.ocena=ocena;
        this.date=date;
        display();
    }
    public void display(){
        System.out.println("Student o imieniu "+getImie()+ " zdobył nową ocenę!\nData: "+date+ "\nOcena:"+ocena+"\nPrzedmiot: "+getK1()+"\n-----------------------------------------");
    }


    public int hashCode(){
        return Integer.parseInt(numerIndeksu);
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
            final Student other = (Student) obj;
            if (!Objects.equals(this.numerIndeksu, other.numerIndeksu)) {
                return false;
            }
            return true;
    }

    public String getNumerIndeksu() {
        return numerIndeksu;
    }

    public void setNumerIndeksu(String numerIndeksu) {
        this.numerIndeksu = numerIndeksu;
    }


    public boolean isCzyERASMUS() {
        return czyERASMUS;
    }

    public void setCzyERASMUS(boolean czyERASMUS) {
        this.czyERASMUS = czyERASMUS;
    }


    public boolean isStacjonarne() {
        return stacjonarne;
    }

    public void setStacjonarne(boolean stacjonarne) {
        this.stacjonarne = stacjonarne;
    }

    public int getStopien() {
        return stopien;
    }

    public void setStopien(int stopien) {
        this.stopien = stopien;
    }

    public Kursy getK1() {
        return k1;
    }

    public void setK(Kursy k1) {
        this.k1 = k1;
    }


    public String toString(){
        System.out.println("----------------------------");
        System.out.println("STUDENT");
        return "\nImie: "+getImie()+"\nNazwisko: "+getNazwisko()+"\nPESEL: "+getPESEL()+"\nWiek: "+getWiek()+"\nPłeć: "+getPlec()+"\nNumer indeksu: "+getNumerIndeksu()+"\nCzy jest na ERASMUSIE: "+czyERASMUS+"\nStopień: "+stopien+" \nDrugi stopień: "+" \nCzy stacjonarne: "+stacjonarne+"\nKursy: "+getK1();
    }


}
