package pl.weronikalos;


import Funkcjonalności.Dodawanie;
import Funkcjonalności.Wyszukiwanie;
import Kursy.Kursy;
import Oceny_Obserwator.Oceny;
import Osoba.Osoba;
import Funkcjonalności.Sortowanie;
import Pracownicy_Uczelni.Pracownik_Administracyjny;
import Pracownicy_Uczelni.Pracownik_Badawczo_Dydaktyczny;
import Uczelnia.Student;

import java.io.Serializable;
import java.util.*;

import GUI.GUI_welcome;


public class Main implements Serializable {


    public static void main(String[] args) {

        Wyszukiwanie W = new Wyszukiwanie();
        Kursy K = new Kursy();
        Dodawanie dodawanie = new Dodawanie();
        Oceny ocena=new Oceny();

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
        listaOsob.add(pracownik_administracyjny1);
        listaOsob.add(pracownik_administracyjny2);
        listaOsob.add(pracownik_badawczo_dydaktyczny);
        listaOsob.add(student1);
        listaOsob.add(student2);
        listaOsob.add(student3);

        Date date = new Date();

        // Wykorzystanie Obserwatora, dodajemy kolejne updaty dotyczące ocen studentów razem z datą i przedmiotem
        System.out.println("------------------------");
        ocena.setMeasurements(date,5);
        System.out.println("------------------------");
        ocena.setMeasurements(date,1);
        System.out.println("------------------------");
        ocena.setMeasurements(date,3);


        GUI_welcome.GUI1();

        System.out.println("Witaj na uczelni!Czy chcesz stworzyć własną bazę osób?:\n1.nie\n2.tak");
        Scanner scan = new Scanner(System.in);
        try {
            int wybor0 = scan.nextInt();
            if (wybor0 == 1 || wybor0 == 2) {
                switch (wybor0) {
                    case 1:
                        System.out.println("Gratulacje,udało ci się wygenerować domyślną bazę danych");
                        break;
                    case 2:
                        listaOsob.clear();
                        int osoba;
                        do {
                            System.out.println("Kogo chcesz dodać do listy?\n1.studenta\n2.pracownika administracyjego\n3.pracownika badawczo-dydaktycznego\n Wpisz 4 jeśli chcesz zakońcyć tworzenie bazy banych");
                            osoba = scan.nextInt();
                            switch (osoba) {
                                case 1:
                                    dodawanie.dodawanieStudenta(listaOsob,bazaKursow);
                                    break;
                                case 2:
                                    dodawanie.dodawaniePracownikaAdministracyjnego(listaOsob);
                                    break;
                                case 3:
                                    dodawanie.dodawaniePracownikaBadawczoNaukowego(listaOsob);
                                    break;
                            }

                        } while (!Objects.equals(osoba, 4));
                }

            } else {
                System.out.println("Nieprawidłowy numer!");

            }
        } catch (InputMismatchException e) {
            System.out.println("NIE WPISAŁEŚ LICZBY CAŁKOWITEJ!!");
            System.exit(0);
        }

      //  Serializacja serializacja = new Serializacja(listaOsob);
       //  serializacja.zapisDoPliku(listaOsob);
       //  serializacja.odczytZPliku(listaOsob);

        Sortowanie sortowanie = new Sortowanie();
        sortowanie.generateComparators();

        while(true) {
            int wybor1 = 0;
            do {
                System.out.println("\n Jeśli chcesz:\n-wyświetlić dane wszystkich studentów---> wpisz 1\n-wyswietlić dane wszystkich pracowników---> wpisz 2\n-wyświetlić dane wszystkich kursów--->wpisz 3\n-przejść do wyszukiwania konkretnych osób/kursów--->wpisz 4\n-przejść do sortowania--->wpisz 5\n-zakończyć program--->wpisz 6");
                try {
                    wybor1 = scan.nextInt();
                    if (wybor1 == 1 || wybor1 == 2 || wybor1 == 3 || wybor1 == 4 || wybor1 == 5 || wybor1 == 6) {
                        switch (wybor1) {
                            case 1:
                                Osoba.wyswieltStudentow(listaOsob);
                                break;
                            case 2:
                                Osoba.wyswieltPracownikow(listaOsob);
                                break;
                            case 3:
                                K.wyswietlanieWszystkichKursow(bazaKursow);
                                break;
                            case 4:
                                System.out.println("Nie wybrałeś opcji wyświetlenia");
                                break;
                            case 5:
                                System.out.println("Sortuj: \n1.Osoby nazwiskami\n2.Osoby nazwiskami i imionami\n3.Osoby nazwiskami i wiekiem\n4.Kursy punktami ECTS\n5.Kursy prowadzącymi");
                                int sort = scan.nextInt();
                                if (sort == 1) {
                                    sortowanie.sortujNazwiskami(listaOsob);
                                } else if (sort == 2) {
                                    sortowanie.sortujNazwiskamiiImionami(listaOsob);
                                }else if(sort==3){
                                    sortowanie.sortujNazwiskamiiWiekiem(listaOsob);
                                 }else if (sort == 4) {
                                    sortowanie.sortujPunktami(bazaKursow);
                                } else if(sort==5){
                                    sortowanie.sortujProwadzacymi(bazaKursow);
                                }
                                else {
                                    System.out.println("Nieprawidłowy numer!");
                                }
                                break;
                            case 6:
                                System.exit(0);
                                break;
                        }
                    } else {
                        System.out.println("Nieprawidłowy numer!");
                    }

                } catch (InputMismatchException e) {
                    System.out.println("NIE WPISAŁEŚ LICZBY CAŁKOWITEJ!!");
                    System.exit(0);
                }
            } while (wybor1 != 4);

            int wybor2 = 0;
            do {
                System.out.println();
                System.out.println("Wybierz kogo/co chcesz wyszukać lub wróć do menu: \n-studenta--->wpisz 1\n-pracownika--->wpisz 2\n-kurs--->wpisz 3\n-powrót do menu--->wpisz 4");
                try {
                    wybor2 = scan.nextInt();
                    if (wybor2 == 1 || wybor2 == 2 || wybor2 == 3 || wybor2 == 4)
                        switch (wybor2) {
                            case 1:
                                try {
                                    System.out.println("WYBIERZ OPCJĘ WYSZUKIWANIA STUDENTÓW:\n" +
                                            "1.po imieniu\n2.po nazwisku\n3.pu numerze indeksu\n4.po stopniu");
                                    int wybor3 = scan.nextInt();
                                    if (wybor3 == 1 || wybor3 == 2 || wybor3 == 3 || wybor3 == 4) {
                                        switch (wybor3) {
                                            case 1:
                                                System.out.println("Wpisz imie:");
                                                String imie = scan.next();
                                                System.out.println("Czy chcesz usunąć tą osobę z listy?\n1.tak\n2.nie");
                                                int b = scan.nextInt();
                                                W.wyszukiwanieStudentaPoImieniu(listaOsob, imie, b);
                                                break;
                                            case 2:
                                                System.out.println("Wpisz nazwisko: ");
                                                String nazwisko = scan.next();
                                                System.out.println("Czy chcesz usunąć tą osobę z listy?\n1.tak\n2.nie");
                                                b = scan.nextInt();
                                                W.wyszukiwanieStudentaPoNazwisku(listaOsob, nazwisko, b);
                                                break;
                                            case 3:
                                                System.out.println("Wpisz numer indeksu: ");
                                                String nr_indeksu = scan.next();
                                                System.out.println("Czy chcesz usunąć tą osobę z listy?\n1.tak\n2.nie");
                                                b = scan.nextInt();
                                                W.wyszukiwanieStudentaPoNumerzeIndeksu(listaOsob, nr_indeksu, b);
                                                break;
                                            case 4:
                                                System.out.println("Wpisz stopień:");
                                                int stopien = scan.nextInt();
                                                System.out.println("Czy chcesz usunąć tą osobę z listy?\n1.tak\n2.nie");
                                                b = scan.nextInt();
                                                W.wyszukiwanieStudentaPoStopniu(listaOsob, stopien, b);
                                                break;
                                        }
                                    } else {
                                        System.out.println("Nieprawidlowy numer");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("NIE WPISAŁEŚ LICZBY CAŁKOWITEJ!!");
                                    System.exit(0);
                                }
                                break;
                            case 2:
                                try {
                                    System.out.println("WYBIERZ OPCJĘ WYSZUKIWANIA PRACOWNIKA:\n" +
                                            "1.po imieniu\n2.po nazwisku\n3.po wieku\n4.po stanowsku\n5. po liczbie nadgodzin\n6.po stażu");
                                    int wybor4 = scan.nextInt();
                                    if (wybor4 == 1 || wybor4 == 2 || wybor4 == 3 || wybor4 == 4 || wybor4 == 5 || wybor4 == 6) {
                                        switch (wybor4) {
                                            case 1:
                                                System.out.println("Wpisz imie:");
                                                String imie = scan.next();
                                                System.out.println("Czy chcesz usunąć tą osobę z listy?\n1.tak\n2.nie");
                                                int b = scan.nextInt();
                                                W.wyszukiwaniePracownikaPoImieniu(listaOsob, imie, b);
                                                break;
                                            case 2:
                                                System.out.println("Wpisz nazwisko:");
                                                String nazwisko = scan.next();
                                                System.out.println("Czy chcesz usunąć tą osobę z listy?\n1.tak\n2.nie");
                                                b = scan.nextInt();
                                                W.wyszukiwaniePracownikaPoNazwisku(listaOsob, nazwisko, b);
                                                break;
                                            case 3:
                                                System.out.println("Wprowadz wiek:");
                                                int wiek = scan.nextInt();
                                                System.out.println("Czy chcesz usunąć tą osobę z listy?\n1.tak\n2.nie");
                                                b = scan.nextInt();
                                                W.wyszukiwaniePracownikaPoWieku(listaOsob, wiek, b);
                                                break;
                                            case 4:
                                                System.out.println("Wprowadz stanowisko:");
                                                String stanowisko = scan.next();
                                                System.out.println("Czy chcesz usunąć tą osobę z listy?\n1.tak\n2.nie");
                                                b = scan.nextInt();
                                                W.wyszukiwaniePracownikaPoStanowisku(listaOsob, stanowisko, b);
                                                break;
                                            case 5:
                                                System.out.println("Wpisz liczbe nadgodzin:");
                                                int nadgodziny = scan.nextInt();
                                                System.out.println("Czy chcesz usunąć tą osobę z listy?\n1.tak\n2.nie");
                                                b = scan.nextInt();
                                                W.wyszukiwaniePracownikaPoNadgodzinach(listaOsob, nadgodziny, b);
                                                break;
                                            case 6:
                                                System.out.println("Wpisz staż: ");
                                                int staz = scan.nextInt();
                                                System.out.println("Czy chcesz usunąć tą osobę z listy?\n1.tak\n2.nie");
                                                b = scan.nextInt();
                                                W.wyszukiwaniePracownikaPoStazu(listaOsob, staz, b);
                                                break;
                                        }
                                    } else {
                                        System.out.println("Nieprawidlowy numer!");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("NIE WPISAŁEŚ LICZBY CAŁKOWITEJ!!");
                                    System.exit(0);
                                }

                                break;
                            case 3:
                                try {
                                    System.out.println("WYBIERZ OPCJĘ WYSZUKIWANIA KURSÓW:\n1.po nazwie\n2.po prowadzacym\n3.po punktach ECTS");
                                    int wybor5 = scan.nextInt();
                                    if (wybor5 == 1 || wybor5 == 2 || wybor5 == 3) {
                                        switch (wybor5) {
                                            case 1:
                                                System.out.println("Wpisz nazwe kursu: ");
                                                String nazwa = scan.next();
                                                System.out.println("Czy chcesz usunąć ten kurs z listy?\n1.tak\n2.nie");
                                                int b = scan.nextInt();
                                                K.wyszukiwanieKursuPoNazwie(bazaKursow, nazwa, b);
                                                break;
                                            case 2:
                                                System.out.println("Wprowadz prowadzacego:");
                                                String prowadzacy = scan.next();
                                                System.out.println("Czy chcesz usunąć ten kurs z listy?\n1.tak\n2.nie");
                                                b = scan.nextInt();
                                                K.wyszukiwanieKursuPoProwadzacym(bazaKursow, prowadzacy, b);
                                                break;
                                            case 3:
                                                System.out.println("Wpisz liczbe ECTS: ");
                                                int ECTS = scan.nextInt();
                                                System.out.println("Czy chcesz usunąć ten kurs z listy?\n1.tak\n2.nie");
                                                b = scan.nextInt();
                                                K.wyszukiwanieKursuPoECTS(bazaKursow, ECTS, b);
                                                break;
                                        }
                                    } else {
                                        System.out.println("Nieprawidlowy numer!");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("NIE WPISAŁEŚ LICZBY CAŁKOWITEJ!!");
                                    System.exit(0);
                                }


                                break;
                        }

                } catch (InputMismatchException e) {
                    System.out.println("NIE WPISAŁEŚ LICZBY CAŁKOWITEJ!!");
                    System.exit(0);
                }
            } while (!Objects.equals(wybor2, 4));

        }
        }
    }







