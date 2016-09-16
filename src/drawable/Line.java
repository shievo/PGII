package drawable;

import interfaces.drawable.DrawableInterface;
import java.awt.Graphics;
import java.util.List;
import uteis.Calcular;
import uteis.Convert;
import uteis.Coordenada;
import uteis.ViewPort;

public class Line extends DrawableObject implements DrawableInterface {

    private Coordenada start, end;

    public Line() {

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

    @Override
    public void translation(Coordenada incPoint) {
        this.end = this.end.add(incPoint);
        this.start = this.start.add(incPoint);
    }

    @Override
    public void escalonar(Coordenada fator, int emRelacao) {
        switch (emRelacao) {
            case 0:
                escalonarSimples(fator);
                break;
            case 1:
                escalonarPrimeiroPonto(fator);
                break;
            case 2:
                escalonarNatural(fator);
                break;
        }
    }
    
    private void escalonarNatural(Coordenada fator){
        List<Coordenada> matrizEscalonamento;
        Coordenada centro = getCenter();
        
        //passo 1
        Coordenada centroInverso = new Coordenada(-centro.getXasFloat(), -centro.getYasFloat(), 1);
        matrizEscalonamento = Calcular.getMatrizNatural(centroInverso);
        this.start = Calcular.multiplicarMatrizCoordenadaAsFloat(this.start, matrizEscalonamento);
        this.end = Calcular.multiplicarMatrizCoordenadaAsFloat(this.end, matrizEscalonamento);
        
        //passo 2
        matrizEscalonamento = Calcular.getMatrizEscalonamento(fator);
        this.start = Calcular.multiplicarMatrizCoordenadaAsFloat(this.start, matrizEscalonamento);
        this.end = Calcular.multiplicarMatrizCoordenadaAsFloat(this.end, matrizEscalonamento);
        
        //passo 3
        matrizEscalonamento = Calcular.getMatrizNatural(centro);
        this.start = Calcular.multiplicarMatrizCoordenadaAsFloat(this.start, matrizEscalonamento);
        this.end = Calcular.multiplicarMatrizCoordenadaAsFloat(this.end, matrizEscalonamento);
        
    }
    
    private void escalonarPrimeiroPonto(Coordenada fator){
        List<Coordenada> matrizEscalonamento = Calcular.getMatrizEscalonamento(fator);
        Coordenada origem = this.start;
        this.start = Calcular.multiplicarMatrizCoordenadaAsFloat(this.start, matrizEscalonamento);
        this.end = Calcular.multiplicarMatrizCoordenadaAsFloat(this.end, matrizEscalonamento);
        Coordenada mover = origem.subtract(this.start);
        translation(mover);
        
    }
    
    private void escalonarSimples(Coordenada fator){
        List<Coordenada> matrizEscalonamento = Calcular.getMatrizEscalonamento(fator);
        Coordenada origem = this.start;
        this.start = Calcular.multiplicarMatrizCoordenadaAsFloat(start, matrizEscalonamento);
        this.end = Calcular.multiplicarMatrizCoordenadaAsFloat(end, matrizEscalonamento);
    }
    

    @Override
    public void refletir(Coordenada reflexao) {
        List<Coordenada> matrizReflexao = Calcular.getMatrizReflexao(reflexao);
        this.start = Calcular.multiplicarMatrizCoordenada(this.start, matrizReflexao);
        this.end = Calcular.multiplicarMatrizCoordenada(this.end, matrizReflexao);
    }

    @Override
    public void rotacionar(double angulo, int emRelacao) {
        switch (emRelacao) {
            case 0:
                rotacionarSimples(angulo);
                break;
            case 1:
                rotacionarPrimeiroPonto(angulo);
                break;
            case 2:
                rotacionarNatural(angulo);
                break;
        }
    }

    public void rotacionarNatural(double angulo) {
        List<Coordenada> matrizRotacao;
        Coordenada centro = getCenter();
        
        System.out.println("centro ->" + centro.toString());
        
        //passo 1
        Coordenada centroInverso = new Coordenada(-centro.getXasFloat(), -centro.getYasFloat(), 1);
        matrizRotacao = Calcular.getMatrizNatural(centroInverso);
        this.start = Calcular.multiplicarMatrizCoordenadaAsFloat(this.start, matrizRotacao);
        this.end = Calcular.multiplicarMatrizCoordenadaAsFloat(this.end, matrizRotacao);
        
        //passo 2
        matrizRotacao = Calcular.getMatrizRotacao(angulo);
        this.start = Calcular.multiplicarMatrizCoordenadaAsFloat(this.start, matrizRotacao);
        this.end = Calcular.multiplicarMatrizCoordenadaAsFloat(this.end, matrizRotacao);
        
        //passo 3
        matrizRotacao = Calcular.getMatrizNatural(centro);
        this.start = Calcular.multiplicarMatrizCoordenadaAsFloat(this.start, matrizRotacao);
        this.end = Calcular.multiplicarMatrizCoordenadaAsFloat(this.end, matrizRotacao);

    }

    public void rotacionarPrimeiroPonto(double angulo) {
        List<Coordenada> matrizRotacao = Calcular.getMatrizRotacao(angulo);
        Coordenada origem = this.start;
        this.start = Calcular.multiplicarMatrizCoordenadaAsFloat(this.start, matrizRotacao);
        this.end = Calcular.multiplicarMatrizCoordenadaAsFloat(this.end, matrizRotacao);
        Coordenada mover = origem.subtract(this.start);
        translation(mover);
    }

    public void rotacionarSimples(double angulo) {
        List<Coordenada> matrizRotacao = Calcular.getMatrizRotacao(angulo);
        this.start = Calcular.multiplicarMatrizCoordenadaAsFloat(this.start, matrizRotacao);
        this.end = Calcular.multiplicarMatrizCoordenadaAsFloat(this.end, matrizRotacao);
    }

    @Override
    public Coordenada getCenter() {
        Coordenada centro = start.add(end);
        Coordenada divisor = new Coordenada(2, 2, 2);
        centro = Calcular.divisaoSimples(divisor, centro);
        return centro;
    }
}
