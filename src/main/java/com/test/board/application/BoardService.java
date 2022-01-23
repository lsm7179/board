package com.test.board.application;

import com.test.board.domain.Board;
import com.test.board.domain.BoardRepository;
import com.test.board.dto.BoardRequest;
import com.test.user.application.UserService;
import com.test.user.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private final UserService userService;
    private final BoardRepository boardRepository;

    public BoardService(UserService userService, BoardRepository boardRepository) {
        this.userService = userService;
        this.boardRepository = boardRepository;
    }


    public Board create(BoardRequest boardRequest, String authorization) {
        User writer = userService.authentication(authorization);
        Board board = boardRequest.toBoard(writer);
        return boardRepository.save(board);
    }

    public List<Board> findAllBoard() {
        return boardRepository.findAll();
    }


}
