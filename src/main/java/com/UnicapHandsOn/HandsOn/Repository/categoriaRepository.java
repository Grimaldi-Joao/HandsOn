package com.UnicapHandsOn.HandsOn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UnicapHandsOn.HandsOn.Entities.categoria;

//não usa componentes pois está erdando do JpaRepository, que já tem essa tag
public interface categoriaRepository extends JpaRepository<categoria, Long> { // repositorios sempre seram interfaçe

}