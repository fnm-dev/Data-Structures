package ed.nseq;

public class NodoLigado {
    public Object dado = null;
    public NodoLigado proximo = null;

    public NodoLigado() {
    }

    public NodoLigado(Object dado) {
        this.dado = dado;
    }

    public NodoLigado(Object dado, NodoLigado proximo) {
        this.dado = dado;
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        String resultado = "";
        if (dado != null) resultado = dado.toString();
        if (proximo != null) resultado += "," + proximo.toString();
        return resultado;
    }

}