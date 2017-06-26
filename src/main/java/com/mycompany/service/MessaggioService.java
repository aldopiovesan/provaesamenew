/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.provaesame.Messaggi;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tss
 */

@Stateless
@Named("msg")

public class MessaggioService {
    
    
    @Inject
    FiltroUtente filtroutente;
    
    
    @PersistenceContext
    EntityManager em;
    
    public List<Messaggi>  findAll(){
        
        return em.createNamedQuery("Messaggi.findAll")
                .getResultList();
    }
    
    
    public List<Messaggi> findbyUser(){
        System.out.println(filtroutente.getUt());
        filtroutente.getUt(); //devo leggere i dati immessi sul filtro, essi sono gia salvati sul setUt
        return em.createNamedQuery("Messaggi.findByUser")
                .setParameter("idUtente", filtroutente.getUt())
                .getResultList(); //condizione utile per trovare i messaggi in base al mio idUtente
      
       
        //prendo dati in lettura, mi ritorna la query creata in entity, setto il parametro che mi filtra la query ("idUtente), prendo il risultato della lista di messaggi.
    }
    
    
    public Messaggi save (Messaggi tosave){
        
        return em.merge(tosave);
    }
    
    public void delete(Messaggi todelete){
        
         em.remove(todelete);
    }
    
    
    public Messaggi findbyId(Integer idMex){
        
        List<Messaggi> mex = em.createNamedQuery("Messaggi.findByIdMessaggio")
                .setParameter("idMessaggio", idMex)
                .getResultList();
        
        return mex.get(0);        
    
}
    
    
}
