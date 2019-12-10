/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufabc.VeganWash.controller;

import br.edu.ufabc.VeganWash.dao.DataSource;
import br.edu.ufabc.VeganWash.dao.PedidoDAO;
import br.edu.ufabc.VeganWash.model.Carrinho;
import br.edu.ufabc.VeganWash.model.ItemCarrinho;
import br.edu.ufabc.VeganWash.model.Produto;
import br.edu.ufabc.VeganWash.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Victor
 */
public class FinalizarCarrinhoServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FinalizarCarrinhoServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FinalizarCarrinhoServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        Carrinho carrinho;
        carrinho = (Carrinho) request.getSession().getAttribute("Carrinho");
        DataSource dataSource = new DataSource();
        PedidoDAO pedDao = new PedidoDAO(dataSource);
        List<ItemCarrinho> it = carrinho.getItens();
        Usuario usuario = (Usuario) request.getSession().getAttribute("user");
        int idUser = usuario.getIdUsuario();
        
        for(int i=0; i<it.size(); i++){
           pedDao.create(it.get(i).getProduto(), idUser, it.get(i).getM2());
        }
        request.getSession().setAttribute("Carrinho", carrinho);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pedidofinalizado.jsp");
        dispatcher.forward(request, response);
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
