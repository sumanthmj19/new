package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Alian;

public interface AlianRepo extends JpaRepository<Alian, Integer>
{
   List<Alian> findByAname(String Aname);
   
   List<Alian> findByAidGreaterThan(int aid);
   
   @Query("from Alian where aname=?1 order by aid")
   List<Alian> findByOrder(String aname);
   
   @Query("from Alian")
   List<Alian> findByOrder1();
}
