package PANEL_DO_GUI;

import Funkcjonalności.Serializacja;
import Kursy.Kursy;
import Oceny_Obserwator.Oceny;
import Osoba.Osoba;
import Pracownicy_Uczelni.Pracownik_Administracyjny;
import Pracownicy_Uczelni.Pracownik_Badawczo_Dydaktyczny;
import Uczelnia.Student;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Locale;

public class do_GUI{

    //klasa zapewniająca funkcjonalności takie jak sortowanie, usuwanie itp

    static ArrayList<Osoba> listaOsob=new ArrayList<>();
    private comparatorNazwisko Comparator1;
    private comparatorECTS Comparator2;
    static Oceny ocena=new Oceny();

    public void generateComparators(){
        Comparator1 = new comparatorNazwisko();
        Comparator2= new comparatorECTS();
    }

    static class comparatorNazwisko implements Comparator<Osoba> {
        public int compare(Osoba a,Osoba b){
            return a.getNazwisko().compareTo(b.getNazwisko());
        }
    }
    static class comparatorECTS implements Comparator<Kursy> {
        public int compare(Kursy a,Kursy b){
            return a.getECTS()-(b.getECTS());
        }
    }



    public static ArrayList<Osoba> getListaOsob() {
        return listaOsob;
    }
    public static ArrayList<Osoba>dodawanieStudenta_GUI(ArrayList<Osoba> listaOsob, String imie, String nazwisko, String PESEL, int wiek, String plec, String indeks, boolean czyERASMUS, int stopien, boolean stacjonarne, Kursy k, Oceny ocena){
        getListaOsob().add(new Student(imie, nazwisko, PESEL, wiek, plec, indeks, czyERASMUS, stopien, stacjonarne, k,ocena));
        return listaOsob;
    }
    public static ArrayList<Osoba> dodawaniePracownikaAdministracyjnego_GUI(ArrayList<Osoba> listaOsob,String imie, String nazwisko,String PESEL,int wiek,String plec,String stanowisko,int staz,double pensja,int nadgodziny){
        getListaOsob().add(new Pracownik_Administracyjny(imie, nazwisko, PESEL, wiek, plec,stanowisko,staz,pensja,nadgodziny));
        return listaOsob;
    }
    public static ArrayList<Osoba> dodawaniePracwonikaBadawczego_GUI(ArrayList<Osoba> listaOsob,String imie, String nazwisko,String PESEL,int wiek,String plec,String stanowisko,int staz,double pensja,int punkty){
        getListaOsob().add(new Pracownik_Badawczo_Dydaktyczny(imie, nazwisko, PESEL, wiek, plec, stanowisko,staz,pensja,punkty));
        return listaOsob;
    }
    public static void wyswietlanie_Kursow() {
        JFrame frame = new JFrame();
        JTextArea jTextArea = new JTextArea(do_GUI.Wyswietlanie_Kursow_GUI_lista(Serializacja.Odczyt_Kursy()));
        jTextArea.setEditable(false);
        JScrollPane jScrollPane=new JScrollPane(jTextArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        frame.add(jScrollPane, BorderLayout.CENTER);
        frame.add(jTextArea);
        frame.setVisible(true);
        frame.setSize(250,500);
    }
   /* public String Wyswietlanie_Studentow_GUI_lista(ArrayList<Osoba>listaOsob){
        ArrayList<Osoba> studenci=new ArrayList<>();
        for(int i=0;i<listaOsob.size();i++){
            if(listaOsob.get(i) instanceof Student){
                studenci.add(listaOsob.get(i));
            }
        }
        return studenci.toString();
    }
    public static String Wyswietlanie_Pracownikow_GUI_lista(ArrayList<Osoba>listaOsob){
        ArrayList<Osoba> pracownicy=new ArrayList<>();
        for(int i=0;i<listaOsob.size();i++){
            if(listaOsob.get(i) instanceof Pracownik_Uczelni){
                pracownicy.add(listaOsob.get(i));
            }
        }
        return pracownicy.toString();
    }*/
    public static String Wyswietlanie_Kursow_GUI_lista(ArrayList<Kursy>bazaKursow){
        return bazaKursow.toString();
    }

    public static String Wyszukiwanie_studenta_po_imieniu(ArrayList<Osoba>listaOsob,String a){
        ArrayList<Osoba>studenci=new ArrayList<>();
        for (int i = 0; i < listaOsob.size(); i++) {
            if (listaOsob.get(i) instanceof Student&&(listaOsob.get(i).getImie().toLowerCase(Locale.ROOT).equals(a.toLowerCase(Locale.ROOT)))) {
                studenci.add(listaOsob.get(i));

            }
        }
       return studenci.toString();
    }
    public static String Wyszukiwanie_kursu_po_ects(ArrayList<Kursy>bazaKursow,int a){
        ArrayList<Kursy> kursy=new ArrayList<Kursy>();
        for (int i = 0; i < bazaKursow.size(); i++) {
            if (bazaKursow.get(i).getECTS()==a) {
                kursy.add(bazaKursow.get(i));
            }
        }
        return kursy.toString();
    }
    public static void Usuwanie_studenta(ArrayList<Osoba>listaOsob,String a) {
       ArrayList<Osoba> studenci = new ArrayList<>();
        for (int i = 0; i < listaOsob.size(); i++) {
            if (!(listaOsob.get(i) instanceof Student && (listaOsob.get(i).getImie().toLowerCase(Locale.ROOT).equals(a.toLowerCase(Locale.ROOT))))) {
                studenci.add(listaOsob.get(i));
            }
        }
        Serializacja serializacja=new Serializacja();
        serializacja.zapisDoPliku_Osoba(studenci);
    }
    public static void Usuwanie_kursu(ArrayList<Kursy>bazaKursow,int a) {
        ArrayList<Kursy> kursy=new ArrayList<>();
        for (int i = 0; i < bazaKursow.size(); i++) {
            if (!(bazaKursow.get(i).getECTS()==a)) {
                kursy.add(bazaKursow.get(i));
            }
        }
        Serializacja serializacja=new Serializacja();
        serializacja.zapisDoPliku_Kursy(kursy);
    }
    public String Sortowanie_nazwiskami(ArrayList<Osoba> osoby){
        osoby.sort(Comparator1);
        ArrayList<Osoba> posortowane=new ArrayList<>();

        String a=osoby.get(0).getNazwisko();

        for(int i=0;i< osoby.size();i++){
            a.compareTo(osoby.get(i).getNazwisko());
            posortowane.add(osoby.get(i));

        }
        return posortowane.toString();
    }
    public String Sortowanie_ects(ArrayList<Kursy>kursy){
        kursy.sort(Comparator2);
        ArrayList<Kursy> posortowane=new ArrayList<>();

        int a=kursy.get(0).getECTS();

        for(int i=0;i< kursy.size();i++){
            if(a-(kursy.get(i).getECTS())!=0){
                System.out.println(kursy.get(i));
                posortowane.add(kursy.get(i));
                a=kursy.get(i).getECTS();

            } else{
                System.out.println(kursy.get(i));
                posortowane.add(kursy.get(i));
            }
        }
        return posortowane.toString();
    }
    public static ArrayList<Osoba> Usuwanie(ArrayList<Osoba>osoby){
        ArrayList<Osoba> bezduplikatow=new ArrayList(new HashSet<>(osoby));

        Serializacja serializacja=new Serializacja();
        serializacja.zapisDoPliku_Osoba(bezduplikatow);
        return bezduplikatow;
    }
}
