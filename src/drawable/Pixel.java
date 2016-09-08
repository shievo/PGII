/*Criador: Kelvin Bergmann 18/08/2016
 *Classe responsavel por armazenar valores referentes a um pixel
 *e realizar a pintura do mesmo
*/
package drawable;

import interfaces.drawable.DrawableInterface;
import java.awt.Graphics;
import uteis.Convert;
import uteis.Coordenada;
import uteis.ViewPort;

public class Pixel extends DrawableObject implements DrawableInterface {
    private Coordenada coordenada;
    
    public Pixel(String nome) {
        this.nome = nome;
        coordenada = new Coordenada();
    }
    
    public Pixel(Coordenada coordenada, String nome) {
        this.nome = nome;
        this.coordenada = coordenada;
    }

    @Override
    public void draw(Graphics graphics, ViewPort viewPort) {
        
        Coordenada convertCoordenada = Convert.toViewPort(this.coordenada, viewPort);
        
        int x = convertCoordenada.getX();
        int y = convertCoordenada.getY();
        graphics.drawLine(x, y, x, y);
    }
    
    @Override
    public void translation(Coordenada incPoint) {
        this.coordenada = this.coordenada.add(incPoint);
    }
    
    @Override
    public void escalonar(Coordenada fator) {
        //nao faz nada , nao ha como aumentar um pixel
    }

}
