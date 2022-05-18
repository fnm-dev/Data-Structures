package ed.nseq;

public class Fila {
    private ListaLigada lista = new ListaLigada();

    public Fila() { }

    public void adicionar(Object valor) {
        lista.adicionar(valor);
    }
    public int comprimento() {
        return lista.comprimento();
    }
    public Object elemento(int posicao) {
        return lista.elemento(posicao);
    }
    public String toString() {
        return lista.toString();
    }
    public boolean vazia() {
        return lista.vazia();
    }

    public Object remover() {
        return lista.remover(0);
    }
}


