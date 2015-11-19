/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JUANCARLOS
 */
@Entity
@Table(name = "formacion_academica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormacionAcademica.findAll", query = "SELECT f FROM FormacionAcademica f"),
    @NamedQuery(name = "FormacionAcademica.findByIdformacionAcademica", query = "SELECT f FROM FormacionAcademica f WHERE f.idformacionAcademica = :idformacionAcademica"),
    @NamedQuery(name = "FormacionAcademica.findByNombre", query = "SELECT f FROM FormacionAcademica f WHERE f.nombre = :nombre"),
    @NamedQuery(name = "FormacionAcademica.findByAnioInicio", query = "SELECT f FROM FormacionAcademica f WHERE f.anioInicio = :anioInicio"),
    @NamedQuery(name = "FormacionAcademica.findByAnioFinalizacion", query = "SELECT f FROM FormacionAcademica f WHERE f.anioFinalizacion = :anioFinalizacion")})
public class FormacionAcademica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idformacion_academica")
    private Integer idformacionAcademica;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anio_inicio")
    @Temporal(TemporalType.DATE)
    private Date anioInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anio_finalizacion")
    @Temporal(TemporalType.DATE)
    private Date anioFinalizacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formacionAcademicaIdformacionAcademica")
    private Collection<Investigador> investigadorCollection;

    public FormacionAcademica() {
    }

    public FormacionAcademica(Integer idformacionAcademica) {
        this.idformacionAcademica = idformacionAcademica;
    }

    public FormacionAcademica(Integer idformacionAcademica, Date anioInicio, Date anioFinalizacion) {
        this.idformacionAcademica = idformacionAcademica;
        this.anioInicio = anioInicio;
        this.anioFinalizacion = anioFinalizacion;
    }

    public Integer getIdformacionAcademica() {
        return idformacionAcademica;
    }

    public void setIdformacionAcademica(Integer idformacionAcademica) {
        this.idformacionAcademica = idformacionAcademica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getAnioInicio() {
        return anioInicio;
    }

    public void setAnioInicio(Date anioInicio) {
        this.anioInicio = anioInicio;
    }

    public Date getAnioFinalizacion() {
        return anioFinalizacion;
    }

    public void setAnioFinalizacion(Date anioFinalizacion) {
        this.anioFinalizacion = anioFinalizacion;
    }

    @XmlTransient
    public Collection<Investigador> getInvestigadorCollection() {
        return investigadorCollection;
    }

    public void setInvestigadorCollection(Collection<Investigador> investigadorCollection) {
        this.investigadorCollection = investigadorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idformacionAcademica != null ? idformacionAcademica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormacionAcademica)) {
            return false;
        }
        FormacionAcademica other = (FormacionAcademica) object;
        if ((this.idformacionAcademica == null && other.idformacionAcademica != null) || (this.idformacionAcademica != null && !this.idformacionAcademica.equals(other.idformacionAcademica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
