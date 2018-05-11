package lab.nice.echo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.Set;
@RedisHash(value = "followers")
public class Followers implements Serializable {
    @Id
    private Long uid;
    private Set<Follow> followers;

    public Followers() {
        super();
    }

    public Followers(Long uid) {
        super();
        this.uid = uid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Set<Follow> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<Follow> followers) {
        this.followers = followers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Followers followers1 = (Followers) o;

        if (uid != null ? !uid.equals(followers1.uid) : followers1.uid != null) return false;
        return followers != null ? followers.equals(followers1.followers) : followers1.followers == null;
    }

    @Override
    public int hashCode() {
        int result = uid != null ? uid.hashCode() : 0;
        result = 31 * result + (followers != null ? followers.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Followers{" +
                "uid=" + uid +
                ", followers=" + followers +
                '}';
    }
}
