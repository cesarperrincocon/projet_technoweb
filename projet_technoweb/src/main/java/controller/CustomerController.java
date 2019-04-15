package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
import model.DataSourceFactory;
import model.DiscountCode;
import model.Product;
import model.PurchaseOrder;

/**
 *
 * @author ejaffre
 */
@WebServlet(name = "customerController", urlPatterns = {"/customerController"})
public class CustomerController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        HttpSession session = request.getSession();
        DAO dao = new DAO();
        String action = request.getParameter("action");
        action = (action == null) ? "" : action; 

        //POUR AJOUTER DES COMMANDES
        String quantite = request.getParameter("quantite");
        ArrayList<String> des = dao.allProduct();
        request.setAttribute("listeProduits", des);

        // POUR SUPPRIMER DES COMMANDES
        String purchaseToDelete = request.getParameter("purchaseToDelete");
        String password = ((String) session.getAttribute("userPassword"));

        //POUR EDITER DES COMMANDES
        String purchaseToEdit = request.getParameter("purchaseToEdit");

        // INFORMATIONS SUR LE CLIENT
        Double solde = dao.soldeClient(Integer.parseInt(password));
        session.setAttribute("solde", solde);

        request.setAttribute("codes", viewCodes(request));
        try {

            Customer c = new Customer();
            c.setPassword(password);
            
            //ON RECUPERE LA VALEUR DE LA VARIABLE ACTION DANS LE JSP 
            session.setAttribute("codes", viewCodes(request));
            switch (action) {

                // AJOUT DE COMMANDE        
                case "ADD_COMMANDE": // Requête d'ajout (vient du formulaire de saisie)
                    dao.addCommande(Integer.parseInt(password), Integer.parseInt(quantite), dao.numProduct(request.getParameter("produit")));
                    session.setAttribute("commandes", dao.customerCommandes(c));
                    solde = dao.soldeClient(Integer.parseInt(password));
                    session.setAttribute("solde", solde);
                    request.setAttribute("message", "Commande de " + quantite + " '" + request.getParameter("produit") + "'" + " réalisée.");

                    //RELOAD DE LA PAGE
                    request.getRequestDispatcher("/Dashio/user.jsp").forward(request, response);
                    break;

                // SUPPRIMER COMMANDE
                case "DELETE_COMMANDE":
                    try {
                        dao.deleteCommande(Integer.parseInt(purchaseToDelete));

                        session.setAttribute("commandes", dao.customerCommandes(c));
                        solde = dao.soldeClient(Integer.parseInt(password));
                        session.setAttribute("solde", solde);
                        request.setAttribute("message", "Commande " + purchaseToDelete + " Supprimée");
                        
                        //RELOAD DE LA PAGE
                        request.getRequestDispatcher("/Dashio/user.jsp").forward(request, response);

                    } catch (SQLIntegrityConstraintViolationException e) {
                        request.setAttribute("message2", "Impossible de supprimer " + purchaseToDelete + ", cette commande est utilisée.");
                    }
                    break;
                
                //POUR EDITER    
                case "EDIT_COMMANDE":
                    try {
                        String quantityToEdit = request.getParameter("quantityToEdit");
                        dao.editCommande(Integer.parseInt(purchaseToEdit), Integer.parseInt(quantityToEdit), Integer.parseInt(password));
                        if (dao.editCommande(Integer.parseInt(purchaseToEdit), Integer.parseInt(quantityToEdit), Integer.parseInt(password))) {
                            request.setAttribute("message", "Commande " + purchaseToEdit + " modifiée");
                        } else {
                            request.setAttribute("message", "Vous n'avez pas assez d'argent pour modifier la commande " + purchaseToEdit);
                        }

                        session.setAttribute("commandes", dao.customerCommandes(c));
                        solde = dao.soldeClient(Integer.parseInt(password));
                        session.setAttribute("solde", solde);
                        
                        //RELOAD DE LA PAGE
                        request.getRequestDispatcher("/Dashio/user.jsp").forward(request, response);

                    } catch (SQLIntegrityConstraintViolationException e) {
                        request.setAttribute("message", "Impossible de modifier " + purchaseToEdit + ", cette commande est utilisée.");
                    }
                    break;
                    
                // VIREMENT    
                case "DO_VIREMENT":
                    try {
                        int montant = Integer.parseInt(request.getParameter("montant"));
                        dao.virement(Integer.parseInt(password), montant);
                        solde = dao.soldeClient(Integer.parseInt(password));
                        session.setAttribute("solde", solde);
                        request.setAttribute("message", "Virement de : " + montant + "$ réalisé sur votre compte.");
                        
                        //RELOAD DE LA PAGE
                        request.getRequestDispatcher("/Dashio/user.jsp").forward(request, response);
                    } catch (SQLIntegrityConstraintViolationException e) {

                    }
                    break;

              
                case "SHOW_CLIENT":
                    request.getRequestDispatcher("/Dashio/user.jsp").forward(request, response);
                    break;

            }
        } catch (Exception ex) {
            Logger.getLogger("customerController").log(Level.SEVERE, "Action en erreur", ex);
            request.setAttribute("message", ex.getMessage());
        }

        // UTILISATEUR CONNECTE ?
        request.getRequestDispatcher("/Dashio/user.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<DiscountCode> viewCodes(HttpServletRequest request) throws SQLException {
        List<DiscountCode> result = new LinkedList<>();
        DAO dao = new DAO();
        HttpSession session = request.getSession();
        String password = ((String) session.getAttribute("userPassword"));
        Customer c = new Customer();
        c.setPassword(password);
        result = dao.customerCodes(c);

        return result;
    }

}
