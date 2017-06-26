/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.provaesame.Utenti;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



/**
 *
 * @author tss
 */


@Stateless
@Named("ut")

public class UtenteService {
    
    @PersistenceContext
    EntityManager em;
    
    public List<Utenti>  findAll(){
        
        return em.createNamedQuery("Messaggi.findAll")
                .getResultList();
    }
    
    
    public Utenti save (Utenti tosave){
        
        return em.merge(tosave);
    }
    
    
    public Utenti find(String user, String password){
        
     List<Utenti> utentetrovato = em.createNamedQuery("Utenti.find")
                .setParameter("user", user)
                .setParameter("pwd", password)
                .getResultList();
              
     if (utentetrovato.isEmpty()==true){
         
         return null;
     }
         return utentetrovato.get(0)  ;  //prendo l'utente 0 della lista creata, cioe quello con user =user e pwd= password
    }
    
    
}