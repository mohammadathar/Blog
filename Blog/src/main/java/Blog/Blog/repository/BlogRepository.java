package Blog.Blog.repository;

import Blog.Blog.entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends  JpaRepository<BlogEntity, Integer> {
}
