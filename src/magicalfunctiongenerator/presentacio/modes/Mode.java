package magicalfunctiongenerator.presentacio.modes;

import magicalfunctiongenerator.aplicatio.*;
import java.awt.*;
import javax.swing.*;

public abstract class Mode
{
    public static final Font FONT = new Font("Arial", Font.BOLD, 16);
    protected JComponent canvas;
    protected ControladorGrafica controlador;

    public Mode(ControladorGrafica con, JComponent c)
    {
        this.controlador = con;
        canvas = c;
    }

    public abstract void dispatchEvent(AWTEvent event);
    public abstract Cursor getDefaultCursor();
    public abstract void dibuixar(Graphics2D g2);
}

