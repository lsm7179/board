package com.test.user.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    @DisplayName("사용자 생성")
    @Test
    void create() {

        User user = new User("이승민", AccountType.LESSEE, "lsm");

        assertThat(user).isNotNull();
    }
}
