package lab.nice.echo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.Set;

@RedisHash(value = "following")
public class Following implements Serializable {
    @Id
    private Long uid;
    private Set<Follow> following;

    public Following() {
        super();
    }

    public Following(Long uid) {
        super();
        this.uid = uid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Set<Follow> getFollowing() {
        return following;
    }

    public void setFollowing(Set<Follow> following) {
        this.following = following;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Following following1 = (Following) o;

        if (uid != null ? !uid.equals(following1.uid) : following1.uid != null) return false;
        return following != null ? following.equals(following1.following) : following1.following == null;
    }

    @Override
    public int hashCode() {
        int result = uid != null ? uid.hashCode() : 0;
        result = 31 * result + (following != null ? following.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Following{" +
                "uid=" + uid +
                ", following=" + following +
                '}';
    }
}
