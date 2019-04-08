/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
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
@WebServlet(name = "LoginC", urlPatterns = {"/LoginC"})
public class LoginC extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        String action = request.getParameter("action");
        if (null != action) {
            switch (action) {
                case "login":
                    checkLogin(request);

                    break;
                case "DECONNEXION":

                    doLogout(request);
                    break;

            }

        }
        // On vérifie que l'utilisateur est connecté 
        // On cherche l'attribut userName dans la session
        String userName = findUserInSession(request);
        String jspView = null;
        if (null == userName) {
            
        // L'utilisateur n'est PAS CONNECTE :
        // On redirige vers la page de login
            jspView = "login.jsp";

            
         // L'utilisateur est CONNECTE :
         // Si ce n'est pas un admin
        } else if (!"admin".equals(userName)) { 
         // On redirigera vers la page customer
            jspView = "WEB-INF/customer.jsp";
            
         // Si c'est un admin
         //On redirigera vers la page admin
        } else if ("admin".equals(userName)) {
            jspView = "WEB-INF/admin.jsp";
        }
        // On va vers la redirection choisie
        request.getRequestDispatcher(jspView).forward(request, response);

    }

    private void doLogout(HttpServletRequest request) {
        // FIN DE SESSION
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }

    private void checkLogin(HttpServletRequest request) throws SQLException {

        // CREATION D'UN DAO POUR INTERACTION AVEC BDD
        DAO dao = new DAO();
        CustomerC cC = new CustomerC();

        // ON RECUPERE LES PARAMETRES DE LOGIN.JSP DONT NOUS AVONS BESOIN
        // Le login :
        String loginP = request.getParameter("loginParam");
        // Le Mdp :
        String mdpP = request.getParameter("passwordParam");

        //ADMIN OU CUSTOMER ?
        //Si c'est un admin il remplit les conditions suivantes :
        if ((loginP.equals("admin@admin") && (mdpP.equals("admin")))) {
            //lancement de la session :
            HttpSession session = request.getSession(true);
            //Nom d'utlisateur : "admin"
            session.setAttribute("userName", "admin");
        } //Si les champs ne sont pas vides :
        else if (!"".equals(loginP) && !"".equals(mdpP)) {
            // A IMPLEMENTER :
            Customer c = dao.findCustomerID(loginP);

            //ON RECUPERE LES PARAM DU CUSTOMER : 
            String name = c.getName();
            String login = c.getEmail();
            String mdp = c.getPassword();
            String state = c.getState();
            String city = c.getCity();
            String phoneNumber = c.getPhone();
            String adresse = c.getAddressline1();
            

            //VERIFICATION DE LA CONCORDANDE ENTRE MDP ET LOGIN :
            //Si le mdp et le login correspondent bel et bien :
            if ((login.equals(loginP) && (mdp.equals(mdpP)))) {
                //Lancement de la session
                HttpSession session = request.getSession(true); // démarre la session
                session.setAttribute("userName", name);
                session.setAttribute("userEmail", login);
                session.setAttribute("userPassword", mdp);
                session.setAttribute("userState", state);
                session.setAttribute("userCity", city);
                session.setAttribute("userPhone", phoneNumber);
                session.setAttribute("userAddress", adresse);

            } else if ("".equals(loginP) || "".equals(mdpP)) { // 
                request.setAttribute("errorMessage", "Login ou Password incorrect");
            } else {
                request.setAttribute("errorMessage", "Login ou Password incorrect");
            }

        }

    }

    private String findUserInSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return (session == null) ? null : (String) session.getAttribute("userName");

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoginC.class.getName()).log(Level.SEVERE, null, ex);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoginC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
