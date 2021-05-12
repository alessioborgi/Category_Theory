package magicalfunctiongenerator.presentacio;

// import javax.swing.*;

public class Principal
{
    public static void main(String[] args)
    {
        System.setProperty("RegistreGrafiques", "magicalfunctiongenerator.persistencia.memoria.RegistreGrafiques");
        System.setProperty("RegistreFuncions", "magicalfunctiongenerator.persistencia.memoria.RegistreFuncions");
        System.setProperty("RegistrePunts", "magicalfunctiongenerator.persistencia.memoria.RegistrePunts");

        Splash s = new Splash();
        FinestraPrincipal.instancia();
        s.dispose();
    }
}
