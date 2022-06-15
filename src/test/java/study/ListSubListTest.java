package study;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListSubListTest {

    @Test
    void sublist() {

        List<Integer> test2 = Arrays.asList(1);
        List<Integer> list1 = test2.subList(0, test2.size()-1);
        Integer a = null;
        a = test2.get(test2.size() -1);
        System.out.println(list1);
        System.out.println(a);
    }
}
