package ait.forum.test;

import ait.forum.dao.Forum;
import ait.forum.dao.ForumImpl;
import ait.forum.model.Post;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class ForumImplTest {
    Forum forum;
    Post[] posts;
    LocalDateTime localDateTime = LocalDateTime.now();
    Comparator<Post> comparator = (p1, p2) -> Integer.compare(p1.getPostId(), p2.getPostId());


    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        forum = new ForumImpl();
        posts = new Post[4];
        posts[0] = new Post(1,"title1", "au1", "con1");
        posts[1] = new Post(2,"title2", "au2", "con2");
        posts[2] = new Post(3,"title3", "au3", "con3");
        for (int i = 0; i < posts.length; i++) {
            forum.addPost(posts[i]);
        }
    }


    @org.junit.jupiter.api.Test
    void addPost() {
        assertFalse(forum.addPost(null));
        assertFalse(forum.addPost(posts[0]));
        Post post = new Post(5,"5","a5","c5");
        assertTrue(forum.addPost(post));
        assertEquals(4, forum.size());
    }

    @org.junit.jupiter.api.Test
    void removePost() {
        assertFalse(forum.removePost(4));
        assertTrue(forum.removePost(1));
        assertEquals(2,forum.size());
        assertNull(forum.getPostById(1));
    }

    @org.junit.jupiter.api.Test
    void updatePost() {
        assertTrue(forum.updatePost(2,"newContent"));
        assertEquals("newContent", forum.getPostById(2).getContent());
    }

    @org.junit.jupiter.api.Test
    void getPostById() {
        assertEquals(posts[2], forum.getPostById(3));
        assertNull(forum.getPostById(8));
    }

    @org.junit.jupiter.api.Test
    void getPostByAuthor() {
        Post[] actual = forum.getPostByAuthor("au2");
        Post[] expected = {posts[1]};
        Arrays.sort(actual, comparator);  // почему мы сортируем после
        assertArrayEquals(expected, actual);

    }

    @org.junit.jupiter.api.Test
    void getPostsByAuthorByPeriod(){
        posts[0].setDate(LocalDateTime.now().minusDays(7));
        posts[1].setDate(LocalDateTime.now().minusDays(2));
        posts[2].setDate(LocalDateTime.now().minusDays(5));
        forum = new ForumImpl();
        for (Post post:posts) {
            forum.addPost(post);
        }
        Post[] actual = forum.getPostByAuthor("au1",LocalDate.now().minusDays(10), LocalDate.now().minusDays(6));
        Arrays.sort(actual, comparator);
        Post[] expected ={posts[0]};
        assertArrayEquals(expected,actual);
    }
    @org.junit.jupiter.api.Test
    void size() {
        assertEquals(3,forum.size());
    }
}