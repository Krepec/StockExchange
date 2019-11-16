package pl.krepec.stockExchange.repository.requests;

import org.springframework.stereotype.Component;

import javax.persistence.Column;

@Component
public class UpdatePortfolioDetail {

    @Column(name = "number_of_shares")
    private Integer numberOfShares;

    public UpdatePortfolioDetail(Integer numberOfShares) {
        this.numberOfShares = numberOfShares;
    }

    public Integer getNumberOfShares() {
        return numberOfShares;
    }

    public void setNumberOfShares(Integer numberOfShares) {
        this.numberOfShares = numberOfShares;
    }

    public UpdatePortfolioDetail() {
    }
}
