package com.lucas.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lucas.modelos.Especialidade;

import java.util.List;

public class EspecialidadeDAO {

    private EntityManagerFactory emf;

    public EspecialidadeDAO() {
        emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    }

    public void salvarEspecialidade(Especialidade especialidade) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(especialidade);
        em.getTransaction().commit();
        em.close();
    }

    public Especialidade buscarEspecialidadePorId(Long id) {
        EntityManager em = emf.createEntityManager();
        Especialidade especialidade = em.find(Especialidade.class, id);
        em.close();
        return especialidade;
    }

    @SuppressWarnings("unchecked")
    public List<Especialidade> buscarTodasEspecialidades() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT e FROM Especialidade e");
        List<Especialidade> especialidade = query.getResultList();
        em.close();
        return especialidade;
    }

    public void atualizarEspecialidade(Especialidade especialidade) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(especialidade);
        em.getTransaction().commit();
        em.close();
    }

    public void excluirEspecialidade(Especialidade especialidade) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        especialidade = em.merge(especialidade);
        em.remove(especialidade);
        em.getTransaction().commit();
        em.close();
    }
    
}
