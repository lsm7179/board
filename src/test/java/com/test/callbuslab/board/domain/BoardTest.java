package com.test.callbuslab.board.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

    @DisplayName("게시글 생성")
    @Test
    void create() {
        Board board = new Board();

        assertThat(board).isNotNull();
    }
}
