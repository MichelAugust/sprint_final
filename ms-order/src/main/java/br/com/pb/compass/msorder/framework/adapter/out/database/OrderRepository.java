package br.com.pb.compass.msorder.framework.adapter.out.database;

import br.com.pb.compass.msorder.domain.model.Address;
import br.com.pb.compass.msorder.domain.model.Order;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByCpf(Sort sorted, String cpf);

    //Order save(Order entity, Address addressDTO);
}
