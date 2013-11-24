/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entityClasses.User;
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
public class UserSB {
    @PersistenceContext(unitName = "Whisky-ejbPU")
    private EntityManager em;

    public boolean exist(String username, String password) {
        User user = findByUsername(username);
        if (user != null) {
            if (user.getPassword().compareTo(password) == 0) { //tener en cuenta encriptacion :c
                return true;
            }
        }
        return false;
    }
    
    public void addUser(String username, String password, String role){
      
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setRole(role);
        em.persist(newUser);
        
    
    }

    public User findByUsername(String username) {
        return em.createNamedQuery("User.findByUsername", User.class)
                .setParameter("username", username)
                .getSingleResult();
    }
    
    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
