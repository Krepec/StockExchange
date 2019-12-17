package pl.krepec.stockExchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.krepec.stockExchange.model.HistoryDTO;
import pl.krepec.stockExchange.repository.model.HistoryDAO;
import pl.krepec.stockExchange.service.HistoryService;

@RestController
@RequestMapping("/stockexchange/history")
public class HistoryController {

    private HistoryService historyService;

    @Autowired
    public HistoryController(HistoryService historyService){
        this.historyService = historyService;
    }

    @PostMapping(value = "/history", consumes = "application/json")
    public Integer addHistory(@RequestBody HistoryDTO historyDTO){
        HistoryDAO historyDAO = historyService.addHistory(historyDTO);
        return  historyDAO.getId();
    }

    @GetMapping("/history")
    public Iterable<HistoryDAO> getAllHistory(){
        return historyService.getAllHistory();
    }
}
