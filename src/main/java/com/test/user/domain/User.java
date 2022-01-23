package com.test.user.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nickname;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Column(nullable = false, length = 100)
    private String accountId;

    @Column(nullable = false)
    private boolean quit;

    protected User() {
    }

    public User(String nickname, AccountType accountType, String accountId) {
        this.nickname = nickname;
        this.accountType = accountType;
        this.accountId = accountId;
    }

    public Long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public String getAccountId() {
        return accountId;
    }

    public boolean isQuit() {
        return quit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(accountId, user.accountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountId);
    }
}
