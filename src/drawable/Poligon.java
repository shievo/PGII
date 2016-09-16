package drawable;

import interfaces.drawable.DrawableInterface;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import uteis.Calcular;
import uteis.Convert;
import uteis.Coordenada;
import uteis.ViewPort;

public class Poligon extends DrawableObject implements DrawableInterface {

    private List<Coordenada> path;

    public Poligon(String nome) {
        this.nome = nome;
        path = new ArrayList<>();
    }

    public Poligon(List<Coordenada> path, String nome) {
        this.nome = nome;
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
        if (path.isEmpty()) {
            return;
        }
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

    @Override
    public void translation(Coordenada incPoint) {
        if (this.path.isEmpty()) {
            return;
        }
        List<Coordenada> translateMatrix = Calcular.getMatrizTranslacao(incPoint);
        List<Coordenada> newPath = new ArrayList<>();
        for (Coordenada coordenada : path) {
            coordenada = Calcular.multiplicarMatrizCoordenadaAsFloat(coordenada, translateMatrix);
            newPath.add(coordenada);
        }
        path = newPath;
        /*
         for (int i = 0; i<this.path.size(); i++) {
         Coordenada coordenada = this.path.get(i);
         coordenada = Calcular.multiplicarMatrizCoordenadaAsFloat(coordenada, translateMatrix);
         this.path.set(i, coordenada);
         }
         */
    }

    @Override
    public void escalonar(Coordenada fator, int emRelacao) {
        if (path.isEmpty()) {
            return;
        }

        if (emRelacao == 2) {
            escalonamentoNatural(fator);
            return;
        }

        Coordenada origem = path.get(0);
        List<Coordenada> matrizEscalonamento = Calcular.getMatrizEscalonamento(fator);
        List<Coordenada> newPath = new ArrayList();

        for (Coordenada coordenada : path) {
            coordenada = Calcular.multiplicarMatrizCoordenadaAsFloat(coordenada, matrizEscalonamento);
            newPath.add(coordenada);
        }
        path = newPath;

        if (emRelacao == 1) {
            Coordenada coordFinal = path.get(0);
            Coordenada mover = origem.subtract(coordFinal);
            mover.setZ(1);
            translation(mover);
        }
    }

    private void escalonamentoNatural(Coordenada fator) {
        if (path.isEmpty()) {
            return;
        }
        List<Coordenada> matrizEscalonamento;
        Coordenada centro = getCenter();

        //primeiro passo
        Coordenada centroInverso = new Coordenada(-centro.getXasFloat(), -centro.getYasFloat(), 1);
        matrizEscalonamento = Calcular.getMatrizNatural(centroInverso);
        List<Coordenada> firstPath = new ArrayList();
        for (Coordenada coordenada : path) {
            coordenada = Calcular.multiplicarMatrizCoordenadaAsFloat(coordenada, matrizEscalonamento);
            firstPath.add(coordenada);
        }

        //segundo passo
        matrizEscalonamento = Calcular.getMatrizEscalonamento(fator);
        List<Coordenada> secondPath = new ArrayList();
        for (Coordenada coordenada : firstPath) {
            coordenada = Calcular.multiplicarMatrizCoordenadaAsFloat(coordenada, matrizEscalonamento);
            secondPath.add(coordenada);
        }

        //terceiro passo
        matrizEscalonamento = Calcular.getMatrizNatural(centro);
        List<Coordenada> thirdPath = new ArrayList();
        for (Coordenada coordenada : secondPath) {
            coordenada = Calcular.multiplicarMatrizCoordenadaAsFloat(coordenada, matrizEscalonamento);
            thirdPath.add(coordenada);
        }

        path = thirdPath;
    }

    @Override
    public void refletir(Coordenada reflexao) {
        if (this.path.isEmpty()) {
            return;
        }
        List<Coordenada> matrizEscalonamento = Calcular.getMatrizReflexao(reflexao);
        List<Coordenada> newPath = new ArrayList<>();
        for (Coordenada coordenada : this.path) {
            coordenada = Calcular.multiplicarMatrizCoordenada(coordenada, matrizEscalonamento);
            newPath.add(coordenada);
        }
        this.path = newPath;
    }

    @Override
    public void rotacionar(double angulo, int emRelacao) {
        if (this.path.isEmpty()) {
            return;
        }
        
        if (emRelacao == 2) {
            rotacionarNatural(angulo);
            return;
        }
        
        Coordenada origem = path.get(0);
        List<Coordenada> matrizRotacao = Calcular.getMatrizRotacao(angulo);
        List<Coordenada> newPath = new ArrayList<>();
        for (Coordenada coordenada : this.path) {
            coordenada = Calcular.multiplicarMatrizCoordenadaAsFloat(coordenada, matrizRotacao);
            newPath.add(coordenada);
        }
        this.path = newPath;
        
        if (emRelacao == 1) {
            Coordenada coordFinal = path.get(0);
            Coordenada mover = origem.subtract(coordFinal);
            mover.setZ(1);
            translation(mover);
        }
    }

    private void rotacionarNatural(double angulo) {
        if (path.isEmpty()) {
            return;
        }
        List<Coordenada> matrizEscalonamento;
        Coordenada centro = getCenter();

        //primeiro passo
        Coordenada centroInverso = new Coordenada(-centro.getXasFloat(), -centro.getYasFloat(), 1);
        matrizEscalonamento = Calcular.getMatrizNatural(centroInverso);
        List<Coordenada> firstPath = new ArrayList();
        for (Coordenada coordenada : path) {
            coordenada = Calcular.multiplicarMatrizCoordenadaAsFloat(coordenada, matrizEscalonamento);
            firstPath.add(coordenada);
        }

        //segundo passo
        matrizEscalonamento = Calcular.getMatrizRotacao(angulo);
        List<Coordenada> secondPath = new ArrayList();
        for (Coordenada coordenada : firstPath) {
            coordenada = Calcular.multiplicarMatrizCoordenadaAsFloat(coordenada, matrizEscalonamento);
            secondPath.add(coordenada);
        }

        //terceiro passo
        matrizEscalonamento = Calcular.getMatrizNatural(centro);
        List<Coordenada> thirdPath = new ArrayList();
        for (Coordenada coordenada : secondPath) {
            coordenada = Calcular.multiplicarMatrizCoordenadaAsFloat(coordenada, matrizEscalonamento);
            thirdPath.add(coordenada);
        }

        path = thirdPath;
    }

    @Override
    public Coordenada getCenter() {
        Coordenada centro = Calcular.sumCoordenada(path);
        int itemCount = path.size();
        Coordenada divisor = new Coordenada(itemCount, itemCount, itemCount);
        centro = Calcular.divisaoSimples(divisor, centro);
        return centro;
    }
}
