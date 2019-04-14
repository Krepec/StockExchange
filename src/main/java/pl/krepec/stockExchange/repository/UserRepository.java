package pl.krepec.stockExchange.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.krepec.stockExchange.repository.model.UserDAO;

@Repository
public interface UserRepository extends CrudRepository<UserDAO, Integer> {

    UserDAO findByUserName(String name);
    UserDAO findByUserNameAndPassword(String userName, String password);

}
