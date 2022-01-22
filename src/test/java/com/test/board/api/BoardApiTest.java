package com.test.board.api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BoardApiTest {

    @LocalServerPort
    int port;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
    }

    @DisplayName("글 목록 확인")
    @Test
    void boardList() {
        RestAssured
                .given().log().all()
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when()
                    .get("/board")
                .then().log().all()
                .extract();
    }
}
