package com.basicjpaweb.basicjpaweb.user;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping
    public String testUserController() {
        return "Hello usercontroller!!";
    }

    @GetMapping("/{userId}")
    public String getUserEmailByID(@PathVariable Integer userId) {
        RestTemplate restTemplate = new RestTemplate();
        //adding headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Application");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String userDataUrl = "https://reqres.in/api/users/" + userId;
        Response resObject = restTemplate.exchange(userDataUrl, HttpMethod.GET,entity, Response.class).getBody();
        return resObject.getData().getEmail();
    }

}
