package com.telusko.springbootrest.controller;

import com.telusko.springbootrest.model.JobPost;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@WebMvcTest(JobRestController.class)
class JobRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    JobRestController jobRestController;

    @Test
    public void testfirst(){
        JobPost job1 = new JobPost(1, "Software Engineer", "Developing and maintaining Java-based applications", 3, Arrays.asList("Java", "Spring Boot", "REST API"));
        JobPost job2 = new JobPost(2, "Front-End Developer", "Design and develop user interfaces using React and JavaScript", 2, Arrays.asList("JavaScript", "React", "Node.js"));
        JobPost job3 = new JobPost(3, "Data Scientist", "Work on machine learning models and data analysis", 5, Arrays.asList("Python", "Django", "Machine Learning"));

        List<JobPost>jobPosts= Arrays.asList(job1,job2,job3);

        when(jobRestController.getallJobs()).thenReturn(jobPosts);
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/jobposts"))
                    .andExpect(MockMvcResultMatchers.status().isOk())  // Expect HTTP 200 OK
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].postId").value(1))  // Check the first job's ID
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].postProfile").value("Software Engineer"))  // Check the first job's profile
                    .andExpect(MockMvcResultMatchers.jsonPath("$[1].postId").value(2))  // Check the second job's ID
                    .andExpect(MockMvcResultMatchers.jsonPath("$[1].postProfile").value("Front-End Developer"))  // Check the second job's profile
                    .andExpect(MockMvcResultMatchers.jsonPath("$[2].postId").value(3))  // Check the third job's ID
                    .andExpect(MockMvcResultMatchers.jsonPath("$[2].postProfile").value("Data Scientist"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}