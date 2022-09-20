package com.crud.tasks.service;

import com.crud.tasks.controller.TaskNotFoundException;
import com.crud.tasks.domain.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DbServiceTest {

    @Autowired
    DbService dbService;

    @Test
    void testSaveTask() throws TaskNotFoundException {
        //given
        Task task = new Task(0L, "title", "content");

        //when
        task = dbService.saveTask(task);

        //then
        assertNotEquals(0L, task.getId());
        assertEquals(1, dbService.getAllTasks().size());

        //cleanup
        dbService.deleteTask(task.getId());
    }

    @Test
    void testGetTask() throws TaskNotFoundException {
        //given
        Task task = new Task(0L, "title", "content");
        task = dbService.saveTask(task);

        //when
        task = dbService.getTask(task.getId());

        //then
        assertNotEquals(0L, task.getId());
        assertEquals(1, dbService.getAllTasks().size());

        //cleanup
        dbService.deleteTask(task.getId());
    }

    @Test
    void testDeleteTask() throws TaskNotFoundException {
        //given
        Task task = new Task(0L, "title", "content");
        task = dbService.saveTask(task);

        //when
        dbService.deleteTask(task.getId());

        //then
        assertEquals(0, dbService.getAllTasks().size());
    }
}
