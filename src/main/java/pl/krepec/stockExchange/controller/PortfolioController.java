package pl.krepec.stockExchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.krepec.stockExchange.model.PortfolioDTO;
import pl.krepec.stockExchange.repository.requests.UpdatePortfolioDetail;
import pl.krepec.stockExchange.service.PortfolioService;

@RestController
@RequestMapping("/stockexchange/portfolio")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @GetMapping("/stockinfo/{symbol}")
    public PortfolioDTO getStockInfoFromURL(@PathVariable("symbol") String stockSymbol){
        return portfolioService.getPortfolioInfoFromUrl(stockSymbol);
    }

    @GetMapping("/stockinfo/")
    public PortfolioDTO getPortfolioStockBySymbol(@RequestParam(value = "symbol") String stockSymbol){
        return portfolioService.getPortfolioByStockBySymbol(stockSymbol);
    }

    @GetMapping("/{id}")
    public PortfolioDTO fingById(@PathVariable("id") Integer id){
        return  portfolioService.findById(id);
    }

    @PostMapping(value = "/register", consumes = "application/json")
    public Integer addPortfolio(@RequestBody PortfolioDTO portfolioDTO){
        return portfolioService.addPortfolio(portfolioDTO);
    }

    @PutMapping("/{id}")
    public String updatePortfolio(@PathVariable(required = true, value = "id") Integer id,
                                  @RequestBody UpdatePortfolioDetail updatePortfolioDetail) {

        return portfolioService.updatePortfolio(id, updatePortfolioDetail);

    }
}
