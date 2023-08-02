package com.gap.mongodb.practice.MongoDBPractice.schedler;


import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SpringBootScheduler {

    public static void main(String[] args) throws InterruptedException {
        new SpringBootScheduler().triggerEveryMinute();

    }

    //@Scheduled(cron = "0/10 0 0 ? * *")
    public void triggerEveryMinute() throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            // System.out.println("This is every minutes scheduler->"+ new Timestamp(System.currentTimeMillis()));
            Object apigeeResponse =
                    new RestTemplate().getForEntity("http://globalassortmentweb-training.apps.cfplatform.dev.azeus.gaptech.com/health", Object.class);

            String response = apigeeResponse.toString();

            if (isAssortmentServiceDown(response)) {
                System.out.println("Apigee end point down");
            } else {
                System.out.println("Apigee end point Up");
            }
            Object pcfURL =
                    new RestTemplate().getForEntity("http://globalassortmentweb-training.apps.cfplatform.dev.azeus.gaptech.com/health", Object.class);

            String response2 = pcfURL.toString();

            if (isAssortmentServiceDown(response2)) {
                System.out.println("PCF URL end point down");
            } else {
                System.out.println("PCF URL end point Up");
            }

            Thread.sleep(10000);
           // String s = (String)
        }

    }

    /*      "message":"Exception while connecting to Assortment Service error I/O error on GET " +
            "request for \"https://stage.api.azeus.gaptech.com:443/assortment/assortment-service/_platform/status\"" +
            ": Read timed out; nested exception is java.net.SocketTimeoutException: Read timed out","thread":"http-nio-8080-exec-4",
            "tracing":{"traceId":"0e82401782d414ff","spanId":"0e82401782d414ff","requestId":"IGQFLmOCMDTIJIgG"},
            "stack-hash":"82ba3d1a","throwable-class":"ResourceAccessException","root-throwable-class":"SocketTimeoutException",
            "stack-trace":"org.springframework.web.client.ResourceAccessException: I/O error on GET request for \"" +
            "https://stage.api.azeus.gaptech.com:443/assortment/assortment-service/_platform/status\": Read timed out;" +
            " nested exception is java.net.SocketTimeoutException: Read timed out\n\tat org.springframework.web.client.RestTemplate.doExecute(RestTemplate.java:748)\n\tat
*/
    /* @Scheduled(cron = "0 15 10 15 * ?")
    public void triggerEveryFiveMinuetes(){
        System.out.println("This is every 5 minutes mentioned in card scheduler->"+ new Timestamp(System.currentTimeMillis()));
    }
//0 0/5 * 1/1 * ? *
@Scheduled(cron = "0 0/5 * 1/1 * ?")
public void triggerEveryGiveMinuetesFromWebsite(){
    int anInt = getInt();
    System.out.println("This is every 5 minutes mentioned in website->"+ new Timestamp(System.currentTimeMillis()));
}
*/
    public int getInt() {
        return 1;
    }

    public boolean isAssortmentServiceDown(String response) {
        if (response.contains("Read timed out; nested exception is java.net.SocketTimeoutException:")) {
            return true;
        }
        return false;
    }
    String regext = "^[a-z]";
}
