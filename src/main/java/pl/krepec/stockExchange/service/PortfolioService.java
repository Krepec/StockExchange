package pl.krepec.stockExchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.krepec.stockExchange.Json;
import pl.krepec.stockExchange.model.PortfolioDTO;
import pl.krepec.stockExchange.repository.PortfolioRepository;
import pl.krepec.stockExchange.repository.model.PortfolioDAO;
import pl.krepec.stockExchange.repository.requests.UpdatePortfolioDetail;

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
        String url = "https://cloud.iexapis.com/stable/tops?token=pk_c929ec1a991e4b5fb83d4d41233ef431&symbols="+stockSymbol;
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

    public String updatePortfolio(Integer id, UpdatePortfolioDetail updatePortfolioDetail) {
        PortfolioDAO portfolioDAO = portfolioRepository.findOne(id);
        portfolioDAO.setNumberOfShares(updatePortfolioDetail.getNumberOfShares());
        portfolioRepository.save(portfolioDAO);
        return "Portfolio updated! Number of shares: " + portfolioDAO.getNumberOfShares();

    }
}
