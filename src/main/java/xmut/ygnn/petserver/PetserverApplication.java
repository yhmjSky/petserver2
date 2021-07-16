package xmut.ygnn.petserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("xmut.ygnn.petserver.dao")
public class PetserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetserverApplication.class, args);
    }

}
