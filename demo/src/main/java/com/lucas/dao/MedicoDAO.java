package com.lucas.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lucas.modelos.Medico;

import java.util.List;

public class MedicoDAO {
    private EntityManagerFactory emf;

    public MedicoDAO() {
        emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    }

    public void salvarMedico(Medico medico) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(medico);
        em.getTransaction().commit();
        em.close();
    }

    public Medico buscarMedicoPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        Medico medico = em.find(Medico.class, id);
        em.close();
        return medico;
    }

    @SuppressWarnings("unchecked")
    public List<Medico> buscarTodosMedicos() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT m FROM Medico m");
        List<Medico> medico = query.getResultList();
        em.close();
        return medico;
    }

    public void atualizarMedico(Medico medico) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(medico);
        em.getTransaction().commit();
        em.close();
    }

    public void excluirMedico(Medico medico) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        medico = em.merge(medico);
        em.remove(medico);
        em.getTransaction().commit();
        em.close();
    }
    
}
