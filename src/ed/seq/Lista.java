package ed.seq;

public class Lista {
    protected Object v[];
    protected int fim = 0;

    public Lista() {
        this(4);
    }

    public Lista(int tam) {
        v = new Object[tam];
    }

    public void adicionar(Object elem) {
        // utiliza método inserir existente!
        inserir(fim, elem);
        // adição=inserção no fim!
    }

    public int capacidade() {
        return v.length;
    }

    public boolean cheia() {
        return fim == v.length;
    }

    public int comprimento() {
        return fim;
    }

    public Object elemento(int pos) {
        if (pos < 0 || pos > fim) {
            throw new RuntimeException("pos=" + pos + " inválida");
        }
        return v[pos];
    }

    public void inserir(int pos, Object elem) {
        if (pos < 0 || pos > fim) {
            throw new RuntimeException("pos=" + pos + " inválida");
        } else if (fim == capacidade()) {
            throw new RuntimeException("lista cheia");
        }
        fim++;
        for (int i = fim - 1; i > pos; i--) {
            v[i] = v[i - 1];
        }
        v[pos] = elem;
    }

    public Object remover (int pos) {
        if (vazia()) {
            throw new RuntimeException("lista vazia");
        }
        Object aux = elemento(pos);
        for (int i = pos + 1; i < fim; i++) {
            v[i - 1] = v[i];
        }
        fim--;
        return aux;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        for (int i = 0; i < fim; i++) {
            sb.append(v[i]);
            sb.append(" ");
        }
        sb.append("]");
        return sb.toString();
    }

    public boolean vazia() {
        return fim == 0;
    }

}
