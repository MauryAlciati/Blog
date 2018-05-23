/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.blog.DTO;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.LocalDate;
import java.util.Objects;
import org.forit.blog.serializer.LocalDateDeserializer;
import org.forit.blog.serializer.LocalDateSerializer;

/**
 *
 * @author forIT
 */
public class postDTO {
 
    private Long ID;
    private Long idCategoria;
    private String titolo;
    private String descrizione;
        
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate data;
    private boolean visibile;
    private int visite;
    private Long idAutore;

    public postDTO() {
    }

    public postDTO(Long ID, Long idCategoria, String titolo, String descrizione, LocalDate data, boolean visibile, int visite, Long idAutore) {
        this.ID = ID;
        this.idCategoria = idCategoria;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.data = data;
        this.visibile = visibile;
        this.visite = visite;
        this.idAutore = idAutore;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public boolean isVisibile() {
        return visibile;
    }

    public void setVisibile(boolean visibile) {
        this.visibile = visibile;
    }

    public int getVisite() {
        return visite;
    }

    public void setVisite(int visite) {
        this.visite = visite;
    }

    public Long getIdAutore() {
        return idAutore;
    }

    public void setIdAutore(Long idAutore) {
        this.idAutore = idAutore;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.ID);
        hash = 79 * hash + Objects.hashCode(this.idCategoria);
        hash = 79 * hash + Objects.hashCode(this.titolo);
        hash = 79 * hash + Objects.hashCode(this.descrizione);
        hash = 79 * hash + Objects.hashCode(this.data);
        hash = 79 * hash + (this.visibile ? 1 : 0);
        hash = 79 * hash + this.visite;
        hash = 79 * hash + Objects.hashCode(this.idAutore);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final postDTO other = (postDTO) obj;
        if (this.visibile != other.visibile) {
            return false;
        }
        if (this.visite != other.visite) {
            return false;
        }
        if (!Objects.equals(this.titolo, other.titolo)) {
            return false;
        }
        if (!Objects.equals(this.descrizione, other.descrizione)) {
            return false;
        }
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        if (!Objects.equals(this.idCategoria, other.idCategoria)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.idAutore, other.idAutore)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "postDTO{" + "ID=" + ID + ", idCategoria=" + idCategoria + ", titolo=" + titolo + ", descrizione=" + descrizione + ", data=" + data + ", visibile=" + visibile + ", visite=" + visite + ", idAutore=" + idAutore + '}';
    }

    
    
}
