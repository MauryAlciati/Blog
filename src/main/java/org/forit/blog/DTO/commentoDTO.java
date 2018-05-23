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
public class commentoDTO {
    
    private Long ID;
    private String nickname;
    private String email;
    
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dataInserimento;
    private String testo;
    
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dataRisposta;
    private String risposta;
    private boolean visibile;
    private Long idPost;

    public commentoDTO() {
    }

    public commentoDTO(Long ID, String nickname, String email, LocalDate dataInserimento, String testo, LocalDate dataRisposta, String risposta, boolean visibile, Long idPost) {
        this.ID = ID;
        this.nickname = nickname;
        this.email = email;
        this.dataInserimento = dataInserimento;
        this.testo = testo;
        this.dataRisposta = dataRisposta;
        this.risposta = risposta;
        this.visibile = visibile;
        this.idPost = idPost;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataInserimento() {
        return dataInserimento;
    }

    public void setDataInserimento(LocalDate dataInserimento) {
        this.dataInserimento = dataInserimento;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public LocalDate getDataRisposta() {
        return dataRisposta;
    }

    public void setDataRisposta(LocalDate dataRisposta) {
        this.dataRisposta = dataRisposta;
    }

    public String getRisposta() {
        return risposta;
    }

    public void setRisposta(String risposta) {
        this.risposta = risposta;
    }

    public boolean isVisibile() {
        return visibile;
    }

    public void setVisibile(boolean visibile) {
        this.visibile = visibile;
    }

    public Long getIdPost() {
        return idPost;
    }

    public void setIdPost(Long idPost) {
        this.idPost = idPost;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.ID);
        hash = 23 * hash + Objects.hashCode(this.nickname);
        hash = 23 * hash + Objects.hashCode(this.email);
        hash = 23 * hash + Objects.hashCode(this.dataInserimento);
        hash = 23 * hash + Objects.hashCode(this.testo);
        hash = 23 * hash + Objects.hashCode(this.dataRisposta);
        hash = 23 * hash + Objects.hashCode(this.risposta);
        hash = 23 * hash + (this.visibile ? 1 : 0);
        hash = 23 * hash + Objects.hashCode(this.idPost);
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
        final commentoDTO other = (commentoDTO) obj;
        if (this.visibile != other.visibile) {
            return false;
        }
        if (!Objects.equals(this.nickname, other.nickname)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.testo, other.testo)) {
            return false;
        }
        if (!Objects.equals(this.risposta, other.risposta)) {
            return false;
        }
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        if (!Objects.equals(this.dataInserimento, other.dataInserimento)) {
            return false;
        }
        if (!Objects.equals(this.dataRisposta, other.dataRisposta)) {
            return false;
        }
        if (!Objects.equals(this.idPost, other.idPost)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "commentoDTO{" + "ID=" + ID + ", nickname=" + nickname + ", email=" + email + ", dataInserimento=" + dataInserimento + ", testo=" + testo + ", dataRisposta=" + dataRisposta + ", risposta=" + risposta + ", visibile=" + visibile + ", idPost=" + idPost + '}';
    }
    
    
}
