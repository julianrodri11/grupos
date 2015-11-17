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
@Table(name = "investigador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Investigador.findAll", query = "SELECT i FROM Investigador i"),
    @NamedQuery(name = "Investigador.findByCedula", query = "SELECT i FROM Investigador i WHERE i.cedula = :cedula"),
    @NamedQuery(name = "Investigador.findByNombres", query = "SELECT i FROM Investigador i WHERE i.nombres = :nombres"),
    @NamedQuery(name = "Investigador.findByApellidos", query = "SELECT i FROM Investigador i WHERE i.apellidos = :apellidos")})
public class Investigador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cedula")
    private Integer cedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellidos")
    private String apellidos;
    @ManyToMany(mappedBy = "investigadorCollection")
    private Collection<Articulo> articuloCollection;
    @JoinTable(name = "ponencias_has_investigador", joinColumns = {
        @JoinColumn(name = "investigador_cedula", referencedColumnName = "cedula")}, inverseJoinColumns = {
        @JoinColumn(name = "ponencias_idponencias", referencedColumnName = "idponencias")})
    @ManyToMany
    private Collection<Ponencias> ponenciasCollection;
    @ManyToMany(mappedBy = "investigadorCollection")
    private Collection<GruposInvestigacion> gruposInvestigacionCollection;
    @JoinTable(name = "libro_has_investigador", joinColumns = {
        @JoinColumn(name = "investigador_cedula", referencedColumnName = "cedula")}, inverseJoinColumns = {
        @JoinColumn(name = "libro_idlibros", referencedColumnName = "idlibros")})
    @ManyToMany
    private Collection<Libro> libroCollection;
    @JoinColumn(name = "estdo_investigador_idestdo_Investigador", referencedColumnName = "idestdo_Investigador")
    @ManyToOne(optional = false)
    private EstdoInvestigador estdoinvestigadoridestdoInvestigador;
    @JoinColumn(name = "formacion_academica_idformacion_academica", referencedColumnName = "idformacion_academica")
    @ManyToOne(optional = false)
    private FormacionAcademica formacionAcademicaIdformacionAcademica;

    public Investigador() {
    }

    public Investigador(Integer cedula) {
        this.cedula = cedula;
    }

    public Investigador(Integer cedula, String nombres, String apellidos) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @XmlTransient
    public Collection<Articulo> getArticuloCollection() {
        return articuloCollection;
    }

    public void setArticuloCollection(Collection<Articulo> articuloCollection) {
        this.articuloCollection = articuloCollection;
    }

    @XmlTransient
    public Collection<Ponencias> getPonenciasCollection() {
        return ponenciasCollection;
    }

    public void setPonenciasCollection(Collection<Ponencias> ponenciasCollection) {
        this.ponenciasCollection = ponenciasCollection;
    }

    @XmlTransient
    public Collection<GruposInvestigacion> getGruposInvestigacionCollection() {
        return gruposInvestigacionCollection;
    }

    public void setGruposInvestigacionCollection(Collection<GruposInvestigacion> gruposInvestigacionCollection) {
        this.gruposInvestigacionCollection = gruposInvestigacionCollection;
    }

    @XmlTransient
    public Collection<Libro> getLibroCollection() {
        return libroCollection;
    }

    public void setLibroCollection(Collection<Libro> libroCollection) {
        this.libroCollection = libroCollection;
    }

    public EstdoInvestigador getEstdoinvestigadoridestdoInvestigador() {
        return estdoinvestigadoridestdoInvestigador;
    }

    public void setEstdoinvestigadoridestdoInvestigador(EstdoInvestigador estdoinvestigadoridestdoInvestigador) {
        this.estdoinvestigadoridestdoInvestigador = estdoinvestigadoridestdoInvestigador;
    }

    public FormacionAcademica getFormacionAcademicaIdformacionAcademica() {
        return formacionAcademicaIdformacionAcademica;
    }

    public void setFormacionAcademicaIdformacionAcademica(FormacionAcademica formacionAcademicaIdformacionAcademica) {
        this.formacionAcademicaIdformacionAcademica = formacionAcademicaIdformacionAcademica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Investigador)) {
            return false;
        }
        Investigador other = (Investigador) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Investigador[ cedula=" + cedula + " ]";
    }
    
}
