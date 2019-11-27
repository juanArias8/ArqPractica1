/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.ejb;

import co.edu.udea.entity.Administradores;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jnda
 */
@Local
public interface AdministradoresFacadeLocal {

    void create(Administradores administradores);

    void edit(Administradores administradores);

    void remove(Administradores administradores);

    Administradores find(Object id);

    List<Administradores> findAll();

    List<Administradores> findRange(int[] range);

    int count();

    boolean checkLogin(String u, String p);
    
}
