package ed.seq;

public class Pilha {
    private Object[] elemento;
    private int topo = 0;

    public Pilha() {
        this(10);
    }

    public Pilha(int tamanho) {
        elemento = new Object[tamanho];
    }

    public void adicionar(Object valor) {
        if (topo < elemento.length) {
            elemento[topo] = valor;
            topo++;
        } else {
            throw new RuntimeException("Pilha cheia");
        }
    }

    public int capacidade() {
        return elemento.length;
    }

    public boolean cheia() {
        return topo == elemento.length;
    }

    public int comprimento() {
        return topo;
    }

    public Object elemento(int pos) {
        if (pos < topo && pos > -1) {
            return elemento[pos];
        } else {
            throw new RuntimeException("Posição inválida");
        }
    }

    public Object remover() {
        if (topo > 0) {
            topo--;
            return elemento[topo];
        } else {
            throw new RuntimeException("Pilha vazia");
        }
    }

    public String toString() {
        String texto = "[ ";
        for (int i = 0; i < topo; i++) {
            texto += elemento[i];
            texto += " ";
        }
        texto += "] : ";
        texto += topo;
        return texto;
    }

    public boolean vazia() {
        return topo == 0;
    }

}
