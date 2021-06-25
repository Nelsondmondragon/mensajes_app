package com.mensaje_app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {

    public static void Menu() throws IOException {
        BufferedReader tc = new BufferedReader(new InputStreamReader(System.in));

        String op = "0";

        do {
            System.out.println("Aplicacion de mensajes \n" +
                    "1.Crear mensaje.\n" +
                    "2.Listar mensaje.\n" +
                    "3.Editar mensaje.\n" +
                    "4.Eliminar mensaje.\n" +
                    "5.Salir.");
            op = tc.readLine();
            switch (op) {
                case "1":
                    MessageService.createMessage();
                    break;
                case "2":
                    MessageService.listMessage();
                    break;
                case "3":
                    MessageService.editMessage();
                    break;
                case "4":
                    MessageService.deleteMessage();
                    break;
                default:
                    break;
            }

        } while (!op.equals("5"));
    }
}
