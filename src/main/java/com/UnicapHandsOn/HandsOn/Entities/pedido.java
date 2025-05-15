package com.UnicapHandsOn.HandsOn.Entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.UnicapHandsOn.HandsOn.Entities.Enum.pedidoStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_pedido")
public class pedido implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant moment;

    private Integer pedidoStatus;

    //@JsonIgnore
    @ManyToOne//Anotation que serve para mostrar que a variavel cliente é uma chave de fora e alem disso mostrar que a relação é de varios pedidos para 1
    @JoinColumn(name = "client_id")//criar uma coluna com o nome desiguinado
    private cliente client;

    @OneToMany(mappedBy = "id.pedido")// pois no itemPedido quem tem acesso aos pedidos é o id
    private Set<itemPedido> items = new HashSet<>();

    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)//classe independente vc está mapeando pegando a variavel pedido do outro lado
    private pagamento pagamento;                                //cascade all vc está mapeando o codigo para ter o mesmo id

    public pedido(){
    }

    public pedido(Long id, Instant moment,pedidoStatus pedidoStatus,cliente client){
        this.id = id;
        this.moment = moment;
        setpedidoStatus(pedidoStatus);
        this.client = client;
    }


    public Long getId() {
        return id;
    }
    public Instant getMoment() {
        return moment;
    }
    public pedidoStatus getpedidoStatus() {
        return pedidoStatus.valueOf(pedidoStatus);
    }

    public cliente getClient() {
        return client;
    }

    public Set<itemPedido> getItems() {
        return items;
    }
    public pagamento getpagamento() {
        return pagamento;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setMoment(Instant moment) {
        this.moment = moment;
    }
    public void setpedidoStatus(pedidoStatus pedidoStatus) {
        if (pedidoStatus != null) {
            this.pedidoStatus = pedidoStatus.getCode();
        }
    }

    public void setClient(cliente client) {
        this.client = client;
    }

    public void setpagamento(pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Double getTotal() {
		double sum = 0.0;
		for (itemPedido x : items) {
			sum += x.getSubTotal();
		}
		return sum;
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
        pedido other = (pedido) obj;
        if (id == null) {
            if(other.getId() != null)
                return false;
        }else if(!id.equals(other.getId())){
            return false;
        }
        return true;
    }
}
