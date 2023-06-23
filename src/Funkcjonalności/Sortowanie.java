package Funkcjonalności;

import Kursy.Kursy;
import Osoba.Osoba;
import java.util.ArrayList;
import java.util.Comparator;

public class Sortowanie {

    public Sortowanie() {

    }

    private comparatorNazwisko Comparator1;
    private comparatorImie Comparator2;
    private comparatorWiek Comparator3;
    private comparatorECTS Comparator4;
    private comparatorProwadzacy Comparator5;

    public void generateComparators(){
        Comparator1 = new comparatorNazwisko();
        Comparator2= new comparatorImie();
        Comparator3= new comparatorWiek();
        Comparator4= new comparatorECTS();
        Comparator5= new comparatorProwadzacy();
    }

    static class comparatorNazwisko implements Comparator<Osoba> {
        public int compare(Osoba a,Osoba b){
            return a.getNazwisko().compareTo(b.getNazwisko());
        }
    }
    static class comparatorImie implements Comparator<Osoba> {
        public int compare(Osoba a,Osoba b){
            return a.getImie().compareTo(b.getImie());
        }
    }
    static class comparatorWiek implements Comparator<Osoba> {
        public int compare(Osoba a,Osoba b){
            return a.getWiek()-(b.getWiek());
        }
    }
    static class comparatorProwadzacy implements Comparator<Kursy> {
        public int compare(Kursy a,Kursy b){
            return a.getProwadzacy().compareTo(b.getProwadzacy());
        }
    }
    static class comparatorECTS implements Comparator<Kursy> {
        public int compare(Kursy a,Kursy b){
            return a.getECTS()-(b.getECTS());
        }
    }
    public void sortujNazwiskami(ArrayList<Osoba> osoby){
        osoby.sort(Comparator1);

        String a=osoby.get(0).getNazwisko();
        System.out.println();
        System.out.println("SORTOWANIE NAZWISKAMI");

        for(int i=0;i< osoby.size();i++){
           a.compareTo(osoby.get(i).getNazwisko());
                System.out.println(osoby.get(i));
               // a=osoby.get(i).getNazwisko();

            }
        }

    public void sortujNazwiskamiiImionami(ArrayList<Osoba>osoby){
        osoby.sort(Comparator2);
        osoby.sort(Comparator1);

        String a=osoby.get(0).getNazwisko();
        String b=osoby.get(0).getImie();
        System.out.println();
        System.out.println("SORTOWANIE IMIONAMI I NAZWISKAMI");

        for(int i=0;i< osoby.size();i++){
            if(a.compareTo(osoby.get(i).getNazwisko())!=0){
                System.out.println(osoby.get(i));
                a=osoby.get(i).getNazwisko();
            } else {
                b.compareTo(osoby.get(i).getImie());
                System.out.println(osoby.get(i));
                b=osoby.get(i).getImie();
            }
        }

    }
   public void sortujNazwiskamiiWiekiem(ArrayList<Osoba>osoby){
        osoby.sort(Comparator1);
        osoby.sort(Comparator3);

        String a=osoby.get(0).getNazwisko();
        int b=osoby.get(0).getWiek();
        System.out.println();
        System.out.println("SORTOWANIE WIEKIEM I NAZWISKAMI");

        for(int i=0;i< osoby.size();i++){
            if(a.compareTo(osoby.get(i).getNazwisko())!=0){
                System.out.println(osoby.get(i));
                a=osoby.get(i).getNazwisko();
            } else if(b-(osoby.get(i).getWiek())!=0){
                System.out.println(osoby.get(i));
                b=osoby.get(i).getWiek();
            }
        }
    }
    public void sortujPunktami(ArrayList<Kursy>kursy){
        kursy.sort(Comparator4);

        int a=kursy.get(0).getECTS();
        System.out.println();
        System.out.println("SORTOWANIE KURSÓW PUNKTAMI ECTS");

        for(int i=0;i< kursy.size();i++){
            if(a-(kursy.get(i).getECTS())!=0){
                System.out.println(kursy.get(i));
                a=kursy.get(i).getECTS();

            } else{
                System.out.println(kursy.get(i));
            }
        }
    }
    public void sortujProwadzacymi(ArrayList<Kursy>kursy){
        kursy.sort(Comparator5);

        String a=kursy.get(0).getProwadzacy();
        System.out.println();
        System.out.println("SORTOWANIE KURSÓW WEDŁUG PROWADZĄCEGO");

        for(int i=0;i< kursy.size();i++){
            a.compareTo(kursy.get(i).getProwadzacy());
                System.out.println(kursy.get(i));
                //a=kursy.get(i).getProwadzacy();

            }
        }
    }




