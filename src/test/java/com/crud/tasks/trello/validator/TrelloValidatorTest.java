package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TrelloValidatorTest {

    @Autowired
    TrelloValidator trelloValidator;

    @Test
    void testValidateCard(){
        //given
        TrelloCard trelloCard = new TrelloCard("name1","description1", "pos1", "list1");

        //when
        boolean valid = trelloValidator.validateCard(trelloCard);

        //then
        assertTrue(valid);
    }

    @Test
    void testValidateCardTest(){
        //given
        TrelloCard trelloCard = new TrelloCard("test","description1", "pos1", "list1");

        //when
        boolean valid = trelloValidator.validateCard(trelloCard);

        //then
        assertFalse(valid);
    }

    @Test
    void testValidateTrelloBoards(){
        //given
        List<TrelloBoard> trelloBoardList = new ArrayList<>();
        TrelloBoard trelloBoard1 = new TrelloBoard("id1", "name1", new ArrayList<>());
        TrelloBoard trelloBoard2 = new TrelloBoard("id2", "name2", new ArrayList<>());
        TrelloBoard trelloBoard3 = new TrelloBoard("id3", "test", new ArrayList<>());
        TrelloBoard trelloBoard4 = new TrelloBoard("id4", "TEST", new ArrayList<>());
        TrelloBoard trelloBoard5 = new TrelloBoard("id5", "Test", new ArrayList<>());
        TrelloBoard trelloBoard6 = new TrelloBoard("id6", "tEsT", new ArrayList<>());

        trelloBoardList.add(trelloBoard1);
        trelloBoardList.add(trelloBoard2);
        trelloBoardList.add(trelloBoard3);
        trelloBoardList.add(trelloBoard4);
        trelloBoardList.add(trelloBoard5);
        trelloBoardList.add(trelloBoard6);

        //when
        List<TrelloBoard> trelloBoardListFiltered = trelloValidator.validateTrelloBoards(trelloBoardList);

        //then
        assertTrue(trelloBoardListFiltered.contains(trelloBoard1));
        assertTrue(trelloBoardListFiltered.contains(trelloBoard2));
        assertFalse(trelloBoardListFiltered.contains(trelloBoard3));
        assertFalse(trelloBoardListFiltered.contains(trelloBoard4));
        assertFalse(trelloBoardListFiltered.contains(trelloBoard5));
        assertFalse(trelloBoardListFiltered.contains(trelloBoard6));
    }
}
