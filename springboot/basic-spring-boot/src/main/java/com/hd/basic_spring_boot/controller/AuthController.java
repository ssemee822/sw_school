package com.hd.basic_spring_boot.controller;

import com.hd.basic_spring_boot.dto.MemberRegDto;
import com.hd.basic_spring_boot.dto.MemberResDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("auth")
public class AuthController {
    @PostMapping("/signup")
    public ResponseEntity<MemberResDto> signup(@RequestBody MemberRegDto memberRegDto) {
        log.info("memberRegDto:{}", memberRegDto);
        MemberResDto memberResDto = new MemberResDto();

        memberResDto.setEmail(memberRegDto.getEmail());
        memberResDto.setName(memberRegDto.getName());
        memberResDto.setPwd(memberRegDto.getPwd());
        memberResDto.setImg("test/test");
        memberResDto.setRegDate(LocalDateTime.now());

        return ResponseEntity.ok(memberResDto);
    }

    @PostMapping("/login")
    public boolean login(@RequestBody MemberRegDto memberRegDto) {
        String email = "email";
        String pwd = "pwd";

        return memberRegDto.getEmail().equals(email) && memberRegDto.getPwd().equals(pwd);
    }

    @GetMapping("/memberlist")
    public List<MemberResDto> memberList(@RequestParam(required = false) String member) {
        List<MemberResDto> list = new ArrayList<>();
        for (int i = 0; i < 10; i ++) {
            MemberResDto vo = new MemberResDto();
            vo.setPwd("Pwd" + i);
            vo.setName("test" + i);
            vo.setEmail("email" + i + "@gmail.com");
            list.add(vo);
        }
        if (member != null){
            return list.stream().filter(e -> e.getName().equals(member)).toList();
        } else {
            return list;
        }
    }
}
