package pl.krepec.stockExchange.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.krepec.stockExchange.repository.model.HistoryDAO;

@Repository
public interface HistoryRepository extends CrudRepository<HistoryDAO, Integer> {
}
