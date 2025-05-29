package com.adotepet.model.ong;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

@Table(name = "ong")

@Getter
@Setter

@NoArgsConstructor
public class OngModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "email")
    private String email;

    @Column(name = "instagram")
    private String instagram;

    @Column(name = "responsavel_nome")
    private String responsavelNome;

    /*@ManyToOne
    @JoinColumn(name = "endereco ", foreignKey = @ForeignKey(name = "fk_ong_endereco"))
    private EnderecoModel endereco; */ 
}
