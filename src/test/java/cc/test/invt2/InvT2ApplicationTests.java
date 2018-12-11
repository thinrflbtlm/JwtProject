package cc.test.invt2;

import cc.test.invt2.domain.User;
import cc.test.invt2.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvT2ApplicationTests {
    @Autowired
    private UserMapper userMapper;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void contextLoads() {
        System.out.println(userMapper.findByName("liming"));
//        System.out.println(userMapper.findByName("liming").getAcount().getRealname());
    }

    @Test
    public void loginTest(){
        User user = userMapper.findByLogin("liqing","123123");
        System.out.println(user.getAcount());
    }



    @Test
    public void test2(){
        System.out.println(passwordEncoder.encode("123123"));
    }


}
