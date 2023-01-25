package br.com.pb.compass.msorder.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_Endereco")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "rua")
    private String street;

    @Column(name = "numero")
    private String number;

    @Column(name = "bairro")
    private String district;

    @Column(name = "cidade")
    private String city;

    @Column(name = "Estado")
    private String state;

    @Column(name = "Cep")
    private String cep;


}
