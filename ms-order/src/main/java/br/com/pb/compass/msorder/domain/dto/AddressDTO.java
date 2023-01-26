package br.com.pb.compass.msorder.domain.dto;

import lombok.Data;


@Data
public class AddressDTO{
    private String cep;
    private String numero;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
}
