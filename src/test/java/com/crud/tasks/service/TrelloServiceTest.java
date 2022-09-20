package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.*;
import com.crud.tasks.trello.client.TrelloClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static java.util.Optional.ofNullable;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TrelloServiceTest {

    @InjectMocks
    private TrelloService trelloService;

    @Mock
    private TrelloClient trelloClient;

    @Mock
    private AdminConfig adminConfig;

    @Mock
    private SimpleEmailService emailService;

    @Test
    void testFetchTrelloBoards() {
        //given
        List<TrelloBoardDto> mappedTrelloBoards =
                List.of(new TrelloBoardDto("1", "test", new ArrayList<>()));

        when(trelloClient.getTrelloBoards()).thenReturn(mappedTrelloBoards);

        //when
        List<TrelloBoardDto> fetchedBoards = trelloService.fetchTrelloBoards();

        //then
        assertEquals(mappedTrelloBoards.size(), fetchedBoards.size());
    }

    @Test
    void testCreateTrelloCard() {
        //given
        TrelloCardDto trelloCardDto = new TrelloCardDto("name", "description", "pos", "list");
        CreatedTrelloCardDto createdTrelloCardDto = new CreatedTrelloCardDto("id", "name", "url", new BadgesDto());

        when(trelloClient.createNewCard(trelloCardDto)).thenReturn(createdTrelloCardDto);
        when(adminConfig.getAdminMail()).thenReturn("admin@domain.com");

        //when
        CreatedTrelloCardDto newCard = trelloService.createTrelloCard(trelloCardDto);

        //then
        assertEquals(createdTrelloCardDto.getId(), newCard.getId());
        assertEquals(createdTrelloCardDto.getName(), newCard.getName());
        assertEquals(createdTrelloCardDto.getShortUrl(), newCard.getShortUrl());
    }
}
