package com.test.board.domain;

import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class TestVoRepository {
    public class TestVo implements Serializable {
        private Long id;
        private String title;
        private String content;

        public TestVo(Long id, String title, String content) {
            this.id = id;
            this.title = title;
            this.content = content;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    public List<TestVo> findBySelectNumberAll(int selectNumber){
        System.out.println("findBySelectNumberAll 메소드 호출");
        if(selectNumber > 0){
            TestVo test1 = new TestVo(1L,"제목1","내용1");
            TestVo test2 = new TestVo(2L,"제목2","내용2");
            TestVo test3 = new TestVo(3L,"제목3","내용3");
            TestVo test4 = new TestVo(4L,"제목4","내용4");
            TestVo test5 = new TestVo(5L,"제목5","내용5");
            TestVo test6 = new TestVo(6L,"제목6","내용6");
            return List.of(test1,test2,test3,test4,test5,test6);
        }else{
            TestVo test7 = new TestVo(7L,"제목1","내용1");
            TestVo test8 = new TestVo(8L,"제목2","내용2");
            TestVo test9 = new TestVo(9L,"제목3","내용3");
            TestVo test10 = new TestVo(10L,"제목4","내용4");
            TestVo test11 = new TestVo(11L,"제목5","내용5");
            TestVo test12 = new TestVo(12L,"제목6","내용6");
            return List.of(test7,test8,test9,test10,test11,test12);
        }
    }

    public TestVo findById(long id){
        System.out.println("findById 메소드 호출");
        if(id == 1L){
            return new TestVo(1L,"제목1","내용1");
        } else if (id == 2L) {
            return new TestVo(2L,"제목2","내용2");
        }else{
            return new TestVo(3L,"제목3","내용3");
        }
    }
}
