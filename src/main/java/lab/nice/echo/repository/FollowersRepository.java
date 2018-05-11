package lab.nice.echo.repository;

import lab.nice.echo.model.Following;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FollowersRepository extends PagingAndSortingRepository<Following, Long> {
}
