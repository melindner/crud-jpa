package br.edu.usj.ads.lpii.sigrefcadastro;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface EmpresaRepository extends CrudRepository<Empresa, Long> {
    List<Empresa> findAll();

    List<Empresa> findByNomeContainingIgnoreCase(String nome);
    


}
