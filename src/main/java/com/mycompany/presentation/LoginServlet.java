/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.presentation;

import com.mycompany.provaesame.Utenti;
import com.mycompany.service.FiltroUtente;
import com.mycompany.service.UtenteService;
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
@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    
    
    @Inject
    UtenteService utenteservice;
    
    @Inject
    FiltroUtente filtroUtente;
    
    
    
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
       
        
        String str = request.getParameter("user");
        
        String str2 = request.getParameter("password");
        
        Utenti ut = utenteservice.find(str, str2);
        
        
        if (str==null && str2==null){
                
              response.sendRedirect("Login.jsp"); // serve per ricaricare la pagina, response=risposta server
                
                }
        
        
        
       if (ut==null){
           
            response.sendRedirect("Login.jsp");
           
       }else{
                      
            filtroUtente.setUt(ut);
            response.sendRedirect("ListaMessaggi.jsp");
            
       };
        
        
      
       /*una volta che il controllo sulla pwd e sullo user è verificato, devo salvare i dati in modo tale 
         da poter risalire al contenuto del mio profilo.
       Per fare cio devo richiamare il costruttore con pwd e user e creare un utente dentro l'if, dopodiche
       setto quei valori attraverso il FiltroUtente passandogli un ut...la classe che mi permette di salvare m
       moentaneamente l'utente(sessionscoped=sessione) è filtro utente.
         
       */
       
       
        
         
                 
                
        
        
        
        
        
        
    }
    

  

}
