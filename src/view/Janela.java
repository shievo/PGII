package view;

import drawable.Line;
import interfaces.drawable.DrawableInterface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
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

        //criação do componentes
        ViewPort viewPort = new ViewPort(-170, 170, -170, 170, 0, 380, 0, 380);
        painel = new Painel(viewPort);
        painel.setBounds(410, 110, 380, 380);
        this.add(painel);

        //criação do botao de adição
        btnAdd = new JButton(add);
        btnAdd.setActionCommand(add);
        btnAdd.addActionListener(this);
        btnAdd.setBounds(5, 500, 100, 20);
        this.add(btnAdd);

        //criação do botao de remoção
        btnRemove = new JButton(remove);
        btnRemove.setActionCommand(remove);
        btnRemove.addActionListener(this);
        btnRemove.setBounds(110, 500, 100, 20);
        this.add(btnRemove);

        //criação da lista para gerenciamento dos itens criados
        lvDrawable = new JList();
        lvDrawable.setBounds(5, 10, 300, 450);
        this.add(lvDrawable);

        //teste
        painel.addDrawable(new Line(new Coordenada(0, -170), new Coordenada(0, 170)));
        painel.addDrawable(new Line(new Coordenada(-170, 0), new Coordenada(170, 0)));
        painel.repaint();

        lvDrawable.setListData(painel.getLstDrawables().toArray());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (add.equals(e.getActionCommand())) {
            //adicionar
        }
        if (remove.equals(e.getActionCommand())) {
            //remover
            if ((!painel.getLstDrawables().isEmpty())&&(lvDrawable.getSelectedIndex()>=0)) {
                painel.removeDrawable(lvDrawable.getSelectedIndex());
                lvDrawable.setListData(painel.getLstDrawables().toArray());
                painel.repaint();
            }
        }

    }

}
