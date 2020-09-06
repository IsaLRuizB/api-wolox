package com.prueba.api.wolox.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="permiso")
public class Permiso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Long idUser;
    @NotNull
    private Long idUserComp;
    @NotNull
    private Long idAlbum;

    @NotNull
    private char tipoPermiso;

    public char getTipoPermiso() {
        return tipoPermiso;
    }

    public void setTipoPermiso(char tipoPermiso) {
        this.tipoPermiso = tipoPermiso;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(Long idAlbum) {
        this.idAlbum = idAlbum;
    }

    public Long getIdUserComp() {
        return idUserComp;
    }

    public void setIdUserComp(Long idUserComp) {
        this.idUserComp = idUserComp;
    }


}
