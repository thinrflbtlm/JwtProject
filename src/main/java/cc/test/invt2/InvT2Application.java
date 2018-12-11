package cc.test.invt2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableCaching
//配置mapper接口的包名
@MapperScan("cc.test.invt2.mapper")
public class InvT2Application {

    public static void main(String[] args) {
        SpringApplication.run(InvT2Application.class, args);
    }
}
