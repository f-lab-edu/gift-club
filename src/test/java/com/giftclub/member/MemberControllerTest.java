package com.giftclub.member;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.giftclub.member.request.MemberLoginRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MemberControllerTest {

    @Autowired
    protected ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    @Test
    @Transactional
    @Rollback(true)
    void signup() throws Exception {

        Member member =
                Member.builder().memberEmail("tes2@com").memberName("w").memberPassword("df").build();

        String content = objectMapper.writeValueAsString(member);
        mockMvc
                .perform(
                        MockMvcRequestBuilders.post("/members/signup")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(content))
                .andExpect(status().isOk());
    }

    @Test
    void login() throws Exception {

        MemberLoginRequest memberLoginRequest
                = MemberLoginRequest.builder().memberEmail("tes@com").memberPassword("df").build();

        String content = objectMapper.writeValueAsString(memberLoginRequest);
        mockMvc
                .perform(
                        MockMvcRequestBuilders.post("/members/login")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(content))
                .andExpect(status().isOk());
    }
}
