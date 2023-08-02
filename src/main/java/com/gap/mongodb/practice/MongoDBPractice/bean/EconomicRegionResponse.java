package com.gap.mongodb.practice.MongoDBPractice.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EconomicRegionResponse {
    private String economicRegionCode;
    private String currencyCode;
    private List<TicketPriceValueResponse> ticketPrices;
}
