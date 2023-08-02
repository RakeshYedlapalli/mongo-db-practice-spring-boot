package com.gap.mongodb.practice.MongoDBPractice.bean;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TicketPriceValueResponse {

    private BigDecimal ticketPrice;
    private String effectiveDate;

}
