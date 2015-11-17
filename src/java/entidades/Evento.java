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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "evento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e"),
    @NamedQuery(name = "Evento.findByIdevento", query = "SELECT e FROM Evento e WHERE e.idevento = :idevento"),
    @NamedQuery(name = "Evento.findByNombre", query = "SELECT e FROM Evento e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Evento.findByLugarRealizacion", query = "SELECT e FROM Evento e WHERE e.lugarRealizacion = :lugarRealizacion"),
    @NamedQuery(name = "Evento.findByFechaInicio", query = "SELECT e FROM Evento e WHERE e.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Evento.findByFechaFinalizacion", query = "SELECT e FROM Evento e WHERE e.fechaFinalizacion = :fechaFinalizacion"),
    @NamedQuery(name = "Evento.findByCaracter", query = "SELECT e FROM Evento e WHERE e.caracter = :caracter")})
public class Evento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idevento")
    private Integer idevento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "lugar_realizacion")
    private String lugarRealizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_finalizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaFinalizacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "caracter")
    private String caracter;
    @JoinColumn(name = "tipo_evento_idtipo_evento", referencedColumnName = "idtipo_evento")
    @ManyToOne(optional = false)
    private TipoEvento tipoEventoIdtipoEvento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventoIdevento")
    private Collection<Ponencias> ponenciasCollection;

    public Evento() {
    }

    public Evento(Integer idevento) {
        this.idevento = idevento;
    }

    public Evento(Integer idevento, String nombre, String lugarRealizacion, Date fechaInicio, Date fechaFinalizacion, String caracter) {
        this.idevento = idevento;
        this.nombre = nombre;
        this.lugarRealizacion = lugarRealizacion;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        this.caracter = caracter;
    }

    public Integer getIdevento() {
        return idevento;
    }

    public void setIdevento(Integer idevento) {
        this.idevento = idevento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugarRealizacion() {
        return lugarRealizacion;
    }

    public void setLugarRealizacion(String lugarRealizacion) {
        this.lugarRealizacion = lugarRealizacion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public String getCaracter() {
        return caracter;
    }

    public void setCaracter(String caracter) {
        this.caracter = caracter;
    }

    public TipoEvento getTipoEventoIdtipoEvento() {
        return tipoEventoIdtipoEvento;
    }

    public void setTipoEventoIdtipoEvento(TipoEvento tipoEventoIdtipoEvento) {
        this.tipoEventoIdtipoEvento = tipoEventoIdtipoEvento;
    }

    @XmlTransient
    public Collection<Ponencias> getPonenciasCollection() {
        return ponenciasCollection;
    }

    public void setPonenciasCollection(Collection<Ponencias> ponenciasCollection) {
        this.ponenciasCollection = ponenciasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idevento != null ? idevento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.idevento == null && other.idevento != null) || (this.idevento != null && !this.idevento.equals(other.idevento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Evento[ idevento=" + idevento + " ]";
    }
    
}
