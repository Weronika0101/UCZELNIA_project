package GUI;

import Osoba.Osoba;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class GUI_welcome {
    public static void GUI1() {
        UIManager manager=new UIManager();
        LinkedList<Object> a=new LinkedList<>();
        a.add(0.3);
        a.add(0.3);
        a.add(new ColorUIResource(208, 135, 196));
        a.add(new ColorUIResource(233, 218, 234));
        a.add(new ColorUIResource(208, 139, 210));
        manager.put("Button.gradient",a);

        JFrame frame = new JFrame("Witaj na uczelni!");
        JPanel panel1= new JPanel();
        JPanel panel2=new JPanel();
        JLabel label=new JLabel("Witaj na uczelni!Czy chcesz stworzyć własną bazę osób?");

        frame.getContentPane().add(BorderLayout.NORTH,panel1);
        frame.getContentPane().add(BorderLayout.CENTER,panel2);
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\weron\\IdeaProjects\\graduation-cap.png");
        frame.setIconImage(icon);

        JButton button1=new JButton("NIE");
        JButton button2=new JButton("TAK");

        panel1.add(label);
        panel2.add(button2);
        panel2.add(button1);
        button1.addActionListener(new Button1(frame));
        button2.addActionListener(new Button2(frame));
        frame.setSize(400,200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    static class Button1 implements ActionListener {
        JFrame frame;

        public Button1(JFrame frame){
            this.frame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Osoba.generateBazaDanych();
            frame.dispose();
            GUI.GUI2();

        }
    }
    static class Button2 implements ActionListener{
        JFrame frame;

        public Button2(JFrame frame){
            this.frame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            GUI_Dodawanie_Studenta.Dodawanie_osoby();

        }
    }
}

