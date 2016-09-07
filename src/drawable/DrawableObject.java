package drawable;

import uteis.ViewPort;

/**
 *
 * @author Kelvin
 */
public class DrawableObject {

    protected String nome;

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
