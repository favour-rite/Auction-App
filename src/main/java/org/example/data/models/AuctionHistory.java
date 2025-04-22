package org.example.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "auctionHistory")
public class AuctionHistory {

    @Id
    private String id;
    private Date timestamp = new Date();
    private String productId;
    private String bidId;
    private String winner;


}
