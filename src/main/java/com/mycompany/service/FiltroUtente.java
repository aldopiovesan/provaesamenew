 package com.mycompany.service;

import com.mycompany.provaesame.Utenti;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tss
 */
@SessionScoped

public class FiltroUtente implements Serializable {
    
    @Inject
    Utenti u;
    
    private Utenti ut;   //serve per salvare i dati dell'utente, perche3 dopo qwuando faccio la login nella servlet vado a settarlo

    public Utenti getUt() {
        return ut;
    }

    public void setUt(Utenti ut) {
        this.ut = ut;
    }
      
} 


