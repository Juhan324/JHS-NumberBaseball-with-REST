package com.jhs.numberbaseball.dao;

import org.apache.ibatis.annotations.Mapper;
import com.jhs.numberbaseball.vo.UserVO;

@Mapper
public interface UserDAO {
    UserVO getUser(String id);

    void insertUser(UserVO data);
}