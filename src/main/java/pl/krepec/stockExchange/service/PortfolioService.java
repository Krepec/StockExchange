package pl.krepec.stockExchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.krepec.stockExchange.model.PortfolioDTO;
import pl.krepec.stockExchange.repository.PortfolioRepository;
import pl.krepec.stockExchange.repository.model.PortfolioDAO;

@Service
public class PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;

    private PortfolioDTO mapPortfolio(PortfolioDAO portfolioDAO){
        return new PortfolioDTO(portfolioDAO.getId(),portfolioDAO.getStockSymbol(),portfolioDAO.getNumberOfShares(),portfolioDAO.getStockCurrentPrice());
    }

    public PortfolioDTO findById(Integer id){
        PortfolioDAO portfolioDAO = portfolioRepository.findOne(id);
        return mapPortfolio(portfolioDAO);
    }

    public Integer addPortfolio(PortfolioDTO portfolioDTO) {
        PortfolioDAO portfolioDAO = portfolioRepository.save(new PortfolioDAO(portfolioDTO.getId(),portfolioDTO.getStockSymbol(),portfolioDTO.getNumberOfShares(),portfolioDTO.getStockCurrentPrice()));
        return portfolioDTO.getId();
    }
}
