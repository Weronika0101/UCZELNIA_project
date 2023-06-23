package GUI;

import Funkcjonalności.Serializacja;
import PANEL_DO_GUI.do_GUI;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class GUI_Sortowanie {
    public static void Sortowanie(){
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
        JLabel label=new JLabel("Wybierz opcję sortowania: ");
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\weron\\IdeaProjects\\graduation-cap.png");
        frame.setIconImage(icon);

        frame.getContentPane().add(BorderLayout.NORTH,panel1);
        frame.getContentPane().add(BorderLayout.CENTER,panel2);
        JButton Button_nazwiskami=new JButton("OSOBY NAZWISKAMI");
        JButton Button_punktami=new JButton("KURSY PUNKTAMI");
        panel1.add(label);
        panel2.add(Button_nazwiskami);
        panel2.add(Button_punktami);
        Button_nazwiskami.addActionListener(new Button_nazwiskami(frame));
        Button_punktami.addActionListener(new Button_punktami(frame));
        frame.setSize(400,200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    static class Button_nazwiskami implements ActionListener {
        JFrame frame;

        public Button_nazwiskami(JFrame frame){
            this.frame = frame;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
          //  do_GUI do_gui=new do_GUI();
            do_GUI do_gui=new do_GUI();
            do_gui.generateComparators();
            JFrame frame=new JFrame();
            JTextArea jTextArea=new JTextArea(do_gui.Sortowanie_nazwiskami(Serializacja.Odczyt_osoby()));
            frame.add(jTextArea);
            JScrollPane jScrollPane=new JScrollPane(jTextArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

            frame.add(jScrollPane,BorderLayout.CENTER);
            frame.setVisible(true);
            frame.pack();
        }
    }
    static class Button_punktami implements ActionListener {
        JFrame frame;

        public Button_punktami(JFrame frame){
            this.frame = frame;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            do_GUI do_gui=new do_GUI();
            do_gui.generateComparators();
            JFrame frame=new JFrame();
            JTextArea jTextArea=new JTextArea(do_gui.Sortowanie_ects(Serializacja.Odczyt_Kursy()));
            frame.add(jTextArea);
            frame.setVisible(true);
            frame.pack();
        }
    }

}
