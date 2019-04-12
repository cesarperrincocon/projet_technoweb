/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Customer;
import model.DAO;

/**
 *
 * @author ejaffre
 */
@WebServlet(name = "CustomerC", urlPatterns = {"/CustomerC"})
public class CustomerC extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        HttpSession session = request.getSession();
        DAO dao = new DAO();
        String action = request.getParameter("action");
        action = (action == null) ? "" : action;

        //POUR AJOUT DE COMMANDE :
        //Quelle quantité
        String quantite = request.getParameter("quantite");
        ArrayList<String> lproduits = dao.allProduct();
        request.setAttribute("listeProduits", lproduits);

        // POUR SUPPRIMER DES COMMANDES :
        //Commande à supprimer :
        String purchaseToDelete = request.getParameter("purchaseToDelete"); //param dans JSP
        String password = ((String) session.getAttribute("userPassword"));

        // POUR EDITER DES COMMANDES :
        String purchaseToEdit = request.getParameter("purchaseToEdit"); //param dans JSP

        // INFORMATION CLIENT
        Double solde = dao.soldeClient(Integer.parseInt(password));
        session.setAttribute("solde", solde);

        // request.setAttribute("code", viewCodes(request));
        try {
            Customer c = new Customer();
            c.setPassword(password);

            switch (action) {

                //AJOUT D'UNE COMMANDE
                case "ADD_COMMANDE":
                    dao.addCommande(Integer.parseInt(password), Integer.parseInt(quantite), dao.numProduct(request.getParameter("produit")));
                    session.setAttribute("commandes", dao.customerCommandes(c));
                    solde = dao.soldeClient(Integer.parseInt(password));
                    session.setAttribute("solde", solde);
                    request.setAttribute("message", "Commande de " + quantite + " '" + request.getParameter("produit") + "'" + " effectuée !");
                    request.getRequestDispatcher("Dashio/lib/basic_table.html").forward(request, response);
                    break;
                case "DELETE_COMMANDE" :
                    try {
                        dao.deleteCommande(Integer.parseInt(purchaseToDelete));
                        
                    }
            }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerC.class.getName()).log(Level.SEVERE, null, ex);
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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerC.class.getName()).log(Level.SEVERE, null, ex);
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
