package com.adotepet.model.animal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/*
 * classe principal de animal, por favor não mecher 
 * nessa classe sem avisar!!!!!
 */
@Entity

@Table(name = "animal")

@Getter
@Setter

@NoArgsConstructor
public class AnimalModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "idade")
    private int idade;

    //Fazer um enum posteriomente
    @Column(name = "porte")
    private String porte;

    //Talvez trasformar em char 
    @Column(name = "sexo")
    private String sexo;

    @Column(name = "descricao")
    private String descricao;

    //Foto por enquanto url
    @Column(name = "foto_url")
    private String foto_url;

    //FOREIGN KEY da tabela de animal
    @ManyToOne
    @JoinColumn(name = "id_tipo_animal", foreignKey = @ForeignKey(name = "fk_idTipoAnimal_animal"))
    private TipoAnimalModel tipoAnimal;

}
