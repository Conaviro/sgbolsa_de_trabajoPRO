package com.ug.ec.dao;

import com.ug.ec.domain.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EmpresaDao extends JpaRepository<Empresa, Integer>{

}