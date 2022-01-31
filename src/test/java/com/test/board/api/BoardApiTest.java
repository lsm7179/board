package com.test.board.api;

import com.test.board.domain.Board;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("게시판 api 테스트")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BoardApiTest {

    @LocalServerPort
    int port;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
    }

    @DisplayName("글 작성")
    @Test
    void boardCreate() {

        Map<String, String> params = boardParams();

        ExtractableResponse response = RestAssured
                .given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .header("Authorization", "1")
                .body(params)
                .when().log().all()
                .post("/board")
                .then().log().all()
                .extract();

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    private Map boardParams() {
        Map<String, String> result = new HashMap<>();
        result.put("title", "제목");
        result.put("contents", "내용입니다.");
        return result;
    }

    @DisplayName("글 목록 확인")
    @Test
    void boardList() {
        ExtractableResponse response = RestAssured
                .given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .get("/board")
                .then().log().all()
                .extract();

        List<Board> boards = response.jsonPath()
                .getList(".", Board.class)
                .stream()
                .collect(Collectors.toList());

        assertAll(
                () -> assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value()),
                () -> assertThat(boards.size()).isPositive()
        );

    }

    @DisplayName("글 삭제 검증")
    @Test
    void deleteBoard() {
        ExtractableResponse createBoard = RestAssured
                .given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .header("Authorization", "1")
                .body(boardParams())
                .when().log().all()
                .post("/board")
                .then().log().all()
                .extract();

        Board board = createBoard.as(Board.class);

        ExtractableResponse response = RestAssured
                .given().log().all()
                .when().log().all()
                .delete("/board/{id}",board.getId())
                .then().log().all()
                .extract();

        assertThat(response.statusCode()).isEqualTo(HttpStatus.NO_CONTENT.value());

    }
}
