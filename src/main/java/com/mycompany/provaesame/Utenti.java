/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.provaesame;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tss
 */
@Entity
@Table(name = "utenti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utenti.findAll", query = "SELECT u FROM Utenti u")
    , @NamedQuery(name = "Utenti.findByIdUtente", query = "SELECT u FROM Utenti u WHERE u.idUtente = :idUtente")
    , @NamedQuery(name = "Utenti.findByEmail", query = "SELECT u FROM Utenti u WHERE u.email = :email")
    , @NamedQuery(name = "Utenti.findByUser", query = "SELECT u FROM Utenti u WHERE u.user = :user")
    , @NamedQuery(name = "Utenti.findByPwd", query = "SELECT u FROM Utenti u WHERE u.pwd = :pwd")
    , @NamedQuery(name = "Utenti.find", query = "SELECT u FROM Utenti u WHERE u.pwd = :pwd and u.user = :user")

})
public class Utenti implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_utente")
    private Integer idUtente;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "user")
    private String user;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pwd")
    private String pwd;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUtente")
    private Collection<Messaggi> messaggiCollection;

    public Utenti() {
    }

    public Utenti(Integer idUtente) {
        this.idUtente = idUtente;
    }

    public Utenti(Integer idUtente, String email, String user, String pwd) { //serve x creare l'utente registrato
        this.email = email;
        this.user = user;
        this.pwd = pwd;
    }
    
    public Utenti(String user, String pwd) { // serve x creare il l'utente loggato
        this.user = user;
        this.pwd = pwd;
    }

    public Integer getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(Integer idUtente) {
        this.idUtente = idUtente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @XmlTransient
    public Collection<Messaggi> getMessaggiCollection() {
        return messaggiCollection;
    }

    public void setMessaggiCollection(Collection<Messaggi> messaggiCollection) {
        this.messaggiCollection = messaggiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUtente != null ? idUtente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utenti)) {
            return false;
        }
        Utenti other = (Utenti) object;
        if ((this.idUtente == null && other.idUtente != null) || (this.idUtente != null && !this.idUtente.equals(other.idUtente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.provaesame.Utenti[ idUtente=" + idUtente + "pwd="+pwd+ " ,user="+user+ " ]";
    }
    
}
