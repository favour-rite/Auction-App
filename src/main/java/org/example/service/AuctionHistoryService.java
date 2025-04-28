//package org.example.service;
//
//import org.example.data.models.AuctionHistory;
//import org.example.data.models.Bid;
//import org.example.data.models.Product;
//import org.example.data.models.User;
//import org.example.data.repository.AuctionHistoryRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class AuctionHistoryService {
//
//        @Autowired
//        private AuctionHistoryRepository auctionHistoryRepository;
//        @Autowired
//        private AuctionHistoryService auctionHistoryService;
//
//
//        public AuctionHistoryService addHistory(Product product, List<Bid> bidHistory, User winner) {
//            AuctionHistoryService auctionHistory = new AuctionHistoryService();
//
//            auctionHistoryRepository.save(auctionHistory);
//            return auctionHistory;
//        }
//
//        public List<AuctionHistoryService> viewHistory() {
//            return auctionHistoryRepository.findById();
//        }
//
//        public String viewWinner(AuctionHistory auctionHistory) {
//            return auctionHistory.getWinner();
//        }
//
//
//
//}
