package com.test.board.application;

import com.test.board.domain.TestVoRepository;
import com.test.board.domain.TestVoRepository.TestVo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CacheService {

    private final TestVoRepository repository;

    public CacheService(TestVoRepository repository) {
        this.repository = repository;
    }

    @Cacheable(value = "testvo")
    public List<TestVo> list(int selectNumber){
        return repository.findBySelectNumberAll(selectNumber);
    }

    @Cacheable(value = "testvo", key = "#id")
    public TestVo findById(long id){
        return repository.findById(id);
    }
}
