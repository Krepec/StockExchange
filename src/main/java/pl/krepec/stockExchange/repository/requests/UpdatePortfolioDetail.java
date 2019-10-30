package pl.krepec.stockExchange.repository.requests;

import org.springframework.stereotype.Component;

import javax.persistence.Column;

@Component
public class UpdatePortfolioDetail {

    @Column(name = "number_of_shares")
    private Double numberOfShares;

    public Double getNumberOfShares() {
        return numberOfShares;
    }

    public void setNumberOfShares(Double numberOfShares) {
        this.numberOfShares = numberOfShares;
    }

}
