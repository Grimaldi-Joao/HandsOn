package com.UnicapHandsOn.HandsOn.Entities.PK;

import java.io.Serializable;

import com.UnicapHandsOn.HandsOn.Entities.*;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable//por ser uma classe auxiliar
public class itemPedidoPk implements Serializable { // essa classe serve para voce ter a informação das outras duas
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private pedido pedido;
    
    @ManyToOne
    @JoinColumn(name = "item_id")
    private item item;

    public pedido getPedido() {
        return pedido;
    }

    public item getItem() {
        return item;
    }

    public void setPedido(pedido pedido) {
        this.pedido = pedido;
    }

    public void setItem(item item) {
        this.item = item;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		itemPedidoPk other = (itemPedidoPk) obj;
		if (pedido == null) {
			if (other.pedido != null)
				return false;
		} else if (!pedido.equals(other.pedido))
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		return true;
	}

}
