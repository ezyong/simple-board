package com.example.borad.domain;

import lombok.Getter; 
import lombok.NoArgsConstructor;
import lombok.Setter; 
import org.springframework.data.annotation.CreatedDate; //Entity 생성 시간을 가져오기 
import org.springframework.data.jpa.domain.support.AuditingEntityListener; //Entity생성 리스너

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity //Board 클래스를 엔티티 클래스로 지정(=데이터베이스 테이블)
@EntityListeners(AuditingEntityListener.class) // 엔티티가 생성되는 시점에 체크
@NoArgsConstructor //파리미터가 없는 생성자 자동 생성 e.g.: Board() {}
@Getter //Getter 자동 생성 어노테이션
@Setter //Setter 자동 생성 어노테이션
public class Board {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10)
    private String author;

    @Column(nullable = false, length = 100)
    private String title;

    @Column (length = 500)
    private String content;

    @CreatedDate  // 시스템 타임을 가져오는 어노테이션
    private LocalDateTime createdAt; //@EntityListeners와 함께 쓰여 Entity가 생성되는 시간 출력

}
