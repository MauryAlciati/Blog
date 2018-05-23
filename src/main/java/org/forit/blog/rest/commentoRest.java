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
import org.forit.blog.DAO.commentoDAO;
import org.forit.blog.DTO.commentoDTO;
import org.forit.blog.exceptions.blogException;

@Path("/commento")
public class commentoRest {

    @Path("/")
    @GET()
    @Produces("application/json")
    public List<commentoDTO> getListaCommenti() {

        commentoDAO commentoDAO = new commentoDAO();
        return commentoDAO.getListaCommento();
    }

    @Path("/{id}")
    @GET()
    @Produces("application/json")
    public commentoDTO getPost(@PathParam("id") long ID) {
        commentoDAO commentoDAO = new commentoDAO();
        return commentoDAO.getCommento(ID);
    }

    @Path("/")
    @POST()
    @Produces("application/json")
    public boolean commentoPost(commentoDTO co) {
        try {
            commentoDAO commento = new commentoDAO();
            commento.insertCommento(co.getNickname(), co.getEmail(), co.getDataInserimento(), co.getTesto(), co.getDataRisposta(), co.getRisposta(), co.isVisibile(), co.getIdPost());
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
    public boolean putCommento(commentoDTO co) {
        try {
            commentoDAO commentoDAO = new commentoDAO();
            commentoDAO.insertCommento(co.getNickname(), co.getEmail(), co.getDataInserimento(), co.getTesto(), co.getDataRisposta(), co.getRisposta(), co.isVisibile(), co.getIdPost());
            return true;
        } catch (blogException ex) {
            return false;
        }
    }

    @Path("/")
    @DELETE()
    @Produces("application/json")
    public boolean deletePost(commentoDTO co) {
        try {
            commentoDAO commento = new commentoDAO();
            commento.deleteCommento(co.getID());
            return true;
        } catch (blogException ex) {
            System.out.println("Errore: " + ex.getMessage());
            return false;
        }
    }
}
