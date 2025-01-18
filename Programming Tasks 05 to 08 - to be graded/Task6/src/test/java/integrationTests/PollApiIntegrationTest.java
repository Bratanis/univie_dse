package integrationTests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
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

/**
 * The validation for pollId (e.g., minimum: 0, maximum: 999) 
 * is not automatically enforced unless the endpoint is fully implemented!
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(
  webEnvironment = SpringBootTest.WebEnvironment.MOCK,
  classes = Application.class)
@AutoConfigureMockMvc
public class PollApiIntegrationTest {
    private static final String POLL_PATH = "/poll";

    @Autowired
    private MockMvc mockMvc;

    // poll GET
    @Test
    public void whenReadAll_thenStatusIsNotImplemented() throws Exception {
        this.mockMvc.perform(get(POLL_PATH)).andExpect(status().isNotImplemented());
    }


    // poll POST
    @Test
    public void whenPost_thenStatusIsNotImplemented() throws Exception {
        String requestBody = """
        {
            "pollId": 101,
            "participants": [
                {
                    "meetingId": 11,
                    "subject": "Design Review",
                    "date": "2025-01-25",
                    "participants": {
                        "minim017": "maybe"
                    }
                },
                {
                    "meetingId": 12,
                    "subject": "Project Kickoff",
                    "date": "2025-02-15",
                    "participants": {
                        "aliquipca7": "yes",
                        "esse_4": "yes"
                    }
                }
            ],
            "isPublished": false
        }
        """;

        this.mockMvc.perform(post(POLL_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotImplemented());
    }

    @Test
    public void whenInvalidPost_thenStatusBadRequest() throws Exception {
        // This body has no field isPublished
        String requestBody = """
        {
            "pollId": 101,
            "participants": [
                {
                    "meetingId": 11,
                    "subject": "Design Review",
                    "date": "2025-01-25",
                    "participants": {
                        "minim017": "maybe"
                    }
                },
                {
                    "meetingId": 12,
                    "subject": "Project Kickoff",
                    "date": "2025-02-15",
                    "participants": {
                        "aliquipca7": "yes",
                        "esse_4": "yes"
                    }
                }
            ],
        }
        """;

        this.mockMvc.perform(post(POLL_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }


    // poll/{id} GET
    @Test
    public void whenReadOne_thenStatusIsNotImplemented() throws Exception {
    	String targetPollId = "/1";
        this.mockMvc.perform(get(POLL_PATH + targetPollId)).andExpect(status().isNotImplemented());
    }

//    @Test
//    public void whenReadOneInvalidId_thenStatusBadRequest() throws Exception {
//    	String targetPollId = "/1000";
//        this.mockMvc.perform(get(POLL_PATH + targetPollId)).andExpect(status().isBadRequest());
//    }
    
    
    
    // poll/{id} DELETE
    @Test
    public void whenDeleteOne_thenStatusIsNotImplemented() throws Exception {
    	String targetPollId = "/1";
        this.mockMvc.perform(delete(POLL_PATH + targetPollId)).andExpect(status().isNotImplemented());
    }

//    @Test
//    public void whenDeleteInvalidId_thenStatusBadRequest() throws Exception {
//    	String targetPollId = "/1000";
//        this.mockMvc.perform(delete(POLL_PATH + targetPollId)).andExpect(status().isBadRequest());
//    }

    // poll/{id} PATCH

    @Test
    public void whenPatch_thenStatusIsNotImplemented() throws Exception {
    	String targetPollId = "/1";
    	String requestBody = """
    							{
    							 "isPublished": "true"
    							}
    			""";
        this.mockMvc.perform(patch(POLL_PATH + targetPollId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotImplemented());
    }

    @Test
    public void whenInvalidPatch_thenStatusBadRequest() throws Exception {
    	String targetPollId = "/1";
    	String requestBody = """
    							{
    							 "isPublished": "yes"
    							}
    			""";
        this.mockMvc.perform(patch(POLL_PATH + targetPollId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
    
    
    // /poll/{pollId}ProposedMeeting POST
    
    @Test
    public void whenPostNewProposedMeeting_thenStatusIsNotImplemented() throws Exception {
    	String restOfPath = "/1/ProposedMeeting";
        String requestBody = """
							{
							  "meetingId": "1",
							  "subject": "Office party",
							  "date": "2025-05-25",
							  "participants": {
							  }
							}
        """;

        this.mockMvc.perform(post(POLL_PATH + restOfPath)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotImplemented());
    }

    @Test
    public void whenPostNewInvalidProposedMeeting_thenStatusBadRequest() throws Exception {
    	String restOfPath = "/1/ProposedMeeting";
        // This body has date in wrong format
        String requestBody = """
							{
							  "meetingId": "1",
							  "subject": "Office party",
							  "date": "2025-25-12",
							  "participants": {
							  }
							}
        """;

        this.mockMvc.perform(post(POLL_PATH + restOfPath)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
    
    // /poll/{pollId}/ProposedMeeting/{meetingId} DELETE
    
    @Test
    public void whenDeleteOneProposedMeeting_thenStatusIsNotImplemented() throws Exception {
    	String restOfPath = "/1/ProposedMeeting/1";
        this.mockMvc.perform(delete(POLL_PATH + restOfPath)).andExpect(status().isNotImplemented());
    }

//    @Test
//    public void whenDeleteInvalidIdProposedMeeting_thenStatusBadRequest() throws Exception {
//    	String restOfPath = "/1/ProposedMeeting/1000";
//        this.mockMvc.perform(delete(POLL_PATH + restOfPath)).andExpect(status().isBadRequest());
//    }
    
    
    // /poll/{pollId}/ProposedMeeting/{meetingId} PATCH (vote for a proposal)
    
    @Test
    public void whenPatchProposedMeeting_thenStatusIsNotImplemented() throws Exception {
    	String restOfPath = "/1/ProposedMeeting/1";
        String requestBody = """
								{
								  "user": {
									"name": "Max Mustermann",
									"availability": "yes"
								  }
								}
        """;

        this.mockMvc.perform(patch(POLL_PATH + restOfPath)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotImplemented());
    }

    /**
     * enum does not get enforced on a stub
     */
//    @Test
//    public void whenPatchProposedMeeting_thenStatusBadRequest() throws Exception {
//    	String restOfPath = "/1/ProposedMeeting/1";
//        // This body has an ambiguous "availability"
//        String requestBody = """
//								{
//								  "user": {
//									"name": "Max Mustermann",
//									"availability": "don't know"
//								  }
//								}
//        """;
//
//        this.mockMvc.perform(patch(POLL_PATH + restOfPath)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(requestBody)
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isBadRequest());
//    }
    
    
   
}








