/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
            throws ServletException, IOException {
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
    }

    private void doLogout(HttpServletRequest request) {
        // FIN DE SESSION
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }

    private void checkLogin(HttpServletRequest request) {

        // CREATION D'UN DAO POUR INTERACTION AVEC BDD
        DAO dao = new DAO();
        CustomerC cC = new CustomerC();

        // ON RECUPERE LES PARAMETRES DE LOGIN.JSP DONT NOUS AVONS BESOIN
        // Le login :
        String loginP = request.getParameter("NOM_DU_PARAM_DANS_JSP");
        // Le Mdp :
        String mdpP = request.getParameter("NOM_DU_PARAM_DANS_JSP");

        //ADMIN OU CUSTOMER ?
        //Si c'est un admin il remplit les conditions suivantes :
        if ((loginP.equals("admin@admin") && (mdpP.equals("admin")))) {
            //lancement de la session :
            HttpSession session = request.getSession(true);
            //Nom d'utlisateur devient automatiquement "admin"
            session.setAttribute("userName", "admin");
        } //Si les champs ne sont pas vides :
        else if (!"".equals(loginP) && !"".equals(mdpP)) {
            // A IMPLEMENTER :
            Customer c = dao.METHODE_TROUVER_CUSTOMER(loginP);

            //ON RECUPERE LES PARAM DU CUSTOMER : 
            String name = c.getName;
            String login = c.getEmail;
            String mdp = c.getPassword;
            String phoneNumber = c.getPhoneNumber;
            String adresse = c.getAdress;

            //VERIFICATION DE LA CONCORDANDE ENTRE MDP ET LOGIN :
            //Si le mdp et le login correspondent bel et bien :
            if ((login.equals(loginP) && (mdp.equals(mdpP)))) {
                //Lancement de la session
                HttpSession session = request.getSession(true); // démarre la session
                session.setAttribute("userName", name);
                session.setAttribute("userEmail", login);
                session.setAttribute("userPassword", mdp);
                session.setAttribute("userPhone", phoneNumber);
                session.setAttribute("userAddress", adresse);

            } //Si le mdp et le login sont vides
            else if ("".equals(loginP) || "".equals(mdpP)) { // 
                request.setAttribute("errorMessage", "Login/Password incorrect");
            } else {
                request.setAttribute("errorMessage", "Login/Password incorrect");
            }

        }

    }

    private String findCustomer(HttpServletRequest request) {
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
        processRequest(request, response);
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
