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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "ponencias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ponencias.findAll", query = "SELECT p FROM Ponencias p"),
    @NamedQuery(name = "Ponencias.findByIdponencias", query = "SELECT p FROM Ponencias p WHERE p.idponencias = :idponencias"),
    @NamedQuery(name = "Ponencias.findByFechaRealizado", query = "SELECT p FROM Ponencias p WHERE p.fechaRealizado = :fechaRealizado"),
    @NamedQuery(name = "Ponencias.findByNombre", query = "SELECT p FROM Ponencias p WHERE p.nombre = :nombre")})
public class Ponencias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idponencias")
    private Integer idponencias;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_realizado")
    @Temporal(TemporalType.DATE)
    private Date fechaRealizado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @ManyToMany(mappedBy = "ponenciasCollection")
    private Collection<Investigador> investigadorCollection;
    @JoinColumn(name = "evento_idevento", referencedColumnName = "idevento")
    @ManyToOne(optional = false)
    private Evento eventoIdevento;

    public Ponencias() {
    }

    public Ponencias(Integer idponencias) {
        this.idponencias = idponencias;
    }

    public Ponencias(Integer idponencias, Date fechaRealizado, String nombre) {
        this.idponencias = idponencias;
        this.fechaRealizado = fechaRealizado;
        this.nombre = nombre;
    }

    public Integer getIdponencias() {
        return idponencias;
    }

    public void setIdponencias(Integer idponencias) {
        this.idponencias = idponencias;
    }

    public Date getFechaRealizado() {
        return fechaRealizado;
    }

    public void setFechaRealizado(Date fechaRealizado) {
        this.fechaRealizado = fechaRealizado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Investigador> getInvestigadorCollection() {
        return investigadorCollection;
    }

    public void setInvestigadorCollection(Collection<Investigador> investigadorCollection) {
        this.investigadorCollection = investigadorCollection;
    }

    public Evento getEventoIdevento() {
        return eventoIdevento;
    }

    public void setEventoIdevento(Evento eventoIdevento) {
        this.eventoIdevento = eventoIdevento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idponencias != null ? idponencias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ponencias)) {
            return false;
        }
        Ponencias other = (Ponencias) object;
        if ((this.idponencias == null && other.idponencias != null) || (this.idponencias != null && !this.idponencias.equals(other.idponencias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
