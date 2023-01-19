package kr.board.controller;

import kr.board.entity.UsersDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login.do")
    public String goLogin(){
        return "loginHome";
    }

    @RequestMapping("/join.do")
    public String join(){
        return "join";
    }

    @RequestMapping("/sign.do")
    public String sign(UsersDTO data){



        return "redirect:/boardList.do";
    }

}

