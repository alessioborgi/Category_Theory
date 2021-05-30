package Login;

/**
 * @author alessioborgi
 * @created 03 / 05 / 2021 - 17:09
 * @project LOGIN
 */

import java.awt.*;

public class New_Login {
    /*
        Class the contains the Main for starting the application. It will runs the
        Login_Start JFrame window, the one with the Login implementation.
     */

    public static void main(String[] args) {
        //SwingUtilities.invokeLater(() -> new Login_Start());
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    Login_Start frame_1 = new Login_Start();
                    //Login.Menu frame_1 = new Menu();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
