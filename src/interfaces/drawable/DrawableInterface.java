
package interfaces.drawable;

import java.awt.Graphics;
import uteis.Coordenada;
import uteis.ViewPort;


public interface DrawableInterface {
    
    public void draw(Graphics graphics, ViewPort viewPort);
    
    public void translation(Coordenada incPoint);
    
    public void escalonar(Coordenada fator, int emRelacao);
    
    public void refletir(Coordenada reflexao);
    
    public void rotacionar(double angulo, int emRelacao);
    
    public Coordenada getCenter();
    
}
