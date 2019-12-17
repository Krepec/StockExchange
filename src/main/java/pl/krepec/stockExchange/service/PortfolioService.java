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

    private PortfolioRepository portfolioRepository;
    private Json json;

    @Autowired
    public PortfolioService(PortfolioRepository portfolioRepository, Json json) {
        this.portfolioRepository = portfolioRepository;
        this.json = json;
    }

    private PortfolioDTO mapPortfolio(PortfolioDAO portfolioDAO) {
        return new PortfolioDTO(portfolioDAO.getId(), portfolioDAO.getStockSymbol(), portfolioDAO.getNumberOfShares(), portfolioDAO.getStockCurrentPrice(),portfolioDAO.getUserId());
    }

    public PortfolioDTO getPortfolioInfoFromUrl(String stockSymbol) {
      //  String url = "https://cloud.iexapis.com/latest/tops?token=pk_a3e7dd6ef6be498583b1da342ebb6901&symbols="+stockSymbol;
        String url = "https://sandbox.iexapis.com/stable/stock/market/batch?symbols="+stockSymbol+"&types=quote&token=Tsk_7b87800c054143e3a8cd563853686bce";
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

    public PortfolioDTO getPortfolioByStockBySymbolAndId(String stockSymbol, Integer id) {
        PortfolioDAO portfolioDAO = portfolioRepository.findByStockSymbolAndUserId(stockSymbol, id);
        return mapPortfolio(portfolioDAO);
    }

    public String updatePortfolio(Integer id, UpdatePortfolioDetail updatePortfolioDetail) {
        PortfolioDAO portfolioDAO = portfolioRepository.findOne(id);
        portfolioDAO.setNumberOfShares(updatePortfolioDetail.getNumberOfShares());
        System.out.println(portfolioDAO);
        portfolioRepository.save(portfolioDAO);
        return "Portfolio updated! Number of shares: " + portfolioDAO.getNumberOfShares();

    }
}
