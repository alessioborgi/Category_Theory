package Login;

import javax.swing.*;
import java.awt.*;

/**
 * @author alessioborgi
 * @created 03 / 05 / 2021 - 17:09
 * @project LOGIN
 */
public class New_Login {

    public static void main(String[] args) {
        //SwingUtilities.invokeLater(() -> new Login_Start());
        ///*
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    //Login_Start frame_1 = new Login_Start();
                    Menu frame_1 = new Menu();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    //*/
    }
}