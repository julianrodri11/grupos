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
import javax.persistence.JoinTable;
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
@Table(name = "articulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articulo.findAll", query = "SELECT a FROM Articulo a"),
    @NamedQuery(name = "Articulo.findByIdarticulo", query = "SELECT a FROM Articulo a WHERE a.idarticulo = :idarticulo"),
    @NamedQuery(name = "Articulo.findByAnioPublicacion", query = "SELECT a FROM Articulo a WHERE a.anioPublicacion = :anioPublicacion"),
    @NamedQuery(name = "Articulo.findByNombreArticulo", query = "SELECT a FROM Articulo a WHERE a.nombreArticulo = :nombreArticulo")})
public class Articulo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idarticulo")
    private Integer idarticulo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anio_publicacion")
    @Temporal(TemporalType.DATE)
    private Date anioPublicacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_articulo")
    private String nombreArticulo;
    @JoinTable(name = "investigador_has_articulo", joinColumns = {
        @JoinColumn(name = "articulo_idarticulo", referencedColumnName = "idarticulo")}, inverseJoinColumns = {
        @JoinColumn(name = "investigador_cedula", referencedColumnName = "cedula")})
    @ManyToMany
    private Collection<Investigador> investigadorCollection;
    @JoinColumn(name = "revista_idrevista", referencedColumnName = "idrevista")
    @ManyToOne(optional = false)
    private Revista revistaIdrevista;

    public Articulo() {
    }

    public Articulo(Integer idarticulo) {
        this.idarticulo = idarticulo;
    }

    public Articulo(Integer idarticulo, Date anioPublicacion, String nombreArticulo) {
        this.idarticulo = idarticulo;
        this.anioPublicacion = anioPublicacion;
        this.nombreArticulo = nombreArticulo;
    }

    public Integer getIdarticulo() {
        return idarticulo;
    }

    public void setIdarticulo(Integer idarticulo) {
        this.idarticulo = idarticulo;
    }

    public Date getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(Date anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    @XmlTransient
    public Collection<Investigador> getInvestigadorCollection() {
        return investigadorCollection;
    }

    public void setInvestigadorCollection(Collection<Investigador> investigadorCollection) {
        this.investigadorCollection = investigadorCollection;
    }

    public Revista getRevistaIdrevista() {
        return revistaIdrevista;
    }

    public void setRevistaIdrevista(Revista revistaIdrevista) {
        this.revistaIdrevista = revistaIdrevista;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idarticulo != null ? idarticulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Articulo)) {
            return false;
        }
        Articulo other = (Articulo) object;
        if ((this.idarticulo == null && other.idarticulo != null) || (this.idarticulo != null && !this.idarticulo.equals(other.idarticulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Articulo[ idarticulo=" + idarticulo + " ]";
    }
    
}
