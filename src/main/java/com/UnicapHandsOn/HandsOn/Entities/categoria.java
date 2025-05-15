package com.UnicapHandsOn.HandsOn.Entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_categoria")
public class categoria implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "categories")// mapeando pela coleção que está na outra classe
    private Set<item> itens = new HashSet<>();//como é coleção é só get

    public categoria(){}

    public categoria(Long id, String name){
        super();
        this.id =id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Set<item> getItens() {
        return itens;
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
        categoria other = (categoria) obj;
        if (id == null) {
            if(other.getId() != null)
                return false;
        }else if(!id.equals(other.getId())){
            return false;
        }
        return true;
    }

}