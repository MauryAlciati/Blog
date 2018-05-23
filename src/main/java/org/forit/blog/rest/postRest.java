/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.blog.rest;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.forit.blog.DAO.postDAO;
import org.forit.blog.DTO.postDTO;
import org.forit.blog.exceptions.blogException;

@Path("/post")
public class postRest {

    @Path("/")
    @GET()
    @Produces("application/json")
    public List<postDTO> getPosts() {

        postDAO postDAO = new postDAO();
        return postDAO.getListaPost();
    }

    @Path("/{id}")
    @GET()
    @Produces("application/json")
    public postDTO getPost(@PathParam("id") long ID) {
        postDAO postDAO = new postDAO();
        return postDAO.getPost(ID);
    }

    @Path("/")
    @POST()
    @Produces("application/json")
    public boolean postPost(postDTO p) {
        try {
            postDAO post = new postDAO();
            post.insertPost(p.getIdCategoria(), p.getTitolo(), p.getDescrizione(), p.getData(), p.isVisibile(), p.getVisite(), p.getIdAutore());
            return true;
        } catch (blogException ex) {
            System.out.println("Errore: " + ex.getMessage());
            return false;
        }
    }

    @Path("/")
    @PUT()
    @Consumes("application/json")
    @Produces("application/json")
    public boolean putPost(postDTO p) {
        try {
            postDAO postDAO = new postDAO();
            postDAO.updatePost(p.getID(), p.getIdCategoria(), p.getTitolo(), p.getDescrizione(), p.getData(), p.isVisibile(), p.getVisite(), p.getIdAutore());
            return true;
        } catch (blogException ex) {
            return false;
        }
    }

    @Path("/")
    @DELETE()
    @Produces("application/json")
    public boolean deletePost(postDTO p) {
        try {
            postDAO post = new postDAO();
            post.deletePost(p.getID());
            return true;
        } catch (blogException ex) {
            System.out.println("Errore: " + ex.getMessage());
            return false;
        }
    }

}
