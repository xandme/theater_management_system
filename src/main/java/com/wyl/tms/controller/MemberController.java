package com.wyl.tms.controller;

import com.wyl.tms.model.MemberInfo;
import com.wyl.tms.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Yhw on 2019-05-06
 */
@RestController
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/list")
    public Object getList(@RequestHeader(value = "user_id", defaultValue = "1") Integer userId) {
        return memberService.getList(userId);
    }

    @GetMapping("/{id}/detail")
    public Object getDetail(@PathVariable("id") Integer memberId) {
        return memberService.getDetail(memberId);
    }

    @PostMapping("/add")
    public Object addMember(@RequestBody MemberInfo memberInfo){
        return memberService.addMember(memberInfo);
    }
}
