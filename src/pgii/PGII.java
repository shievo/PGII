
package pgii;

import drawable.Line;
import javax.swing.JFrame;
import uteis.Convert;
import uteis.Coordenada;
import uteis.ViewPort;
import view.FrmPainel;
import view.Janela;
import view.Painel;

public class PGII {    
    public static void main(String[] args) {
        /*
        FrmPainel painel = new FrmPainel();
        painel.pack();
        painel.setVisible(true);
        painel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      */
        /*
        ViewPort viewPort = new ViewPort(-250, 250, -250, 250, 0, 500, 0, 500);
        Coordenada coordenada = new Coordenada(100, -100);
        System.out.println("Coordenada -> " + coordenada.toString());
        System.out.println("Coordenada convertida -> " + Convert.toViewPort(coordenada, viewPort));
        
        Painel painel = new Painel();
        painel.setSize(500, 500);
        painel.setViewPort(viewPort);
        
        Line line = new Line(new Coordenada(0, -250), new Coordenada(0, 250));
        painel.addDrawable(line);
        
        Line line2 = new Line(new Coordenada(-250, 0), new Coordenada(250, 0));
        painel.addDrawable(line2);
        
        
        JFrame janela =  new JFrame();
        janela.add(painel);
        janela.setLayout(null);
        janela.setSize(600,600);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        */
        
        Janela janela =  new Janela();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
       
    }
    
}
