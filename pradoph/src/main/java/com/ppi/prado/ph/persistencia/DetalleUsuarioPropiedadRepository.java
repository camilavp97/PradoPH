package com.ppi.prado.ph.persistencia;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ppi.prado.ph.entidades.DetalleUsuarioPropiedad;

public interface DetalleUsuarioPropiedadRepository extends CrudRepository<DetalleUsuarioPropiedad, Long>{
	
	@Query("SELECT d FROM DetalleUsuarioPropiedad d WHERE d.usuario.id =:idUsuario AND d.propiedad.id =:idPropiedad")
    public DetalleUsuarioPropiedad buscarDetallePorUsurioYPropiedad(@Param("idUsuario") Long idUsuario,@Param("idPropiedad") Long idPropiedad);

}
