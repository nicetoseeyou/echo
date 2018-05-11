package lab.nice.echo.model;

import java.io.Serializable;

public class Follow implements Serializable {
    private Long uid;
    private String time = String.valueOf(System.currentTimeMillis());

    public Follow() {
        super();
    }

    public Follow(Long uid) {
        super();
        this.uid = uid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Follow follow = (Follow) o;

        if (uid != null ? !uid.equals(follow.uid) : follow.uid != null) return false;
        return time != null ? time.equals(follow.time) : follow.time == null;
    }

    @Override
    public int hashCode() {
        int result = uid != null ? uid.hashCode() : 0;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Follow{" +
                "uid=" + uid +
                ", time='" + time + '\'' +
                '}';
    }
}
