/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufabc.VeganWash.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Victor
 */

public class DataSource {

    private String hostname;
    private int port;
    private String database;
    private String username;
    private String password;
    private Connection connection;

    public DataSource() {

        hostname = "localhost";
        port = 3306;
        database = "VeganWash";
        username = "root";
        password = "@brasil@";
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database;
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Conectado!");
        } catch (Exception ex) {
            System.out.println("ERRO AO CONECTAR - Verificar senha no DatasSource.java");
            System.out.println(ex.getMessage());
        }
    }

    public Connection getConnection() {
        return this.connection;
    }

}
