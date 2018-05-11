package lab.nice.echo.repository;

import lab.nice.echo.common.TimelineType;
import lab.nice.echo.model.Timeline;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface TimelineRepository extends PagingAndSortingRepository<Timeline, Long> {
    Iterable<Timeline> findAllByUid(Long uid);

    Optional<Timeline> findByUidAndType(Long uid, TimelineType type);
}
