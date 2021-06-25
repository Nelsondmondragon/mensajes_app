package com.mensaje_app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MessageService {

    private static BufferedReader tc = new BufferedReader(new InputStreamReader(System.in));;



    public static void createMessage()  throws IOException{
        System.out.println("Generar mensaje");
        String message = tc.readLine();
        System.out.println("Autor");
        String autor = tc.readLine();
        Message ms = new Message();
        ms.setMensaje(message);
        ms.setAutor_mensaje(autor);
        MessageDAO.createMessageBD(ms);
    }

    public static void readMessage() {
        ArrayList<Message> list = MessageDAO.readMessageBD();
        for (Message m : list) {
            System.out.println(m);
        }
    }

    public static void deleteMessage() throws IOException {
        System.out.println("Ingrese el id del mensaje a borrar");
        MessageDAO.deleteMessageDB(Integer.parseInt(tc.readLine()));
    }

    public static void editMessage() throws IOException{
        System.out.println("Escribe tu nuevo mensaje");
        String ms= tc.readLine();
        System.out.println("Escribe id del mansaje");
        MessageDAO.updateMessageDB(Integer.parseInt(tc.readLine()),ms);
    }

}
