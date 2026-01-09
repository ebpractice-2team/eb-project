package com.twog.shopping.ebproj.controller;

import org.junit.jupiter.api.DisplayName;
import org.springframework.http.MediaType; // ✅ 이걸 넣어야 빨간줄이 사라집니다.
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
// ✅ MockMvc 테스트에는 이걸 써야 합니다.
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest

@AutoConfigureMockMvc
class MenuControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("상태확인")
    @Test
    public void healthCheckTest() throws Exception {
        mockMvc.perform(get("/health"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @DisplayName("4번 메뉴 확인")
    @Test
    public void findMenuByMenuCodeTest() throws Exception {
        mockMvc.perform(get("/menus/4"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.menuName").value("갈릭미역파르페"))
                .andDo(print());


    }

}