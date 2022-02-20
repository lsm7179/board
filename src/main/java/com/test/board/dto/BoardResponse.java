package com.test.board.dto;

import com.test.board.domain.Board;

public class BoardResponse {

    private long id;
    private String title;
    private String contents;
    private String writerName;

    private BoardResponse(long id, String title, String contents, String writerName) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.writerName = writerName;
    }

    public static BoardResponse from(Board board) {
        return new BoardResponse(board.getId(), board.getTitle(), board.getContents(),
                board.getWriter().getNickname());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }
}
