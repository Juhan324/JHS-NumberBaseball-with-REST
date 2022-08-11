package com.jhs.numberbaseball.DAO;

import org.apache.ibatis.annotations.Mapper;
import com.jhs.numberbaseball.VO.UserVO;

@Mapper
public interface UserDAO {
    UserVO getUser(String id);

    void insertUser(UserVO data);
}