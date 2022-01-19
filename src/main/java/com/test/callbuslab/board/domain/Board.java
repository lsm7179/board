package com.test.callbuslab.board.domain;

import com.test.callbuslab.jpautil.BaseTimeEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Board extends BaseTimeEntity {

    @Id
    private Long id;


    protected Board() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Objects.equals(id, board.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
