package ait.forum.dao;

import ait.forum.model.Post;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class ForumImpl implements Forum {

    private Post[] posts;
    private int size;
    public ForumImpl() {
        this.posts = new Post[100];
    }
   private Comparator<Post> comparator = (p1,p2) -> p1.getAuthor().compareTo(p2.getAuthor());

    @Override
    public boolean addPost(Post post) {
        if (post == null || size == posts.length || getPostById(post.getPostId()) != null) {
            return false;
        }
        posts[size++] = post;
        return true;
    }

    @Override
    public boolean removePost(int postId) {
        for (int i = 0; i < size; i++) {
            if (posts[i].getPostId() == postId) {
                System.arraycopy(posts, i + 1, posts, i, size - i - 1);
                posts[--size] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updatePost(int postId, String content) {
        Post post = getPostById(postId);
        if(post == null) {
            return false;
        }
        post.setContent(content);
        return true;
    }

    @Override
    public Post getPostById(int postId) {
        for (int i = 0; i < size(); i++) {
            if (posts[i].getPostId() == postId) {
                return posts[i];
            }
        }
        return null;
    }

    @Override
    public Post[] getPostByAuthor(String author) {
        return findPostByPredicate(p -> p.getAuthor().equals(author));
    }


    @Override
    public Post[] getPostByAuthorByPeriod(String author, LocalDate dateFrom, LocalDate dateTo) {
        Post pattern = new Post(0,null,author,null,dateFrom.atStartOfDay(), 0);
        int from = Arrays.binarySearch(posts,0, size, pattern, comparator);
        from = from >=0 ? from : -from -1;
        pattern = new Post(0,null,author,null,dateTo.plusDays(1).atStartOfDay(),0);
        int to = Arrays.binarySearch(posts,0, size, pattern, comparator);
        to = to >= 0 ? to : -to -1;
        return Arrays.copyOfRange(posts, from, to);
    }

    @Override
    public int size() {
        return size;
    }
    private Post[] findPostByPredicate(Predicate<Post> predicate) {
        Post[] res = new Post[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (predicate.test(posts[i])) {
                res[j++] = posts[i];
            }
        }
        return Arrays.copyOf(res, j);
    }
}
