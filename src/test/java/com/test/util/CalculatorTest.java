package com.test.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @DisplayName("객체 생성")
    @Test
    void create() {
        Calculator cal = new Calculator();
        assertThat(cal).isNotNull();
    }

    @DisplayName("덧셈 검증")
    @Test
    void plus() {
        Calculator cal = new Calculator();

        int plus = cal.plus(2, 3);
        int plus2 = cal.plus(3, 4);

        assertThat(plus).isEqualTo(5);
        assertThat(plus2).isEqualTo(7);
    }

}
