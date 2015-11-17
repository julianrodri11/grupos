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
@Table(name = "revista")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Revista.findAll", query = "SELECT r FROM Revista r"),
    @NamedQuery(name = "Revista.findByIdrevista", query = "SELECT r FROM Revista r WHERE r.idrevista = :idrevista"),
    @NamedQuery(name = "Revista.findByNombre", query = "SELECT r FROM Revista r WHERE r.nombre = :nombre"),
    @NamedQuery(name = "Revista.findByIndexada", query = "SELECT r FROM Revista r WHERE r.indexada = :indexada"),
    @NamedQuery(name = "Revista.findByCategorizacion", query = "SELECT r FROM Revista r WHERE r.categorizacion = :categorizacion")})
public class Revista implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idrevista")
    private Integer idrevista;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "indexada")
    private String indexada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "categorizacion")
    private String categorizacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "revistaIdrevista")
    private Collection<Articulo> articuloCollection;

    public Revista() {
    }

    public Revista(Integer idrevista) {
        this.idrevista = idrevista;
    }

    public Revista(Integer idrevista, String nombre, String indexada, String categorizacion) {
        this.idrevista = idrevista;
        this.nombre = nombre;
        this.indexada = indexada;
        this.categorizacion = categorizacion;
    }

    public Integer getIdrevista() {
        return idrevista;
    }

    public void setIdrevista(Integer idrevista) {
        this.idrevista = idrevista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIndexada() {
        return indexada;
    }

    public void setIndexada(String indexada) {
        this.indexada = indexada;
    }

    public String getCategorizacion() {
        return categorizacion;
    }

    public void setCategorizacion(String categorizacion) {
        this.categorizacion = categorizacion;
    }

    @XmlTransient
    public Collection<Articulo> getArticuloCollection() {
        return articuloCollection;
    }

    public void setArticuloCollection(Collection<Articulo> articuloCollection) {
        this.articuloCollection = articuloCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrevista != null ? idrevista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Revista)) {
            return false;
        }
        Revista other = (Revista) object;
        if ((this.idrevista == null && other.idrevista != null) || (this.idrevista != null && !this.idrevista.equals(other.idrevista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Revista[ idrevista=" + idrevista + " ]";
    }
    
}
