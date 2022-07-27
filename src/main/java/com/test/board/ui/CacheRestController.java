package com.test.board.ui;

import com.test.board.application.CacheService;
import com.test.board.domain.TestVoRepository.TestVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cache")
public class CacheRestController {
    private final CacheService cacheService;

    public CacheRestController(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @GetMapping("/list/{selectNumber}")
    public ResponseEntity<List> findAllBoard(@PathVariable int selectNumber) {
        return ResponseEntity.ok(cacheService.list(selectNumber));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestVo> findById(@PathVariable Long id) {
        return ResponseEntity.ok(cacheService.findById(id));
    }
}
