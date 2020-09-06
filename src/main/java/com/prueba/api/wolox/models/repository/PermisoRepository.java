package com.prueba.api.wolox.models.repository;

import com.prueba.api.wolox.models.entity.Permiso;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PermisoRepository extends CrudRepository<Permiso, Long> {

    @Query("Select p from Permiso p  where p.idUserComp =?1 and p.idUser =?2 and p.idAlbum =?3 ")
    public Optional<Permiso> findByIdUserCompAndIdUserAndIdAlbum(Long idUserCpomp, Long idUser, Long idAlbum);

    @Query("Select p.idUserComp from Permiso p  where p.idAlbum =?1 and p.tipoPermiso =?2 ")
    public List<Long> findByIdAlbumAndPermiso(Long idAlbum, char tipoPermiso);
}
