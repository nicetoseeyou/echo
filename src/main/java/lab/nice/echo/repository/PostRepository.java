package lab.nice.echo.repository;

import lab.nice.echo.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PostRepository extends PagingAndSortingRepository<Post, Long> {
    Page<Post> findAllByUid(Pageable pageable, Long uid);
}
