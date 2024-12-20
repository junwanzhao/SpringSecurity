package top.hyzhu;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import top.hyzhu.entity.User;
import top.hyzhu.service.IUserService;


@SpringBootTest
@Slf4j
class ApplicationTests {
    @Resource
    private IUserService userService;

    @Test
    @DisplayName("根据用户名查询用户")
    void testMp() {
        User admin = userService.getOne(new LambdaQueryWrapper<User>().eq(User::getUserName, "admin"));
        log.info(String.valueOf(admin));
    }

    @Test
    @DisplayName("插入一条用户数据")
    void insertUserTest() {
        User user = new User();
        user.setUserName("admin1");
        user.setPassword(new BCryptPasswordEncoder().encode("123456"));
        user.setLoginName("管理员");
        user.setPhone("13688888888");
        userService.save(user);
    }

    @Test
    @DisplayName("根据手机号和密码登录")
    void loginTest() {
        User user = userService.getOne(new LambdaQueryWrapper<User>().eq(User::getPhone, "13688888888"));
        if ("$2a$10$X5K22B7s4tsbhkf0twPj3eO.LgQ0fF3/8.J3IrqaeXrPap/RThr42".equals(user.getPassword())) {
            log.info("登录成功");
        } else {
            log.info("登录失败");
        }
    }
}
