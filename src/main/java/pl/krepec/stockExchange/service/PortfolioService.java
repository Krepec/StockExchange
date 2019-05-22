package pl.krepec.stockExchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.krepec.stockExchange.model.PortfolioDTO;
import pl.krepec.stockExchange.repository.PortfolioRepository;
import pl.krepec.stockExchange.repository.model.PortfolioDAO;
import pl.krepec.stockExchange.repository.requests.UpdateUserDetail;

@Service
public class PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;
    @Autowired
    private Json json;


    private PortfolioDTO mapPortfolio(PortfolioDAO portfolioDAO) {
        return new PortfolioDTO(portfolioDAO.getId(), portfolioDAO.getStockSymbol(), portfolioDAO.getNumberOfShares(), portfolioDAO.getStockCurrentPrice(),portfolioDAO.getUserId());
    }

    public PortfolioDTO getPortfolioInfoFromUrl(String stockSymbol) {
        String url = "https://api.iextrading.com/1.0/stock/"+ stockSymbol +"/quote";
        String jsonString = json.readUrl(url);

        return json.parseJson(jsonString);

    }

    public PortfolioDTO findById(Integer id) {
        PortfolioDAO portfolioDAO = portfolioRepository.findOne(id);
        return mapPortfolio(portfolioDAO);
    }

    public Integer addPortfolio(PortfolioDTO portfolioDTO) {
        PortfolioDAO portfolioDAO = portfolioRepository.save(new PortfolioDAO(portfolioDTO.getId(), portfolioDTO.getStockSymbol(), portfolioDTO.getNumberOfShares(), portfolioDTO.getStockCurrentPrice(), portfolioDTO.getUserId()));
        return portfolioDAO.getId();
    }

    public PortfolioDTO getPortfolioByStockBySymbol(String stockSymbol) {
        PortfolioDAO portfolioDAO = portfolioRepository.findByStockSymbol(stockSymbol);
        return mapPortfolio(portfolioDAO);
    }

    public String updatePortfolio(Integer id, UpdateUserDetail updateUserDetail) {
        PortfolioDAO portfolioDAO = portfolioRepository.findOne(id);
        portfolioDAO.setNumberOfShares(updateUserDetail.getNumberOfShares());
        portfolioRepository.save(portfolioDAO);
        return "Portfolio updated! Number of shares: " + portfolioDAO.getNumberOfShares();

    }
}
