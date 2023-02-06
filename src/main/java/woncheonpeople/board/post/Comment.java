package woncheonpeople.board.post;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import woncheonpeople.board.member.Member;

@Entity
@Table(name = "comments")
@NoArgsConstructor
@Getter @Setter
public class Comment {
  @Id
  @GeneratedValue
  @Column(name = "comment_id")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "post_id")
  private Post post;

  @ManyToOne
  @JoinColumn(name = "member_id")
  private Member member;

  @CreatedDate
  private Date createDate;

  @LastModifiedDate
  private Date updateDate;
}
