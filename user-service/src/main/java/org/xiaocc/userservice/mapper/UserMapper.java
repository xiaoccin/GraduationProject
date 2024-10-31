package org.xiaocc.userservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.xiaocc.commonmodule.entity.User;


@Mapper
public interface  UserMapper extends BaseMapper<User> {
}
