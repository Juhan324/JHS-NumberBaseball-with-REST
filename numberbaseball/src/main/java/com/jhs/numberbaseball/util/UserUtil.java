package com.jhs.numberbaseball.util;

import com.jhs.numberbaseball.vo.PlayerVO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserUtil {
    private static List<PlayerVO> userList = new ArrayList<>();

    public static List<PlayerVO> getUserList(){
        return userList;
    }

    public static PlayerVO findbyName(String username){
        return userList.get(UserUtil.userExists(username));
    }
    public static boolean numberRegist(String username, int number){
        if(userList.size()==0){
            return false;
        }else{
            if(userExists(username)!=-1) {
                userList.get(userExists(username)).setNumber(number);
                return true;
            }else{
                return false;

            }
        }
    }
    public static boolean numberRegist(PlayerVO user){
        if(userList.size()==0){
            userList.add(user);
            return true;
        }else{
            if(userExists(user)!=-1) {
                userList.get(userExists(user)).setNumber(user.getNumber());
                return true;
            }else{
                return false;
            }
        }
    }

    public static boolean connectionRegist(String username, Object connection){
        if(userList.size()==0){
            PlayerVO user = new PlayerVO(username);
            user.setConnection(connection);
            userList.add(user);
            return true;
        }else{
            if(userExists(username)==-1) {
                PlayerVO user = new PlayerVO(username);
                user.setConnection(connection);
                userList.add(user);
                return true;
            }
        }
        return false;
    }

 public static boolean connectionRegist(PlayerVO user){
        if(userList.size()==0){
            userList.add(user);
            return true;
        }else{
            if(userExists(user)==-1) {
                userList.add(user);
                return true;
            }
        }
        return false;
    }

    public static int userExists(String username){
        PlayerVO user = new PlayerVO(username);
        for(PlayerVO userVo : userList) {
            if (userVo.equals(user)) {
                int index = userList.indexOf(user);
                return index;
            }
        }
        return -1;
    }

    public static int userExists(PlayerVO user){
        for(PlayerVO userVo : userList) {
            if (userVo.equals(user)) {
                int index = userList.indexOf(user);
                return index;
            }
        }
        return -1;
    }

}
