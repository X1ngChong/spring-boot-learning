package top.test.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.test.mp.entity.UserDO;

/**
 * @author JXS
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {
}
