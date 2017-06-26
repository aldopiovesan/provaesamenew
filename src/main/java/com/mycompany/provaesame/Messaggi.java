/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.provaesame;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tss
 */
@Entity
@Table(name = "messaggi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Messaggi.findAll", query = "SELECT m FROM Messaggi m")
    , @NamedQuery(name = "Messaggi.findByIdMessaggio", query = "SELECT m FROM Messaggi m WHERE m.idMessaggio = :idMessaggio")
    , @NamedQuery(name = "Messaggi.findByContenuto", query = "SELECT m FROM Messaggi m WHERE m.contenuto = :contenuto")
    , @NamedQuery(name = "Messaggi.findByDataCrezione", query = "SELECT m FROM Messaggi m WHERE m.dataCrezione = :dataCrezione")
    , @NamedQuery(name = "Messaggi.findByUser", query = "SELECT m FROM Messaggi m WHERE m.idUtente = :idUtente") // mi creo la query per far comparire i messaggi di quell'utente, attraverso la chiave ossia idUtente.
//devo inoltre settare :idUtente, in quanto nn è ancora presente sotto forma di variabile.
})
public class Messaggi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_messaggio")
    private Integer idMessaggio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "contenuto")
    private String contenuto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_crezione")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCrezione = new Date();
    @JoinColumn(name = "id_utente", referencedColumnName = "id_utente")
    @ManyToOne(optional = false)
    private Utenti idUtente; //idUtente è la chiave x risalire all'entity utente

    public Messaggi() {
    }

    public Messaggi(Integer idMessaggio) {
        this.idMessaggio = idMessaggio;
    }

    public Messaggi(String contenuto, Utenti t) {
        
        this.contenuto = contenuto;
        this.idUtente = t;
    
    }

    public Integer getIdMessaggio() {
        return idMessaggio;
    }

    public void setIdMessaggio(Integer idMessaggio) {
        this.idMessaggio = idMessaggio;
    }

    public String getContenuto() {
        return contenuto;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    public Date getDataCrezione() {
        return dataCrezione;
    }

    public void setDataCrezione(Date dataCrezione) {
        this.dataCrezione = dataCrezione;
    }

    public Utenti getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(Utenti idUtente) {
        this.idUtente = idUtente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMessaggio != null ? idMessaggio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Messaggi)) {
            return false;
        }
        Messaggi other = (Messaggi) object;
        if ((this.idMessaggio == null && other.idMessaggio != null) || (this.idMessaggio != null && !this.idMessaggio.equals(other.idMessaggio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.provaesame.Messaggi[ idMessaggio=" + idMessaggio + " ]";
    }
    
}
