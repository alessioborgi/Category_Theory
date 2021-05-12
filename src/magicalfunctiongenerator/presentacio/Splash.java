package magicalfunctiongenerator.presentacio;

import magicalfunctiongenerator.utils.*;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.*;

import javax.swing.*;


public class Splash extends JWindow
{
    public Splash()
    {
        initialize();
    }

    private void initialize()
    {
        JLabel lab = new JLabel(PopurriUtils.instancia().getImageIcon("splash.gif"));
        this.getContentPane().add(lab, BorderLayout.CENTER);
        this.pack();
        PopurriUtils.instancia().centrarPantalla(this);
        this.setVisible(true);
    }

}
