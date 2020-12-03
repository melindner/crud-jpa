package br.edu.usj.ads.lpii.sigrefcadastro;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Empresa {



    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column
    String cnpj;

    @Column
    String nome;

    @Column
    String telefone;

    @Column
    String email;
    
    @Column
    String cep;

    @Column
    String uf;

    @Column
    String cidade;

    @Column
    String bairro;

    @Column
    String endereco;






}