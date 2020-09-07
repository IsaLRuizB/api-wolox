package com.prueba.api.wolox.dto;

public class Permiso {

    private Long idUser;
    private Long idUserComp;
    private Long idAlbum;
    private char tipoPermiso;

    public Permiso(Long idUser, Long idUserComp, Long idAlbum, char tipoPermiso) {
        this.idUser = idUser;
        this.idUserComp = idUserComp;
        this.idAlbum = idAlbum;
        this.tipoPermiso = tipoPermiso;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdUserComp() {
        return idUserComp;
    }

    public void setIdUserComp(Long idUserComp) {
        this.idUserComp = idUserComp;
    }

    public Long getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(Long idAlbum) {
        this.idAlbum = idAlbum;
    }

    public char getTipoPermiso() {
        return tipoPermiso;
    }

    public void setTipoPermiso(char tipoPermiso) {
        this.tipoPermiso = tipoPermiso;
    }
}
