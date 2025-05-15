package com.UnicapHandsOn.HandsOn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UnicapHandsOn.HandsOn.Entities.cliente;

//não usa componentes pois está erdando do JpaRepository, que já tem essa tag
public interface clienteRepository extends JpaRepository<cliente, Long> { // repositorios sempre seram interfaçe

    public cliente findByEmail(String email);

    public boolean existsByEmail(String email);
}
