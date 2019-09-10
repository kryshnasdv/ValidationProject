package com.validation.project.controller;

import static org.hamcrest.CoreMatchers.containsString;

import javax.validation.constraints.Size;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class) 
@WebMvcTest
@AutoConfigureMockMvc
public class ClassControllerTest {
	
	@Autowired
    ClassController classController;
 
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void whenEmployeeIdIsValid() throws Exception {
    	
        mockMvc.perform(MockMvcRequestBuilders.get("/getBandInfoById/124567890J")
          .contentType(MediaType.APPLICATION_JSON_UTF8))
          .andExpect(MockMvcResultMatchers.status().isOk())
          .andExpect(MockMvcResultMatchers.content().string(containsString("124567890J")));
    }
    
    @Test
    public void whenEmployeeIdIsEmpty() throws Exception {
    	String employeeId=" ";
        mockMvc.perform(MockMvcRequestBuilders.get("/getBandInfoById/"+employeeId)
          .contentType(MediaType.APPLICATION_JSON_UTF8))
          .andExpect(MockMvcResultMatchers.status().isBadRequest())
          .andExpect(MockMvcResultMatchers.content().string(containsString("EmployeeId shouldn't be blank/whitespace")));
    }
    
    //@Test
    public void whenEmployeeIdIsNull() throws Exception {
    	String employeeId=null;
        mockMvc.perform(MockMvcRequestBuilders.get("/getBandInfoById/"+employeeId)
          .contentType(MediaType.APPLICATION_JSON_UTF8))
          .andExpect(MockMvcResultMatchers.status().is4xxClientError())
          .andExpect(MockMvcResultMatchers.content().string(containsString("EmployeeId Shouldn't be null")));
    }
    
    @Test
    public void whenEmployeeIdIsNotAlphanumeric() throws Exception {
    	
        mockMvc.perform(MockMvcRequestBuilders.get("/getBandInfoById/13216!548")
          .contentType(MediaType.APPLICATION_JSON_UTF8))
          .andExpect(MockMvcResultMatchers.status().isBadRequest())
          .andExpect(MockMvcResultMatchers.content().string(containsString("EmployeeId must be Alphanumeric")));
    }
}
