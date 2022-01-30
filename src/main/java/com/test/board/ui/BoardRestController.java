package com.test.board.ui;

import com.test.board.application.BoardService;
import com.test.board.domain.Board;
import com.test.board.dto.BoardRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardRestController {

    private final BoardService boardService;

    public BoardRestController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Board> create(@RequestHeader String authorization, @RequestBody BoardRequest boardRequest) {
        Board created = boardService.create(boardRequest, authorization);
        URI uri = URI.create("/board" + created.getId());
        return ResponseEntity.created(uri)
                .body(created);
    }

    @GetMapping
    public ResponseEntity<List> findAllBoard() {
        return ResponseEntity.ok(boardService.findAllBoard());
    }

    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boardService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
