/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sidc.vista;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author julian
 */
@Entity
@Table(name = "alergia", catalog = "sidc_2", schema = "")
@NamedQueries({
    @NamedQuery(name = "Alergia.findAll", query = "SELECT a FROM Alergia a")
    , @NamedQuery(name = "Alergia.findByIdAlergia", query = "SELECT a FROM Alergia a WHERE a.idAlergia = :idAlergia")
    , @NamedQuery(name = "Alergia.findByNombre", query = "SELECT a FROM Alergia a WHERE a.nombre = :nombre")})
public class Alergia implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_alergia")
    private Integer idAlergia;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;

    public Alergia() {
    }

    public Alergia(Integer idAlergia) {
        this.idAlergia = idAlergia;
    }

    public Alergia(Integer idAlergia, String nombre) {
        this.idAlergia = idAlergia;
        this.nombre = nombre;
    }

    public Integer getIdAlergia() {
        return idAlergia;
    }

    public void setIdAlergia(Integer idAlergia) {
        Integer oldIdAlergia = this.idAlergia;
        this.idAlergia = idAlergia;
        changeSupport.firePropertyChange("idAlergia", oldIdAlergia, idAlergia);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        changeSupport.firePropertyChange("nombre", oldNombre, nombre);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlergia != null ? idAlergia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alergia)) {
            return false;
        }
        Alergia other = (Alergia) object;
        if ((this.idAlergia == null && other.idAlergia != null) || (this.idAlergia != null && !this.idAlergia.equals(other.idAlergia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sidc.vista.Alergia[ idAlergia=" + idAlergia + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
