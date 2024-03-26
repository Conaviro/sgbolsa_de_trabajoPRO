package com.ug.ec.dao;

import com.ug.ec.domain.Conocimiento;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

public interface ConocimientoDao extends JpaRepository<Conocimiento, Integer>{

}