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
@Table(name = "libro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Libro.findAll", query = "SELECT l FROM Libro l"),
    @NamedQuery(name = "Libro.findByIdlibros", query = "SELECT l FROM Libro l WHERE l.idlibros = :idlibros"),
    @NamedQuery(name = "Libro.findByAnioPublicacion", query = "SELECT l FROM Libro l WHERE l.anioPublicacion = :anioPublicacion"),
    @NamedQuery(name = "Libro.findByTitulo", query = "SELECT l FROM Libro l WHERE l.titulo = :titulo")})
public class Libro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlibros")
    private Integer idlibros;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anio_publicacion")
    @Temporal(TemporalType.DATE)
    private Date anioPublicacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "titulo")
    private String titulo;
    @ManyToMany(mappedBy = "libroCollection")
    private Collection<Investigador> investigadorCollection;
    @JoinColumn(name = "editorial_ideditorial", referencedColumnName = "ideditorial")
    @ManyToOne(optional = false)
    private Editorial editorialIdeditorial;

    public Libro() {
    }

    public Libro(Integer idlibros) {
        this.idlibros = idlibros;
    }

    public Libro(Integer idlibros, Date anioPublicacion, String titulo) {
        this.idlibros = idlibros;
        this.anioPublicacion = anioPublicacion;
        this.titulo = titulo;
    }

    public Integer getIdlibros() {
        return idlibros;
    }

    public void setIdlibros(Integer idlibros) {
        this.idlibros = idlibros;
    }

    public Date getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(Date anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @XmlTransient
    public Collection<Investigador> getInvestigadorCollection() {
        return investigadorCollection;
    }

    public void setInvestigadorCollection(Collection<Investigador> investigadorCollection) {
        this.investigadorCollection = investigadorCollection;
    }

    public Editorial getEditorialIdeditorial() {
        return editorialIdeditorial;
    }

    public void setEditorialIdeditorial(Editorial editorialIdeditorial) {
        this.editorialIdeditorial = editorialIdeditorial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlibros != null ? idlibros.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libro)) {
            return false;
        }
        Libro other = (Libro) object;
        if ((this.idlibros == null && other.idlibros != null) || (this.idlibros != null && !this.idlibros.equals(other.idlibros))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Libro[ idlibros=" + idlibros + " ]";
    }
    
}
