package com.rohitsahufirstspringproject.bookManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class BookManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookManagementApplication.class, args);
		Book book = new Book(123,"jhgvh","hgvv",500);

//		Map<Integer,Book> data = new HashMap<>();
//		Book book1 = new Book(123,"abc","xyz",50);
//		data.put(book1.getBookId(),book1);
	}

}
