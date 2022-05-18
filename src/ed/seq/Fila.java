package ed.seq;

public class Fila {
    private Object[] elemento;
    private int fim = 0;

    public Fila() {
        this(10);
    }

    public Fila(int tamanho) {
        elemento = new Object[tamanho];
    }

    public void adicionar(Object valor) {
        if (fim < elemento.length) {
            elemento[fim] = valor;
            fim++;
        } else {
            throw new RuntimeException("Fila cheia");
        }
    }

    public int capacidade() {
        return elemento.length;
    }

    public boolean cheia() {
        return fim == elemento.length;
    }

    public int comprimento() {
        return fim;
    }

    public Object elemento(int pos) {
        if (pos < fim && pos > -1) {
            return elemento[pos];
        } else {
            throw new RuntimeException("Posição inválida");
        }
    }

    public Object remover() {
        if (fim > 0) {
            Object aux = elemento[0];
            for(int p=1; p<fim; p++) {
                elemento[p-1] = elemento[p];
            }
            fim--;
            return aux;
        } else {
            throw new RuntimeException("Fila vazia");
        }
    }

    public String toString() {
        String texto = "[ ";
        for (int i = 0; i < fim; i++) {
            texto += elemento[i];
            texto += " ";
        }
        texto += "] : ";
        texto += fim;
        return texto;
    }

    public boolean vazia() {
        return fim == 0;
    }

}
