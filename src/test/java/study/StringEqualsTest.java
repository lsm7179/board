package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringEqualsTest {
    @DisplayName("동등비교 비교 테스트")
    @Test
    void 동등비교테스트() {
        boolean 동등비교 = "test" == "test";

        assertThat(동등비교).isTrue();
    }

    @DisplayName("객체생성_동등비교")
    @Test
    void 객체생성_동등비교() {
        String test1 = new String("test1");
        String test2 = "test1";

        boolean 동등비교 = test1 == test2;

        assertThat(동등비교).isTrue();
    }

    @DisplayName("객체생성_equals_비교")
    @Test
    void 객체생성_equals_비교() {
        String test1 = new String("test1");
        String test2 = "test1";

        boolean 동등비교 = test1.equals(test2);

        assertThat(동등비교).isTrue();
    }
}
