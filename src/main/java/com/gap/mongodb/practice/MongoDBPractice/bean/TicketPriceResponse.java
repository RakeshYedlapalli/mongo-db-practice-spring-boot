package com.gap.mongodb.practice.MongoDBPractice.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TicketPriceResponse {
    private String brandCode;
    private String marketCode;
    private String channelCode;
    private String customerChoice;
    private String universalCustomerChoice;
    private String assortedCustomerChoiceId;
    private List<EconomicRegionResponse> economicRegion;
}
