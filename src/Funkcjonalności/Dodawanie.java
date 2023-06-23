package Funkcjonalności;

import Kursy.Kursy;
import Oceny_Obserwator.Oceny;
import Osoba.Osoba;
import Pracownicy_Uczelni.Pracownik_Administracyjny;
import Pracownicy_Uczelni.Pracownik_Badawczo_Dydaktyczny;
import Uczelnia.Student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Dodawanie implements Serializable {
    Scanner scan=new Scanner(System.in);
    static Oceny ocena=new Oceny();

    public Dodawanie() {
    }

    public void dodawaniePracownikaAdministracyjnego(ArrayList<Osoba> listaOsob) {

        System.out.println("DODAWANIE PRACOWNIKA ADMINISTRACYJNEGO");
        System.out.println("Podaj imie: ");
        String imie1 = scan.next();
        System.out.println("Podaj nazwisko: ");
        String nazwisko1 = scan.next();
        System.out.println("Podaj PESEL:");
        String PESEL1 = scan.next();
        System.out.println("Podaj wiek: ");
        int wiek1 = scan.nextInt();
        System.out.println("Podaj płeć:");
        String plec1 = scan.next();
        System.out.println("Podaj stanowsko: ");
        String stanowisko = scan.next();
        System.out.println("Podaj staż pracy: ");
        int staz = scan.nextInt();
        System.out.println("Podaj pensję: ");
        double pensja = scan.nextDouble();
        System.out.println("Podaj liczbe nadgodzin: ");
        int nadgodziny = scan.nextInt();
        listaOsob.add(new Pracownik_Administracyjny(imie1, nazwisko1, PESEL1, wiek1, plec1, stanowisko, staz, pensja, nadgodziny));
    }
    public void dodawanieStudenta(ArrayList<Osoba> listaOsob,ArrayList<Kursy>bazaKursow) {

        System.out.println("DODAWANIE STUDENTA");
        System.out.println("Podaj imie: ");
        String imie = scan.next();
        System.out.println("Podaj nazwisko: ");
        String nazwisko = scan.next();
        System.out.println("Podaj PESEL:");
        String PESEL = scan.next();
        System.out.println("Podaj wiek: ");
        int wiek = scan.nextInt();
        System.out.println("Podaj płeć:");
        String plec = scan.next();
        System.out.println("Podaj numer indeksu:");
        String indeks = scan.next();
        System.out.println("Czy jest na ERASMUSIE?");
        boolean czyERASMUS = scan.nextBoolean();
        System.out.println("Który stopień?");
        int stopien = scan.nextInt();
        System.out.println("Czy jest na studiach stacjonarnych?");
        boolean stacjonarne = scan.nextBoolean();
        System.out.println("Wybierz kurs na który będzie chodził student:\n1.Analiza matematyczna |\n2.Fizyka |\n3.Algebra\n4.Technologie informacyjne\n5.Grafika inżynierska\n6.Programowanie");
        Kursy k1 = bazaKursow.get(scan.nextInt() - 1);
        listaOsob.add(new Student(imie, nazwisko, PESEL, wiek, plec, indeks, czyERASMUS, stopien, stacjonarne, k1,ocena));
    }
    public void dodawaniePracownikaBadawczoNaukowego(ArrayList<Osoba> listaOsob) {

        System.out.println("DODAWANIE PRACOWNIKA BADAWCZO-DYDAKTYCZNEGO");
        System.out.println("Podaj imie: ");
        String imie2 = scan.next();
        System.out.println("Podaj nazwisko: ");
        String nazwisko2 = scan.next();
        System.out.println("Podaj PESEL:");
        String PESEL2 = scan.next();
        System.out.println("Podaj wiek: ");
        int wiek2 = scan.nextInt();
        System.out.println("Podaj płeć:");
        String plec2 = scan.next();
        System.out.println("Podaj stanowsko: ");
        String stanowisko1 = scan.next();
        System.out.println("Podaj staż pracy: ");
        int staz1 = scan.nextInt();
        System.out.println("Podaj pensję: ");
        double pensja1 = scan.nextDouble();
        System.out.println("Podaj punktację z dorobku: ");
        int punktacja = scan.nextInt();
        listaOsob.add(new Pracownik_Badawczo_Dydaktyczny(imie2, nazwisko2, PESEL2, wiek2, plec2, stanowisko1, staz1, pensja1, punktacja));
    }
}
