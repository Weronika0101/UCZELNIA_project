package PANEL_DO_GUI;

import Osoba.Osoba;
import Uczelnia.Pracownik_Uczelni;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Wysw_pr implements Wyswietlanie_Strategia {

    //Przesłonięta metoda z interfejsu Wyświetlanie_Strategia

    public void Wyswietlanie_Osob_GUI_lista(String pracownicy) {
        JFrame frame = new JFrame();
        JTextArea jTextArea = new JTextArea(pracownicy);
        jTextArea.setEditable(false);
        frame.add(jTextArea);
        JScrollPane jScrollPane=new JScrollPane(jTextArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        frame.add(jScrollPane, BorderLayout.CENTER);
        frame.setSize(250,500);
        frame.setVisible(true);
    }

    // Metoda iterująca po liście wybierająca z niej tylko instancje typu Pracownik_Uczelni

    public String Wyswietlanie_Pracownika(ArrayList<Osoba> listaOsob){

        ArrayList<Osoba> pracownicy=new ArrayList<>();

        for(int i=0;i<listaOsob.size();i++){
            if(listaOsob.get(i) instanceof Pracownik_Uczelni){
                pracownicy.add(listaOsob.get(i));
            }
        }
        return pracownicy.toString();
    }

}
