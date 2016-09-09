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
    
    public Line(){
        
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
    public void escalonar(Coordenada fator, boolean emRelacaoOrigem) {
        List<Coordenada> matrizEscalonamento = Calcular.getMatrizEscalonamento(fator);
        Coordenada origem = this.start;
        this.start = Calcular.multiplicarMatrizCoordenadaAsFloat(start, matrizEscalonamento);
        this.end = Calcular.multiplicarMatrizCoordenadaAsFloat(end, matrizEscalonamento);
        if (emRelacaoOrigem) {
            translation(origem.subtract(this.start));
        }
    }
    
    @Override
    public void refletir(Coordenada reflexao) {
        List<Coordenada> matrizReflexao = Calcular.getMatrizReflexao(reflexao);
        this.start = Calcular.multiplicarMatrizCoordenada(this.start, matrizReflexao);
        this.end = Calcular.multiplicarMatrizCoordenada(this.end, matrizReflexao);
    }

    @Override
    public void rotacionar(double angulo) {
        List<Coordenada> matrizRotacao = Calcular.getMatrizRotacao(angulo);
        this.start = Calcular.multiplicarMatrizCoordenadaAsFloat(this.start, matrizRotacao);
        this.end = Calcular.multiplicarMatrizCoordenadaAsFloat(this.end, matrizRotacao);
    }
}