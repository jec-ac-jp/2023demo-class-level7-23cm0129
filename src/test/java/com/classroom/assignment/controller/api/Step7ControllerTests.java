package com.classroom.assignment.controller.api;

import static org.assertj.core.api.Assertions.assertThat;
import com.classroom.assignment.controller.Step7Controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.CoreMatchers.containsString;

@SpringBootTest
@AutoConfigureMockMvc
public class Step7ControllerTests {

  @Autowired
  private MockMvc mockMvc;
  @Autowired
  private Step7Controller controller;

  @Test
  void contextLoads() {
    // given
    // when
    // then
    assertThat(controller).isNotNull();
  }

  @Test
  public void allSearchOperationCheck() throws Exception {
    // given
    // when
    // then
    this.mockMvc.perform(get("/step7/search-name").param("searchName", "")).andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("田中")))
        .andExpect(content().string(containsString("佐藤")))
        .andExpect(content().string(containsString("高橋")));
  }

}
