package kr.co.kospo.tms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

@SpringBootApplication
@EnableJpaAuditing // @CreatedDate, @LastModifiedDate 사용시 필요
public class TmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TmsApplication.class, args);
	}

	// Jackson Serialize 에러 - No serializer found for class -org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor and no properties discovered to create BeanSerializer
	// https://offetuoso.github.io/blog/develop/troubleshooting/jpa/no-serializer-found-for-class/
	@Bean
	Hibernate5Module hibernate5Module() {
		return new Hibernate5Module();
	}
}
