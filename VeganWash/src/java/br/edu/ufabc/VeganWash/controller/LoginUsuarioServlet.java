/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufabc.VeganWash.controller;

import br.edu.ufabc.VeganWash.dao.DataSource;
import br.edu.ufabc.VeganWash.dao.GenericDAO;
import br.edu.ufabc.VeganWash.dao.UsuarioDAO;
import br.edu.ufabc.VeganWash.model.Endereco;
import br.edu.ufabc.VeganWash.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Victor
 */
public class LoginUsuarioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String paginaDestino = "/login.jsp";
        try {
            String userEmail = request.getParameter("txtEmail");
            String userSenha = request.getParameter("txtSenha");
            Usuario usuario = new Usuario();
            usuario.setEmail(userEmail);
            usuario.setSenha(userSenha);

            DataSource dataSource = new DataSource();
            UsuarioDAO userDao = new UsuarioDAO(dataSource);
            boolean status = userDao.Login(usuario);
            if (status == true) {
                paginaDestino = "/pesquisaprodutos.jsp";
                HttpSession session = request.getSession(true);
                session.setAttribute("idUser", usuario.getIdUsuario());
            } else {
                paginaDestino = "/erro.jsp";
            }
            dataSource.getConnection().close();
        } catch (Exception ex) {
            ex.printStackTrace();
            paginaDestino = "/erro.jsp";
        } finally {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
            dispatcher.forward(request, response);
        }
    }

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
