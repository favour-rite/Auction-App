package org.example.service;


import org.example.data.models.AuctionHistory;
import org.example.data.models.Bid;
import org.example.data.models.Product;
import org.example.data.models.User;
import org.example.data.repository.AuctionHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionHistoryServiceImpl implements AuctionHistoryService {


    private final AuctionHistoryRepository auctionHistoryRepository;
    private final AuctionHistoryServiceImpl auctionHistoryServiceImpl;

    public AuctionHistoryServiceImpl(AuctionHistoryRepository auctionHistoryRepository, AuctionHistoryServiceImpl auctionHistoryServiceImpl, AuctionHistoryRepository auctionHistoryRepository1, AuctionHistoryServiceImpl auctionHistoryServiceImpl1) {
        this.auctionHistoryRepository = auctionHistoryRepository1;
        this.auctionHistoryServiceImpl = auctionHistoryServiceImpl1;

    }

//
//    public AuctionHistoryService addHistory(Product product, List<Bid> bidHistory, User winner) {
//
////        AuctionHistoryServiceImpl auctionHistory = new AuctionHistoryServiceImpl();
//
////        auctionHistoryRepository.save(auctionHistory);
////        return auctionHistory;
//    }

//    public List<AuctionHistoryService> viewHistory() {
//        return auctionHistoryRepository.findById();
//    }

    public String viewWinner(AuctionHistory auctionHistory) {
        return auctionHistory.getWinner();
    }



}

