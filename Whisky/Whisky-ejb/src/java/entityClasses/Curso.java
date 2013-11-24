/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entityClasses;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
 * @author Ina
 */
@Entity
@Table(name = "curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c"),
    @NamedQuery(name = "Curso.findByCodigoCurso", query = "SELECT c FROM Curso c WHERE c.codigoCurso = :codigoCurso"),
    @NamedQuery(name = "Curso.findByTotalAlumnosCurso", query = "SELECT c FROM Curso c WHERE c.totalAlumnosCurso = :totalAlumnosCurso"),
    @NamedQuery(name = "Curso.findByNombreCurso", query = "SELECT c FROM Curso c WHERE c.nombreCurso = :nombreCurso")})
public class Curso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "codigo_curso")
    private String codigoCurso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_alumnos_curso")
    private int totalAlumnosCurso;
    @Size(max = 256)
    @Column(name = "nombre_curso")
    private String nombreCurso;
    @JoinTable(name = "curso_profesor", joinColumns = {
        @JoinColumn(name = "codigo_curso", referencedColumnName = "codigo_curso")}, inverseJoinColumns = {
        @JoinColumn(name = "id_profesor", referencedColumnName = "id_profesor")})
    @ManyToMany
    private Collection<Profesor> profesorCollection;
    @ManyToMany(mappedBy = "cursoCollection")
    private Collection<Alumno> alumnoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoCurso")
    private Collection<Clase> claseCollection;

    public Curso() {
    }

    public Curso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public Curso(String codigoCurso, int totalAlumnosCurso) {
        this.codigoCurso = codigoCurso;
        this.totalAlumnosCurso = totalAlumnosCurso;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public int getTotalAlumnosCurso() {
        return totalAlumnosCurso;
    }

    public void setTotalAlumnosCurso(int totalAlumnosCurso) {
        this.totalAlumnosCurso = totalAlumnosCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    @XmlTransient
    public Collection<Profesor> getProfesorCollection() {
        return profesorCollection;
    }

    public void setProfesorCollection(Collection<Profesor> profesorCollection) {
        this.profesorCollection = profesorCollection;
    }

    @XmlTransient
    public Collection<Alumno> getAlumnoCollection() {
        return alumnoCollection;
    }

    public void setAlumnoCollection(Collection<Alumno> alumnoCollection) {
        this.alumnoCollection = alumnoCollection;
    }

    @XmlTransient
    public Collection<Clase> getClaseCollection() {
        return claseCollection;
    }

    public void setClaseCollection(Collection<Clase> claseCollection) {
        this.claseCollection = claseCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCurso != null ? codigoCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.codigoCurso == null && other.codigoCurso != null) || (this.codigoCurso != null && !this.codigoCurso.equals(other.codigoCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityClasses.Curso[ codigoCurso=" + codigoCurso + " ]";
    }
    
}
