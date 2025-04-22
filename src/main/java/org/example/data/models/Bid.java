package org.example.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "bids")
public class Bid {


    @Id
    private String id;
    private String productId;
    private Double currentBidAmount;
    private Double actualBidAmount;
    private Product product;
    private String bidderUserName;
    private String bidderId;
    private User user;



}
