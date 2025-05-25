package Blog.Blog.service;

import Blog.Blog.entity.BlogEntity;
import Blog.Blog.exceptions.CustomException;
import Blog.Blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BlogService {

    private BlogRepository blogRepository;

    @Autowired
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }


    //Get All Blog
    public List<BlogEntity> getAllBlog(){
        List<BlogEntity> allBlog = blogRepository.findAll();
        return allBlog;
    }


    //Get a Blog by ID
    public BlogEntity getBlogById(int id) throws CustomException {
        Optional<BlogEntity> byId = blogRepository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        } else {
            throw new CustomException(
                    HttpStatus.NOT_FOUND,
                    "The blog is not found for id " + id,
                    "/customer/" + id
            );
        }
    }


    //Save a Blog
    public BlogEntity postBlog(BlogEntity blogEntity) {
        BlogEntity save = blogRepository.save(blogEntity);
        return save;

    }

}
