package com.apress.springrecipes.sequence;

import com.apress.springrecipes.sequence.Entity.SequenceGenerator;
import com.apress.springrecipes.sequence.config.SequenceGeneratorConfiguration;

import com.apress.springrecipes.sequence.dao.SequenceDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(
        includeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.REGEX,
                        pattern = {"com.apress.springrecipes.sequence.*Dao",
                                "com.apress.springrecipes.sequence.*Service"})
        },
        excludeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ANNOTATION,
                        classes = {org.springframework.stereotype.Controller.class})
        }
)
@Slf4j
public class SequenceApplication {

    public static void main(String[] args) {
        // Ioc 컨테이너를 초기화하여 애너테이션 스케닝하기
        ApplicationContext context = new AnnotationConfigApplicationContext(SequenceGeneratorConfiguration.class);
        log.info("Sequence: {}", context.getBean(SequenceGenerator.class).getSequence());
        // Ioc 컨테이너에서 POJO 인스턴스/빈을 가져오기
        SequenceGenerator generator = context.getBean(SequenceGenerator.class);
        SequenceGenerator generator2 = context.getBean("sequenceGenerator", SequenceGenerator.class);

        log.info("Sequence: {}", generator.getSequence());
        log.info("Sequence: {}", generator2.getSequence());


        ApplicationContext context1 = new AnnotationConfigApplicationContext("com.apress.springrecipes.sequence");
        SequenceDao sequenceDao = context1.getBean(SequenceDao.class);

        log.info("Sequence: {}", sequenceDao.getNextValue("IT"));
        log.info("Sequence: {}", sequenceDao.getNextValue("IT"));

        SpringApplication.run(SequenceApplication.class, args);
    }

}
