package br.com.pb.mshistory.framework.out.database;

import br.com.pb.mshistory.domain.model.History;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface HistoryRepository extends MongoRepository<History, String> {

    List<History> getByDate(LocalDate start, LocalDate end);


    List<History> getByDate(LocalDate date);
}
