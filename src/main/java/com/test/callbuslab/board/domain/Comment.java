package com.test.callbuslab.board.domain;

import com.test.callbuslab.jpautil.BaseTimeEntity;
import com.test.callbuslab.user.domain.User;

import javax.persistence.*;


@Entity
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 300)
    private String contents;

    @ManyToOne
    @JoinColumn(name = "borad_id", foreignKey = @ForeignKey(name = "fk_comment_board"))
    private Board board;

    @ManyToOne
    @JoinColumn(name = "writer_id", foreignKey = @ForeignKey(name = "fk_comment_writer"))
    private User writer;

    @Column(nullable = false)
    private boolean deleted;

    protected Comment() {
    }

    public Comment(Board board, String contents, User writer) {
        this.board = board;
        this.contents = contents;
        this.writer = writer;
    }
}
