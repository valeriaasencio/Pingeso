/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entityClasses.Clase;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ina
 */
@Stateless
@LocalBean
public class ClaseSB {
    @PersistenceContext(unitName = "Whisky-ejbPU")
    private EntityManager em;

    public List findByFechaClase(Date date) { //Las clases del día
        return em.createNamedQuery("Clase.findByFechaClase", Clase.class)
                .setParameter("fechaClase", date)
                .getResultList();
    }
    
    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
