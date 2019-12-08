/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufabc.VeganWash.controller;

import br.edu.ufabc.VeganWash.dao.FornecedorDAO;
import br.edu.ufabc.VeganWash.dao.DataSource;
import br.edu.ufabc.VeganWash.dao.GenericDAO;
import br.edu.ufabc.VeganWash.dao.ProdutoDAO;
import br.edu.ufabc.VeganWash.model.Fornecedor;
import br.edu.ufabc.VeganWash.model.Produto;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.*;
import java.sql.*;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Victor
 */
public class BuscarProdutoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resultadobusca.jsp");
            DataSource ds = new DataSource();
            GenericDAO dao = new ProdutoDAO(ds);
            List<Object> lista = dao.read();
            ds.getConnection().close();
            System.out.println("Tamanho da lista = " + lista.size());
            request.setAttribute("Lista", lista);
            System.out.println("Algo deu Errado");
            dispatcher.forward(request, response);
        } catch (Exception ex) {
            System.out.println("Algo deu Errado");
            ex.printStackTrace();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    /*@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resultadobusca.jsp");
            DataSource ds = new DataSource();
            GenericDAO dao = new ProdutoDAO(ds);
            List<Object> lista = dao.read();
            ds.getConnection().close();
            System.out.println("Tamanho da lista = " + lista.size());
            request.setAttribute("Lista", lista);

            dispatcher.forward(request, response);
        } catch (Exception ex) {
            System.out.println("Algo deu Errado");
        }
    }*
    
    /

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
