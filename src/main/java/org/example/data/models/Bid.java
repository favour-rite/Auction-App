package org.example.data.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalTime;

@Data
@RequiredArgsConstructor
@Document(collection = "bids")
public class Bid {


    @Id
    private String Id;
    private String productId;
    private Double currentBidAmount;
    private Double bidAmount;
    private Product product;
    private User user;



}
