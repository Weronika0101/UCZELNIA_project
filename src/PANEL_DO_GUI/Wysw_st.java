package PANEL_DO_GUI;

import Osoba.Osoba;
import Uczelnia.Student;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Wysw_st implements Wyswietlanie_Strategia {

    //Przesłonięta metoda z interfejsu Wyświetlanie_Strategia

    public void Wyswietlanie_Osob_GUI_lista(String studenci) {

        JFrame frame = new JFrame();
        JTextArea jTextArea = new JTextArea(studenci);
        jTextArea.setEditable(false);
        frame.add(jTextArea);
        JScrollPane jScrollPane=new JScrollPane(jTextArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        frame.add(jScrollPane, BorderLayout.CENTER);
        frame.setSize(250,500);
        frame.setVisible(true);
    }

    // Metoda iterująca po liście wybierająca z niej tylko instancje typu Pracownik_Uczelni

    public String Wyswietlanie_Studenta(ArrayList<Osoba> listaOsob){
        ArrayList<Osoba> studenci=new ArrayList<>();

        for(int i=0;i<listaOsob.size();i++){
            if(listaOsob.get(i) instanceof Student){
                studenci.add(listaOsob.get(i));
            }
        }
        return studenci.toString();
    }
}
