/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kornk
 */
public class ShoppingListServlet extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                 
        HttpSession session = request.getSession();
        
        String username = (String) session.getAttribute("username");                
        if (username == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
        
        ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");        
        request.setAttribute("items", items);
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
       
        String logout = request.getParameter("logout");
        if (logout != null) {
            logout(request, response, session);
        }
        
        String register = request.getParameter("action");
        if (register != null) {
            String username = request.getParameter("username");
            request.setAttribute("username", username);            
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            //ArrayList<String> items = (String) session.getAttribute("username");
            //register(request, response, session);
        }
    }

    
    private void register() {
        
    }
    
    private void add() {
        
    }
    
    private void delete() {
        
    }
    
    private void logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        session.invalidate();
            request.setAttribute("logout", true);
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

}
