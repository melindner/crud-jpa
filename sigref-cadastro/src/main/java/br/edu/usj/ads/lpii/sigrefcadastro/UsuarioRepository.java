package br.edu.usj.ads.lpii.sigrefcadastro;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    List<Usuario> findAll();

    List<Usuario> findByNomeContainingIgnoreCase(String nome);
    


}