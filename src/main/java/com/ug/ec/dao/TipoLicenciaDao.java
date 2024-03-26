package com.ug.ec.dao;

import com.ug.ec.domain.TipoLicencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface TipoLicenciaDao extends JpaRepository<TipoLicencia, Integer>{

}