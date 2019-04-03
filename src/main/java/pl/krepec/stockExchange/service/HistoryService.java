package pl.krepec.stockExchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.krepec.stockExchange.model.HistoryDTO;
import pl.krepec.stockExchange.repository.HistoryRepository;
import pl.krepec.stockExchange.repository.model.HistoryDAO;

import java.util.Date;

@Service
public class HistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    private HistoryDAO mapHistory(HistoryDTO historyDTO){
        return new HistoryDAO(historyDTO.getId(),historyDTO.getOperation(),historyDTO.getStock_symbol(),historyDTO.getStock_price(), new Date());
    }

    public HistoryDAO addHistory(HistoryDTO historyDTO){
        HistoryDAO historyDAO = mapHistory(historyDTO);

        return historyRepository.save(historyDAO);
    }


    public Iterable<HistoryDAO> getAllHistory() {
       return historyRepository.findAll();
    }
}
