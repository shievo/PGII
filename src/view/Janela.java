package view;

import drawable.Line;
import drawable.Pixel;
import drawable.Poligon;
import interfaces.drawable.DrawableInterface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import uteis.Coordenada;
import uteis.ViewPort;

public class Janela extends JFrame {

    public interface ButtonClick {

        public void click();
    }

    private Painel painel;
    private JButton btnZoomIn;
    private JButton btnZoomOut;
    private JButton btnRemove;

    private JButton btnMoveLeft;
    private JButton btnMoveRight;
    private JButton btnMoveUp;
    private JButton btnMoveDown;

    private JList lvDrawable;
    private BoxLayout layout;

    private final String zoomIn = "zoomIn";
    private final String zoomOut = "zoomOut";
    private final String remove = "Remove";

    private final String moveLeft = "MoveLeft";
    private final String moveRight = "MoveRight";
    private final String moveUp = "MoveUp";
    private final String moveDown = "MoveDown";

    FrmPainel frm;

    public Janela() {

        this.setLayout(null);
        this.setSize(800, 600);
        this.setLocation(400, 80);
        this.setResizable(false);

        //criação do componentes
        ViewPort viewPort = new ViewPort(-170, 170, -170, 170, 0, 380, 0, 380);
        painel = new Painel(viewPort);
        painel.setBounds(380, 90, 380, 380);
        this.add(painel);

        //criação do botao de adição
        btnZoomIn = new JButton("+");
        btnZoomIn.setActionCommand(zoomIn);
        btnZoomIn.addActionListener(new WorldController());
        btnZoomIn.setBounds(330, 110, 50, 50);
        this.add(btnZoomIn);

        btnZoomOut = new JButton("-");
        btnZoomOut.setActionCommand(zoomOut);
        btnZoomOut.addActionListener(new WorldController());
        btnZoomOut.setBounds(330, 160, 50, 50);
        this.add(btnZoomOut);

        //criação do botao de remoção
        btnRemove = new JButton(remove);
        btnRemove.setActionCommand(remove);
        btnRemove.addActionListener(new WorldController());
        btnRemove.setBounds(110, 500, 100, 20);
        this.add(btnRemove);

        //botoes de movimento
        btnMoveLeft = new JButton(moveLeft);
        btnMoveLeft.setActionCommand(moveLeft);
        btnMoveLeft.addActionListener(new WorldController());
        btnMoveLeft.setBounds(330, 510, 100, 20);
        this.add(btnMoveLeft);

        btnMoveRight = new JButton(moveRight);
        btnMoveRight.setActionCommand(moveRight);
        btnMoveRight.addActionListener(new WorldController());
        btnMoveRight.setBounds(530, 510, 100, 20);
        this.add(btnMoveRight);

        btnMoveUp = new JButton(moveUp);
        btnMoveUp.setActionCommand(moveUp);
        btnMoveUp.addActionListener(new WorldController());
        btnMoveUp.setBounds(430, 500, 100, 20);
        this.add(btnMoveUp);

        btnMoveDown = new JButton(moveDown);
        btnMoveDown.setActionCommand(moveDown);
        btnMoveDown.addActionListener(new WorldController());
        btnMoveDown.setBounds(430, 520, 100, 20);
        this.add(btnMoveDown);

        //criação da lista para gerenciamento dos itens criados
        lvDrawable = new JList();
        lvDrawable.setBounds(5, 10, 300, 450);
        this.add(lvDrawable);

        //teste
        painel.setBorder(BorderFactory.createEtchedBorder());
        painel.addDrawable(new Line(new Coordenada(0, -170, 1), new Coordenada(0, 170, 1), "Linha vertical"));
        painel.addDrawable(new Line(new Coordenada(-170, 0, 1), new Coordenada(170, 0, 1), "Linha horizontal"));
        painel.repaint();

        lvDrawable.setListData(painel.getLstDrawables().toArray());

        frm = new FrmPainel();
        frm.setActionAddPixel(new AddPixel());
        frm.setActionAddLine(new AddLine());
        frm.setActionAddPoligon(new AddPoligon());
        frm.setActionAplicar(new AplicarAlteracao());
        frm.setVisible(true);
    }

    public class WorldController implements ActionListener {

        private Map<String, ButtonClick> buttonClicks = new HashMap<String, ButtonClick>();

        public class OnClickZoomIn implements ButtonClick {

            @Override
            public void click() {
                ViewPort viewPort = painel.getViewPort();
                float zoom = viewPort.getZoom();
                zoom *= 2;
                viewPort.setZoom(zoom);
                painel.setViewPort(viewPort);
                painel.repaint();
            }
        }

        public class OnClickZoomOut implements ButtonClick {

            @Override
            public void click() {
                ViewPort viewPort = painel.getViewPort();
                float zoom = viewPort.getZoom();
                zoom /= 2;
                viewPort.setZoom(zoom);
                painel.setViewPort(viewPort);
                painel.repaint();
            }
        }

        public class OnClickRemove implements ButtonClick {

            @Override
            public void click() {
                if ((!painel.getLstDrawables().isEmpty()) && (lvDrawable.getSelectedIndex() >= 0)) {
                    painel.removeDrawable(lvDrawable.getSelectedIndex());
                    lvDrawable.setListData(painel.getLstDrawables().toArray());
                    painel.repaint();
                }
            }
        }

        public class OnClickMoveLeft implements ButtonClick {

            @Override
            public void click() {
                ViewPort viewPort = painel.getViewPort();
                int xMov = viewPort.getxMov();
                xMov -= 10;
                viewPort.setxMov(xMov);
                painel.setViewPort(viewPort);
                painel.repaint();
            }
        }

        public class OnClickMoveRight implements ButtonClick {

            @Override
            public void click() {
                ViewPort viewPort = painel.getViewPort();
                int xMov = viewPort.getxMov();
                xMov += 10;
                viewPort.setxMov(xMov);
                painel.setViewPort(viewPort);
                painel.repaint();
            }
        }

        public class OnClickMoveUp implements ButtonClick {

            @Override
            public void click() {
                ViewPort viewPort = painel.getViewPort();
                int yMov = viewPort.getyMov();
                yMov += 10;
                viewPort.setyMov(yMov);
                painel.setViewPort(viewPort);
                painel.repaint();
            }
        }

        public class OnClickMoveDown implements ButtonClick {

            @Override
            public void click() {
                ViewPort viewPort = painel.getViewPort();
                int yMov = viewPort.getyMov();
                yMov -= 10;
                viewPort.setyMov(yMov);
                painel.setViewPort(viewPort);
                painel.repaint();
            }
        }

        public WorldController() {
            super();
            buttonClicks.put(zoomIn, new OnClickZoomIn());
            buttonClicks.put(zoomOut, new OnClickZoomOut());
            buttonClicks.put(remove, new OnClickRemove());
            buttonClicks.put(moveLeft, new OnClickMoveLeft());
            buttonClicks.put(moveRight, new OnClickMoveRight());
            buttonClicks.put(moveUp, new OnClickMoveUp());
            buttonClicks.put(moveDown, new OnClickMoveDown());
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            ButtonClick buttonClick = buttonClicks.get(e.getActionCommand());
            buttonClick.click();
        }

    }

    public class AplicarAlteracao implements ActionListener {

        private Map<Integer, ButtonClick> buttonClicks = new HashMap<Integer, ButtonClick>();

        private class AplicarTransalacao implements ButtonClick {
            @Override
            public void click() {
                int selectedIndex = lvDrawable.getSelectedIndex();
                if ((!painel.getLstDrawables().isEmpty()) && (selectedIndex >= 0)) {
                    DrawableInterface drawable = painel.getDrawable(selectedIndex);
                    Coordenada incPoint = frm.getTransformCoordenada();
                    drawable.translation(incPoint);
                    painel.updateDrawable(selectedIndex, drawable);
                    painel.repaint();
                }
            }

        }

        public AplicarAlteracao() {
            super();
            buttonClicks.put(0, new AplicarTransalacao());
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            ButtonClick buttonClick = buttonClicks.get(frm.getOperacaoTransformacao());
            buttonClick.click();
        }

    }

    public class AddPixel implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (frm != null) {

                Pixel pixel = frm.getPixel();
                if (!pixel.getNome().isEmpty()) {
                    painel.addDrawable(pixel);
                    painel.repaint();
                    lvDrawable.setListData(painel.getLstDrawables().toArray());
                } else {
                    JOptionPane.showMessageDialog(null, "Informe um nome para o Objeto!");
                }
            }
        }
    }

    public class AddLine implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (frm != null) {
                Line line = frm.getLine();
                if (!line.getNome().isEmpty()) {
                    painel.addDrawable(line);
                    painel.repaint();
                    lvDrawable.setListData(painel.getLstDrawables().toArray());
                } else {
                    JOptionPane.showMessageDialog(null, "Informe um nome para o Objeto!");
                }
            }
        }
    }

    public class AddPoligon implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (frm != null) {
                Poligon poligon = frm.getPoligon();
                if (!poligon.getNome().isEmpty()) {
                    painel.addDrawable(poligon);
                    painel.repaint();
                    lvDrawable.setListData(painel.getLstDrawables().toArray());
                } else {
                    JOptionPane.showMessageDialog(null, "Informe um nome para o Objeto!");
                }
            }
        }
    }
}
