package br.edu.usj.ads.lpii.sigrefcadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;









@Controller
public class UsuarioController {
    
    @Autowired
    UsuarioRepository usuarioRepository;


    @GetMapping(value="/tela-usuario")
    public ModelAndView getListarTodosUsuarios() {
        List<Usuario> listaUsuario = usuarioRepository.findAll();
    ModelAndView modelAndView = new ModelAndView("tela-usuario");
    modelAndView.addObject("listaUsuario", listaUsuario);
    return modelAndView;
    }

    @GetMapping(value="/cadastro-usuario")
    public ModelAndView getUsuario() {
    Usuario usuario = new Usuario();
    ModelAndView modelAndView = new ModelAndView("cadastro-usuario");
    modelAndView.addObject("usuario", usuario);
    return modelAndView;
    }


    @GetMapping(value="/detalhes-usuario/{id}")
    public ModelAndView getMostrarPorId(@PathVariable Long id) {
    //ler do banco
    Usuario usuario = usuarioRepository.findById(id).get();

    ModelAndView modelAndView = new ModelAndView("detalhes-usuario");
    // acrescentar
    modelAndView.addObject("usuario", usuario);
    return modelAndView;
    }

    
    @GetMapping(value="/deletar-usuario/{id}")
    public String getDeletar(@PathVariable Long id) {
    
        usuarioRepository.deleteById(id);
    return "redirect:/";
    }


    @GetMapping(value="/editar-usuario/{id}")
    public ModelAndView getEditar(@PathVariable Long id) {
        Usuario usuario = usuarioRepository.findById(id).get();

        ModelAndView modelAndView = new ModelAndView("cadastro-usuario");
        modelAndView.addObject("usuario", usuario);

    
    return modelAndView;
    }

    @GetMapping(value="/pesquisar-usuario")
    public String getPesquisarUsuario() {
        return "pesquisar-usuario";
    }
    @PostMapping(value="pesquisar-usuario")
    public ModelAndView postPesquisarUsuario(@RequestParam String nome) {
        
        List<Usuario> listaUsuario = usuarioRepository.findByNomeContainingIgnoreCase(nome);

        ModelAndView modelAndView = new ModelAndView("pesquisar-usuario");
        modelAndView.addObject("nome", nome);
        modelAndView.addObject("listaUsuario", listaUsuario);
        return modelAndView;
    }
    
    
    
    
@PostMapping(value="/cadastrar-usuario")
public String postAdicionarUsuario(Usuario usuario) {
    
   usuarioRepository.save(usuario);
    return "redirect:/";
   

}
}
