package com.test.board.application;

import com.test.board.domain.Board;
import com.test.board.domain.BoardRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }


    public List<Board> findAllBoard() {
        return boardRepository.findAll();
    }
}
