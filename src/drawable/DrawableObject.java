/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package drawable;

import uteis.ViewPort;

/**
 *
 * @author Kelvin
 */
public class DrawableObject {
    protected String nome;
    
    protected void getCordenada(ViewPort viewPort, int x, int y) {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public String toString() {
        return nome;
    }
}
