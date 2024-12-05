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

    public Member getMemberById(Long id) {
        Member member = memberRepository.findById(id).orElse(null);
        if (member == null) {
            throw new RuntimeException("Member not found with id: " + id);
        }
        return member;
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
}