/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class Painel extends JPanel{

    private List<DrawableInterface> lstDrawables;
    private ViewPort viewPort;
    
    public Painel() {
        super();
        lstDrawables = new ArrayList<>();
        this.setBackground(Color.red);
        viewPort = new ViewPort();
    }
    
    public Painel(ViewPort viewPort) {
        super();
        lstDrawables = new ArrayList<>();
        this.viewPort = viewPort;
        this.setBackground(Color.red);
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
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        for (DrawableInterface drawable : lstDrawables) {
            drawable.draw(g, this.viewPort);
        }
    }    
    
}
