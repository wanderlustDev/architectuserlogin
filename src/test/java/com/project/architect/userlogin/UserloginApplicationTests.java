package com.project.architect.userlogin;

import com.project.architect.userlogin.entity.User;
import com.project.architect.userlogin.enums.Message;
import com.project.architect.userlogin.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserloginApplicationTests {

    @Autowired
    public MockMvc mockMvc;

    @Autowired
    public UserService userService;

    @Test
    public void testCreateUser_NewUser() throws Exception {
        String uri = "/user/create";

        String username = "enriqueiglesia";
        String password = "Dringhdd1!";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(TestUtil.convertToByteArray(username, password))
                .characterEncoding(StandardCharsets.UTF_8.displayName())
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)).andReturn();

        assertEquals(200, result.getResponse().getStatus());

        Optional<User> user = userService.findByUsername("enriqueiglesia");
        assertTrue(user.isPresent());
        assertEquals(user.get().getId(), 1L, 0);
        assertEquals(user.get().getPassword(), password);
    }

    @Test
    public void testCreateUser_UserAlreadyExists() throws Exception {
        String uri = "/user/create";

        String username = "enriqueiglesia";
        String password = "Dringhdd1!";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(TestUtil.convertToByteArray(username, password))
                .characterEncoding(StandardCharsets.UTF_8.displayName())
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)).andReturn();

        assertEquals(200, result.getResponse().getStatus());

        String newUsername = "enriqueiglesia";
        String newPassword = "Shgfythf1!";

        result = mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(TestUtil.convertToByteArray(newUsername, newPassword))
                .characterEncoding(StandardCharsets.UTF_8.displayName())
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)).andReturn();

        assertTrue(result.getModelAndView().getModel().containsKey("error"));
        assertEquals(result.getModelAndView().getModel().get("error").toString(),
                Message.USER_ALREADY_EXISTS.message());
    }

    @Test
    public void testCreateUser_InvalidUsername() throws Exception {
        String uri = "/user/create";

        String username = "joy";
        String password = "Dringhdd1!";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(TestUtil.convertToByteArray(username, password))
                .characterEncoding(StandardCharsets.UTF_8.displayName())
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)).andReturn();

        assertEquals(200, result.getResponse().getStatus());

        assertTrue(result.getModelAndView().getModel().containsKey("error"));
        assertEquals(result.getModelAndView().getModel().get("error").toString(),
                "[Invalid username. Please enter a new username]");
    }

    @Test
    public void testCreateUser_InvalidPassword() throws Exception {
        String uri = "/user/create";

        String username = "enriqueiglesia";
        String password = "Drghjnk!";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(TestUtil.convertToByteArray(username, password))
                .characterEncoding(StandardCharsets.UTF_8.displayName())
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)).andReturn();

        assertEquals(200, result.getResponse().getStatus());

        assertTrue(result.getModelAndView().getModel().containsKey("error"));
        assertEquals(result.getModelAndView().getModel().get("error").toString(),
                "[Invalid password. Please enter a new password]");
    }

    @Test
    public void testCreateUser_InvalidUsernameAndPassword() throws Exception {
        String uri = "/user/create";

        String username = "esia";
        String password = "Drghjnk!";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(TestUtil.convertToByteArray(username, password))
                .characterEncoding(StandardCharsets.UTF_8.displayName())
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)).andReturn();

        assertEquals(200, result.getResponse().getStatus());

        assertTrue(result.getModelAndView().getModel().containsKey("error"));
        List<String> errors = (List<String>)result.getModelAndView().getModel().get("error");
        assertEquals(errors.size(), 2);
        assertTrue(errors.contains("Invalid username. Please enter a new username"));
        assertTrue(errors.contains("Invalid password. Please enter a new password"));

    }
}
