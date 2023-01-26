package br.com.pb.compass.msorder.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

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
    @Pattern(regexp = "^\\d{11}$",message = "deve ter apenas numeros")
    private String number;
    @Column(name = "bairro")
    private String district;
    @Column(name = "cidade")
    private String city;
    @Column(name = "Estado")
    private String state;
    @Column(name = "Cep")
    @Pattern(regexp = "^\\d{11}$",message = "deve ter apenas numeros")
    private String cep;


}
