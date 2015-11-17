/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import entidades.Ponencias;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author JUANCARLOS
 */
@Stateless
public class PonenciasFacade extends AbstractFacade<Ponencias> {
    @PersistenceContext(unitName = "GrupoInvestigacionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PonenciasFacade() {
        super(Ponencias.class);
    }
    
}
