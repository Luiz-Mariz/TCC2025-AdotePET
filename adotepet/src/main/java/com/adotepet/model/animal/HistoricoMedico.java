package com.adotepet.model.animal;

import javax.xml.crypto.Data;

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

@Entity

@Table(name = "Historico_Medico")

@Getter
@Setter

@NoArgsConstructor
public class HistoricoMedico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn (name = "id_animal", foreignKey = @ForeignKey(name = "fk_historicoMedico_animal"))
    private AnimalModel animal;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "data_registro")
    private Data data_registro;
}
