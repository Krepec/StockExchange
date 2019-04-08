package pl.krepec.stockExchange.repository.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PortfolioDAO.class)
public abstract class PortfolioDAO_ {

	public static volatile SingularAttribute<PortfolioDAO, Double> stockCurrentPrice;
	public static volatile SingularAttribute<PortfolioDAO, String> stockSymbol;
	public static volatile SingularAttribute<PortfolioDAO, Integer> numberOfShares;
	public static volatile SingularAttribute<PortfolioDAO, Integer> id;

	public static final String STOCK_CURRENT_PRICE = "stockCurrentPrice";
	public static final String STOCK_SYMBOL = "stockSymbol";
	public static final String NUMBER_OF_SHARES = "numberOfShares";
	public static final String ID = "id";

}

