/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jhon Deibys Torres
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "com.Dev-Jhon_LoginJSF_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    public Usuario iniciarSesion(String nombres, String contrasenna) {
       Query query = em.createQuery("SELECT U FROM Usuario U WHERE U.nombres=:nombres AND U.contraseña=:password");
        query.setParameter("nombres", nombres);
        query.setParameter("password", contrasenna);
        
        
        try {
            return (Usuario) query.getSingleResult();
        } catch (Exception e) {
        }
        
        Usuario userIn = new Usuario();
        return  userIn;
    }
    
}
