package com.gap.mongodb.practice.MongoDBPractice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "seasonCodeResources")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SeasonCodeMapping {

    private String id;
    @Id
    private String systemName;
    private List<SeasonCodes> seasonCodes;

}
