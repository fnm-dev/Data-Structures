package ed.hash;

public class TabelaHash {
    public int size = 0;
    public int collision = 0;
    public NodoInterno[] bucket;

    public TabelaHash() {
        this(20);
    }

    public TabelaHash(int bucketNumber) {
        bucket = new NodoInterno[bucketNumber];
    }

    private class NodoInterno {
        public Object key;
        public Object value;
        public NodoInterno next;
    }

    public void put(Object key, Object value) {
        int hash = (key.hashCode() & 0x7fffffff) % bucket.length;
        if (bucket[hash] == null) {
            bucket[hash] = new NodoInterno();
            bucket[hash].key = key;
            bucket[hash].value = value;
            bucket[hash].next = null;
            size++;
        } else {
            collision++;
            NodoInterno aux = bucket[hash];
            while (!aux.key.equals(key) && aux.next != null) {
                aux = aux.next;
            }
        }
    }

    public Object get(Object key) {
        int hash = (key.hashCode() & 0x7fffffff) % bucket.length;
        Object value = null;
        if (bucket[hash] != null) {
            NodoInterno aux = bucket[hash];
            while (!aux.key.equals(key) && aux.next != null) {
                aux = aux.next;
            }
            if (aux.key.equals(key)) {
                value = aux.value;
            }
        }
        return value;
    }

    public Object remove(Object key) {
        int hash = (key.hashCode() & 0x7fffffff) % bucket.length;
        Object value = null;
        if (bucket[hash] != null) {
            NodoInterno aux = bucket[hash];
            NodoInterno ant = null;
            while (!aux.key.equals(key) && aux.next != null) {
                ant = aux;
                aux = aux.next;
            }
            if (aux.key.equals(key)) {
                value = aux.value;
                ant = aux.next;
                aux = null;
            }
        }
        return value;
    }

    public int size(){
        return size;
    }

    public boolean containsKey(Object key) {
        int hash = (key.hashCode() & 0x7fffffff) % bucket.length;
        if (bucket[hash] != null) {
            NodoInterno aux = bucket[hash];
            while (!aux.key.equals(key) && aux.next != null){
                aux = aux.next;
            }
            if (aux.key.equals(key)) return true;
        }
        return false;
    }

    public boolean containsValue(Object value){
        for(int i=0; i<bucket.length; i++){
            for(NodoInterno aux = bucket[i]; aux!=null; aux=aux.next){
                if(value.equals(aux.value)) return true;
            }
        }
        return false;
    }

    public double collisionRate(){
        double average = collision/size;
        return average;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Tabela Hash: [ ");
        for(int i=0; i<bucket.length; i++){
            for(NodoInterno aux = bucket[i]; aux!=null; aux=aux.next){
                if(aux!=null) {
                    sb.append("("+aux.key + "|" + aux.value+")");
                    sb.append(" ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

