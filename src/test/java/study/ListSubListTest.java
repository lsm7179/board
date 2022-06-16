package study;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ListSubListTest {

    @Test
    void sublist() {

        List<Integer> test2 = Arrays.asList(1);
        List<Integer> list1 = test2.subList(0, test2.size()-1);
        Integer a = test2.get(test2.size() -1);

        assertThat(list1).isEqualTo(Collections.EMPTY_LIST);
        assertThat(a).isEqualTo(1);
    }
}
