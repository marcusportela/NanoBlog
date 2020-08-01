package com.programem.Nanoblog;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class MensagemController {

    @Autowired
    private MensagemRepository mensagemRepository;

    //LISTA MENSAGEM
    private ListaMensagem listaMensagem = new ListaMensagem();

    //HTML DE INICIO
    @GetMapping("/")
    public String mensagemForm(){
      return "mensagemForm";
    }

    //INSERINDO MENSAGEM    
    @PostMapping(path="/insere")
    public @ResponseBody String addNewMensagem (
         @RequestParam String titulo
        ,@RequestParam String texto
        ) {

            Mensagem m = new Mensagem();

            m.setTitulo(titulo);
            m.setTexto(texto);
            

            mensagemRepository.save(m);

            return "A sua mensagem foi inserida em nosso banco de dados";
    }
    
    //LISTA MENSAGEM
    @GetMapping(path="/lista")
    public @ResponseBody String getAllMensagem() {
      
      Iterable<Mensagem> resultado = mensagemRepository.findAll();
      
      return listaMensagem.exibeListaMensagem(resultado);
  }

    //FILTRO FORM HERE
    /*@GetMapping(path="/filtroForm")
    public String filtroForm(){
      return "filtroForm";
    }

    @GetMapping(path="/filtro")
    public @ResponseBody String getCliente(@RequestParam Integer idade) {
    
     Iterable<Cliente> resultado = clienteRepository.findCliente(idade);
    
        return listaCliente.exibeListaCliente(resultado);
}*/ //FIM FILTRO - DESCIDIR SE VAI USAR OU NÃO -------

//INICIANDO UPDATE
@GetMapping(path="/updateForm")
public String updateForm(){
  return "updateForm";
}
//aplicando update apenas no texto
@PostMapping(path="/update")
public @ResponseBody String updateMensagem(@RequestParam String texto, @RequestParam Integer id) {
    Optional<Mensagem> o = mensagemRepository.findById(id);

    if(o.isPresent()){
      Mensagem m = o.get();
      m.setTexto(texto);
      mensagemRepository.save(m);
    }

  return "respostaUpdate";
}


//APLICAÇÃO DE DELETE

@GetMapping(path="/deleteForm")
public String deleteForm(){
  return "deleteForm";
}

@PostMapping(path="/delete")
public @ResponseBody String deleteMensagem( @RequestParam Integer id) {
  mensagemRepository.deleteById(id);
  return "respostaUpdate";
}
}