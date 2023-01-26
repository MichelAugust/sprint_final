package br.com.pb.compass.msorder.framework.helper.viacep;

import br.com.pb.compass.msorder.domain.dto.AddressDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url="https://viacep.com.br/ws/", name = "viacep")
public interface ViaCepClient {

    @GetMapping("{cep}/json")
    AddressDTO findByCep(@PathVariable("cep") String cep) ;


}
