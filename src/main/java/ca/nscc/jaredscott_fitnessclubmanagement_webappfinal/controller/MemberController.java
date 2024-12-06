package ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.controller;

import ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.model.Member;
import ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {
    @Autowired
    private MemberService memberService;

    // Add a new member
    @PostMapping
    public Member addMember(@RequestBody Member member) {
        return memberService.addMember(member);
    }

    // Member login
    @PostMapping("/login")
    public Member login(@RequestParam String email, @RequestParam String password) {
        return memberService.login(email, password);
    }

    // Delete a member by ID
    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
    }

    // Retrieve a list of all members
    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }
}