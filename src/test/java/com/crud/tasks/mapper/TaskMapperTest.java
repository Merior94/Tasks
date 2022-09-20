package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskMapperTest {

    @Autowired
    private TaskMapper taskMapper;

    @Test
    void testMapToTaskDto(){
        //given
        Task task = new Task(0L, "title", "content");

        //when
        TaskDto taskDto = taskMapper.mapToTaskDto(task);

        //then
        assertEquals(task.getId(),taskDto.getId());
        assertEquals(task.getTitle(), taskDto.getTitle());
        assertEquals(task.getContent(), taskDto.getContent());
    }

    @Test
    void testMapToTask() {
        //given
        TaskDto taskDto = new TaskDto(0L, "title", "content");

        //when
        Task task = taskMapper.mapToTask(taskDto);

        //then
        assertEquals(taskDto.getId(),task.getId());
        assertEquals(taskDto.getTitle(), task.getTitle());
        assertEquals(taskDto.getContent(), task.getContent());
    }

    @Test
    void testMapToTaskDtoList() {
        //given
        List<Task> taskList = new ArrayList<>();
        Task task1 = new Task(0L, "title1", "content1");
        Task task2 = new Task(1L, "title2", "content2");

        taskList.add(task1);
        taskList.add(task2);

        //when
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(taskList);

        //then
        assertEquals(2,taskDtoList.size());
        assertEquals(task1.getId(),taskDtoList.get(0).getId());
        assertEquals(task1.getTitle(), taskDtoList.get(0).getTitle());
        assertEquals(task1.getContent(), taskDtoList.get(0).getContent());

        assertEquals(task2.getId(),taskDtoList.get(1).getId());
        assertEquals(task2.getTitle(), taskDtoList.get(1).getTitle());
        assertEquals(task2.getContent(), taskDtoList.get(1).getContent());
    }
}
