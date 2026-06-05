package com.dam.uf3.java_mongo;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Model model = new Model();
        View view = new View();

        Scanner sc = new Scanner(System.in);

        int opcio;

        do {

            opcio = view.mostrarMenu();

            switch (opcio) {

                case 1:

                    System.out.print("Artista: ");
                    String artist = sc.nextLine();

                    System.out.print("Títol: ");
                    String title = sc.nextLine();

                    System.out.print("Data (yyyy-mm-dd): ");
                    String date =
                            sc.nextLine();

                    model.inserirAlbum(
                            new Album(artist, title, date));

                    break;

                case 2:

                    List<Album> albumsDelete =
                            model.getAllAlbums();

                    view.mostrarAlbums(albumsDelete);

                    System.out.print("Títol a eliminar: ");
                    model.deleteAlbum(sc.nextLine());

                    break;

                case 3:

                    List<Album> albumsUpdate =
                            model.getAllAlbums();

                    view.mostrarAlbums(albumsUpdate);

                    System.out.print("Títol actual: ");
                    String oldTitle = sc.nextLine();

                    System.out.print("Nou artista: ");
                    artist = sc.nextLine();

                    System.out.print("Nou títol: ");
                    title = sc.nextLine();

                    System.out.print("Nova data: ");
                    date = sc.nextLine();

                    model.updateAlbum(
                            oldTitle,
                            new Album(artist, title, date)
                    );

                    break;

                case 4:

                    view.mostrarAlbums(
                            model.getAllAlbums());

                    break;

                case 5:

                    System.out.print("Data inici: ");
                    LocalDate inici =
                            LocalDate.parse(sc.nextLine());

                    System.out.print("Data fi: ");
                    LocalDate fi =
                            LocalDate.parse(sc.nextLine());

                    view.mostrarAlbums(
                            model.getAlbumByDate(inici, fi)
                    );

                    break;

                case 6:

                    System.out.print("Text a cercar: ");

                    view.mostrarAlbums(
                            model.getFilteredAlbum(
                                    sc.nextLine()
                            )
                    );

                    break;
            }

        } while (opcio != 7);
    }
}

