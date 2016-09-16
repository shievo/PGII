/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteis;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kelvin
 */
public class Calcular {

    public static List<Coordenada> genDefMatiz(int size, Coordenada valueDef) {
        List<Coordenada> matriz = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            matriz.add(valueDef);
        }

        return matriz;
    }

    public static List<Coordenada> somarMatrizCoordenada(List<Coordenada> a, List<Coordenada> b) {
        if (a.size() != a.size()) {
            return null;
        }
        List<Coordenada> s = new ArrayList<>();

        for (int i = 0; i < a.size(); i++) {
            Coordenada coordA = a.get(i);
            Coordenada coordB = b.get(i);
            Coordenada coordS = coordA.add(coordB);
            s.add(coordS);
        }
        return s;
    }

    public static List<Coordenada> multiplicarMatrizCoordenada(List<Coordenada> a, List<Coordenada> b) {
        List<Coordenada> s = new ArrayList<>();
        if (b.size() != 3) {
            return null;
        }
        for (Coordenada coordenadaA : a) {
            int x, y, z;
            x = y = z = 0;
            for (int i = 0; i < b.size(); i++) {
                Coordenada coordenadaB = b.get(i);
                x += coordenadaB.getX() * coordenadaA.get(i);
                y += coordenadaB.getY() * coordenadaA.get(i);
                z += coordenadaB.getZ() * coordenadaA.get(i);
            }
            Coordenada coordenadaS = new Coordenada(x, y, z);
            s.add(coordenadaS);
        }
        return s;
    }

    public static Coordenada multiplicarMatrizCoordenada(Coordenada coordenadaA, List<Coordenada> b) {
        if (b.size() != 3) {
            return null;
        }
        int x, y, z;
        x = y = z = 0;
        for (int i = 0; i < b.size(); i++) {
            Coordenada coordenadaB = b.get(i);
            x += coordenadaB.getX() * coordenadaA.get(i);
            y += coordenadaB.getY() * coordenadaA.get(i);
            z += coordenadaB.getZ() * coordenadaA.get(i);
        }
        return new Coordenada(x, y, z);
    }

    public static Coordenada multiplicarMatrizCoordenadaAsFloat(Coordenada coordenadaA, List<Coordenada> b) {
        if (b.size() != 3) {
            return null;
        }
        float x, y, z;
        x = y = z = 0;
        for (int i = 0; i < b.size(); i++) {
            Coordenada coordenadaB = b.get(i);
            x += coordenadaB.getXasFloat() * coordenadaA.get(i);
            y += coordenadaB.getYasFloat() * coordenadaA.get(i);
            z += coordenadaB.getZasFloat() * coordenadaA.get(i);
        }
        return new Coordenada(x, y, z);
    }

    public static List<Coordenada> getMatrizTranslacao(Coordenada coordenada) {
        List<Coordenada> matrizTranslacao = new ArrayList<>();
        matrizTranslacao.add(new Coordenada(1, 0, 0));
        matrizTranslacao.add(new Coordenada(0, 1, 0));
        matrizTranslacao.add(coordenada);
        return matrizTranslacao;
    }

    public static List<Coordenada> getMatrizEscalonamento(Coordenada coordenada) {
        List<Coordenada> matrizEscalonamento = new ArrayList<>();
        matrizEscalonamento.add(new Coordenada(coordenada.getXasFloat(), 0, 0));
        matrizEscalonamento.add(new Coordenada(0, coordenada.getYasFloat(), 0));
        matrizEscalonamento.add(new Coordenada(0, 0, coordenada.getZasFloat()));
        return matrizEscalonamento;
    }
    
    public static List<Coordenada> getMatrizNatural(Coordenada coordenada) {
        List<Coordenada> matrizEscalonamento = new ArrayList<>();
        matrizEscalonamento.add(new Coordenada(1, 0, 0));
        matrizEscalonamento.add(new Coordenada(0, 1, 0));
        matrizEscalonamento.add(new Coordenada(coordenada.getXasFloat(), coordenada.getYasFloat(), coordenada.getZasFloat()));
        return matrizEscalonamento;
    }

    public static List<Coordenada> getMatrizReflexao(Coordenada coordenada) {
        List<Coordenada> matrizReflexao = new ArrayList<>();
        matrizReflexao.add(new Coordenada(coordenada.getX(), 0, 0));
        matrizReflexao.add(new Coordenada(0, coordenada.getY(), 0));
        matrizReflexao.add(new Coordenada(0, 0, coordenada.getZ()));
        return matrizReflexao;
    }

    public static List<Coordenada> getMatrizRotacao(double angulo) {
        List<Coordenada> matrizRotacao = new ArrayList<>();
        angulo = Math.toRadians(angulo);
        double seno = Math.sin(angulo);
        double coseno = Math.cos(angulo);
        matrizRotacao.add(new Coordenada(new Float(coseno), new Float(seno), 0));
        matrizRotacao.add(new Coordenada(new Float(-seno), new Float(coseno), 0));
        matrizRotacao.add(new Coordenada(0, 0, 1));
        return matrizRotacao;
    }
    
    public static Coordenada divisaoSimples(Coordenada divisor, Coordenada dividendo) {
        float x, y, z;
        x = dividendo.getXasFloat() / divisor.getXasFloat();
        y = dividendo.getYasFloat() / divisor.getYasFloat();
        z = dividendo.getZasFloat() / divisor.getZasFloat();
        return new Coordenada(x, y, z);
    }
    
    public static Coordenada sumCoordenada(List<Coordenada> lstCoordenada) {
        Coordenada sumResult = new Coordenada();
        for (Coordenada coordenada : lstCoordenada) 
            sumResult = sumResult.add(coordenada);
        return sumResult;
    }
        
}
