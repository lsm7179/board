package com.test.board.domain;

import com.test.user.domain.AccountType;
import com.test.user.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User("이승민", AccountType.LESSEE, "lsm");
    }

    @DisplayName("게시글 생성")
    @Test
    void create() {
        Board board = new Board("제목", "내용입니다.", user);

        assertThat(board).isNotNull();
    }
}
