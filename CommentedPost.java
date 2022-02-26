
import java.util.ArrayList;
/**
 * Write a description of class CommentedPost here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CommentedPost extends Post
{
    int likes;
    //ArrayList<String> comments = new ArrayList<String>();
    String comments;
    public CommentedPost(String author)
    {
        super(author);
        timestamp = System.currentTimeMillis();
        likes = 0;
        //comments = new ArrayList<>();
        comments = null;
    }

    /**
     * Record one more 'Like' indication from a user.
     */
    public void like()
    {
        likes++;
    }

    /**
     * Record that a user has withdrawn his/her 'Like' vote.
     */
    public void unlike()
    {
        if (likes > 0) {
            likes--;
        }
    }

    /**
     * Add a comment to this post.
     * 
     * @param text  The new comment to add.
     */
    public void addComment(String text)
    {
        comments = text;
    }
    /*
    public void display()
    {
        //super.display();
        if(likes > 0) {
            System.out.println("  -  " + likes + " people like this.");
        }
        else {
            System.out.println();
        }
        
        if(comments.isEmpty()) {
            System.out.println("   No comments.");
        }
        else {
            System.out.println("   " + comments.size() + " comment(s). Click here to view.");
        }
    }
    */
    public String display1()
    {
        //super.display();
        if(likes > 0) {
            return likes + " people like this.";
        }
        else {
            return "0 people like this.";
        }
        /*
        if(comments.isEmpty()) {
            System.out.println("   No comments.");
        }
        else {
            System.out.println("   " + comments.size() + " comment(s). Click here to view.");
        }
        */
    }
    public String display2()
    {
        //super.display();
        /*
        if(likes > 0) {
            return likes + " people like this.";
        }
        else {
            return "0 people like this.";
        }
        */
        
        if(comments.isEmpty()) {
            return "   No comments.";
        }
        else {
            return "Comment posted: " + comments;
        }
        
    }
}


