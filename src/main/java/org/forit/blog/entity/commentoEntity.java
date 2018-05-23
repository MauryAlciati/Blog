/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.blog.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "commento")
@NamedQueries({
    @NamedQuery(
            name = "commento.selectAll",
            query = "SELECT co "
            + "FROM commentoEntity co "
            + "ORDER BY co.nickname"
    )
})
public class commentoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private long ID;

    @Column(table = "commento", name = "nickname", nullable = false)
    private String nickname;

    @Column(table = "commento", name = "email", nullable = false)
    private String email;

    @Column(table = "commento", name = "data_inserimento", nullable = false)
    private LocalDate dataInserimento;

    @Column(table = "commento", name = "testo", nullable = false)
    private String testo;

    @Column(table = "commento", name = "data_risposta", nullable = true)
    private LocalDate dataRisposta;

    @Column(table = "commento", name = "risposta", nullable = true)
    private String risposta;

    @Column(table = "commento", name = "visibile", nullable = false)
    private boolean visibile;

    @Column(table = "commento", name = "id_post", unique = false, nullable = false)
    private Long idPost;

    public commentoEntity() {
    }

    public commentoEntity(long ID, String nickname, String email, LocalDate dataInserimento, String testo, LocalDate dataRisposta, String risposta, boolean visibile, Long idPost) {
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

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
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
        hash = 59 * hash + (int) (this.ID ^ (this.ID >>> 32));
        hash = 59 * hash + Objects.hashCode(this.nickname);
        hash = 59 * hash + Objects.hashCode(this.email);
        hash = 59 * hash + Objects.hashCode(this.dataInserimento);
        hash = 59 * hash + Objects.hashCode(this.testo);
        hash = 59 * hash + Objects.hashCode(this.dataRisposta);
        hash = 59 * hash + Objects.hashCode(this.risposta);
        hash = 59 * hash + (this.visibile ? 1 : 0);
        hash = 59 * hash + Objects.hashCode(this.idPost);
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
        final commentoEntity other = (commentoEntity) obj;
        if (this.ID != other.ID) {
            return false;
        }
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
        return "commentoEntity{" + "ID=" + ID + ", nickname=" + nickname + ", email=" + email + ", dataInserimento=" + dataInserimento + ", testo=" + testo + ", dataRisposta=" + dataRisposta + ", risposta=" + risposta + ", visibile=" + visibile + ", idPost=" + idPost + '}';
    }

}
