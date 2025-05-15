package com.UnicapHandsOn.HandsOn.Entities;


import java.io.Serializable;

import com.UnicapHandsOn.HandsOn.Entities.PK.itemPedidoPk;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order_item")
public class itemPedido implements Serializable{
    private static final long serialVersionUID = 1L;

    @EmbeddedId//como nosso id é composto nos usamos essa anotation
    private itemPedidoPk id = new itemPedidoPk();

    private Integer quantity;
    private Double price;

    public itemPedido(){}

    public itemPedido(pedido order, item product,Integer quantity,Double price){
        super();
        id.setPedido(order);
        id.setItem(product);
        this.quantity = quantity;
        this.price = price;
    }

    @JsonIgnore//para evitar a associação de mão dupla
    public pedido getPedido(){// nos fazemos isso para essa classer ter acesso a classe pk
        return id.getPedido();
    }

    public void setPedido(pedido order){
        id.setPedido(order);
    }

    public item getItem(){
        return id.getItem();
    }

    public void setItem(item product){
        id.setItem(product);
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getSubTotal() {
		return price * quantity;
	}

    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime*result+((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        itemPedido other = (itemPedido) obj;
        if (id == null) {
            if(other.id != null)
                return false;
        }else if(!id.equals(other.id)){
            return false;
        }
        return true;
    }
}