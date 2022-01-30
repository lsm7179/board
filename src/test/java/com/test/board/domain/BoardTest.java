package com.test.board.domain;

import com.test.user.domain.AccountType;
import com.test.user.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class BoardTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User("이승민", AccountType.NORMAL, "lsm");
    }

    @DisplayName("게시글 생성")
    @Test
    void create() {
        Board board = new Board("제목", "내용입니다.", user);

        assertAll(
                () -> assertThat(board).isNotNull(),
                () -> assertThat(board.isDeleted()).isFalse()
        );

    }

    @DisplayName("게시글 삭제 검증")
    @Test
    void delete() {
        Board board = new Board("제목", "내용입니다.", user);

        board.delete();

        assertThat(board.isDeleted()).isTrue();
    }
}
