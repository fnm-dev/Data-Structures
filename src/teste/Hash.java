package teste;

import ed.hash.TabelaHash;

import java.util.Scanner;

public class Hash {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TabelaHash hash = new TabelaHash();

        System.out.println("##################################");
        System.out.println("\t\tHashing Table");
        System.out.println("##################################");

        // put(key, value)
        hash.put(1, 2);
        hash.put(2, 3);
        hash.put(3, 4);

        System.out.println(hash.containsKey(1));
        System.out.println(hash.containsKey(2));
        System.out.println(hash.containsKey(3));
        System.out.println(hash.containsKey(4));

        System.out.println(hash.containsValue(2));
        System.out.println(hash.containsValue(5));

        System.out.println("Colisão: "+hash.collisionRate());

        System.out.println(hash.size);

        System.out.println(hash.toString());
    }
}
