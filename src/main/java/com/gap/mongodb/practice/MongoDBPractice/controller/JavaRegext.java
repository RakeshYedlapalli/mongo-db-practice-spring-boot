package com.gap.mongodb.practice.MongoDBPractice.controller;

import com.gap.mongodb.practice.MongoDBPractice.model.SeasonCodes;
import lombok.NonNull;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.util.StringUtils;

public class JavaRegext {
    static int number = 10;

    protected static Criteria addRegexMatchesCriteriaIfNotNull(@NonNull String field, String regex,
                                                               @NonNull Criteria criteria) {
        if (StringUtils.isEmpty(regex)) {
            return criteria;
        }
        criteria.and(field).regex(regex);
        return criteria;
    }

    private static Criteria addCustomerChoiceGlobalIdCriteria(String value, Criteria criteria) {
        if (StringUtils.isEmpty(value)) {
            return criteria;
        }
        return addRegexMatchesCriteriaIfNotNull("customerChoice.globalId", "^.{3}" + value + "(.*)$", criteria);
    }

    public static void main(String[] args) {

        SeasonCodes todo = new SeasonCodes("Fall", "F");
        //System.out.println("todo =>" + todo);
        SeasonCodes seasonCodes = todo;

        todo.setSeasonName("This is season");


        // System.out.println("SeasonCode =>" + seasonCodes);




     /*  // Criteria cr = new Criteria();
       // addCustomerChoiceGlobalIdCriteria("000222222322",cr);
        List<String> list = Arrays.asList("apple","apple","orange","banana","banana");
        Map<String,Integer> map = new HashMap<>();
        for(String s : list){

            if(map.get(s)!=null){
                map.put(s,map.get(s)+1);
            }else{
                map.put(s,1);
            }
        }
        System.out.println(map);*/
        int numbr = increment(number);
        System.out.println(number);
        System.out.println("enw number =>" + numbr);

    }

    public static int increment(int number) {
        number = number + 1;
        return number;
    }
}
