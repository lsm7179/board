package com.test.board.domain;

import com.test.user.domain.AccountType;
import com.test.user.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @DisplayName("게시글 등록")
    @Test
    void create() {
        User user = new User("이승민", AccountType.NORMAL, "lsm");
        Board board = new Board("제목", "내용입니다.", user);

        Board savedBoard = boardRepository.save(board);

        assertThat(savedBoard.getId()).isNotNull();

    }
}