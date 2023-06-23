package Funkcjonalności;

import Kursy.Kursy;
import Osoba.Osoba;

import java.io.*;
import java.util.ArrayList;

public class Serializacja{
    private static ArrayList<Osoba> osobalista = null;
    private static ArrayList<Kursy> kursy = null;


    public void zapisDoPliku_Osoba(ArrayList<Osoba> Listaosob)
    {
        try {
            FileOutputStream fo = new FileOutputStream("NowyPlikOsob.txt");
            ObjectOutputStream so = new ObjectOutputStream(fo);

            so.writeObject(Listaosob);

            try {
                so.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fo.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }

    }
    public void zapisDoPliku_Kursy(ArrayList<Kursy> bazaKursow)
    {
        try {
            FileOutputStream fo = new FileOutputStream("bazaKursow.txt");
            ObjectOutputStream so = new ObjectOutputStream(fo);

            so.writeObject(bazaKursow);

            try {
                so.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fo.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }

    }
    public static ArrayList<Osoba> Odczyt_osoby()
    {
        try {
            FileInputStream fis = new FileInputStream("NowyPlikOsob.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            osobalista = (ArrayList) obj;
            // sprawdzenie dzialania odczytu.

            System.out.println("z pliku---------------------------------------------------------------");
//            for(int i=0;i<osoba.size(); i++)
//            {
//                System.out.println(osoba.get(i));
//            }


            try {
                ois.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fis.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }



        } catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();

        }
       return osobalista;
    }
    public static ArrayList<Kursy> Odczyt_Kursy()
    {
        try {
            FileInputStream fis = new FileInputStream("bazaKursow.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            kursy = (ArrayList) obj;
            // sprawdzenie dzialania odczytu.

            System.out.println("z pliku---------------------------------------------------------------");
//            for(int i=0;i<osoba.size(); i++)
//            {
//                System.out.println(osoba.get(i));
//            }


            try {
                ois.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fis.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }



        } catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();

        }
        return kursy;
    }

}
