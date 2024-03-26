package com.ug.ec.dao;

import com.ug.ec.domain.TipoVehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TipoVehiculoDao extends JpaRepository<TipoVehiculo, Integer>{

}