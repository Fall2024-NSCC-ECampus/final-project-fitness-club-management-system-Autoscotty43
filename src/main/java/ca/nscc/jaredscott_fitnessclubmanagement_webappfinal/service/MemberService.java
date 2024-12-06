package ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.service;

import ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.model.Member;
import ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member login(String email, String password) {
        return memberRepository.findByEmailAndPassword(email, password)
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
    }

    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    public Member getMemberById(Long memberId) {
        return null;
    }
}