package ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.service;

import ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.model.Admin;
import ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.model.Member;
import ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.model.Trainer;
import ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.repository.AdminRepository;
import ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.repository.MemberRepository;
import ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private MemberRepository memberRepository;

    public Admin login(String username, String password) {
        Admin admin = adminRepository.findByUsername(username);
        if (admin != null && admin.getPassword().equals(password)) {
            return admin;
        }
        throw new RuntimeException("Invalid credentials");
    }

    // Add a new trainer
    public Trainer addTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    // Add a new member
    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    // Update an existing trainer
    public Trainer updateTrainer(Long trainerId, Trainer trainerDetails) {
        Trainer trainer = trainerRepository.findById(trainerId).orElseThrow(() -> new RuntimeException("Trainer not found"));
        trainer.setName(trainerDetails.getName());
        trainer.setSpecialty(trainerDetails.getSpecialty());
        return trainerRepository.save(trainer);
    }

    // Update an existing member
    public Member updateMember(Long memberId, Member memberDetails) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("Member not found"));
        member.setName(memberDetails.getName());
        member.setMembershipType(memberDetails.getMembershipType());
        return memberRepository.save(member);
    }

    // Delete a trainer
    public void deleteTrainer(Long trainerId) {
        trainerRepository.deleteById(trainerId);
    }

    // Delete a member
    public void deleteMember(Long memberId) {
        memberRepository.deleteById(memberId);
    }
}
