package com.test.board.domain;

import com.test.jpautil.BaseTimeEntity;
import com.test.user.domain.User;

import javax.persistence.*;

@Table(name = "likes")
@Entity
public class Like extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "writer_id", foreignKey = @ForeignKey(name = "fk_like_liker"))
    private User liker;

    @Column
    private Long contentId;

    protected Like() {
    }

    public Like(User liker, Long contentId) {
        this.liker = liker;
        this.contentId = contentId;
    }

    public Long getId() {
        return id;
    }

    public User getLiker() {
        return liker;
    }

    public Long getContentId() {
        return contentId;
    }
}
