package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Item;

public interface ItemRepository extends JpaRepository<Item , Long> {  // <엔티티 , id 값타입 >

	
	List<Item> findByItemName(String itemName); 
	//원래는 find + 엔티티 + BY + 컬럼명이지만 엔티티값 생략가능
	// 매개변수로는 검색할때 사용할 상품명 변수를 
	
	
	// 조건 or 조건입니다
	List<Item> findByItemNameOrItemDetail(String itemame,String itemDetail);
	
	
	// 어떤한값ㅂ다 작을때 ..ㅎ
	
	List<Item> findByPriceLessThan(Integer price);
	
	
	
	List<Item> findByPriceLessThanOrderByPriceDesc(Integer price);
}
