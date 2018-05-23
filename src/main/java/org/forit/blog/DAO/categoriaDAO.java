/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.blog.DAO;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.forit.blog.DTO.categoriaDTO;
import org.forit.blog.entity.categoriaEntity;
import org.forit.blog.exceptions.blogException;

/**
 *
 * @author forIT
 */
public class categoriaDAO {

    public List<categoriaDTO> getListaCategorie() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog_pu");
        EntityManager em = emf.createEntityManager();

        TypedQuery<categoriaEntity> query = em.createNamedQuery("categoria.selectAll", categoriaEntity.class);
        List<categoriaEntity> list = query.getResultList();
        List<categoriaDTO> categoria = list.stream().map(entity -> {
            return new categoriaDTO(entity.getID(), entity.getDescrizione(), entity.getNome(), entity.getImmagine(), entity.isVisibile()
            );
        }).collect(Collectors.toList());

        em.close();
        emf.close();

        return categoria;
    }

    public categoriaDTO getCategoria(long ID) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog_pu");
        EntityManager em = emf.createEntityManager();

        categoriaEntity entity = em.find(categoriaEntity.class, ID);
        categoriaDTO categoria = new categoriaDTO(entity.getID(),
                entity.getDescrizione(),
                entity.getNome(),
                entity.getImmagine(),
                entity.isVisibile());

        em.close();
        emf.close();

        return categoria;
    }

    public void insertCategoria(String descrizione, String nome, String immagine, boolean visibile) throws blogException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog_pu");
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            categoriaEntity categoria = new categoriaEntity();
            categoria.setDescrizione(descrizione);
            categoria.setNome(nome);
            categoria.setImmagine(immagine);
            categoria.setVisibile(visibile);

            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            throw new blogException();
        } finally {
            em.close();
            emf.close();
        }
    }

    public void deletePost(long ID) throws blogException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog_pu");
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            categoriaEntity categoria = em.find(categoriaEntity.class, ID);

            em.remove(categoria);

            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            throw new blogException();
        } finally {
            em.close();
            emf.close();
        }
    }

}
