package com.todo.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // 테이블 설계시 항상 공통적으로 들어가는 생성일자, 수정일자 등의 컬럼에 대해 자동으로 값을 넣어주는 기능을 Spring-Data-Jpa에서 제공한다.
public class TodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

}
