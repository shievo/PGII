package drawable;

import interfaces.drawable.DrawableInterface;
import java.awt.Graphics;
import uteis.Convert;
import uteis.Coordenada;
import uteis.ViewPort;

public class Line extends DrawableObject implements DrawableInterface {
    private Coordenada start, end;
    
    public Line(){
        
    }
    
    public Line(String nome) {
        this.nome = nome;
        start = new Coordenada();
        end = new Coordenada();
    }
    
    public Line(Coordenada start, Coordenada end, String nome) {
        this.nome = nome;
        this.start = start;
        this.end = end;
    }
    
    @Override
    public void draw(Graphics graphics, ViewPort viewPort) {
        Coordenada convert1 = Convert.toViewPort(start, viewPort);
        Coordenada convert2 = Convert.toViewPort(end, viewPort);
        graphics.drawLine(convert1.getX(), convert1.getY(), convert2.getX(), convert2.getY());
    }
}