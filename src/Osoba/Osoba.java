package Osoba;


import Funkcjonalności.Serializacja;
import Kursy.Kursy;
import Oceny_Obserwator.Oceny;
import Pracownicy_Uczelni.Pracownik_Administracyjny;
import Pracownicy_Uczelni.Pracownik_Badawczo_Dydaktyczny;
import Uczelnia.Pracownik_Uczelni;
import Uczelnia.Student;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Osoba implements Serializable {
    private String imie;
    private String nazwisko;
    private String PESEL;
    private int wiek;
    private String plec;
    private static final long serialVersionUID = 6679563588983870396L;
    static Oceny ocena=new Oceny();

    public Osoba() {

    }

    public Osoba(String imie, String nazwisko, String PESEL, int wiek, String plec) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.PESEL = PESEL;
        this.wiek = wiek;
        this.plec = plec;
    }


    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPESEL() {
        return PESEL;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public String toString() {
        return "\n\nImie: " + imie + " Nazwisko: " + nazwisko + " PESEL: " + PESEL + " Wiek: " + wiek + " Płeć: " + plec;
    }


    //wyswietlanie informacji o wszystkich osobach z arrayList
    public static void wyswieltStudentow(ArrayList<Osoba> listaOsob) {
        for (int i = 0; i < listaOsob.size(); i++) {
            if (listaOsob.get(i) instanceof Student) {
                System.out.println(listaOsob.get(i));
            }
        }

    }

    public static void wyswieltPracownikow(ArrayList<Osoba> listaOsob) {
        for (int i = 0; i < listaOsob.size(); i++) {
            if (listaOsob.get(i) instanceof Pracownik_Uczelni) {
                System.out.println(listaOsob.get(i));
            }
        }

    }

    public static void generateBazaDanych() {
        ArrayList<Kursy> bazaKursow = new ArrayList<>();
        bazaKursow.add(new Kursy("Analiza matematyczna |", "Tomasz Wilk", 6));
        bazaKursow.add(new Kursy("Fizyka |", "Andrzej Kot", 4));
        bazaKursow.add(new Kursy("Algebra", "Barbara Kowalska", 6));
        bazaKursow.add(new Kursy("Technologie informacyjne", "Paulina Kowalczyk", 3));
        bazaKursow.add(new Kursy("Grafika inżynierska", "Karol Baranowski", 4));
        bazaKursow.add(new Kursy("Programowanie", "Andrzej Karaś", 5));

        ArrayList<Osoba> listaOsob = new ArrayList<>();
        Osoba pracownik_administracyjny1 = new Pracownik_Administracyjny("Benedykt", "Zimniak", "60052097633", 61, "mezczyzna", "Referent", 25, 4500, 15);
        Osoba pracownik_administracyjny2 = new Pracownik_Administracyjny("Jan", "Kowalski", "79120634544", 52, "mężczyzna", "Specjalista", 21, 4800, 10);
        Osoba pracownik_badawczo_dydaktyczny = new Pracownik_Badawczo_Dydaktyczny("Katarzyna", "Piechota", "73081557422", 48, "kobieta", "wykładowca", 20, 5500, 25);
        Osoba student1 = new Student("Andrzej", "Kowalski", "014723349", 21, "mezczyzna", "255867", false, 1, true, bazaKursow.get(0),ocena);
        Osoba student2 = new Student("Krzysztof", "Nowaczyk", "01220835759", 20, "mezczyzna", "266844", false, 1, true, bazaKursow.get(1),ocena);
        Osoba student3 = new Student("Maja", "Andrzejewska", "1234567890", 20, "kobieta", "12345", false, 2, false, bazaKursow.get(2),ocena);
        Osoba student4 = new Student("Maja", "Andrzejewska", "1234567890", 20, "kobieta", "12345", false, 2, false, bazaKursow.get(2),ocena);

        listaOsob.add(pracownik_administracyjny1);
        listaOsob.add(pracownik_administracyjny2);
        listaOsob.add(pracownik_badawczo_dydaktyczny);
        listaOsob.add(student1);
        listaOsob.add(student2);
        listaOsob.add(student3);
        listaOsob.add(student4);
        Serializacja serializacja=new Serializacja();
        serializacja.zapisDoPliku_Kursy(bazaKursow);
        serializacja.zapisDoPliku_Osoba(listaOsob);


    }

    public static ArrayList<Kursy> getBazaKursow() {
        ArrayList<Kursy> bazaKursow = new ArrayList<>();
        bazaKursow.add(new Kursy("Analiza matematyczna |", "Tomasz Wilk", 6));
        bazaKursow.add(new Kursy("Fizyka |", "Andrzej Kot", 4));
        bazaKursow.add(new Kursy("Algebra", "Barbara Kowalska", 6));
        bazaKursow.add(new Kursy("Technologie informacyjne", "Paulina Kowalczyk", 3));
        bazaKursow.add(new Kursy("Grafika inżynierska", "Karol Baranowski", 4));
        bazaKursow.add(new Kursy("Programowanie", "Andrzej Karaś", 5));
        return bazaKursow;
    }
    /*public static ArrayList<Osoba> getListaOsob(){
        ArrayList<Osoba> listaOsob = new ArrayList<>();
        Osoba pracownik_administracyjny1 = new Pracownik_Administracyjny("Benedykt", "Zimniak", "60052097633", 61, "mezczyzna", "Referent", 25, 4500, 15);
        Osoba pracownik_administracyjny2 = new Pracownik_Administracyjny("Jan", "Kowalski", "79120634544", 52, "mężczyzna", "Specjalista", 21, 4800, 10);
        Osoba pracownik_badawczo_dydaktyczny = new Pracownik_Badawczo_Dydaktyczny("Katarzyna", "Piechota", "73081557422", 48, "kobieta", "wykładowca", 20, 5500, 25);
        Osoba student1 = new Student("Andrzej", "Kowalski", "014723349", 21, "mezczyzna", "255867", false, 1, true, getBazaKursow().get(0));
        Osoba student2 = new Student("Krzysztof", "Nowaczyk", "01220835759", 20, "mezczyzna", "266844", false, 1, true, getBazaKursow().get(2));
        Osoba student3 = new Student("Maja", "Andrzejewska", "1234567890", 20, "kobieta", "12345", false, 2, false, getBazaKursow().get(4));
        listaOsob.add(pracownik_administracyjny1);
        listaOsob.add(pracownik_administracyjny2);
        listaOsob.add(pracownik_badawczo_dydaktyczny);
        listaOsob.add(student1);
        listaOsob.add(student2);
        listaOsob.add(student3);
        return listaOsob;
    }*/
}
