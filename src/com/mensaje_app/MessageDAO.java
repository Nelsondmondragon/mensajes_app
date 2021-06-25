package com.mensaje_app;

import com.mysql.cj.jdbc.ConnectionImpl;
import com.mysql.cj.x.protobuf.MysqlxPrepare;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class MessageDAO {
    private static ResultSet rs;

    public static void createMessageBD(Message message) {
        PreparedStatement ps = null;
        try {
            ps = ConnectionBD.get_connection().prepareStatement("INSERT INTO mensaje (mensaje, autor_mensaje) VALUES (?,?)");
            ps.setString(1, message.getMensaje());
            ps.setString(2, message.getAutor_mensaje());
            ps.executeUpdate();
            System.out.println("Mensaje creado");
        } catch (SQLException exception) {
            System.out.println(exception);
        }

    }

    public static ArrayList readMessageBD() {
        PreparedStatement ps = null;
        ArrayList<Message> list = new ArrayList<>();
        rs = null;
        try {
            ps = ConnectionBD.get_connection().prepareStatement("SELECT * FROM mensaje");
            rs = ps.executeQuery();

            while (rs.next()) {
                Message ms = new Message();
                ms.setId_mensaje(rs.getInt("id_mensaje"));
                ms.setMensaje(rs.getString("mensaje"));
                ms.setAutor_mensaje(rs.getString("autor_mensaje"));
                ms.setFecha_mensaje(rs.getString("fecha_mensaje"));
                list.add(ms );
            }
        } catch (SQLException e) {
            System.out.println("No se pudo leer. \n" + e);
        }
        return list;
    }

    public static void deleteMessageDB(int idMessage) {
        PreparedStatement ps =null;
        try {
            ps=ConnectionBD.get_connection().prepareStatement("DELETE FROM mensaje WHERE id_mensaje = ?");
            ps.setInt(1,idMessage);
            ps.executeUpdate();
            System.out.println("Delete");
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public static void updateMessageDB(int idMessage, String message) {
        PreparedStatement ps= null;
        try{
            ps= ConnectionBD.get_connection().prepareStatement("UPDATE mensaje SET mensaje = ? WHERE id_mensaje =?");
            ps.setString(1,message);
            ps.setInt(2,idMessage);
            ps.executeUpdate();
            System.out.println("Mensaje Actualizado");
        }catch (SQLException e){
            System.out.println(e);
        }
    }


}
