package integrationTests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.example.Task6.Application;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
  webEnvironment = SpringBootTest.WebEnvironment.MOCK,
  classes = Application.class)
@AutoConfigureMockMvc
public class MeetingApiIntegrationTest {
    private static final String MEETING_PATH = "/meeting";

    @Autowired
    private MockMvc mockMvc;

    // meeting GET
    @Test
    public void whenReadAll_thenStatusIsNotImplemented() throws Exception {
        this.mockMvc.perform(get(MEETING_PATH)).andExpect(status().isNotImplemented());
    }
    
    
    // meeting POST
    @Test
    public void whenPost_thenStatusIsNotImplemented() throws Exception {
        String requestBody = """
							{
							  "meetingId": 1,
							  "subject": "Very important meeting",
							  "date": "2025-01-01"
							}	
        """;

        this.mockMvc.perform(post(MEETING_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotImplemented());
    }

    @Test
    public void whenInvalidPost_thenStatusBadRequest() throws Exception {
        // Missing subject
        String requestBody = """
							{
							  "meetingId": 1,
							  "subject": ,
							  "date": "2025-01-01"
							}	
        """;

        this.mockMvc.perform(post(MEETING_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
    
    
    // meeting/{id} GET
    
    @Test
    public void whenReadOne_thenStatusIsNotImplemented() throws Exception {
    	String targetMeetingId = "/1";
        this.mockMvc.perform(get(MEETING_PATH + targetMeetingId)).andExpect(status().isNotImplemented());
    }
    
    // meeting/{id} DELETE
    
    
    @Test
    public void whenDeleteOne_thenStatusIsNotImplemented() throws Exception {
    	String targetMeetingId = "/1";
        this.mockMvc.perform(delete(MEETING_PATH + targetMeetingId)).andExpect(status().isNotImplemented());
    }
    
}




