package pl.krepec.stockExchange.model;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import pl.krepec.stockExchange.repository.model.UserDAO;
import pl.krepec.stockExchange.repository.model.UserDAO_;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Component
public class UserSpecyfication {

    public  Specification<UserDAO> getUserByUserName(String userName) {
        return new Specification<UserDAO>() {
            @Override
            public Predicate toPredicate(Root<UserDAO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.equal(root.get(UserDAO_.userName), userName);
                return predicate;
            }
        };


    }


}
