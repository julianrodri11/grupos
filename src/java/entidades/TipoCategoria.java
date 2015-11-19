/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

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
 * @author JUANCARLOS
 */
@Entity
@Table(name = "tipo_categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCategoria.findAll", query = "SELECT t FROM TipoCategoria t"),
    @NamedQuery(name = "TipoCategoria.findByIdtipoCategoria", query = "SELECT t FROM TipoCategoria t WHERE t.idtipoCategoria = :idtipoCategoria"),
    @NamedQuery(name = "TipoCategoria.findByNombre", query = "SELECT t FROM TipoCategoria t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TipoCategoria.findByDescripcion", query = "SELECT t FROM TipoCategoria t WHERE t.descripcion = :descripcion")})
public class TipoCategoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipo_categoria")
    private Integer idtipoCategoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoCategoriaIdtipoCategoria")
    private Collection<GruposInvestigacion> gruposInvestigacionCollection;

    public TipoCategoria() {
    }

    public TipoCategoria(Integer idtipoCategoria) {
        this.idtipoCategoria = idtipoCategoria;
    }

    public TipoCategoria(Integer idtipoCategoria, String nombre, String descripcion) {
        this.idtipoCategoria = idtipoCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getIdtipoCategoria() {
        return idtipoCategoria;
    }

    public void setIdtipoCategoria(Integer idtipoCategoria) {
        this.idtipoCategoria = idtipoCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<GruposInvestigacion> getGruposInvestigacionCollection() {
        return gruposInvestigacionCollection;
    }

    public void setGruposInvestigacionCollection(Collection<GruposInvestigacion> gruposInvestigacionCollection) {
        this.gruposInvestigacionCollection = gruposInvestigacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoCategoria != null ? idtipoCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCategoria)) {
            return false;
        }
        TipoCategoria other = (TipoCategoria) object;
        if ((this.idtipoCategoria == null && other.idtipoCategoria != null) || (this.idtipoCategoria != null && !this.idtipoCategoria.equals(other.idtipoCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
