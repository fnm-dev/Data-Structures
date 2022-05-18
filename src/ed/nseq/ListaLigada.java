package ed.nseq;

public class ListaLigada {
    private NodoLigado inicio = null;
    private NodoLigado fim = null;
    private int comprimento = 0;

    public ListaLigada() {

    }

    public void adicionar(Object valor) {

        NodoLigado novo = new NodoLigado(valor);

        if (fim != null) {
            fim.proximo = novo;
        } else {
            inicio = novo;
        }
        fim = novo;
        comprimento++;
    }

    public int comprimento() {
        return comprimento;
    }

    public Object elemento(int posicao) {
        NodoLigado aux = referenciaElemento(posicao);
        return aux.dado;
    }

    public void inserir(int posicao, Object valor) {
        NodoLigado novo = new NodoLigado(valor);
        if (posicao == 0) {
            novo.proximo = inicio;
            inicio = novo;
            if (comprimento == 0) {
                fim = novo;
            }
        } else if (posicao == comprimento) {
            if (fim != null) {

                fim.proximo = novo;
            } else {

                fim = novo;
                inicio = novo;
            }
        } else {

            NodoLigado anterior = referenciaElemento(posicao - 1);
            novo.proximo = anterior.proximo;
            anterior.proximo = novo;
        }
        comprimento++;
    }


    public Object remover(int posicao) {
        if (comprimento == 0) {
            throw new IllegalArgumentException("lista vazia");
        }
        NodoLigado aux = null;
        if (posicao == 0) {
            aux = inicio;
            inicio = inicio.proximo;
            aux.proximo = null;
            if (comprimento == 1) {
                fim = inicio;
            }
        } else if (posicao == comprimento - 1) {
            aux = fim;
            fim = referenciaElemento(posicao - 1);
            fim.proximo = null;
            if (comprimento == 1) {
                inicio = fim;
            }
        } else if (posicao > 0 && posicao < comprimento - 1) {
            NodoLigado ant = referenciaElemento(posicao - 1);
            aux = ant.proximo;
            ant.proximo = aux.proximo;
            aux.proximo = null;
        } else {
            throw new IllegalArgumentException("posição inválida: " + posicao);
        }
        comprimento--;
        return aux.dado;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        NodoLigado aux = inicio;
        while (aux != null) {
            sb.append(aux.dado);
            if (aux.proximo != null) {
                sb.append(",");
            }
            aux = aux.proximo;
        }
        sb.append("]");
        return sb.toString();
    }

    public boolean vazia() {
        return comprimento == 0;
    }

    private NodoLigado referenciaElemento(int posicao) {
        validaPosicao(posicao);
        NodoLigado aux = inicio;
        for(int p = 0; p < posicao; p++) {
            aux = aux.proximo;
        }
        return aux;
    }

    private void validaPosicao(int posicao) {
        if (posicao < 0 || posicao >= comprimento) {
            throw new IllegalArgumentException("posição invalida: " + posicao);
        }
    }

}