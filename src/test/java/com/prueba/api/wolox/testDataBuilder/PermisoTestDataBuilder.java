package com.prueba.api.wolox.testDataBuilder;


import com.prueba.api.wolox.dto.Permiso;

public class PermisoTestDataBuilder {


    private static final Long IDUSER= new Long(1);
    private static final Long IDUSERCOMP= new Long(5);
    private static final Long IDALBUM= new Long(1);
    private static final char TIPOPERMISO='1';

    private Long idUser;
    private Long idUserComp;
    private Long idAlbum;
    private char tipoPermiso;

    public PermisoTestDataBuilder(){
        this.idUser=IDUSER;
        this.idUserComp=IDUSERCOMP;
        this.idAlbum=IDALBUM;
        this.tipoPermiso=TIPOPERMISO;

    }

    public PermisoTestDataBuilder conIdUser(Long idUser){
    this.idUser=idUser;
    return this;
    }

    public PermisoTestDataBuilder conidUserComp(Long idUserComp){
        this.idUserComp=idUserComp;
        return this;
    }

    public PermisoTestDataBuilder conidAlbum(Long idAlbum){
        this.idAlbum=idAlbum;
        return this;
    }

    public PermisoTestDataBuilder contipoPermiso(char tipoPermiso){
        this.tipoPermiso=tipoPermiso;
        return this;
    }

    public Permiso build(){ return new Permiso(idUser, idUserComp,idAlbum,tipoPermiso);}

    public ComandoPermisoBuilder buildComando(){
        return new ComandoPermisoBuilder(this.idUser, this.idUserComp, this.idAlbum, this.tipoPermiso);
    }

}
