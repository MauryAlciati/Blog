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
public class accountDTO {
    
    private Long ID;
    private String nome;
    private String cognome;
    private String username;
    private String email;
    private String password;
        
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dataRegistrazione;
    
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dataUltimoAccesso;
    private boolean attivo;
    private boolean bloccato;
    private int numeroTentativi;
    private Long idRuolo;

    public accountDTO() {
    }

    public accountDTO(Long ID, String nome, String cognome, String username, String email, String password, LocalDate dataRegistrazione, LocalDate dataUltimoAccesso, boolean attivo, boolean bloccato, int numeroTentativi, Long idRuolo) {
        this.ID = ID;
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.email = email;
        this.password = password;
        this.dataRegistrazione = dataRegistrazione;
        this.dataUltimoAccesso = dataUltimoAccesso;
        this.attivo = attivo;
        this.bloccato = bloccato;
        this.numeroTentativi = numeroTentativi;
        this.idRuolo = idRuolo;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDataRegistrazione() {
        return dataRegistrazione;
    }

    public void setDataRegistrazione(LocalDate dataRegistrazione) {
        this.dataRegistrazione = dataRegistrazione;
    }

    public LocalDate getDataUltimoAccesso() {
        return dataUltimoAccesso;
    }

    public void setDataUltimoAccesso(LocalDate dataUltimoAccesso) {
        this.dataUltimoAccesso = dataUltimoAccesso;
    }

    public boolean isAttivo() {
        return attivo;
    }

    public void setAttivo(boolean attivo) {
        this.attivo = attivo;
    }

    public boolean isBloccato() {
        return bloccato;
    }

    public void setBloccato(boolean bloccato) {
        this.bloccato = bloccato;
    }

    public int getNumeroTentativi() {
        return numeroTentativi;
    }

    public void setNumeroTentativi(int numeroTentativi) {
        this.numeroTentativi = numeroTentativi;
    }

    public Long getIdRuolo() {
        return idRuolo;
    }

    public void setIdRuolo(Long idRuolo) {
        this.idRuolo = idRuolo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.ID);
        hash = 83 * hash + Objects.hashCode(this.nome);
        hash = 83 * hash + Objects.hashCode(this.cognome);
        hash = 83 * hash + Objects.hashCode(this.username);
        hash = 83 * hash + Objects.hashCode(this.email);
        hash = 83 * hash + Objects.hashCode(this.password);
        hash = 83 * hash + Objects.hashCode(this.dataRegistrazione);
        hash = 83 * hash + Objects.hashCode(this.dataUltimoAccesso);
        hash = 83 * hash + (this.attivo ? 1 : 0);
        hash = 83 * hash + (this.bloccato ? 1 : 0);
        hash = 83 * hash + this.numeroTentativi;
        hash = 83 * hash + Objects.hashCode(this.idRuolo);
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
        final accountDTO other = (accountDTO) obj;
        if (this.attivo != other.attivo) {
            return false;
        }
        if (this.bloccato != other.bloccato) {
            return false;
        }
        if (this.numeroTentativi != other.numeroTentativi) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cognome, other.cognome)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        if (!Objects.equals(this.dataRegistrazione, other.dataRegistrazione)) {
            return false;
        }
        if (!Objects.equals(this.dataUltimoAccesso, other.dataUltimoAccesso)) {
            return false;
        }
        if (!Objects.equals(this.idRuolo, other.idRuolo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "accountDTO{" + "ID=" + ID + ", nome=" + nome + ", cognome=" + cognome + ", username=" + username + ", email=" + email + ", password=" + password + ", dataRegistrazione=" + dataRegistrazione + ", dataUltimoAccesso=" + dataUltimoAccesso + ", attivo=" + attivo + ", bloccato=" + bloccato + ", numeroTentativi=" + numeroTentativi + ", idRuolo=" + idRuolo + '}';
    }

    

    
    
    
}
