package com.UnicapHandsOn.HandsOn.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "tb_user")
public class cliente implements Serializable {

        private static final long serialVersionUID = 1L; //Numero do Serializable

    @Id//Chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)//como é uma chave numeria essa anotatio serve para demonstrar para o banco de dados que essa variavel é auto incrementavel
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;

    @OneToMany(mappedBy = "cliente")//fazendo o outro lado da relação, mostrando que a relação de user com order é de 1 para varias
    private List<item> itens = new ArrayList<>();

    public cliente (Long id,String name, String email, String phone, String password){
        super();
        this.id = id;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.password = password;
    }

    public cliente(){}//Por padrão

    public List<item> getItens() {
        return itens;
    }

    public String getEmail() {
        return email;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }public String getPhone() {
        return phone;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setPhone(String phone) {
        this.phone = phone;
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
        cliente other = (cliente) obj;
        if (id == null) {
            if(other.id != null)
                return false;
        }else if(!id.equals(other.id)){
            return false;
        }
        return true;
    }
}