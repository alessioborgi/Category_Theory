package magicalfunctiongenerator.presentacio.proietatsgrafica;

import magicalfunctiongenerator.presentacio.*;
import magicalfunctiongenerator.utils.*;

import javax.swing.*;

public class FinestraPropietatsGrafica extends JDialog
{
    private static FinestraPropietatsGrafica instancia;
    private JTabbedPane tab = new JTabbedPane();
    private TabFuncio tabfuncio = new TabFuncio();
    private TabEixos tabeixos = new TabEixos();
    private TabGraella tabgraella = new TabGraella();

    public static FinestraPropietatsGrafica instancia()
    {
        if (instancia == null)
        {
            instancia = new FinestraPropietatsGrafica();
        }
        return instancia;
    }

    private FinestraPropietatsGrafica()
    {
        super(FinestraPrincipal.instancia(), "Graphic property ::::: NOT IMPLEMENTED YET!!");
        initialize();
    }

    public void initialize()
    {
        tab.addTab("Opcions de la funciÃ³", tabfuncio);
        tab.addTab("Opcions dels eixos", tabeixos);
        tab.addTab("Opcions de la graella", tabgraella);
        this.setContentPane(tab);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        PopurriUtils.instancia().centrarPantalla(this);
        this.setVisible(true);
    }
}