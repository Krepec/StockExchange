package pl.krepec.stockExchange.repository.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(HistoryDAO.class)
public abstract class HistoryDAO_ {

	public static volatile SingularAttribute<HistoryDAO, Date> operationDate;
	public static volatile SingularAttribute<HistoryDAO, String> stockSymbol;
	public static volatile SingularAttribute<HistoryDAO, Integer> id;
	public static volatile SingularAttribute<HistoryDAO, String> operation;
	public static volatile SingularAttribute<HistoryDAO, Double> stockPrice;

	public static final String OPERATION_DATE = "operationDate";
	public static final String STOCK_SYMBOL = "stockSymbol";
	public static final String ID = "id";
	public static final String OPERATION = "operation";
	public static final String STOCK_PRICE = "stockPrice";

}

