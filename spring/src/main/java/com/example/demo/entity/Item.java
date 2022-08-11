package com.example.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.example.demo.constant.ItemSell;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Entity //클래스를 엔티티로 설정하기
@Table(name="item") //엔티티와 테이블을 매핑하기위한 테이블명
@Getter
@Setter
@ToString
public class Item {

	@Id  //프라이머리키를 지정하기
	@Column // 테이블의 컬럼이니깐 지정하기.
	@GeneratedValue(strategy = GenerationType.AUTO) // 오토 프라이머리 키값 자동생성하기
	private Long id;  //상품코드
	
	@Column(nullable = false , length = 50) // nullable --> not null 값  문자길이 50자까지
	private String itemName; //상품명

	@Column(name = "price" ,nullable = false) // 컬럼명을 price 로 하고 not null 값 지정 
	private Integer price; // 가격
	
	@Column(nullable = false) // not null 값ㅎ을 지정
	private int amount; // 재고수량
	
	@Lob
	@Column(nullable = false)
	private String itemDetail;  // 상품 상세 설명
	
	
	@Enumerated(EnumType.STRING) // enum 만든거 타입 매핑하기
	private ItemSell itemSell; // 상품 판매상태 ItemSell 이 enm으로 판매중인지 확인하는것임.
	
	
	private LocalDateTime regTime; // 상품 등록시간
	
	private LocalDateTime updateTime;  // 상품 수정 시간
}
