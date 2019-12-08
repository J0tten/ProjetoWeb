/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufabc.VeganWash.controller;

import br.edu.ufabc.VeganWash.dao.DataSource;
import br.edu.ufabc.VeganWash.dao.FornecedorDAO;
import br.edu.ufabc.VeganWash.dao.GenericDAO;
import br.edu.ufabc.VeganWash.dao.LimpezaDAO;
import br.edu.ufabc.VeganWash.dao.ProdutoDAO;
import br.edu.ufabc.VeganWash.dao.UsuarioDAO;
import br.edu.ufabc.VeganWash.model.Endereco;
import br.edu.ufabc.VeganWash.model.Fornecedor;
import br.edu.ufabc.VeganWash.model.Limpeza;
import br.edu.ufabc.VeganWash.model.Produto;
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
 * @author GUILHERME
 */
public class CriarProdutoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String paginaDestino = "/index.jsp";
        try {
            HttpSession session = request.getSession(true);
            String prodNome = request.getParameter("prodNome");
            double prodValorM2 = Double.parseDouble(request.getParameter("valorm2"));
            String getLavagem = request.getParameter("dropLavagem");
            String lavagem = getLavagem.trim();
            

            Produto produto = new Produto();
            produto.setNomeProduto(prodNome);
            produto.setValorM2(prodValorM2);
            
            // tratar endereços
            Fornecedor forn = new Fornecedor();
            forn.setEmail((String) session.getAttribute("emailForn"));
            String email = forn.getEmail();
           

            DataSource dataSource = new DataSource();
            LimpezaDAO limpDao = new LimpezaDAO(dataSource);
            FornecedorDAO fornDao = new FornecedorDAO(dataSource);
            Limpeza dadosLimp = (Limpeza) limpDao.read(lavagem);
            System.out.println(getLavagem+"FDP");
            System.out.println(lavagem+"FDP1");
            System.out.println(email+"FDP");
            
            
            Fornecedor dadosForn = (Fornecedor) fornDao.read(email);
            
            
            
            ProdutoDAO prodDao = new ProdutoDAO(dataSource);
            produto.setFornecedor(dadosForn);
            prodDao.create(produto);
            dataSource.getConnection().close();
            paginaDestino = "/sucesso.jsp";
        } catch (Exception ex) {
            ex.printStackTrace();
            paginaDestino = "/erro.jsp";
        } finally {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
            dispatcher.forward(request, response);
        }
    }
}
