package com.UnicapHandsOn.HandsOn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UnicapHandsOn.HandsOn.Entities.itemPedido;
import com.UnicapHandsOn.HandsOn.Entities.PK.itemPedidoPk;
//não usa componentes pois está erdando do JpaRepository, que já tem essa tag
public interface itemPedidoRepository extends JpaRepository<itemPedido, itemPedidoPk> { // repositorios sempre seram interfaçe

}
