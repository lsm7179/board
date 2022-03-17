package com.test.board.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.configurations.EnableMockMvc;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@Transactional
@EnableMockMvc
public class BoardMockMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @DisplayName("글 작성")
    @Test
    void create() throws Exception {
        String content = objectMapper.writeValueAsString(boardParams());

        mockMvc.perform(post("/board")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .header("Authorization", "1")
                        .content(content))
                .andExpect(status().isCreated())
                .andDo(MockMvcResultHandlers.log())
                .andDo(MockMvcResultHandlers.print());
    }

    @DisplayName("글 목록 확인")
    @Test
    void boardList() throws Exception{
        mockMvc.perform(get("/board")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .header("Authorization", "1"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.log())
                .andDo(MockMvcResultHandlers.print());
    }

    private Map boardParams() {
        Map<String, String> result = new HashMap<>();
        result.put("title", "제목");
        result.put("contents", "내용입니다.");
        return result;
    }
}
