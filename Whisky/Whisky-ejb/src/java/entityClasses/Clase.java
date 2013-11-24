/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entityClasses;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ina
 */
@Entity
@Table(name = "clase")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clase.findAll", query = "SELECT c FROM Clase c"),
    @NamedQuery(name = "Clase.findByIdClase", query = "SELECT c FROM Clase c WHERE c.idClase = :idClase"),
    @NamedQuery(name = "Clase.findByFechaClase", query = "SELECT c FROM Clase c WHERE c.fechaClase = :fechaClase"),
    @NamedQuery(name = "Clase.findByAsistenciaTotalClase", query = "SELECT c FROM Clase c WHERE c.asistenciaTotalClase = :asistenciaTotalClase"),
    @NamedQuery(name = "Clase.findByHoraInicio", query = "SELECT c FROM Clase c WHERE c.horaInicio = :horaInicio"),
    @NamedQuery(name = "Clase.findByHoraTermino", query = "SELECT c FROM Clase c WHERE c.horaTermino = :horaTermino")})
public class Clase implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_clase")
    private Integer idClase;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_clase")
    @Temporal(TemporalType.DATE)
    private Date fechaClase;
    @Column(name = "asistencia_total_clase")
    private Integer asistenciaTotalClase;
    @Column(name = "hora_inicio")
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    @Column(name = "hora_termino")
    @Temporal(TemporalType.TIME)
    private Date horaTermino;
    @JoinColumn(name = "codigo_curso", referencedColumnName = "codigo_curso")
    @ManyToOne(optional = false)
    private Curso codigoCurso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clase")
    private Collection<Asistencia> asistenciaCollection;

    public Clase() {
    }

    public Clase(Integer idClase) {
        this.idClase = idClase;
    }

    public Clase(Integer idClase, Date fechaClase) {
        this.idClase = idClase;
        this.fechaClase = fechaClase;
    }

    public Integer getIdClase() {
        return idClase;
    }

    public void setIdClase(Integer idClase) {
        this.idClase = idClase;
    }

    public Date getFechaClase() {
        return fechaClase;
    }

    public void setFechaClase(Date fechaClase) {
        this.fechaClase = fechaClase;
    }

    public Integer getAsistenciaTotalClase() {
        return asistenciaTotalClase;
    }

    public void setAsistenciaTotalClase(Integer asistenciaTotalClase) {
        this.asistenciaTotalClase = asistenciaTotalClase;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraTermino() {
        return horaTermino;
    }

    public void setHoraTermino(Date horaTermino) {
        this.horaTermino = horaTermino;
    }

    public Curso getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(Curso codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    @XmlTransient
    public Collection<Asistencia> getAsistenciaCollection() {
        return asistenciaCollection;
    }

    public void setAsistenciaCollection(Collection<Asistencia> asistenciaCollection) {
        this.asistenciaCollection = asistenciaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClase != null ? idClase.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clase)) {
            return false;
        }
        Clase other = (Clase) object;
        if ((this.idClase == null && other.idClase != null) || (this.idClase != null && !this.idClase.equals(other.idClase))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityClasses.Clase[ idClase=" + idClase + " ]";
    }
    
}
