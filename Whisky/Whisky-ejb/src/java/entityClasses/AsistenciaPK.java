/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entityClasses;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Ina
 */
@Embeddable
public class AsistenciaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_alumno")
    private int idAlumno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_clase")
    private int idClase;
    @Basic(optional = false)
    @Column(name = "id_asistencia")
    private int idAsistencia;

    public AsistenciaPK() {
    }

    public AsistenciaPK(int idAlumno, int idClase, int idAsistencia) {
        this.idAlumno = idAlumno;
        this.idClase = idClase;
        this.idAsistencia = idAsistencia;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdClase() {
        return idClase;
    }

    public void setIdClase(int idClase) {
        this.idClase = idClase;
    }

    public int getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(int idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAlumno;
        hash += (int) idClase;
        hash += (int) idAsistencia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsistenciaPK)) {
            return false;
        }
        AsistenciaPK other = (AsistenciaPK) object;
        if (this.idAlumno != other.idAlumno) {
            return false;
        }
        if (this.idClase != other.idClase) {
            return false;
        }
        if (this.idAsistencia != other.idAsistencia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityClasses.AsistenciaPK[ idAlumno=" + idAlumno + ", idClase=" + idClase + ", idAsistencia=" + idAsistencia + " ]";
    }
    
}
