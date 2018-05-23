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
import org.forit.blog.DAO.categoriaDAO;
import org.forit.blog.DTO.categoriaDTO;
import org.forit.blog.exceptions.blogException;

@Path("/categoria")
public class categoriaRest {

    @Path("/")
    @GET()
    @Produces("application/json")
    public List<categoriaDTO> getListaCategoria() {

        categoriaDAO categoriaDAO = new categoriaDAO();
        return categoriaDAO.getListaCategorie();
    }

    @Path("/{id}")
    @GET()
    @Produces("application/json")
    public categoriaDTO getCategoria(@PathParam("id") long ID) {
        categoriaDAO categoriaDAO = new categoriaDAO();
        return categoriaDAO.getCategoria(ID);
    }

    @Path("/")
    @POST()
    @Produces("application/json")
    public boolean postCategoria(categoriaDTO c) {
        try {
            categoriaDAO categoria = new categoriaDAO();
            categoria.insertCategoria(c.getDescrizione(), c.getNome(), c.getImmagine(), c.isVisibile());
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
    public boolean putCategoria(categoriaDTO c) {
        try {
            categoriaDAO categoriaDAO = new categoriaDAO();
            categoriaDAO.insertCategoria(c.getDescrizione(), c.getNome(), c.getImmagine(), c.isVisibile());
            return true;
        } catch (blogException ex) {
            return false;
        }
    }

    @Path("/")
    @DELETE()
    @Produces("application/json")
    public boolean deleteCategoria(categoriaDTO c) {
        try {
            categoriaDAO categoria = new categoriaDAO();
            categoria.deletePost(c.getID());
            return true;
        } catch (blogException ex) {
            System.out.println("Errore: " + ex.getMessage());
            return false;
        }
    }
}
