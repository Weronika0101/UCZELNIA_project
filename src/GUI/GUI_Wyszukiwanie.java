package GUI;

import Funkcjonalności.Serializacja;
import PANEL_DO_GUI.do_GUI;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class GUI_Wyszukiwanie {
    static JTextField input;


    public static void Wyszukiwanie(){
        UIManager manager=new UIManager();
        LinkedList<Object> a=new LinkedList<>();
        a.add(0.3);
        a.add(0.3);
        a.add(new ColorUIResource(208, 135, 196));
        a.add(new ColorUIResource(233, 218, 234));
        a.add(new ColorUIResource(208, 139, 210));
        manager.put("Button.gradient",a);
        JFrame frame = new JFrame("UCZELNIA");
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\weron\\IdeaProjects\\graduation-cap.png");
        frame.setIconImage(icon);
        JPanel panel1= new JPanel();
        JPanel panel2=new JPanel();
        JLabel label=new JLabel("Wybierz opcję wyszukiwania: ");

        frame.getContentPane().add(BorderLayout.NORTH,panel1);
        frame.getContentPane().add(BorderLayout.CENTER,panel2);
        JButton Button_student_po_imieniu=new JButton("STUDENT PO IMIENIU");
        JButton Button_kurs_po_ects=new JButton("KURS PO PKT ECTS");
        panel1.add(label);
        panel2.add(Button_student_po_imieniu);
        panel2.add(Button_kurs_po_ects);
        Button_student_po_imieniu.addActionListener(new Button_student_po_imieniu(frame));
        Button_kurs_po_ects.addActionListener(new Button_kurs_po_ects(frame));
        frame.setLocationRelativeTo(null);
        frame.setSize(400,200);
        frame.setVisible(true);
    }
    public static void Wyszukiwanie_student(){
        UIManager manager=new UIManager();
        LinkedList<Object> a=new LinkedList<>();
        a.add(0.3);
        a.add(0.3);
        a.add(new ColorUIResource(208, 135, 196));
        a.add(new ColorUIResource(233, 218, 234));
        a.add(new ColorUIResource(208, 139, 210));
        manager.put("Button.gradient",a);
        JFrame frame = new JFrame("UCZELNIA");
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\weron\\IdeaProjects\\graduation-cap.png");
        frame.setIconImage(icon);
        JPanel panel2=new JPanel();
        JPanel panel3=new JPanel();
        JLabel label=new JLabel("Wpisz imie: ");
        input=new JTextField(16);
        JButton Button_wyszukaj_s =new JButton("WYSZUKAJ");
        JButton Button_usun_s=new JButton("USUŃ Z BAZY");

        frame.getContentPane().add(BorderLayout.CENTER,panel2);
        frame.getContentPane().add(BorderLayout.SOUTH,panel3);
        panel2.add(label);
        panel2.add(input);
        panel3.add(Button_wyszukaj_s);
        panel3.add(Button_usun_s);
        Button_wyszukaj_s.addActionListener(new Button_wyszukaj_s(frame));
        Button_usun_s.addActionListener(new Button_usun_s(frame));
        frame.setLocationRelativeTo(null);
        frame.setSize(400,200);
        frame.setVisible(true);

    }
    public static void Wyszukiwanie_kurs(){
        UIManager manager=new UIManager();
        LinkedList<Object> a=new LinkedList<>();
        a.add(0.3);
        a.add(0.3);
        a.add(new ColorUIResource(208, 135, 196));
        a.add(new ColorUIResource(233, 218, 234));
        a.add(new ColorUIResource(208, 139, 210));
        manager.put("Button.gradient",a);
        JFrame frame = new JFrame("UCZELNIA");
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\weron\\IdeaProjects\\graduation-cap.png");
        frame.setIconImage(icon);
        JPanel panel2=new JPanel();
        JPanel panel3=new JPanel();
        JLabel label=new JLabel("Wpisz ilosc ECTS: ");
        input=new JTextField(16);
        JButton Button_wyszukaj_k =new JButton("WYSZUKAJ");
        JButton Button_usun_k=new JButton("USUŃ Z BAZY");

        frame.getContentPane().add(BorderLayout.CENTER,panel2);
        frame.getContentPane().add(BorderLayout.SOUTH,panel3);
        panel2.add(label);
        panel2.add(input);
        panel3.add(Button_wyszukaj_k);
        panel3.add(Button_usun_k);
        Button_wyszukaj_k.addActionListener(new Button_wyszukaj_k(frame));
        Button_usun_k.addActionListener(new Button_usun_k(frame));
        frame.setSize(400,200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    static class Button_student_po_imieniu implements ActionListener {
        JFrame frame;

        public Button_student_po_imieniu(JFrame frame){
            this.frame = frame;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            Wyszukiwanie_student();
        }
    }
    static class Button_kurs_po_ects implements ActionListener {
        JFrame frame;

        public Button_kurs_po_ects(JFrame frame){
            this.frame = frame;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            Wyszukiwanie_kurs();
        }
    }
    static class Button_wyszukaj_s implements ActionListener{
        JFrame frame1;

        public Button_wyszukaj_s(JFrame frame){
            this.frame1 = frame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            GUI.GUI2();
            String imie=input.getText();
            frame1.dispose();
            JFrame frame=new JFrame();
            JTextArea jTextArea=new JTextArea(do_GUI.Wyszukiwanie_studenta_po_imieniu(Serializacja.Odczyt_osoby(),imie));
            frame.add(jTextArea);
            frame.setVisible(true);
            frame.setSize(400,300);

        }
    }
    static class Button_usun_s implements ActionListener{
        JFrame frame;

        public Button_usun_s(JFrame frame){
            this.frame = frame;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            UIManager manager=new UIManager();
            LinkedList<Object> a=new LinkedList<>();
            a.add(0.3);
            a.add(0.3);
            a.add(new ColorUIResource(208, 135, 196));
            a.add(new ColorUIResource(233, 218, 234));
            a.add(new ColorUIResource(208, 139, 210));
            manager.put("Button.gradient",a);
            frame.dispose();
            String imie=input.getText();
            do_GUI.Usuwanie_studenta(Serializacja.Odczyt_osoby(),imie);
            JFrame frame=new JFrame();
            JPanel jPanel1=new JPanel();
            JPanel jPanel2=new JPanel();
            JLabel jLabel=new JLabel("Właśnie usunąłeś studenta z bazy");
            JButton Button_ok=new JButton("OK");
            frame.add(jPanel1);
            frame.add(jPanel2);
            jPanel1.add(jLabel);
            jPanel2.add(Button_ok);
            frame.getContentPane().add(BorderLayout.CENTER,jPanel1);
            frame.getContentPane().add(BorderLayout.SOUTH,jPanel2);
            Button_ok.addActionListener(new Button_ok(frame));
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            frame.setSize(400,200);
        }
    }
    static class Button_wyszukaj_k implements ActionListener{
        JFrame frame;

        public Button_wyszukaj_k(JFrame frame){
            this.frame = frame;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            GUI.GUI2();
            int punkty=Integer.parseInt(input.getText());
            JFrame frame=new JFrame();
            JTextArea jTextArea=new JTextArea(do_GUI.Wyszukiwanie_kursu_po_ects(Serializacja.Odczyt_Kursy(),punkty));
            frame.add(jTextArea);
            frame.setVisible(true);
            frame.setSize(400,200);

        }
    }
    static class Button_usun_k implements ActionListener{
        JFrame frame;

        public Button_usun_k(JFrame frame){
            this.frame = frame;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            UIManager manager=new UIManager();
            LinkedList<Object> a=new LinkedList<>();
            a.add(0.3);
            a.add(0.3);
            a.add(new ColorUIResource(208, 135, 196));
            a.add(new ColorUIResource(233, 218, 234));
            a.add(new ColorUIResource(208, 139, 210));
            manager.put("Button.gradient",a);
            frame.dispose();
            int punkty=Integer.parseInt(input.getText());
            do_GUI.Usuwanie_kursu(Serializacja.Odczyt_Kursy(),punkty);
            JFrame frame=new JFrame();
            Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\weron\\IdeaProjects\\graduation-cap.png");
            frame.setIconImage(icon);
            JPanel jPanel1=new JPanel();
            JPanel jPanel2=new JPanel();
            JLabel jLabel=new JLabel("Właśnie usunąłeś kurs z bazy");
            JButton Button_ok=new JButton("OK");
            frame.add(jPanel1);
            frame.add(jPanel2);
            jPanel1.add(jLabel);
            jPanel2.add(Button_ok);
            frame.getContentPane().add(BorderLayout.CENTER,jPanel1);
            frame.getContentPane().add(BorderLayout.SOUTH,jPanel2);
            Button_ok.addActionListener(new Button_ok(frame));
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            frame.setSize(400,200);
        }
    }
    static class Button_ok implements ActionListener{
        JFrame frame;

        public Button_ok(JFrame frame){
            this.frame = frame;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            GUI.GUI2();
        }
    }

}
