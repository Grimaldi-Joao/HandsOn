package com.UnicapHandsOn.HandsOn.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.UnicapHandsOn.HandsOn.Entities.item;

//não usa componentes pois está erdando do JpaRepository, que já tem essa tag
public interface itemRepository extends JpaRepository<item, Long> { // repositorios sempre seram interfaçe

}
