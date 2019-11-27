/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.ejb;

import co.edu.udea.entity.Administradores;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jnda
 */
@Stateless
public class AdministradoresFacade extends AbstractFacade<Administradores> implements AdministradoresFacadeLocal {

    @PersistenceContext(unitName = "appConcesionarioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdministradoresFacade() {
        super(Administradores.class);
    }

    @Override
    public boolean checkLogin(String u, String p) {
        Query q = em.createQuery("select a from Administradores a where a.username=:u and a.password=:p");
        q.setParameter("u", u);
        q.setParameter("p", p);

        return q.getResultList().size() > 0;
    }

}
