package ed.nseq;

public class Deque {
    private ListaLigada lista = new ListaLigada();

    public Deque() { }

    public void adicionarFim(Object valor) {
        lista.adicionar(valor);
    }
    public void adicionarInicio(Object valor) {
        lista.inserir(0, valor);
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

    public Object removerInicio() {
        return lista.remover(0);
    }
    public Object removerFim() {
        return lista.remover(lista.comprimento()-1);
    }
}


