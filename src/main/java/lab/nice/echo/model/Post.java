package lab.nice.echo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@RedisHash(value = "posts")
public class Post implements Serializable {
    @Id
    private Long pid;
    @Indexed
    private Long uid;
    private String content;
    private String time = String.valueOf(System.currentTimeMillis());
    @Indexed
    private Long replyToPid;

    public Post() {
        super();
    }

    public Post(Long uid, String content) {
        super();
        this.uid = uid;
        this.content = content;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Long getReplyToPid() {
        return replyToPid;
    }

    public void setReplyToPid(Long replyToPid) {
        this.replyToPid = replyToPid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (pid != null ? !pid.equals(post.pid) : post.pid != null) return false;
        if (uid != null ? !uid.equals(post.uid) : post.uid != null) return false;
        if (content != null ? !content.equals(post.content) : post.content != null) return false;
        if (time != null ? !time.equals(post.time) : post.time != null) return false;
        return replyToPid != null ? replyToPid.equals(post.replyToPid) : post.replyToPid == null;
    }

    @Override
    public int hashCode() {
        int result = pid != null ? pid.hashCode() : 0;
        result = 31 * result + (uid != null ? uid.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (replyToPid != null ? replyToPid.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Post{" +
                "pid=" + pid +
                ", uid=" + uid +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                ", replyToPid=" + replyToPid +
                '}';
    }
}
