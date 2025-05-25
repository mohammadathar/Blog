package Blog.Blog.controller;

import Blog.Blog.entity.BlogEntity;
import Blog.Blog.entity.ErrorDetail;
import Blog.Blog.exceptions.CustomException;
import Blog.Blog.repository.BlogRepository;
import Blog.Blog.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class BlogController {

    private final BlogRepository blogRepository;
    private BlogService blogService;


    public BlogController(BlogService blogService, BlogRepository blogRepository) {
        this.blogService = blogService;
        this.blogRepository = blogRepository;
    }

    @GetMapping("/blog")
    public ResponseEntity<List<BlogEntity>> getAllBlog() {
        List<BlogEntity> allBlog = blogRepository.findAll();

        if (allBlog.isEmpty()) {
            throw new CustomException(HttpStatus.NO_CONTENT, "There is no data to show", "/blog");
        }

        return new ResponseEntity<>(allBlog, HttpStatus.OK);
    }


    // Get customer details by id
        //localhost:8080/customer/{id}
        @GetMapping("/blog/{id}")
        public ResponseEntity<?> getCustomerById(@PathVariable int id) throws CustomException {

            BlogEntity blogById = blogService.getBlogById(id);
            return ResponseEntity.ok().body(blogById);

        }



    @PostMapping("/blog")
    public ResponseEntity<?> postBlog(@RequestBody BlogEntity blogEntity){
        if(blogEntity==null){
            return ResponseEntity.badRequest().body("Something went wrong, Please try again");
        }
        blogService.postBlog(blogEntity);
        return ResponseEntity.ok().body(blogEntity);
    }
}
