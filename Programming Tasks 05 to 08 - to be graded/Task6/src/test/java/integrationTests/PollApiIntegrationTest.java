//package integrationTests;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.example.Task6.api.PollApiController;
//import com.example.Task6.model.Poll;
//
////@WebMvcTest(PollApiController.class)
//@SpringBootTest
//public class PollApiIntegrationTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
////    @MockBean
//    @Autowired
//    private PollApiController pollCtl;
//
//
//    @Test
//    public void testGetAllPolls() throws Exception {
//        // Mocking the response
//        Poll poll1 = new Poll();
//        poll1.setPollId(101);
//        poll1.setIsPublished(false);
//
//        Poll poll2 = new Poll();
//        poll2.setPollId(102);
//        poll2.setIsPublished(true);
//
//        List<Poll> polls = Arrays.asList(poll1, poll2);
//
//        when(pollCtl.pollGet()).thenReturn(ResponseEntity.ok(polls));
//
//        //  Perform GET request and validate the response
//        mockMvc.perform(get("/poll")
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$[0].pollId").value(101))
//                .andExpect(jsonPath("$[1].pollId").value(102))
//                .andExpect(jsonPath("$[0].isPublished").value(false))
//                .andExpect(jsonPath("$[1].isPublished").value(true));
//    }
//}
//
