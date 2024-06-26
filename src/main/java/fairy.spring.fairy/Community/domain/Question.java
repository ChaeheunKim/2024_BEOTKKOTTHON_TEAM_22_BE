package fairy.spring.fairy.Community.domain;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Setter
@Getter
@Entity
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;


    @Column(nullable = false)
    private String email;

    @Column(nullable = true)
    private List<String> imageurl;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private Integer bookmarkcount;

    @Column(nullable = false)
    private Integer commentcount;

    @Column(nullable = false)
    private String timestamp;


    private boolean bookmarkstatus;


    @Builder
    public Question(Long id, String title, String content, String email,List<String> imageurl,String nickname,String category,Integer bookmarkcount,Integer commentcount,String timestamp,boolean bookmarkstatus) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.email=email;
        this.imageurl=imageurl;
        this.nickname=nickname;
        this.category=category;
        this.bookmarkcount=bookmarkcount;
        this.commentcount=commentcount;
        this.timestamp=timestamp;
        this.bookmarkstatus=bookmarkstatus;

    }


}
