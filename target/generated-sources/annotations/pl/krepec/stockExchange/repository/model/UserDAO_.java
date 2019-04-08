package pl.krepec.stockExchange.repository.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserDAO.class)
public abstract class UserDAO_ {

	public static volatile SingularAttribute<UserDAO, String> password;
	public static volatile SingularAttribute<UserDAO, Integer> id;
	public static volatile SingularAttribute<UserDAO, String> userName;
	public static volatile SingularAttribute<UserDAO, Double> cash;

	public static final String PASSWORD = "password";
	public static final String ID = "id";
	public static final String USER_NAME = "userName";
	public static final String CASH = "cash";

}

