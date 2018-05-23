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
import org.forit.blog.DTO.tagDTO;
import org.forit.blog.entity.tagEntity;
import org.forit.blog.exceptions.blogException;

/**
 *
 * @author forIT
 */
public class tagDAO {

    public List<tagDTO> getListaTag() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog_pu");
        EntityManager em = emf.createEntityManager();

        TypedQuery<tagEntity> query = em.createNamedQuery("tag.selectAll", tagEntity.class);
        List<tagEntity> list = query.getResultList();
        List<tagDTO> tag = list.stream().map(entity -> {
            return new tagDTO(entity.getID(),
                    entity.getNome()
            );
        }).collect(Collectors.toList());

        em.close();
        emf.close();

        return tag;
    }

    public tagDTO getTag(long ID) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog_pu");
        EntityManager em = emf.createEntityManager();

        tagEntity entity = em.find(tagEntity.class, ID);
        tagDTO tag = new tagDTO(entity.getID(),
                entity.getNome());

        em.close();
        emf.close();

        return tag;
    }

    public void insertTag(String nome) throws blogException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog_pu");
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            tagEntity tag = new tagEntity();
            tag.setNome(nome);

            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            throw new blogException();
        } finally {
            em.close();
            emf.close();
        }
    }

    public void deleteTag(long ID) throws blogException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog_pu");
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            tagEntity commento = em.find(tagEntity.class, ID);

            em.remove(commento);

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
