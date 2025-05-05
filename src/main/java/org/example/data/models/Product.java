package org.example.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.data.enums.AuctionStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "products")
public class Product {

    @Id
    private String Id;
    private String productName;
    private String description;
    private String category;
    private double startingPrice;
    private LocalTime auctionStartTime;
    private LocalTime auctionEndTime;
    private LocalTime timeStamp;
    private LocalDate dateStamp;
    private double currentBidAmount;
    private String imageUrl;


    private List<Bid> bids;
    private List<AuctionHistory> auctionHistory;
    private AuctionStatus auctionStatus;

}



