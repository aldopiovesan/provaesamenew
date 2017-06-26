/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.presentation;

import com.mycompany.provaesame.Messaggi;
import com.mycompany.service.MessaggioService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tss
 */
@WebServlet(urlPatterns = {"/delete"})
public class Delete extends HttpServlet {

    @Inject
    MessaggioService messaggioservice;
    
  
    
    

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         int ciop;        
        
         String cip = request.getParameter("idMex");  //mi arriva una stringa.
         
         ciop = Integer.parseInt(cip);
        
       Messaggi mg = messaggioservice.findbyId(ciop);
        
        messaggioservice.delete(mg);
        
        response.sendRedirect("ListaMessaggi.jsp");
        
        
        
        
        
        
        
    }

   

    

}
