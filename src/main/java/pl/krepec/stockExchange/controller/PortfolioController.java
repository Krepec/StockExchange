package pl.krepec.stockExchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.krepec.stockExchange.model.PortfolioDTO;
import pl.krepec.stockExchange.service.PortfolioService;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @GetMapping("/{id}")
    public PortfolioDTO fingById(@PathVariable("id") Integer id){
        return  portfolioService.findById(id);
    }

    @PostMapping(value = "/register", consumes = "application/json")
    public Integer addPortfolio(@RequestBody PortfolioDTO portfolioDTO){
        return portfolioService.addPortfolio(portfolioDTO);
    }

}
