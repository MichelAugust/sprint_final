package br.com.pb.compass.msorder.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_Items")
public class Item {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "nome")
    private String name;
    @Column(name = "data_de_criacao")
    private LocalDateTime creationDate;
    @Column(name = "data_de_validade")
    private LocalDateTime expirationDate;
    @Column(name = "preco")
    private BigDecimal value;
    @Column(name = "descricao")
    private String description;

}
