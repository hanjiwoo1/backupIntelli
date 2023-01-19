package kr.board.service;

import kr.board.entity.UsersDTO;

import java.util.Map;

public interface LoginService {

    boolean isLogin(Map map);

    public String join(UsersDTO data);

}
