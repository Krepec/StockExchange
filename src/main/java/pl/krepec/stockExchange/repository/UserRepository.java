package pl.krepec.stockExchange.repository;


import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.krepec.stockExchange.repository.model.UserDAO;

@Repository
public interface UserRepository extends CrudRepository<UserDAO, Integer>, JpaSpecificationExecutor<UserDAO> {
}
