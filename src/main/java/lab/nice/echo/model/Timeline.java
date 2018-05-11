package lab.nice.echo.model;

import lab.nice.echo.common.TimelineType;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;
import java.util.Set;

@RedisHash(value = "timeline")
public class Timeline implements Serializable {
    @Id
    private Long tid;
    @Indexed
    private Long uid;
    @Indexed
    private TimelineType type;
    private Set<Long> pids;

    public Timeline() {
        super();
    }

    public Timeline(Long uid, TimelineType type) {
        super();
        this.uid = uid;
        this.type = type;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public TimelineType getType() {
        return type;
    }

    public void setType(TimelineType type) {
        this.type = type;
    }

    public Set<Long> getPids() {
        return pids;
    }

    public void setPids(Set<Long> pids) {
        this.pids = pids;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Timeline timeline = (Timeline) o;

        if (tid != null ? !tid.equals(timeline.tid) : timeline.tid != null) return false;
        if (uid != null ? !uid.equals(timeline.uid) : timeline.uid != null) return false;
        if (type != timeline.type) return false;
        return pids != null ? pids.equals(timeline.pids) : timeline.pids == null;
    }

    @Override
    public int hashCode() {
        int result = tid != null ? tid.hashCode() : 0;
        result = 31 * result + (uid != null ? uid.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (pids != null ? pids.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Timeline{" +
                "tid=" + tid +
                ", uid=" + uid +
                ", type=" + type +
                ", pids=" + pids +
                '}';
    }
}
