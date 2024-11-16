package top.hyzhu.service.impl;

import top.hyzhu.entity.User;
import top.hyzhu.mapper.UserMapper;
import top.hyzhu.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hyzhu
 * @since 2024-11-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
