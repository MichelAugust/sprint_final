package br.com.pb.compass.msorder.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_Order")
public class Order {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "cpf")
    @CPF
    private String cpf;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "items_id")
    private List<Item> items;
    @Column(name = "total")
    private BigDecimal amount;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;


}


