/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import entidades.TipoCategoria;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author JUANCARLOS
 */
@Stateless
public class TipoCategoriaFacade extends AbstractFacade<TipoCategoria> {
    @PersistenceContext(unitName = "GrupoInvestigacionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoCategoriaFacade() {
        super(TipoCategoria.class);
    }
    
}
