package com.ug.ec.dao;

import com.ug.ec.domain.SubArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface SubAreaDao extends JpaRepository<SubArea, Integer>{

}