package woncheonpeople.board.post;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostService {

  private PostJpaRepository postJpaRepository;

  public Post createPost(PostDTO postDTO) {
    Post saved = new Post(postDTO.getTitle(), postDTO.getContents());
    return postJpaRepository.save(saved);
  }

  public Post getPostOne(Long postId) {
    Post post = postJpaRepository.findById(postId).orElseThrow(() -> new IllegalStateException());
    post.setHits(post.getHits() + 1);
    postJpaRepository.save(post);
    return post;
  }

  public List<Post> getPosts(Pageable pageable) {
    List<Post> posts = postJpaRepository.findAll(pageable).toList();
    return posts;
  }

  public Post updatePost(Long postId, PostDTO postDTO) {
    Post saved = postJpaRepository.findById(postId).orElseThrow(() -> new IllegalStateException());
    saved.setTitle(postDTO.getTitle());
    saved.setContents(postDTO.getContents());
    return postJpaRepository.save(saved);
  }

  public void deletePost(Long postId) {
    postJpaRepository.deleteById(postId);
  }
  
}
