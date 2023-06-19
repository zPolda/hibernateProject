package com.lucas.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lucas.modelos.Endereco;

import java.util.List;

public class EnderecoDAO {

    private EntityManagerFactory emf;

    public EnderecoDAO() {
        emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    }

    

    public void salvarEndereco(Endereco endereco) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(endereco);
        em.getTransaction().commit();
        em.close();
    }

    public Endereco buscarEnderecoPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        Endereco endereco = em.find(Endereco.class, id);
        em.close();
        return endereco;
    }

    @SuppressWarnings("unchecked")
    public List<Endereco> buscarTodosEnderecos() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT e FROM Endereco e");
        List<Endereco> endereco = query.getResultList();
        em.close();
        return endereco;
    }

    public void atualizarEndereco(Endereco endereco) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(endereco);
        em.getTransaction().commit();
        em.close();
    }

    public void excluirEndereco(Endereco endereco) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        endereco = em.merge(endereco);
        em.remove(endereco);
        em.getTransaction().commit();
        em.close();
    }
    
}
