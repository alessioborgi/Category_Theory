package magicalfunctiongenerator.domini.eixos;

import magicalfunctiongenerator.domini.*;
import java.awt.*;

public class EixCoordenades
{
    private EixX eixX;
    private EixY eixY;


    public EixCoordenades(Grafica g)
    {
        eixX = new EixX(g);
        eixY = new EixY(g);
    }

    public void dibuixar(Graphics2D g2)
    {
        eixX.dibuixar(g2);
        eixY.dibuixar(g2);
    }
}

