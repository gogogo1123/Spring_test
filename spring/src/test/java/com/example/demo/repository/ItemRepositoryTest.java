package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.example.demo.constant.ItemSell;
import com.example.demo.entity.Item;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class ItemRepositoryTest {


	@Autowired
	ItemRepository itemRepository; //인터페이스
	
	
	@Test
	@DisplayName("상품저장테스트")
	void createItemtest() {
		Item item = new Item();
		
		item.setItemName("테스트상품");
		item.setPrice(10000);
		item.setItemDetail("상품상세설명하기");
		item.setItemSell(ItemSell.SELL);
		item.setAmount(100);
		item.setRegTime(LocalDateTime.now());
		item.setUpdateTime(LocalDateTime.now());
		
		//아이템을 저장하자 ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ
	    Item savedItem = itemRepository.save(item);
	    
	    
	    System.out.println(savedItem.toString());
	    
	}
	
	
	@Test
	@DisplayName("리스트")
	void createList() {
		for(int i=1; i<=10; i++) {
			Item item = new Item();
			item.setItemName("테스트상품"+i);
			item.setPrice(10000+i);
			item.setItemDetail("테스트상품설명"+i);
			item.setItemSell(ItemSell.SELL);
			item.setAmount(100);
			item.setRegTime(LocalDateTime.now());
			item.setUpdateTime(LocalDateTime.now());
			
			Item savedItem = itemRepository.save(item);
		}
		

		}
	
	@Test
	@DisplayName("상품명조회")
  void findBYitemname() {
		this.createList();
		List<Item> itemList = itemRepository.findByItemName("테스트상품1");
		
		for(Item item:itemList) {
			System.out.println(item.toString());
		}
	
	}

	
	@Test
	@DisplayName("or 조건 사용하기")
	void or() {
		this.createList();
		List<Item> itemList= 
				itemRepository.findByItemNameOrItemDetail("테스트상품1","테스트상품설명3");
		
		for(Item item:itemList) {
			System.out.println(item.toString());
		}
		

	}
	
	
	
	@Test
	@DisplayName("가격찾zzz기")
	void finetest() {
		this.createList();
    List<Item> itemList = itemRepository.findByPriceLessThan(10005);
    
    for(Item item : itemList) {
    	System.out.println(item.toString());
    }
    
	}
	
	
	
	
	@Test
	@DisplayName("사이값")
	void eee1() {
		this.createList();
		
		List<Item> itemList = itemRepository.findByPriceLessThanOrderByPriceDesc(10010);
		
		for(Item item : itemList) {
			System.out.println(item.toString());
		}
	}
	
}
