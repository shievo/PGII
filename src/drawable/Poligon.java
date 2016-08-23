package drawable;

import interfaces.drawable.DrawableInterface;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import uteis.Convert;
import uteis.Coordenada;
import uteis.ViewPort;

public class Poligon extends DrawableObject implements DrawableInterface {
    
    private List<Coordenada> path;
    
    public Poligon (){
        path = new ArrayList<>();
    }
    
    public Poligon (List<Coordenada> path){
        this.path = path;
    }

    public List<Coordenada> getPath() {
        return path;
    }

    public void setPath(List<Coordenada> path) {
        this.path = path;
    }
    
    @Override
    public void draw(Graphics graphics, ViewPort viewPort) {
        if (path.isEmpty())
            return;
        int xPoints[] = new int[path.size()];
        int yPoints[] = new int[path.size()];
        
        for (Coordenada coordenada : path) {
            int position = path.indexOf(coordenada);
            Coordenada convertCoordenada = Convert.toViewPort(coordenada, viewPort);
            xPoints[position] = convertCoordenada.getX();
            yPoints[position] = convertCoordenada.getY();
        }
        graphics.drawPolygon(xPoints, yPoints, path.size());
    }
    
}