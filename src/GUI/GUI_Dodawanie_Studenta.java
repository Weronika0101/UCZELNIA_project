package GUI;

import Funkcjonalności.Dodawanie;
import Funkcjonalności.Serializacja;
import Kursy.Kursy;
import Oceny_Obserwator.Oceny;
import Osoba.Osoba;
import PANEL_DO_GUI.do_GUI;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

public class GUI_Dodawanie_Studenta extends GUI {
    static JTextField inputField1;
    static JTextField inputField2;
    static JTextField inputField3;
    static JTextField inputField4;
    static JTextField inputField5;
    static JTextField inputField6;
    static JTextField inputField7;
    static JTextField inputField8;
    static JTextField inputField9;
    static JRadioButton jRadioButton1;
    static JRadioButton jRadioButton2;
    static JRadioButton jRadioButton3;
    static JRadioButton jRadioButton4;
    static JRadioButton jRadioButton5;
    static JRadioButton jRadioButton6;
    static Oceny ocena=new Oceny();

     ArrayList<Osoba> listaOsob;
    Kursy k=new Kursy();


    Dodawanie d=new Dodawanie();
    public static void Dodawanie_osoby(){
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
        JLabel label=new JLabel("Kogo chcesz dodać?");
        frame.getContentPane().add(BorderLayout.NORTH,panel1);
        frame.getContentPane().add(BorderLayout.CENTER,panel2);
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\weron\\IdeaProjects\\graduation-cap.png");
        frame.setIconImage(icon);
        panel2.setLayout(new FlowLayout());
        JButton button1=new JButton("STUDENT");
        JButton button2=new JButton("PRACOWNIK ADMINISTRACYJNY");
        JButton button3=new JButton("PRACOWNIK BADAWCZO-DYDAKTYCZY");
        panel1.add(label);
        panel2.add(button1);
        panel2.add(button2);
        panel2.add(button3);
        button1.addActionListener(new Button1_dodawanie_studenta(frame));
        button2.addActionListener(new Button2_dodawanie_pracownika_adm(frame));
        button3.addActionListener(new Button3_dodawanie_pracownika_bad(frame));
        frame.setSize(400,200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void Dodawanie_osoby_student(){
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
        JPanel panel3=new JPanel();
        JPanel panel4=new JPanel();
        JLabel label=new JLabel("DODAWANIE STUDENTA");
        frame.getContentPane().add(BorderLayout.NORTH,panel1);
        frame.getContentPane().add(BorderLayout.EAST,panel2);
        frame.getContentPane().add(BorderLayout.WEST,panel3);
        frame.getContentPane().add(BorderLayout.SOUTH,panel4);
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\weron\\IdeaProjects\\graduation-cap.png");
        frame.setIconImage(icon);
        panel1.add(label);
         inputField1 = new JTextField(16);
        inputField2 = new JTextField(16);
        inputField3 = new JTextField(16);
        inputField4 = new JTextField(16);
        inputField5 = new JTextField(16);
        inputField6 = new JTextField(16);
        inputField7 = new JTextField(16);
        inputField8 = new JTextField(16);
         inputField9 = new JTextField(16);
        JLabel label1 = new JLabel("Wpisz imie: ");
        JLabel label2 = new JLabel("Wpisz nazwisko: ");
        JLabel label3 = new JLabel("Wpisz PESEL:");
        JLabel label4 = new JLabel("Wpisz wiek: ");
        JLabel label5 = new JLabel("Wpisz płeć:");
        JLabel label6 = new JLabel("Wpisz numer indeksu:");
        JLabel label7 = new JLabel("Czy jest na ERASMUSIE:");
        JLabel label8 = new JLabel("Wpisz stopień:");
        JLabel label9 = new JLabel("Czy studiuje stacjonarnie:");
        JLabel label10 = new JLabel("Wybierz kurs:");
        jRadioButton1=new JRadioButton("Analiza",true);
        jRadioButton2=new JRadioButton("Fizyka",false);
        jRadioButton3=new JRadioButton("Algebra",false);
        jRadioButton4=new JRadioButton("Technologie inf",false);
        jRadioButton5=new JRadioButton("Grafika",false);
        jRadioButton6=new JRadioButton("Programowanie",false);
        JButton submitButton1 = new JButton("Dodaj więcej osób");
        JButton submitButton2 = new JButton("Zakończ dodawanie");


        frame.getContentPane().add(BorderLayout.CENTER, panel2);
        panel2.setLayout(new GridLayout(5,2));
        panel4.setLayout(new FlowLayout());



        panel1.add(label);
        panel2.add(label1);
        panel2.add(inputField1);
        panel2.add(label2);
        panel2.add(inputField2);
        panel2.add(label3);
        panel2.add(inputField3);
        panel2.add(label4);
        panel2.add(inputField4);
        panel2.add(label5);
        panel2.add(inputField5);
        panel2.add(label6);
        panel2.add(inputField6);
        panel2.add(label7);
        panel2.add(inputField7);
        panel2.add(label8);
        panel2.add(inputField8);
        panel2.add(label9);
        panel2.add(inputField9);
        panel4.add(label10);
        ButtonGroup buttonGroup=new ButtonGroup();
        buttonGroup.add(jRadioButton1);
        buttonGroup.add(jRadioButton2);
        buttonGroup.add(jRadioButton3);
        buttonGroup.add(jRadioButton4);
        buttonGroup.add(jRadioButton5);
        buttonGroup.add(jRadioButton6);
        panel4.add(jRadioButton1);
        panel4.add(jRadioButton2);
        panel4.add(jRadioButton3);
        panel4.add(jRadioButton4);
        panel4.add(jRadioButton5);
        panel4.add(jRadioButton6);
        panel4.add(submitButton1);
        panel4.add(submitButton2);

        submitButton2.addActionListener(new submitButton2(frame));
        submitButton1.addActionListener(new submitButton1(frame));



       // frame.pack();
        frame.setSize(1000,450);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);

    }
    static class Button1_dodawanie_studenta implements ActionListener {
        private Dodawanie d;
        JFrame frame;


        public Button1_dodawanie_studenta(JFrame frame){
            this.frame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            GUI_Dodawanie_Studenta.Dodawanie_osoby_student();

        }
    }
    static class Button2_dodawanie_pracownika_adm implements ActionListener{
        JFrame frame;

        public Button2_dodawanie_pracownika_adm(JFrame frame){
            this.frame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Osoba.generateBazaDanych();
            frame.dispose();
            GUI_Dodawanie_Pracownika_Administracyjnego.Dodawanie_osoby_pracownik_administracyjny();

        }
    }
    static class Button3_dodawanie_pracownika_bad implements ActionListener{
        JFrame frame;

        public Button3_dodawanie_pracownika_bad(JFrame frame){
            this.frame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Osoba.generateBazaDanych();
            frame.dispose();
            GUI_Dodawanie_Pracownika_Badawczego.Dodawanie_osoby_pracownik_badawczy();

        }
    }
    static class submitButton1 implements ActionListener{
        JFrame frame;
        private Kursy k;

        public submitButton1(JFrame frame){
            this.frame = frame;
        }

        public void actionPerformed(ActionEvent e){
            frame.dispose();
            String imie=inputField1.getText();
            String nazwisko=inputField2.getText();
            String PESEL=inputField3.getText();
            int wiek=Integer.parseInt(inputField4.getText());
            String plec=inputField5.getText();
            String indeks=inputField6.getText();
            boolean ERASMUS= Boolean.parseBoolean(inputField7.getText());
            int stopien= Integer.parseInt(inputField8.getText());
            boolean stacjonarne= Boolean.parseBoolean(inputField9.getText());
            if(jRadioButton1.isSelected()){
                k=Osoba.getBazaKursow().get(0);
            }
            else if(jRadioButton2.isSelected()){
                k=Osoba.getBazaKursow().get(1);
            }
            else if(jRadioButton3.isSelected()){
                k=Osoba.getBazaKursow().get(2);
            }
            else if(jRadioButton4.isSelected()){
                k=Osoba.getBazaKursow().get(3);
            }
            else if(jRadioButton5.isSelected()){
                k=Osoba.getBazaKursow().get(4);
            }
            else if(jRadioButton6.isSelected()){
                k=Osoba.getBazaKursow().get(5);
            }
            do_GUI.dodawanieStudenta_GUI(do_GUI.getListaOsob(),imie,nazwisko,PESEL,wiek,plec,indeks,ERASMUS,stopien,stacjonarne,k,ocena);
            frame.dispose();
            GUI_Dodawanie_Studenta.Dodawanie_osoby();

        }
    }
    static class submitButton2 implements ActionListener{
        private Kursy k;
        JFrame frame;

        public submitButton2(JFrame frame){
            this.frame = frame;
        }

        public void actionPerformed(ActionEvent e){
            frame.dispose();
            String imie=inputField1.getText();
            String nazwisko=inputField2.getText();
            String PESEL=inputField3.getText();
            int wiek=Integer.parseInt(inputField4.getText());
            String plec=inputField5.getText();
            String indeks=inputField6.getText();
            boolean ERASMUS= Boolean.parseBoolean(inputField7.getText());
            int stopien= Integer.parseInt(inputField8.getText());
            boolean stacjonarne= Boolean.parseBoolean(inputField9.getText());
            if(jRadioButton1.isSelected()){
                k=Osoba.getBazaKursow().get(0);
            }
            else if(jRadioButton2.isSelected()){
                k=Osoba.getBazaKursow().get(1);
            }
            else if(jRadioButton3.isSelected()){
                k=Osoba.getBazaKursow().get(2);
            }
            else if(jRadioButton4.isSelected()){
                k=Osoba.getBazaKursow().get(3);
            }
            else if(jRadioButton5.isSelected()){
                k=Osoba.getBazaKursow().get(4);
            }
            else if(jRadioButton6.isSelected()){
                k=Osoba.getBazaKursow().get(5);
            }
            Serializacja serializacja=new Serializacja();
            serializacja.zapisDoPliku_Osoba(do_GUI.dodawanieStudenta_GUI(do_GUI.getListaOsob(),imie,nazwisko,PESEL,wiek,plec,indeks,ERASMUS,stopien,stacjonarne,k,ocena));
            frame.dispose();
            GUI.GUI2();


        }

    }

}
