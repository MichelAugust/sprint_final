package br.com.pb.compass.msorder.repository;

import br.com.pb.compass.msorder.domain.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
