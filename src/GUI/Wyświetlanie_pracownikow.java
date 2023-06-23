package GUI;

import Funkcjonalności.Serializacja;
import PANEL_DO_GUI.Wysw_pr;
import PANEL_DO_GUI.Wysw_st;

import javax.swing.*;
import java.awt.*;

public class Wyświetlanie_pracownikow extends GUI_Wyświetlanie {
    public Wyświetlanie_pracownikow(){
        Wysw= new Wysw_pr();
    }
/*
    public static void Wyswietlanie_Osob_GUI_lista() {
        JFrame frame = new JFrame();
        Wysw_pr wysw_pr=new Wysw_pr();
        JTextArea jTextArea = new JTextArea(wysw_pr.Wyswietlanie_Osob_GUI_lista(Serializacja.Odczyt_osoby()));
        jTextArea.setEditable(false);
        frame.add(jTextArea);
        JScrollPane jScrollPane=new JScrollPane(jTextArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        frame.add(jScrollPane, BorderLayout.CENTER);
        frame.setSize(250,500);
        frame.setVisible(true);
    }*/

}
