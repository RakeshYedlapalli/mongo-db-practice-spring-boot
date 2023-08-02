import com.gap.mongodb.practice.MongoDBPractice.controller.ExampleInterface;
import com.gap.mongodb.practice.MongoDBPractice.controller.TodoController;
import com.gap.mongodb.practice.MongoDBPractice.model.ToDo;
import com.gap.mongodb.practice.MongoDBPractice.repository.TodoRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest
@ContextConfiguration(classes = {
        TodoController.class})
public class TestController {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    TodoRepository todoRepository;


    @MockBean
    private ExampleInterface ex;

    @MockBean
    private MongoTemplate mongoTemplate;

    @Test
    public void getAllTodosShouldGetAllTodosFoundInDatabase() throws Exception {

        List<ToDo> listOfTods = Arrays.asList(
                new ToDo("1", "rakesh", "yedlapalli", true, new Date(), new Date()));
        when(todoRepository.findAll()).thenReturn(listOfTods);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/getAllTodos").accept(MediaType.APPLICATION_JSON)).andReturn();
        verify(todoRepository).findAll();
        System.out.println(mvcResult.getResponse().getContentAsString());
        ResponseEntity<List<ToDo>> response =
                new ResponseEntity(mvcResult.getResponse(),
                        HttpStatus.OK);
        int listOfData = response.getStatusCode().value();
        Assertions.assertEquals(200, response.getStatusCode().value());
    }

    @Test
    public void getAllTodosShouldGetNoTodosFoundInDatabase() throws Exception {

        when(todoRepository.findAll()).thenReturn(Collections.emptyList());
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/getAllTodos").accept(MediaType.APPLICATION_JSON)).andReturn();
        verify(todoRepository).findAll();
        //System.out.println(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(204, mvcResult.getResponse().getStatus());

    }


    @Test
    public void getByToDoNameShouldSendListOfTodoMatchedByGivenName() throws Exception {


        List<ToDo> listOfTods = Arrays.asList(new ToDo("1", "rakesh", "yedlapalli", true, new Date(), new Date()));
        Mockito.when(todoRepository.findByTodo(Mockito.any())).thenReturn(listOfTods);
        MvcResult mvcResult =
                mockMvc.perform(MockMvcRequestBuilders.get("/getByTodoName/Python learning").accept(MediaType.APPLICATION_JSON)).andReturn();
        System.out.print("MVC Result =>" + mvcResult.getResponse());

        verify(todoRepository).findByTodo(Mockito.any());

        ResponseEntity<List<ToDo>> response =
                new ResponseEntity(mvcResult.getResponse(),
                        HttpStatus.OK);
        Assertions.assertEquals(200, mvcResult.getResponse().getStatus());

    }

    @Test
    public void getByToDoNameShouldGetResponseNoTodosFound() throws Exception {

        Mockito.when(todoRepository.findByTodo(Mockito.any())).thenReturn(Collections.emptyList());
        MvcResult mvcResult =
                mockMvc.perform(MockMvcRequestBuilders.get("/getByTodoName/Python learning").accept(MediaType.APPLICATION_JSON)).andReturn();
        System.out.print("MVC Result =>" + mvcResult.getResponse());

        verify(todoRepository).findByTodo(Mockito.any());
        /*ResponseEntity<ToDo> response =
                new ResponseEntity(mvcResult.getResponse().getContentAsString(),
                        HttpStatus.OK);*/
        Assert.assertEquals(204, mvcResult.getResponse().getStatus());

        //  ResponseEntity<ToDo> responseEntity =  mvcResult.getResponse().getContentAsString();
        // System.out.print("Response is ==>"+ mvcResult.getResponse().getContentAsString());
        //Assert.assertEquals(response.getBody().getTodo(),);

    }


    @Test
    public void createTodosShouldReturnTodosOnSuccessfullSave() throws Exception {

        ToDo toDo = new ToDo();
        toDo.setTodo("rakesh");
        toDo.setDescription("This is Description");
        toDo.setCompleted(true);

        ToDo returnD = new ToDo();
        returnD.setTodo("rakesh");
        when(todoRepository.save(any())).thenReturn(returnD);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .post("/createToDos")
                .content(asJsonString(toDo))
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        ResponseEntity<ToDo> response =
                new ResponseEntity(mvcResult.getResponse(),
                        HttpStatus.OK);

        verify(todoRepository, times(1)).save(any());
        Assertions.assertEquals(200, mvcResult.getResponse().getStatus());

    }

    @Test
    public void createTodosShouldReturnInternalServerErrorOnFailure() throws Exception {
        ToDo toDo = new ToDo();
        when(todoRepository.save(any())).thenReturn(null);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .post("/createToDos")
                .content(asJsonString(toDo))
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        ResponseEntity<ToDo> response =
                new ResponseEntity(mvcResult.getResponse(),
                        HttpStatus.OK);
        verify(todoRepository, times(1)).save(any());
        Assertions.assertEquals(500, mvcResult.getResponse().getStatus());


    }

    @Test
    public void getTodoByIdShouldGetTheTodoObject() throws Exception {
        ToDo toDo = new ToDo();
        when(todoRepository.findById(any())).thenReturn(java.util.Optional.of(toDo));
        MvcResult mvcResult =
                mockMvc.perform(MockMvcRequestBuilders.get("/getToDoByid/9399399933").accept(MediaType.APPLICATION_JSON)).andReturn();

        ResponseEntity<ToDo> response =
                new ResponseEntity(mvcResult.getResponse(),
                        HttpStatus.OK);
        verify(todoRepository, times(1)).findById(any());
        Assertions.assertEquals(200, mvcResult.getResponse().getStatus());

    }

    @Test
    public void getTodoByIdShouldGetNoContentAsResponse() throws Exception {
        ToDo toDo = new ToDo();
        when(todoRepository.findById(any())).thenReturn(Optional.empty());
        MvcResult mvcResult =
                mockMvc.perform(MockMvcRequestBuilders.get("/getToDoByid/9399399933").accept(MediaType.APPLICATION_JSON)).andReturn();

        ResponseEntity<ToDo> response =
                new ResponseEntity(mvcResult.getResponse(),
                        HttpStatus.OK);
        verify(todoRepository, times(1)).findById(any());
        Assertions.assertEquals(204, mvcResult.getResponse().getStatus());

    }

    @Test
    public void updateTodoByIdShouldReturnTheUpdatedTodoObject() throws Exception {
        ToDo toDo = new ToDo();
        toDo.setTodo("This is updated data");
        toDo.setDescription("This is updated description");
        when(todoRepository.save(any())).thenReturn(toDo);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .put("/updateData")
                .content(asJsonString(toDo))
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        verify(todoRepository, times(1)).save(any());
        Assertions.assertEquals(200, mvcResult.getResponse().getStatus());

    }

    @Test
    public void updateTodoByIdShouldReturnInternalServerError() throws Exception {
        ToDo toDo = new ToDo();
        toDo.setTodo("This is updated data");
        toDo.setDescription("This is updated description");
        when(todoRepository.save(any())).thenReturn(null);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .put("/updateData")
                .content(asJsonString(toDo))
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        verify(todoRepository, times(1)).save(any());
        Assertions.assertEquals(500, mvcResult.getResponse().getStatus());

    }

    @Test
    public void deleteTodoByIdShouldDeleteTheRecordByGivenId() throws Exception {
        doNothing().when(todoRepository).deleteById("1233444");
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .delete("/deleteById/1233444")
                .content("1233444")
                .contentType(MediaType.TEXT_PLAIN))
                .andReturn();
        verify(todoRepository).deleteById(any());
        Assertions.assertEquals(200, mvcResult.getResponse().getStatus());
    }

    /*@Test
    public void deleteTodoByIdShouldGetTheInternalServerError() throws Exception{
        doNothing().when(todoRepository).deleteById(any());
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .delete("/deleteById/kkk")
                .content("1233444")
                .contentType(MediaType.TEXT_PLAIN))
                .andReturn();
        verify(todoRepository).deleteById(any());
        Assertions.assertEquals(500,mvcResult.getResponse().getStatus());
    }*/


    @Test
    public void findByConditionShouldSendListOfTodosMatchedByGivenCondition() throws Exception {
     /*   ToDo toDo = new ToDo();
        toDo.setDescription("This is description");
        toDo.setTodo("This is do..");
        toDo.setCompleted(true);




        Query query = new Query();
        query.addCriteria(Criteria.where("todo").is(toDo));
        toDo.setCredateAt(new Date(System.currentTimeMillis()));*/


        List<ToDo> listOfTods = Arrays.asList(new ToDo("1", "rakesh", "yedlapalli", true, new Date(), new Date()));
        when(mongoTemplate.find(any(), any())).thenReturn(Collections.singletonList(listOfTods));
        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.
                        get("/getListOfTodoByCondition/This is do..")
                        .accept(MediaType.APPLICATION_JSON)).andReturn();

        verify(mongoTemplate).find(any(), any());
        Assertions.assertEquals(200, mvcResult.getResponse().getStatus());

    }

    @Test
    public void findByConditionShouldSendNoContent() throws Exception {
     /*   ToDo toDo = new ToDo();
        toDo.setDescription("This is description");
        toDo.setTodo("This is do..");
        toDo.setCompleted(true);




        Query query = new Query();
        query.addCriteria(Criteria.where("todo").is(toDo));
        toDo.setCredateAt(new Date(System.currentTimeMillis()));*/


        //List<ToDo> listOfTods = Arrays.asList(new ToDo("1", "rakesh", "yedlapalli", true, new Date(), new Date()));
        when(mongoTemplate.find(any(), any())).thenReturn(Collections.emptyList());
        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.
                        get("/getListOfTodoByCondition/This is do..")
                        .accept(MediaType.APPLICATION_JSON)).andReturn();

        verify(mongoTemplate).find(any(), any());
        Assertions.assertEquals(204, mvcResult.getResponse().getStatus());

    }
  /*  @Test
    public void updateAllByConditionShouldSendSuccessAfterUpdate() throws Exception {
        Update update = new Update();
        Query query = new Query();
        query.addCriteria(Criteria
                .where("id").in(Arrays.asList("123456","abcdefg")));
        update.set("todo","PROCESSING");
        when(mongoTemplate.updateMulti(Query.class ,Update.class,ToDo.class)).thenReturn(any());
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .put("/updateAllByCondition")
               // .content()
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        verify(mongoTemplate).updateMulti(any(),any(),any());
        Assertions.assertEquals(200,mvcResult.getResponse().getStatus());
    }
*/

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
