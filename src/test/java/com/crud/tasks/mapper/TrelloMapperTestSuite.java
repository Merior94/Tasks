package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TrelloMapperTestSuite {

    @Autowired
    TrelloMapper trelloMapper;

    @Test
    void testMapToBoardDtoList(){
        //given
        List<TrelloBoard> trelloBoardList = new ArrayList<>();
        TrelloBoard trelloBoard1 = new TrelloBoard("id1", "name1", new ArrayList<>());
        TrelloBoard trelloBoard2 = new TrelloBoard("id2", "name2", new ArrayList<>());

        trelloBoardList.add(trelloBoard1);
        trelloBoardList.add(trelloBoard2);

        //when
        List<TrelloBoardDto> trelloBoardDtoList = trelloMapper.mapToBoardsDto(trelloBoardList);

        //then
        assertEquals(2,trelloBoardDtoList.size());
        assertEquals(trelloBoard1.getId(), trelloBoardDtoList.get(0).getId());
        assertEquals(trelloBoard1.getName(), trelloBoardDtoList.get(0).getName());

        assertEquals(trelloBoard2.getId(), trelloBoardDtoList.get(1).getId());
        assertEquals(trelloBoard2.getName(), trelloBoardDtoList.get(1).getName());
    }

    @Test
    void testMapToBoardList(){
        //given
        List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();
        TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto("id1", "name1", new ArrayList<>());
        TrelloBoardDto trelloBoardDto2 = new TrelloBoardDto("id2", "name2", new ArrayList<>());

        trelloBoardDtoList.add(trelloBoardDto1);
        trelloBoardDtoList.add(trelloBoardDto2);

        //when
        List<TrelloBoard> trelloBoardList = trelloMapper.mapToBoards(trelloBoardDtoList);

        //then
        assertEquals(2,trelloBoardList.size());
        assertEquals(trelloBoardDto1.getId(), trelloBoardList.get(0).getId());
        assertEquals(trelloBoardDto1.getName(), trelloBoardList.get(0).getName());

        assertEquals(trelloBoardDto2.getId(), trelloBoardList.get(1).getId());
        assertEquals(trelloBoardDto2.getName(), trelloBoardList.get(1).getName());
    }

    @Test
    void testMapToTrelloDtoList(){
        //given
        List<TrelloList> trelloListList = new ArrayList<>();
        TrelloList trelloList1 = new TrelloList("id1", "name1", false);
        TrelloList trelloList2 = new TrelloList("id2", "name2", false);

        trelloListList.add(trelloList1);
        trelloListList.add(trelloList2);

        //when
        List<TrelloListDto> TrelloListListDto = trelloMapper.mapToListDto(trelloListList);

        //then
        assertEquals(2,TrelloListListDto.size());
        assertEquals(trelloList1.getId(), TrelloListListDto.get(0).getId());
        assertEquals(trelloList1.getName(), TrelloListListDto.get(0).getName());

        assertEquals(trelloList2.getId(), TrelloListListDto.get(1).getId());
        assertEquals(trelloList2.getName(), TrelloListListDto.get(1).getName());
    }

    @Test
    void testMapToTrelloList(){
        //given
        List<TrelloListDto> trelloListDtoList = new ArrayList<>();
        TrelloListDto trelloListDto1 = new TrelloListDto("id1", "name1", false);
        TrelloListDto trelloListDto2 = new TrelloListDto("id2", "name2", false);

        trelloListDtoList.add(trelloListDto1);
        trelloListDtoList.add(trelloListDto2);

        //when
        List<TrelloList> TrelloListList = trelloMapper.mapToList(trelloListDtoList);

        //then
        assertEquals(2,TrelloListList.size());
        assertEquals(trelloListDto1.getId(), TrelloListList.get(0).getId());
        assertEquals(trelloListDto1.getName(), TrelloListList.get(0).getName());

        assertEquals(trelloListDto2.getId(), TrelloListList.get(1).getId());
        assertEquals(trelloListDto2.getName(), TrelloListList.get(1).getName());
    }

    @Test
    void testMapToTrelloCardDto(){
        //given
        TrelloCard trelloCard = new TrelloCard("name1", "description1", "pos1", "list1");

        //when
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        //then
        assertEquals(trelloCard.getName(), trelloCardDto.getName());
        assertEquals(trelloCard.getDescription(), trelloCardDto.getDescription());
        assertEquals(trelloCard.getPos(), trelloCardDto.getPos());
        assertEquals(trelloCard.getListId(), trelloCardDto.getListId());
    }

    @Test
    void testMapToTrelloCard(){
        //given
        TrelloCardDto trelloCardDto = new TrelloCardDto("name1", "description1", "pos1", "list1");

        //when
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        //then
        assertEquals(trelloCardDto.getName(), trelloCard.getName());
        assertEquals(trelloCardDto.getDescription(), trelloCard.getDescription());
        assertEquals(trelloCardDto.getPos(), trelloCard.getPos());
        assertEquals(trelloCardDto.getListId(), trelloCard.getListId());
    }

}
