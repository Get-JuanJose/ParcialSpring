package com.ideasexpress.sprignboot.app.demo.Models.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.ideasexpress.sprignboot.app.demo.Models.Entity.Detalle;

@Repository
public class DetalleDaoImp implements IDetalleDao {

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Detalle> findAll() {

        return em.createQuery("from Detalle").getResultList();

    }

    @Transactional
    @Override
    public void save(Detalle Detalle) {

        if (Detalle.getId() != null && Detalle.getId() > 0) {
            em.merge(Detalle);
        } else {
            em.persist(Detalle);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Detalle findOne(Long id) {
        return em.find(Detalle.class, id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Detalle Detalle = findOne(id);
        em.remove(Detalle);
    }

}
