/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JUANCARLOS
 */
@Entity
@Table(name = "grupos_investigacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GruposInvestigacion.findAll", query = "SELECT g FROM GruposInvestigacion g"),
    @NamedQuery(name = "GruposInvestigacion.findByIdgruposInvestigacion", query = "SELECT g FROM GruposInvestigacion g WHERE g.idgruposInvestigacion = :idgruposInvestigacion"),
    @NamedQuery(name = "GruposInvestigacion.findByNombre", query = "SELECT g FROM GruposInvestigacion g WHERE g.nombre = :nombre"),
    @NamedQuery(name = "GruposInvestigacion.findByLineaInvestigacion", query = "SELECT g FROM GruposInvestigacion g WHERE g.lineaInvestigacion = :lineaInvestigacion")})
public class GruposInvestigacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idgrupos_investigacion")
    private Integer idgruposInvestigacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "linea_investigacion")
    private String lineaInvestigacion;
    @JoinTable(name = "investigador_has_grupos_investigacion", joinColumns = {
        @JoinColumn(name = "grupos_investigacion_idgrupos_investigacion", referencedColumnName = "idgrupos_investigacion")}, inverseJoinColumns = {
        @JoinColumn(name = "investigador_cedula", referencedColumnName = "cedula")})
    @ManyToMany
    private Collection<Investigador> investigadorCollection;
    @JoinColumn(name = "tipo_categoria_idtipo_categoria", referencedColumnName = "idtipo_categoria")
    @ManyToOne(optional = false)
    private TipoCategoria tipoCategoriaIdtipoCategoria;

    public GruposInvestigacion() {
    }

    public GruposInvestigacion(Integer idgruposInvestigacion) {
        this.idgruposInvestigacion = idgruposInvestigacion;
    }

    public GruposInvestigacion(Integer idgruposInvestigacion, String nombre, String lineaInvestigacion) {
        this.idgruposInvestigacion = idgruposInvestigacion;
        this.nombre = nombre;
        this.lineaInvestigacion = lineaInvestigacion;
    }

    public Integer getIdgruposInvestigacion() {
        return idgruposInvestigacion;
    }

    public void setIdgruposInvestigacion(Integer idgruposInvestigacion) {
        this.idgruposInvestigacion = idgruposInvestigacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLineaInvestigacion() {
        return lineaInvestigacion;
    }

    public void setLineaInvestigacion(String lineaInvestigacion) {
        this.lineaInvestigacion = lineaInvestigacion;
    }

    @XmlTransient
    public Collection<Investigador> getInvestigadorCollection() {
        return investigadorCollection;
    }

    public void setInvestigadorCollection(Collection<Investigador> investigadorCollection) {
        this.investigadorCollection = investigadorCollection;
    }

    public TipoCategoria getTipoCategoriaIdtipoCategoria() {
        return tipoCategoriaIdtipoCategoria;
    }

    public void setTipoCategoriaIdtipoCategoria(TipoCategoria tipoCategoriaIdtipoCategoria) {
        this.tipoCategoriaIdtipoCategoria = tipoCategoriaIdtipoCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgruposInvestigacion != null ? idgruposInvestigacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GruposInvestigacion)) {
            return false;
        }
        GruposInvestigacion other = (GruposInvestigacion) object;
        if ((this.idgruposInvestigacion == null && other.idgruposInvestigacion != null) || (this.idgruposInvestigacion != null && !this.idgruposInvestigacion.equals(other.idgruposInvestigacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
