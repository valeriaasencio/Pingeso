/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import sessionBeans.ClaseSB;
import sessionBeans.UserSB;

/**
 *
 * @author Ina
 */
@Stateless
public class LoginMB {
    @EJB
    private UserSB userSB;
    @EJB
    private ClaseSB claseSB;
    private String username;
    private String password;
    private Date dateLogin;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public boolean login() {

        if (userSB.exist(username, password)) {
            //aquí se supone que se revisa el tiempo igual
            List clases = claseSB.findByFechaClase(dateLogin); //ver que eso sea el día... ÑAh :c
            Iterator itr = clases.iterator();
            while (itr.hasNext()) {
                Object clase = itr.next();
                //if() revisar que pertenezca al curso y revisar si la clase está activa.
                return true;
            }

        }
        return false;
    }

}
