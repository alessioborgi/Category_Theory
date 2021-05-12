//MODIFIED

package magicalfunctiongenerator.utils;

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.image.*;
import java.io.*;
import java.util.Locale;

import javax.imageio.ImageTranscoder;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.ImageWriteParam;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.spi.ImageTranscoderSpi;
import javax.swing.*;

public class Portapapers implements ClipboardOwner
{
    private static Portapapers instancia;

    private Portapapers()
    {}

    public static Portapapers instancia()
    {
        if (instancia == null)
        {
            instancia = new Portapapers();
        }
        return instancia;
    }

    public void copiarText(String text)
    {
        copiar(new StringSelection(text));
    }

    public void copiarImatge(Image i)
    {
        ImageTranscoderSpi im = new ImageTranscoderSpi() {
            @Override
            public String getReaderServiceProviderName() {
                return null;
            }

            @Override
            public String getWriterServiceProviderName() {
                return null;
            }

            @Override
            public ImageTranscoder createTranscoderInstance() {
                return null;
            }

            @Override
            public String getDescription(Locale locale) {
                return null;
            }
        };
        copiar((Transferable) im);
    }

    public void copiarComponent(JComponent c)
    {
        BufferedImage bif = new BufferedImage(c.getWidth(), c.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = bif.createGraphics();
        c.printAll(g2);

        ImageTranscoder im = new ImageTranscoder() {
            @Override
            public IIOMetadata convertStreamMetadata(IIOMetadata inData, ImageWriteParam param) {
                return null;
            }

            @Override
            public IIOMetadata convertImageMetadata(IIOMetadata inData, ImageTypeSpecifier imageType, ImageWriteParam param) {
                return null;
            }
        };
        copiar((Transferable) im);
    }

    private void copiar(Transferable t)
    {
        Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
        c.setContents(t, this);
    }

    public void lostOwnership(Clipboard cb, Transferable trans)
    {
        //System.out.println("S'ha perdut el propietari del portapapers");
    }
}

