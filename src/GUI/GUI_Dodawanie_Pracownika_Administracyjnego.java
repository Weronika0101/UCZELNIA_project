package GUI;

import Funkcjonalności.Serializacja;

import PANEL_DO_GUI.do_GUI;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.LinkedList;


public class GUI_Dodawanie_Pracownika_Administracyjnego{
    static JTextField inputField1;
    static JTextField inputField2;
    static JTextField inputField3;
    static JTextField inputField4;
    static JTextField inputField5;
    static JTextField inputField6;
    static JTextField inputField7;
    static JTextField inputField8;
    static JTextField inputField9;
    public static void Dodawanie_osoby_pracownik_administracyjny(){
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
        JLabel label=new JLabel("DODAWANIE PRACOWNIKA ADMINISTRACYJNEGO");
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
        JLabel label6 = new JLabel("Wpisz stanowisko:");
        JLabel label7 = new JLabel("Wpisz staż pracy:");
        JLabel label8 = new JLabel("Wpisz pensję:");
        JLabel label9 = new JLabel("Ile nadgodzin:");
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
        panel4.add(submitButton1);
        panel4.add(submitButton2);

      submitButton2.addActionListener(new submitButton2(frame));
       submitButton1.addActionListener(new submitButton1(frame));




        frame.setSize(1000,450);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);

    }
    static class submitButton1 implements ActionListener {
        JFrame frame;

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
            String stanowisko=inputField6.getText();
            int staz= Integer.parseInt(inputField7.getText());
            double pensja= Double.parseDouble(inputField8.getText());
            int nadgodziny=Integer.parseInt(inputField9.getText());

            do_GUI.dodawaniePracownikaAdministracyjnego_GUI(do_GUI.getListaOsob(),imie,nazwisko,PESEL,wiek,plec,stanowisko,staz,pensja,nadgodziny);


            frame.dispose();

            GUI_Dodawanie_Studenta.Dodawanie_osoby();

        }
    }
    static class submitButton2 implements ActionListener {
        JFrame frame;

        public submitButton2(JFrame frame){
            this.frame = frame;
        }

        public void actionPerformed(ActionEvent e){
            String imie=inputField1.getText();
            String nazwisko=inputField2.getText();
            String PESEL=inputField3.getText();
            int wiek=Integer.parseInt(inputField4.getText());
            String plec=inputField5.getText();
            String stanowisko=inputField6.getText();
            int staz= Integer.parseInt(inputField7.getText());
            double pensja= Double.parseDouble(inputField8.getText());
            int nadgodziny=Integer.parseInt(inputField9.getText());

            Serializacja serializacja=new Serializacja();
            serializacja.zapisDoPliku_Osoba(do_GUI.dodawaniePracownikaAdministracyjnego_GUI(do_GUI.getListaOsob(),imie,nazwisko,PESEL,wiek,plec,stanowisko,staz,pensja,nadgodziny));

            frame.dispose();
            GUI.GUI2();

        }
    }
}
