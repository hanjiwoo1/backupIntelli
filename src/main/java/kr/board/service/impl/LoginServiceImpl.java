package kr.board.service.impl;

import kr.board.entity.UsersDTO;
import kr.board.mapper.LoginMapper;
import kr.board.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper mapper;

    @Override
    public boolean isLogin(Map map) {

        return false;
    }

    @Override
    public String join(UsersDTO data) {

        return null;
    }
}
