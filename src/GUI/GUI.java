package GUI;

import Funkcjonalności.Serializacja;
import PANEL_DO_GUI.Wysw_pr;
import PANEL_DO_GUI.Wysw_st;
import PANEL_DO_GUI.do_GUI;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class GUI {

    public static void GUI2(){
        UIManager manager=new UIManager();
        LinkedList<Object> a=new LinkedList<>();
        a.add(0.3);
        a.add(0.3);
        a.add(new ColorUIResource(208, 135, 196));
        a.add(new ColorUIResource(233, 218, 234));
        a.add(new ColorUIResource(208, 139, 210));
        manager.put("Button.gradient",a);
        JFrame frame = new JFrame("UCZELNIA");
        JPanel panel1= new JPanel();
        JPanel panel2=new JPanel();
        JLabel label=new JLabel("Gratulacje,udało ci się wygenerować bazę danych!Co chcesz dalej zrobić?");
        frame.getContentPane().add(BorderLayout.NORTH,panel1);
        frame.getContentPane().add(BorderLayout.CENTER,panel2);
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\weron\\IdeaProjects\\graduation-cap.png");
        frame.setIconImage(icon);
        panel2.setLayout(new GridLayout(3, 2,50,50));
        JButton button1=new JButton("WYŚWIETL STUDENTÓW");
        JButton button2=new JButton("WYŚWIETL PRACOWNIKÓW");
        JButton button3=new JButton("WYŚWIETL KURSY");
        JButton button4=new JButton("WYSZUKAJ OSOBY I KURSY");
        JButton button5=new JButton("SORTUJ OSOBY I KURSY");
        JButton button7= new JButton("USUŃ POWTARZAJĄCE SIĘ OSOBY");
        JButton button6=new JButton("ZAKOŃCZ PROGRAM");

        button1.addActionListener(new Button_wyswietlanie_studentow());
        button2.addActionListener(new Button_wyswietlanie_pracownikow());
        button3.addActionListener(new Button_wyswietlanie_kursow());
        button4.addActionListener(new Button_wyszukiwanie(frame));
        button5.addActionListener(new Button_sortowanie());
        button6.addActionListener(new Button_exit(frame));
        button7.addActionListener(new Button_usuwanie(frame));
        Color col=new Color(194, 8, 8, 255);
        button6.setForeground(col);

        panel1.add(label);
        panel2.add(button1);
        panel2.add(button2);
        panel2.add(button3);
        panel2.add(button4);
        panel2.add(button5);
        panel2.add(button7);
        panel2.add(button6);

        frame.setSize(900,400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    static class Button_wyswietlanie_studentow implements ActionListener {



        @Override
        public void actionPerformed(ActionEvent e) {
            Wyswietlanie_studentow ws=new Wyswietlanie_studentow();
           Wysw_st wysw_st=new Wysw_st();
            ws.Wyswietl_Osoby(wysw_st.Wyswietlanie_Studenta(Serializacja.Odczyt_osoby()));

        }
    }
    static class Button_wyswietlanie_pracownikow implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Wyświetlanie_pracownikow wp=new Wyświetlanie_pracownikow();
            Wysw_pr wysw_pr=new Wysw_pr();
            // Uruchamiamy metodę Wyswietl_Osoby z klasy GUI_Wyświetlanie w stosunku do instancji klasy Wyświetlanie_pracownikow
            //do której przekazujemy w argumencie wynik działanie metody Wyswietlanie_Pracownika, czyli Stringa z pracownikami
           wp.Wyswietl_Osoby(wysw_pr.Wyswietlanie_Pracownika(Serializacja.Odczyt_osoby()));

        }
    }
    static class Button_wyswietlanie_kursow implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        do_GUI.wyswietlanie_Kursow();
        }
    }
    static class Button_wyszukiwanie implements ActionListener{
        JFrame frame;

        public Button_wyszukiwanie(JFrame frame){
            this.frame = frame;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            GUI_Wyszukiwanie.Wyszukiwanie();
        }
    }
    static class Button_sortowanie implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            GUI_Sortowanie.Sortowanie();
        }
    }
    static class Button_usuwanie implements ActionListener{
        JFrame frame;

        public Button_usuwanie(JFrame frame){
            this.frame = frame;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            do_GUI.Usuwanie(Serializacja.Odczyt_osoby());
            UIManager manager=new UIManager();
            LinkedList<Object> a=new LinkedList<>();
            a.add(0.3);
            a.add(0.3);
            a.add(new ColorUIResource(208, 135, 196));
            a.add(new ColorUIResource(233, 218, 234));
            a.add(new ColorUIResource(208, 139, 210));
            manager.put("Button.gradient",a);
            frame.dispose();
            JFrame frame=new JFrame();
            JPanel jPanel1=new JPanel();
            JPanel jPanel2=new JPanel();
            JLabel jLabel=new JLabel("Właśnie usunąłeś powtarzające się osoby");
            JButton Button_ok=new JButton("OK");
            frame.add(jPanel1);
            frame.add(jPanel2);
            jPanel1.add(jLabel);
            jPanel2.add(Button_ok);
            frame.getContentPane().add(BorderLayout.CENTER,jPanel1);
            frame.getContentPane().add(BorderLayout.SOUTH,jPanel2);
            Button_ok.addActionListener(new GUI_Wyszukiwanie.Button_ok(frame));
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            frame.setSize(400,200);
        }
    }

    static class Button_exit implements ActionListener{
        JFrame frame;

        public Button_exit(JFrame frame){
            this.frame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();

            System.exit(0);

        }
    }


}
