package Kursy;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;


public class Kursy implements Serializable {
    private String nazwa;
    private String prowadzacy;
    private int ECTS;
    //private static ArrayList<Kursy>bazaKursow;


    public Kursy() {

    }

    public Kursy(String nazwa, String prowadzacy, int ECTS) {
        this.nazwa = nazwa;
        this.prowadzacy = prowadzacy;
        this.ECTS = ECTS;

    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getProwadzacy() {
        return prowadzacy;
    }

    public void setProwadzacy(String prowadzacy) {
        this.prowadzacy = prowadzacy;
    }

    public int getECTS() {
        return ECTS;
    }

    public void setECTS(int ECTS) {
        this.ECTS = ECTS;
    }

    public String toString() {
        return "\n" + "Nazwa kursu: " + getNazwa() + "\n" + "Prowadzący: " + getProwadzacy() + "\n" + "Ilość punktów ECTS: " + getECTS();
    }


    /*baza wszystkich kursów
    public void initializeKursy() {
        bazaKursow = new Kursy[6];
        bazaKursow[0] = new Kursy("Analiza matematyczna |", "Tomasz Wilk", 6);
        bazaKursow[1] = new Kursy("Fizyka |", "Andrzej Kot", 4);
        bazaKursow[2] = new Kursy("Algebra", "Barbara Kowalska", 6);
        bazaKursow[3] = new Kursy("Technologie informacyjne", "Paulina Kowalczyk", 3);
        bazaKursow[4] = new Kursy("Grafika inżynierska", "Karol Baranowski", 4);
        bazaKursow[5] = new Kursy("Programowanie", "Andrzej Karaś", 5);

    }

    //losowanie tablicy z kursami dla każdego studenta
    public Kursy[] wylosujKursy(Kursy[] k) {
        Random generator = new Random();
        Kursy[] wylosowaneKursy = new Kursy[generator.nextInt(k.length - 1) + 1];
        for (int i = 0; i < wylosowaneKursy.length; i++) {
            wylosowaneKursy[i] = k[i];
        }
        return wylosowaneKursy;
    }*/

    //szukanie kursu po nazwie
    public void wyszukiwanieKursuPoNazwie(ArrayList<Kursy>bazaKursow,String a,int b) {
        for (int i = 0; i < bazaKursow.size(); i++) {
            if (bazaKursow.get(i).getNazwa().toLowerCase(Locale.ROOT).equals(a.toLowerCase(Locale.ROOT))) {
                System.out.println("-----------------");
                System.out.println("OTO SZUKANY KURS");
                System.out.println(bazaKursow.get(i));
                if(b==1){
                    bazaKursow.remove(i);
                }
            }
        }

    }
    public void wyszukiwanieKursuPoProwadzacym(ArrayList<Kursy>bazaKursow,String a, int b){
        for (int i = 0; i < bazaKursow.size(); i++) {
            if (bazaKursow.get(i).getProwadzacy().toLowerCase(Locale.ROOT).equals(a.toLowerCase(Locale.ROOT))) {
                System.out.println("-----------------");
                System.out.println("OTO SZUKANY KURS");
                System.out.println(bazaKursow.get(i));
                if(b==1){
                    bazaKursow.remove(i);
                }
            }
        }
    }
    public void wyszukiwanieKursuPoECTS(ArrayList<Kursy>bazaKursow,int a,int b){
        for (int i = 0; i < bazaKursow.size(); i++) {
            if (bazaKursow.get(i).getECTS()==a) {
                System.out.println("-----------------");
                System.out.println("OTO SZUKANY KURS");
                System.out.println(bazaKursow.get(i));
                if(b==1){
                    bazaKursow.remove(i);
                }
            }
        }
    }
    //wyswietlanie WSZYSTKICH kursow
    public void wyswietlanieWszystkichKursow(ArrayList<Kursy>bazaKursow) {
        System.out.println("--------------------------\nBAZA KURSÓW");
        for (int i = 0; i < bazaKursow.size(); i++) {
            System.out.println(bazaKursow.get(i));
        }
    }
}
