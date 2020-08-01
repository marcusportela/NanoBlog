package com.programem.Nanoblog;

public class ListaMensagem {
    String exibeListaMensagem(Iterable<Mensagem> lista){
        String html = "";

        for(Mensagem c : lista){
            html = html +
            "<h1>id:"+c.getId()+"</h1>"+
            "<p>Titulo:"+c.getTitulo()+"</p>"+
            "<p>Texto:"+c.getTexto()+"</p>"+
            "<br>"
            ;
        }
        return html;
    }
}