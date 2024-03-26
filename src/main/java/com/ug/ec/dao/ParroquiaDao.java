package com.ug.ec.dao;

import com.ug.ec.domain.Parroquia;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;


public interface ParroquiaDao extends JpaRepository<Parroquia, Integer>{

}