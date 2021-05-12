package magicalfunctiongenerator.presentacio.configuracions;

import java.awt.*;

import javax.swing.*;

public class TabModes extends JTabbedPane
{
    TabModeSurf mode_surf = new TabModeSurf();
    TabModeZoomPlus mode_zoom_plus = new TabModeZoomPlus();
    TabModeZoomMinus mode_zoom_minus = new TabModeZoomMinus();
    TabModelmant mode_imant = new TabModelmant();

    public TabModes()
    {

        initialize();
    }

    private void initialize()
    {
        this.addTab("Surf mode", mode_surf);
        this.addTab("Zoom in mode", mode_zoom_plus);
        this.addTab("Zoom out mode", mode_zoom_minus);
        this.addTab("Magnet mode", mode_imant);

        this.setPreferredSize(new Dimension(400, 300));
    }
}
