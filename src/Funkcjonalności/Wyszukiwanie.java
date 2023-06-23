package Funkcjonalności;

import Osoba.Osoba;
import Pracownicy_Uczelni.Pracownik_Administracyjny;
import Uczelnia.Pracownik_Uczelni;
import Uczelnia.Student;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


public class Wyszukiwanie {

    //szukanie studenta po nazwisku
    public void wyszukiwanieStudentaPoNazwisku(ArrayList<Osoba>listaOsob,String a,int b) {
        for (int i = 0; i < listaOsob.size(); i++) {
            if (listaOsob.get(i) instanceof Student) {
                if ((listaOsob.get(i).getNazwisko()).toLowerCase(Locale.ROOT).equals(a.toLowerCase(Locale.ROOT))) {
                    System.out.println("\n\nOTO SZUKANY STUDENT");
                    System.out.println(listaOsob.get(i));
                    if(b==1){
                        listaOsob.remove(i);
                    }
                }
            }
        }
    }
    public void wyszukiwanieStudentaPoImieniu(ArrayList<Osoba>listaOsob,String a,int b) {
        for (int i = 0; i < listaOsob.size(); i++) {
            if (listaOsob.get(i) instanceof Student) {
                if ((listaOsob.get(i).getImie()).toLowerCase(Locale.ROOT).equals(a.toLowerCase(Locale.ROOT))) {
                    System.out.println("\n\nOTO SZUKANY STUDENT");
                    System.out.println(listaOsob.get(i));
                    if(b==1){
                        listaOsob.remove(i);
                    }
                }
            }
        }
    }
    public void wyszukiwanieStudentaPoNumerzeIndeksu(ArrayList<Osoba>listaOsob,String a,int b) {
        for (int i = 0; i < listaOsob.size(); i++) {
            if (listaOsob.get(i) instanceof Student) {
                if (((Student) listaOsob.get(i)).getNumerIndeksu().equals(a)) {
                    System.out.println("\n\nOTO SZUKANY STUDENT");
                    System.out.println(listaOsob.get(i));
                    if(b==1){
                        listaOsob.remove(i);
                    }
                }
            }
        }
    }
    public void wyszukiwanieStudentaPoStopniu(ArrayList<Osoba>listaOsob,int a,int b) {
        for (int i = 0; i < listaOsob.size(); i++) {
            if (listaOsob.get(i) instanceof Student) {
                if (((Student) listaOsob.get(i)).getStopien()==a) {
                    System.out.println("\n\nOTO SZUKANY STUDENT");
                    System.out.println(listaOsob.get(i));
                    if(b==1){
                        listaOsob.remove(i);
                    }
                }
            }
        }
    }

    //szukanie pracownika po wieku
    public void wyszukiwaniePracownikaPoWieku(ArrayList<Osoba> listaOsob,int a,int b) {
        for (int i = 0; i < listaOsob.size(); i++) {
            if (listaOsob.get(i) instanceof Pracownik_Uczelni) {
                if (listaOsob.get(i).getWiek()==a) {
                    System.out.println("\n\nOTO SZUKANY PRACOWNNIK");
                    System.out.println(listaOsob.get(i));
                    if(b==1){
                        listaOsob.remove(i);
                    }
                }
            }
        }
    }
    public void wyszukiwaniePracownikaPoImieniu(ArrayList<Osoba> listaOsob,String a,int b ) {
        for (int i = 0; i < listaOsob.size(); i++) {
            if (listaOsob.get(i) instanceof Pracownik_Uczelni) {
                if ((listaOsob.get(i).getImie().toLowerCase(Locale.ROOT).equals(a.toLowerCase(Locale.ROOT)))) {
                    System.out.println("\n\nOTO SZUKANY PRACOWNNIK");
                    System.out.println(listaOsob.get(i));
                    if(b==1){
                        listaOsob.remove(i);
                    }
                }
            }
        }
    }
    public void wyszukiwaniePracownikaPoNazwisku(ArrayList<Osoba> listaOsob,String a,int b) {
        for (int i = 0; i < listaOsob.size(); i++) {
            if (listaOsob.get(i) instanceof Pracownik_Uczelni) {
                if (listaOsob.get(i).getNazwisko().toLowerCase(Locale.ROOT).equals(a.toLowerCase(Locale.ROOT))) {
                    System.out.println("\n\nOTO SZUKANY PRACOWNNIK");
                    System.out.println(listaOsob.get(i));
                    if(b==1){
                        listaOsob.remove(i);
                    }
                }
            }
        }
    }
    public void wyszukiwaniePracownikaPoStazu(ArrayList<Osoba> listaOsob,int a,int b) {
        for (int i = 0; i < listaOsob.size(); i++) {
            if (listaOsob.get(i) instanceof Pracownik_Uczelni) {
                if (((Pracownik_Uczelni) listaOsob.get(i)).getStazPracy()==a) {
                    System.out.println("\n\nOTO SZUKANY PRACOWNNIK");
                    System.out.println(listaOsob.get(i));
                    if(b==1){
                        listaOsob.remove(i);
                    }
                }
            }
        }
    }
    public void wyszukiwaniePracownikaPoNadgodzinach(ArrayList<Osoba> listaOsob,int a,int b) {
        for (int i = 0; i < listaOsob.size(); i++) {
            if (listaOsob.get(i) instanceof Pracownik_Administracyjny) {
                if ((((Pracownik_Administracyjny) listaOsob.get(i)).getLiczbaNadgodzin()==a)) {
                    System.out.println("\n\nOTO SZUKANY PRACOWNNIK");
                    System.out.println(listaOsob.get(i));
                    if(b==1){
                        listaOsob.remove(i);
                    }
                }
            }
        }
    }
    public void wyszukiwaniePracownikaPoStanowisku(ArrayList<Osoba> listaOsob,String a,int b) {
        for (int i = 0; i < listaOsob.size(); i++) {
            if (listaOsob.get(i) instanceof Pracownik_Uczelni) {
                if (((Pracownik_Uczelni) listaOsob.get(i)).getStanowisko().toLowerCase(Locale.ROOT).equals(a.toLowerCase(Locale.ROOT))) {
                    System.out.println("\n\nOTO SZUKANY PRACOWNNIK");
                    System.out.println(listaOsob.get(i));
                    if(b==1){
                        listaOsob.remove(i);
                    }
                }
            }
        }
    }

}
