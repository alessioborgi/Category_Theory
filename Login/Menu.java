package Login;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;


/**
 * @author alessioborgi
 * @created 03 / 05 / 2021 - 16:01
 * @project LOGIN
 */

public class Menu extends JFrame implements ActionListener{

    protected static JFrame frame = new JFrame();
    private JPanel panel = new JPanel(){protected void paintComponent(Graphics g) {
        if (g instanceof Graphics2D) {
            Paint p = new GradientPaint(0.0f, 0.0f, new Color(249, 166, 2, 150),
                    getWidth(), getHeight(), new Color(249, 166, 2, 255), true);
            Graphics2D g2d = (Graphics2D)g;
            g2d.setPaint(p);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        } else {
            super.paintComponent(g);
        }
    }};
    private JFXPanel fxPanel = new JFXPanel();

    private JLabel cat_label = new JLabel();
    private JLabel acsai = new JLabel();
    private JLabel sapienza = new JLabel();
    private JLabel sapienza_1 = new JLabel();
    private JLabel java_item = new JLabel();
    private JLabel java_item_1 = new JLabel();
    private JLabel current_date = new JLabel();
    private JLabel current_time = new JLabel();



    public Menu() {
        setter();
        adder();
        addListeners();
        clock();

        Platform.runLater(() -> JavaFX.initFX(fxPanel));
        pack();
    }

    private void setter(){
        frame.setBounds(10, 10,800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Category Theory's Menu");
        panel.setLayout(null);

        java_item.setBounds(0, 0, 160, 75);
        java_item.setIcon(new ImageIcon("img/java_2.png"));
        cat_label.setBounds(160, 0, 480, 75);
        cat_label.setIcon(new ImageIcon("img/Programming_1.jpeg"));
        java_item_1.setBounds(640, 0, 160, 75);
        java_item_1.setIcon(new ImageIcon("img/java_2.png"));

        current_date.setBounds(0, 650, 150, 25);
        current_date.setForeground(Login_Start.black);
        Font f = current_date.getFont();
        current_date.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
        current_time.setBounds(700, 650, 100, 25 );
        current_time.setForeground(Login_Start.black);
        current_time.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
        sapienza.setBounds(0, 675, 160, 100);
        sapienza.setIcon(new ImageIcon("img/Sapienza.png"));
        acsai.setBounds(160, 675, 480, 100);
        acsai.setIcon(new ImageIcon("img/ACSAI_1.jpeg"));
        sapienza_1.setBounds(640, 675, 160, 100);
        sapienza_1.setIcon(new ImageIcon("img/Sapienza.png"));

        fxPanel.setBounds(0, 75, 800, 620);
        frame.setVisible(true);
    }

    private void adder(){
        panel.add(java_item);
        panel.add(cat_label);
        panel.add(java_item_1);

        panel.add(sapienza);
        panel.add(acsai);
        panel.add(sapienza_1);
        panel.add(current_date);
        panel.add(current_time);

        panel.add(fxPanel);
        frame.add(panel);
    }

    public void clock(){
        String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        Thread clock = new Thread(){
            public void run(){
                try {
                    for(;;) {     //Never Ending Loop (We could have also used the "while(true)"
                        Calendar cal = new GregorianCalendar();
                        int day = cal.get(Calendar.DAY_OF_MONTH);
                        int month = cal.get(Calendar.MONTH);
                        int year = cal.get(Calendar.YEAR);
                        int second = cal.get(Calendar.SECOND);
                        int minute = cal.get(Calendar.MINUTE);
                        int hour = cal.get(Calendar.HOUR);
                        current_time.setText("Time " + hour + ":" + minute + ":" + second);
                        current_date.setText(" Date: " + months[month] + "/" + day + "/" + year);
                        sleep(100);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        clock.start();
    }

    private void addListeners(){
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
