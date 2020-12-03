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
public class EmpresaController {
    
    @Autowired
    EmpresaRepository empresaRepository;


    @GetMapping(value="/tela-empresa")
    public ModelAndView getListarTodosEmpresa() {
        List<Empresa> listaEmpresa = empresaRepository.findAll();
    ModelAndView modelAndView = new ModelAndView("tela-empresa");
    modelAndView.addObject("listaEmpresa", listaEmpresa);
    return modelAndView;
    }

    @GetMapping(value="/cadastro-empresa")
    public ModelAndView getEmpresa() {
    Empresa empresa = new Empresa();
    ModelAndView modelAndView = new ModelAndView("cadastro-empresa");
    modelAndView.addObject("empresa", empresa);
    return modelAndView;
    }


    @GetMapping(value="/detalhes-empresa/{id}")
    public ModelAndView getMostrarPorId(@PathVariable Long id) {
    //ler do banco
    Empresa empresa = empresaRepository.findById(id).get();

    ModelAndView modelAndView = new ModelAndView("detalhes-empresa");
    // acrescentar
    modelAndView.addObject("empresa", empresa);
    return modelAndView;
    }

    
    @GetMapping(value="/deletar-empresa/{id}")
    public String getDeletar(@PathVariable Long id) {
    
        empresaRepository.deleteById(id);
    return "redirect:/";
    }


    @GetMapping(value="/editar-empresa/{id}")
    public ModelAndView getEditar(@PathVariable Long id) {
        Empresa empresa = empresaRepository.findById(id).get();

        ModelAndView modelAndView = new ModelAndView("cadastro-empresa");
        modelAndView.addObject("empresa", empresa);

    
    return modelAndView;
    }

    @GetMapping(value="/pesquisar-empresa")
    public String getPesquisarEmpresa() {
        return "/pesquisar-empresa";
    }
    @PostMapping(value="pesquisar-empresa")
    public ModelAndView postPesquisarEmpresa(@RequestParam String nome) {
        
        List<Empresa> listaEmpresa = empresaRepository.findByNomeContainingIgnoreCase(nome);

        ModelAndView modelAndView = new ModelAndView("pesquisar-empresa");
        modelAndView.addObject("nome", nome);
        modelAndView.addObject("listaEmpresa", listaEmpresa);
        return modelAndView;
    }
    
    
    
    
@PostMapping(value="/cadastrar-empresa")
public String postAdicionarUsuario(Empresa empresa) {
    
   
   empresaRepository.save(empresa);
    return "redirect:/";
   
}

}
