package pl.krepec.stockExchange.repository;

import org.springframework.data.repository.CrudRepository;
import pl.krepec.stockExchange.repository.model.PortfolioDAO;

public interface PortfolioRepository extends CrudRepository<PortfolioDAO, Integer> {

    PortfolioDAO findByStockSymbol(String stockSymbol);
    PortfolioDAO findByStockSymbolAndUserId(String stockSymbol, Integer userId);
}
