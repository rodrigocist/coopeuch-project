package com.coopeuch.task;

import com.coopeuch.task.controllers.TaskController;
import com.coopeuch.task.dto.TaskDto;
import com.coopeuch.task.services.TaskService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@WebMvcTest(TaskController.class)
public class TaskTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskService service;

    @Test
    public void createTaskAPI() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                .post("/v_1/task/")
                .content(asJsonString(getTask()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.status().is(201));
    }


    @Test
    public void getAllTasksAPI() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/v_1/task/")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    public void getTaskByIdAPI() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/v_1/task/1")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.status().is(200));
    }


    @Test
    public void deleteTaskAPI() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/v_1/task/1")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(202));
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private TaskDto getTask(){
        TaskDto task = new TaskDto();
        task.setDescription("test task 1");
        task.setValidity(true);
        return task;
    }

}
