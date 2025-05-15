package com.UnicapHandsOn.HandsOn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UnicapHandsOn.HandsOn.Entities.pedido;

//não usa componentes pois está erdando do JpaRepository, que já tem essa tag
public interface pedidoRepository extends JpaRepository<pedido, Long> { // repositorios sempre seram interfaçe

}