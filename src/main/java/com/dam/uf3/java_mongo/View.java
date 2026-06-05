package com.dam.uf3.java_mongo;

import java.util.List;
import java.util.Scanner;

public class View {
    private Scanner sc = new Scanner(System.in);

    public int mostrarMenu() {

        System.out.println("\n=== GESTIÓ D'ÀLBUMS ===");
        System.out.println("1. Afegir àlbum");
        System.out.println("2. Eliminar àlbum");
        System.out.println("3. Modificar àlbum");
        System.out.println("4. Llistar tots");
        System.out.println("5. Llistar entre dates");
        System.out.println("6. Cercar per títol");
        System.out.println("7. Sortir");

        return Integer.parseInt(sc.nextLine());
    }

    public void mostrarAlbums(List<Album> albums) {

        for (int i = 0; i < albums.size(); i++) {

            System.out.println((i + 1) + ". " + albums.get(i));
        }
    }
}
