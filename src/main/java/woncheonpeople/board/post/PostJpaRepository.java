package woncheonpeople.board.post;

import org.springframework.data.jpa.repository.JpaRepository;

import woncheonpeople.board.post.entity.Post;

public interface PostJpaRepository extends JpaRepository<Post, Long> {

}
