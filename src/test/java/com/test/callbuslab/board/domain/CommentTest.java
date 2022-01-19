package com.test.callbuslab.board.domain;

import com.test.callbuslab.user.domain.AccountType;
import com.test.callbuslab.user.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CommentTest {

    private Board board;
    private User user;

    @BeforeEach
    void setUp() {
        board = new Board();// TODO 생성자 수정
        user = new User("이승민", AccountType.LESSEE, "lsm");
    }

    @DisplayName("생성 검증")
    @Test
    void create() {
        Comment comment = new Comment(board, "댓글작성테스트", user);

        assertThat(comment).isNotNull();
    }
}
