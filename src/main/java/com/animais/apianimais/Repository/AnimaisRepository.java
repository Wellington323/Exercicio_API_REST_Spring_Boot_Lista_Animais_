package com.animais.apianimais.Repository;


import org.springframework.data.jpa.repository.JpaRepository; 

import com.animais.apianimais.model.Animais;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimaisRepository extends JpaRepository<Animais, Long> {
}
