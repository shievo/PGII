package view;

import drawable.Line;
import drawable.Pixel;
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
    private JButton btnZoomIn;
    private JButton btnZoomOut;
    private JButton btnRemove;
    private JList lvDrawable;
    private BoxLayout layout;

    private final String zoomIn = "ZoomIn";
    private final String zoomOut = "ZoomOut";
    private final String remove = "Remove";

    FrmPainel frm;

    public Janela() {
        this.setLayout(null);
        this.setSize(800, 600);

        //criação do componentes
        ViewPort viewPort = new ViewPort(-170, 170, -170, 170, 0, 380, 0, 380);
        painel = new Painel(viewPort);
        painel.setBounds(380, 90, 380, 380);
        this.add(painel);

        //criação do botao de adição
        btnZoomIn = new JButton("+");
        btnZoomIn.setActionCommand(zoomIn);
        btnZoomIn.addActionListener(this);
        btnZoomIn.setBounds(330, 110, 50, 50);
        this.add(btnZoomIn);
        
        
        //criação do botao de adição
        btnZoomOut = new JButton("-");
        btnZoomOut.setActionCommand(zoomOut);
        btnZoomOut.addActionListener(this);
        btnZoomOut.setBounds(330, 160, 50, 50);
        this.add(btnZoomOut);

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

        frm = new FrmPainel();
        frm.setActionAddPixel(new AddPixel());
        frm.setActionAddLine(new AddLine());
        frm.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (zoomIn.equals(e.getActionCommand())) {
            ViewPort viewPort = painel.getViewPort();
            float zoom = viewPort.getZoom();
            zoom *= 2;
            viewPort.setZoom(zoom);
            painel.setViewPort(viewPort);
            painel.repaint();
        }
        if (zoomOut.equals(e.getActionCommand())) {
            ViewPort viewPort = painel.getViewPort();
            float zoom = viewPort.getZoom();
            zoom /= 2;
            viewPort.setZoom(zoom);
            painel.setViewPort(viewPort);
            painel.repaint();
        }
        if (remove.equals(e.getActionCommand())) {
            //remover
            if ((!painel.getLstDrawables().isEmpty()) && (lvDrawable.getSelectedIndex() >= 0)) {
                painel.removeDrawable(lvDrawable.getSelectedIndex());
                lvDrawable.setListData(painel.getLstDrawables().toArray());
                painel.repaint();
            }
        }
    }

    public class AddPixel implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (frm != null) {
                Pixel pixel = frm.getPixel();
                painel.addDrawable(pixel);
                painel.repaint();
                lvDrawable.setListData(painel.getLstDrawables().toArray());
            }
        }
    }

    public class AddLine implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (frm != null) {
                Line line = frm.getLine();
                painel.addDrawable(line);
                painel.repaint();
                lvDrawable.setListData(painel.getLstDrawables().toArray());
            }
        }
    }
}
