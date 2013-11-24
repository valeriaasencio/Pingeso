/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entityClasses;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ina
 */
@Entity
@Table(name = "asistencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asistencia.findAll", query = "SELECT a FROM Asistencia a"),
    @NamedQuery(name = "Asistencia.findByIdAlumno", query = "SELECT a FROM Asistencia a WHERE a.asistenciaPK.idAlumno = :idAlumno"),
    @NamedQuery(name = "Asistencia.findByIdClase", query = "SELECT a FROM Asistencia a WHERE a.asistenciaPK.idClase = :idClase"),
    @NamedQuery(name = "Asistencia.findByIdAsistencia", query = "SELECT a FROM Asistencia a WHERE a.asistenciaPK.idAsistencia = :idAsistencia"),
    @NamedQuery(name = "Asistencia.findByAsistio", query = "SELECT a FROM Asistencia a WHERE a.asistio = :asistio"),
    @NamedQuery(name = "Asistencia.findByHoraAsistencia", query = "SELECT a FROM Asistencia a WHERE a.horaAsistencia = :horaAsistencia")})
public class Asistencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AsistenciaPK asistenciaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "asistio")
    private boolean asistio;
    @Column(name = "hora_asistencia")
    @Temporal(TemporalType.TIME)
    private Date horaAsistencia;
    @JoinColumn(name = "id_clase", referencedColumnName = "id_clase", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Clase clase;
    @JoinColumn(name = "id_alumno", referencedColumnName = "id_alumno", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alumno alumno;

    public Asistencia() {
    }

    public Asistencia(AsistenciaPK asistenciaPK) {
        this.asistenciaPK = asistenciaPK;
    }

    public Asistencia(AsistenciaPK asistenciaPK, boolean asistio) {
        this.asistenciaPK = asistenciaPK;
        this.asistio = asistio;
    }

    public Asistencia(int idAlumno, int idClase, int idAsistencia) {
        this.asistenciaPK = new AsistenciaPK(idAlumno, idClase, idAsistencia);
    }

    public AsistenciaPK getAsistenciaPK() {
        return asistenciaPK;
    }

    public void setAsistenciaPK(AsistenciaPK asistenciaPK) {
        this.asistenciaPK = asistenciaPK;
    }

    public boolean getAsistio() {
        return asistio;
    }

    public void setAsistio(boolean asistio) {
        this.asistio = asistio;
    }

    public Date getHoraAsistencia() {
        return horaAsistencia;
    }

    public void setHoraAsistencia(Date horaAsistencia) {
        this.horaAsistencia = horaAsistencia;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (asistenciaPK != null ? asistenciaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asistencia)) {
            return false;
        }
        Asistencia other = (Asistencia) object;
        if ((this.asistenciaPK == null && other.asistenciaPK != null) || (this.asistenciaPK != null && !this.asistenciaPK.equals(other.asistenciaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityClasses.Asistencia[ asistenciaPK=" + asistenciaPK + " ]";
    }
    
}
