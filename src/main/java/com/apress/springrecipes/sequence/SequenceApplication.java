package com.apress.springrecipes.sequence;

import com.apress.springrecipes.sequence.config.SequenceGeneratorConfiguration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
@Slf4j
public class SequenceApplication {

	public static void main(String[] args) {
		// Ioc 컨테이너를 초기화하여 애너테이션 스케닝하기
		ApplicationContext context = new AnnotationConfigApplicationContext(SequenceGeneratorConfiguration.class);
		log.info("Sequence: " + context.getBean(SequenceGenerator.class).getSequence());
		// Ioc 컨테이너에서 POJO 인스턴스/빈을 가져오기
		SequenceGenerator generator = context.getBean(SequenceGenerator.class);
		SequenceGenerator generator2 = context.getBean("sequenceGenerator", SequenceGenerator.class);

		log.info("Sequence: " + generator.getSequence());
		log.info("Sequence: " + generator2.getSequence());

		SpringApplication.run(SequenceApplication.class, args);
	}

}
