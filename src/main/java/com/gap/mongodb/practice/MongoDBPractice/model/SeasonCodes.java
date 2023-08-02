package com.gap.mongodb.practice.MongoDBPractice.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class SeasonCodes {
    private String seasonName;
    private String seasonIdentifier;
}

