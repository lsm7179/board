package com.test.board.dto;

import com.test.board.domain.Board;
import com.test.user.domain.User;

public class BoardRequest {
    private String title;
    private String contents;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Board toBoard(User writer) {
        return new Board(this.title, this.contents, writer);
    }
}
