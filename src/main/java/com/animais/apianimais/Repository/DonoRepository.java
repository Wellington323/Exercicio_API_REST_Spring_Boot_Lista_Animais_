package com.animais.apianimais.Repository;

import org.springframework.data.jpa.repository.JpaRepository;  

import com.animais.apianimais.model.Dono;
import org.springframework.stereotype.Repository;

@Repository
public interface DonoRepository extends JpaRepository<Dono, Long>{

}
 