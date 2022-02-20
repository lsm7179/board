package com.test.board.application;

import com.test.board.domain.Board;
import com.test.board.domain.BoardRepository;
import com.test.board.dto.BoardRequest;
import com.test.board.dto.BoardResponse;
import com.test.user.application.UserService;
import com.test.user.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class BoardService {

    private final UserService userService;
    private final BoardRepository boardRepository;

    public BoardService(UserService userService, BoardRepository boardRepository) {
        this.userService = userService;
        this.boardRepository = boardRepository;
    }

    @Transactional
    public Board create(BoardRequest boardRequest, String authorization) {
        User writer = userService.authentication(authorization);
        Board board = boardRequest.toBoard(writer);
        return boardRepository.save(board);
    }

    public List<Board> findAllBoard() {
        return boardRepository.findAll();
    }

    @Transactional
    public void delete(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        board.delete();
    }

    public BoardResponse findBoardById(long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        return BoardResponse.from(board);
    }
}
