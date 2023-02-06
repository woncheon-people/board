package woncheonpeople.board.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import woncheonpeople.board.BaseTimeEntity;

@Entity
@Table(name = "members")
@NoArgsConstructor
@Getter @Setter
public class Member extends BaseTimeEntity {
  @Id
  @GeneratedValue
  @Column(name = "member_id")
  private Long id;

  private String nickname;

  private String username;

  private String password;
}
