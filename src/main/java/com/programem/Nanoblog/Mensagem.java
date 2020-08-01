package com.programem.Nanoblog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mensagem {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String titulo;
    private String texto;
    
    //GETS E VOID TEXTO
    public Integer getId(){
        return this.id;
    }
    public void setId(Integer id){
        this.id = id;
    }
    
    //GETS E VOID TITULO
    public String getTitulo(){
        return this.titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    //GETS E VOID TEXTO
    public String getTexto(){
        return this.texto;
    }
    public void setTexto(String texto){
        this.texto = texto;
    }
}