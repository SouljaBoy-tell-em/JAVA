package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SQLRepository extends JpaRepository<SQLConnectorObject, Integer>, CrudRepository<SQLConnectorObject, Integer>{

}
