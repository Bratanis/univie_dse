package integrationTests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.example.Task6.Application;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
  webEnvironment = SpringBootTest.WebEnvironment.MOCK,
  classes = Application.class)
@AutoConfigureMockMvc
public class DashboardApiIntegrationTest {
    private static final String DASHBOARD_PATH = "/dashboard";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenReadAll_thenStatusIsNotImplemented() throws Exception {
        this.mockMvc.perform(get(DASHBOARD_PATH)).andExpect(status().isNotImplemented());
    }

//    @Test
//    public void whenReadOne_thenStatusIsNotImplemented() throws Exception {
//        this.mockMvc.perform(get(DASHBOARD_PATH + 1)).andExpect(status().isNotImplemented());
//    }
}