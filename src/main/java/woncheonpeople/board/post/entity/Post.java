package woncheonpeople.board.post.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import woncheonpeople.board.BaseTimeEntity;

@Entity
@Table(name = "posts")
@NoArgsConstructor
@Getter @Setter
public class Post extends BaseTimeEntity {
  @Id
  @GeneratedValue
  @Column(name = "post_id")
  private Long id;

  private String title;

  private String contents;

  private Integer hits;

  @OneToMany(mappedBy = "post")
  private List<Comment> comments = new ArrayList<>();

  public Post(String title, String contents) {
    this.title = title;
    this.contents = contents;
    this.hits = 0;
  }
}
