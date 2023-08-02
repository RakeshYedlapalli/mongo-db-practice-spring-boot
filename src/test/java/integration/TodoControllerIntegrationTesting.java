package integration;

import com.gap.mongodb.practice.MongoDBPractice.MongoDbPracticeApplication;
import com.gap.mongodb.practice.MongoDBPractice.controller.TodoController;
import com.gap.mongodb.practice.MongoDBPractice.model.ToDo;
import io.cucumber.messages.internal.com.google.gson.Gson;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MongoDbPracticeApplication.class)
@ContextConfiguration(classes = {
        TodoController.class})
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
//@EnableAutoConfiguration
public class TodoControllerIntegrationTesting {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getAllTodosIntegrationTesting() throws Exception {
        MvcResult mvcResult = mockMvc.
                perform(MockMvcRequestBuilders.get("/getAllTodos").accept(MediaType.APPLICATION_JSON)).andReturn();
        String resp =  mvcResult.getResponse().getContentAsString();
       // Assertions.assertEquals(3,listOfTodos.size());
        System.out.println("***************"+mvcResult.getResponse().getContentAsString()+"*****************");
        List<ToDo> object = new Gson().fromJson(resp,List.class);
        Assertions.assertEquals(3,object.size());

    }
    public void createToDosShouldCreateANewRecordInDatabase() throws Exception {
        MvcResult mvcResult = mockMvc.
                perform(MockMvcRequestBuilders.get("/getAllTodos").accept(MediaType.APPLICATION_JSON)).andReturn();
        System.out.println("***************"+mvcResult.getResponse().getContentAsString()+"*****************");
    }

}
