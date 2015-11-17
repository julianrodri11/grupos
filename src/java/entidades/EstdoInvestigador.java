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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JUANCARLOS
 */
@Entity
@Table(name = "estdo_investigador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstdoInvestigador.findAll", query = "SELECT e FROM EstdoInvestigador e"),
    @NamedQuery(name = "EstdoInvestigador.findByIdestdoInvestigador", query = "SELECT e FROM EstdoInvestigador e WHERE e.idestdoInvestigador = :idestdoInvestigador"),
    @NamedQuery(name = "EstdoInvestigador.findByEstado", query = "SELECT e FROM EstdoInvestigador e WHERE e.estado = :estado")})
public class EstdoInvestigador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idestdo_Investigador")
    private Integer idestdoInvestigador;
    @Size(max = 8)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estdoinvestigadoridestdoInvestigador")
    private Collection<Investigador> investigadorCollection;

    public EstdoInvestigador() {
    }

    public EstdoInvestigador(Integer idestdoInvestigador) {
        this.idestdoInvestigador = idestdoInvestigador;
    }

    public Integer getIdestdoInvestigador() {
        return idestdoInvestigador;
    }

    public void setIdestdoInvestigador(Integer idestdoInvestigador) {
        this.idestdoInvestigador = idestdoInvestigador;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
        hash += (idestdoInvestigador != null ? idestdoInvestigador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstdoInvestigador)) {
            return false;
        }
        EstdoInvestigador other = (EstdoInvestigador) object;
        if ((this.idestdoInvestigador == null && other.idestdoInvestigador != null) || (this.idestdoInvestigador != null && !this.idestdoInvestigador.equals(other.idestdoInvestigador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.EstdoInvestigador[ idestdoInvestigador=" + idestdoInvestigador + " ]";
    }
    
}
