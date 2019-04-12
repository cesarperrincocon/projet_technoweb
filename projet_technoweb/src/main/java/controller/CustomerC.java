/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
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
import model.Product;

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
                    request.getRequestDispatcher("/Dashio/lib/user.jsp").forward(request, response);
                    break;

                //SUPPRESSION D'UNE COMMANDE
                case "DELETE_COMMANDE":
                    try {
                        dao.deleteCommande(Integer.parseInt(purchaseToDelete));
                        session.setAttribute("commandes", dao.customerCommandes(c));
                        solde = dao.soldeClient(Integer.parseInt(password));
                        session.setAttribute("solde", solde);
                        request.setAttribute("message", "Commande " + purchaseToDelete + " supprimée !");
                        request.getRequestDispatcher("/Dashio/lib/user.jsp").forward(request, response);
                    } catch (SQLIntegrityConstraintViolationException e) {
                        request.setAttribute("messageErreur", "Impossible de supprimer " + purchaseToDelete + ", cette commande est utilisée.");
                    }
                    break;

                //MODIFICATION D'UNE COMMANDE
                case "EDIT_COMMANDE":
                    try {
                        String quantityToEdit = request.getParameter("quantityToEdit");
                        dao.editCommande(Integer.parseInt(purchaseToEdit), Integer.parseInt(quantityToEdit), Integer.parseInt(password));
                        if (dao.editCommande(Integer.parseInt(purchaseToEdit), Integer.parseInt(quantityToEdit), Integer.parseInt(password))) {
                            request.setAttribute("message", "Commande " + purchaseToEdit + " modifiée !");
                        } else {
                            request.setAttribute("message", "Vous n'avez pas assez d'argent pour modifier la commande " + purchaseToEdit);
                        }

                        session.setAttribute("commandes", dao.customerCommandes(c));
                        solde = dao.soldeClient(Integer.parseInt(password));
                        session.setAttribute("solde", solde);
                        request.getRequestDispatcher("/Dashio/lib/user.jsp").forward(request, response);

                    } catch (SQLIntegrityConstraintViolationException e) {
                        request.setAttribute("message", "Impossible de modifier " + purchaseToEdit + ", cette commande est utilisée !");
                    }
                    break;

                //SUPPRESSION D'UNE COMMANDE
                case "DO_VIREMENT":
                    try {
                        int montant = Integer.parseInt(request.getParameter("montant"));
                        dao.virement(Integer.parseInt(password), montant);
                        solde = dao.soldeClient(Integer.parseInt(password));
                        session.setAttribute("solde", solde);
                        request.setAttribute("message", "Virement de : " + montant + "$ réalisé sur votre compte.");
                        request.getRequestDispatcher("/Dashio/lib/user.jsp").forward(request, response);
                    } catch (SQLIntegrityConstraintViolationException e) {
                    }
                    break;

                case "SHOW_PRODUIT":
                    ArrayList<Product> listeProduit = dao.listProduct();
                    session.setAttribute("listeProduit", listeProduit);
                    request.getRequestDispatcher("/Dashio/lib/user.jsp").forward(request, response);
                    break;

                case "SHOW_CLIENT":
                    request.getRequestDispatcher("/Dashio/lib/user.jsp").forward(request, response);
                    break;

            }
        } catch (Exception ex) {
            Logger.getLogger("CustomerC").log(Level.SEVERE, "Action en erreur", ex);
            request.setAttribute("message", ex.getMessage());
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
            Logger.getLogger(CustomerC.class
                    .getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CustomerC.class
                    .getName()).log(Level.SEVERE, null, ex);
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
