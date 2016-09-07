package view;

import interfaces.drawable.DrawableInterface;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import uteis.ViewPort;

/**
 *
 * @author Kelvin
 */
public class Painel extends JPanel {

    private List<DrawableInterface> lstDrawables;
    private ViewPort viewPort;

    public Painel() {
        super();
        lstDrawables = new ArrayList<>();
        this.setBackground(Color.white);
        viewPort = new ViewPort();
    }

    public Painel(ViewPort viewPort) {
        super();
        lstDrawables = new ArrayList<>();
        this.viewPort = viewPort;
        this.setBackground(Color.white);
    }

    public List<DrawableInterface> getLstDrawables() {
        return lstDrawables;
    }

    public void setLstDrawables(List<DrawableInterface> lstDrawables) {
        this.lstDrawables = lstDrawables;
    }

    public ViewPort getViewPort() {
        return viewPort;
    }

    public void setViewPort(ViewPort viewPort) {
        this.viewPort = viewPort;
    }

    public void addDrawable(DrawableInterface drawable) {
        lstDrawables.add(drawable);
    }

    public void removeDrawable(int index) {
        lstDrawables.remove(index);
    }
    
    public void updateDrawable(int index, DrawableInterface drawable) {
        lstDrawables.set(index, drawable);
    }

    public DrawableInterface getDrawable(int index) {
        return lstDrawables.get(index);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (DrawableInterface drawable : lstDrawables) {
            drawable.draw(g, this.viewPort);
        }
    }

}
