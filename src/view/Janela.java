package view;

import drawable.Line;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.jws.Oneway;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import uteis.Coordenada;
import uteis.ViewPort;

public class Janela extends JFrame implements ActionListener {
    private Painel painel;
    private JButton btnAdd;
    private JButton btnRemove;
    private JList lvDrawable;
    private BoxLayout layout;
    
    private final String add = "Add";
    private final String remove = "Remove";
    
    
    public Janela() {
        this.setLayout(null);
        this.setSize(800, 600);
        
        painel = new Painel();
        this.add(painel);
        painel.setBounds(410, 110, 380, 380);
        
        ViewPort viewPort = new ViewPort(-170, 170, -170, 170, 0, 380, 0, 380);
        painel.setViewPort(viewPort);
        
        Line line = new Line(new Coordenada(0, -170), new Coordenada(0, 170));
        painel.addDrawable(line);
        
        Line line2 = new Line(new Coordenada(-170, 0), new Coordenada(170, 0));
        painel.addDrawable(line2);
        painel.repaint();
        
        
        
        btnAdd = new JButton(add);
        btnAdd.setActionCommand(add);
        btnAdd.addActionListener(this);
        
        btnRemove = new JButton(remove);
        btnRemove.setActionCommand(remove);
        btnRemove.addActionListener(this);
        
        lvDrawable = new JList();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (add.equals(e.getActionCommand())){
            //adicionar
        }
        if (remove.equals(e.getActionCommand())) {
            //remover
        }
        
    }
    
}
