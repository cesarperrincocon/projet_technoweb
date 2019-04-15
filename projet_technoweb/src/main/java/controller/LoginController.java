/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
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
import model.DiscountCode;
import model.PurchaseOrder;

/**
 *
 * @author ejaffre
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        // ON RECUPERE LA VALEUR DU PARAMETRE ACTION DANS LE JSP
        String action = request.getParameter("connexion");
        if (null != action) {
            switch (action) {
                case "connexion":
                    //SI C'EST UNE CONNEXION ON CHECK LE LOGIN
                    checkLogin(request);
                    break;
                    
                case "DECONNEXION":
                    //SI C'EST UNE DECONNEXION ON LANCE LE PROCESSUS DE DECONNEXION   
                    doLogout(request);
                    break;

            }
        }

        // UTILISATEUR CONNECTÉ ?
        // ON CHERCHE L'ATTRIBUT 'userName'
        String userName = findUserInSession(request);
        String jspView = null;
        if (null == userName) {
        // UTILISATEUR PAS CONNECTÉ :
            
            // ON ORIENTE VERS LA VUE LOGIN.JSP
            jspView = "Dashio/login.jsp";
            
        // UTILISATEUR CONNECTÉ
        } else if (!"admin".equals(userName)) { 
            // SI CE N'EST PAS UN ADMIN ON ORIENTE VERS LA VUE USER.JSP
            jspView = "Dashio/user.jsp";
        } else if ("admin".equals(userName)) {
            // SI C'EST UN ADMIN ON ORIENTE VERS LA VUE ADMIN.JSP
            jspView = "Dashio/admin.jsp";
        }
        
        // ON CHARGE LA PAGE CHOISIE
        request.getRequestDispatcher(jspView).forward(request, response);

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

    private void checkLogin(HttpServletRequest request) throws SQLException {
        // ON CRÉE UN DAO POUR INTERAGIR AVEC LA BDD
        DAO dao = new DAO();
       
        // ON RECUPERE LES LOGIN ET PASSWORD ENTRÉS
        String loginParam = request.getParameter("loginParam");
        String passwordParam = request.getParameter("passwordParam");
        
        // ADMIN QUI SE CONNECTE ?
        if ((loginParam.equals("admin@admin") && (passwordParam.equals("admin")))) {
            // RECHERCHE DE LA COMBINAISON LOGIN/MDP
            // ON STOCK L'INFORMATION DANS LA SESSION
            HttpSession session = request.getSession(true); //DEMARRAGE DE LA SESSION
            session.setAttribute("userName", "admin");
            
        } else if (!"".equals(loginParam) && !"".equals(passwordParam)) {
            Customer c = dao.findCustomerID(loginParam);
            String login = c.getEmail();
            String password = c.getPassword();
            String userName = c.getName();
            String phone = c.getPhone();
            String address = c.getAddressline1();

            // SI LE LOGIN ET LE MDP CORRESPONDENT
            if ((login.equals(loginParam) && (password.equals(passwordParam)))) {
                
                // ON STOCK LES INFOS DANS LA SESSION
                //DEMARRAGE DE LA SESSION
                HttpSession session = request.getSession(true);
                session.setAttribute("userName", userName);
                session.setAttribute("userEmail", login);
                session.setAttribute("userPassword", password);
                session.setAttribute("userAddress", address);
                session.setAttribute("userPhone", phone);
                session.setAttribute("commandes", dao.customerCommandes(c));
                ArrayList<String> des = dao.allProduct();
                request.setAttribute("listeProduits", des);
                Double solde = dao.soldeClient(Integer.parseInt(password));
                session.setAttribute("solde", solde);
                session.setAttribute("codes", viewCodes(request));
                
                //MESSAGE D'ERREUR
            } else if (login.equals("nodata")) {
                request.setAttribute("errorMessage", "Login/Password incorrect");
            } else if ("".equals(loginParam) || "".equals(passwordParam)) { // On positionne un message d'erreur pour l'afficher dans la JSP
                request.setAttribute("errorMessage", "Login/Password incorrect");
            } else {
                request.setAttribute("errorMessage", "Login/Password incorrect");
            }
        }

        
    }

    private void doLogout(HttpServletRequest request) {
        // FIN DE SESSION
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }

    private String findUserInSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return (session == null) ? null : (String) session.getAttribute("userName");
    }

    public List<PurchaseOrder> viewCommandes(HttpServletRequest request) throws SQLException {
        List<PurchaseOrder> result = new LinkedList<>();
        DAO dao = new DAO();
        HttpSession session = request.getSession();
        String password = ((String) session.getAttribute("userPassword"));
        Customer c = new Customer();
        c.setPassword(password);
        result = dao.customerCommandes(c);
        return result;
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
