package woncheonpeople.board.post;

import java.net.URI;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/posts")
@AllArgsConstructor
public class PostController {

  private PostService postService;

  @PostMapping(path = "")
  ResponseEntity<Object> createPost(@RequestBody PostDTO body) {
    Post post = postService.createPost(body);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
      .path("/{id}")
      .buildAndExpand(post.getId())
      .toUri();
    
    return ResponseEntity.created(location).build();
  }

  @GetMapping(path = "/{id}")
  ResponseEntity<Post> getPostOne(@PathVariable Long id) {
    Post post = postService.getPostOne(id);

    return ResponseEntity.ok(post);
  }

  @GetMapping(path = "")
  ResponseEntity<List<Post>> getPosts(Pageable pageable) {
    List<Post> posts = postService.getPosts(pageable);

    return ResponseEntity.ok(posts);
  }

  @PatchMapping(path = "/{id}")
  ResponseEntity<Object> updatePost(@PathVariable Long id, @RequestBody PostDTO body) {
    postService.updatePost(id, body);

    return ResponseEntity.noContent().build();
  }

  @DeleteMapping(path = "/{id}")
  ResponseEntity<Object> deletePost(@PathVariable Long id) {
    postService.deletePost(id);

    return ResponseEntity.noContent().build();
  }
}
