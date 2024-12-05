package ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.controller;

import ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.model.Admin;
import ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.model.Member;
import ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.model.Trainer;
import ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Admin login
    @PostMapping("/login")
    public Admin login(@RequestParam String username, @RequestParam String password) {
        return adminService.login(username, password);
    }

    // Add a new trainer
    @PostMapping("/trainers")
    public Trainer addTrainer(@RequestBody Trainer trainer) {
        return adminService.addTrainer(trainer);
    }

    // Add a new member
    @PostMapping("/members")
    public Member addMember(@RequestBody Member member) {
        return adminService.addMember(member);
    }

    // Update an existing trainer
    @PutMapping("/trainers/{trainerId}")
    public Trainer updateTrainer(@PathVariable Long trainerId, @RequestBody Trainer trainerDetails) {
        return adminService.updateTrainer(trainerId, trainerDetails);
    }

    // Update an existing member
    @PutMapping("/members/{memberId}")
    public Member updateMember(@PathVariable Long memberId, @RequestBody Member memberDetails) {
        return adminService.updateMember(memberId, memberDetails);
    }

    // Delete a trainer
    @DeleteMapping("/trainers/{trainerId}")
    public void deleteTrainer(@PathVariable Long trainerId) {
        adminService.deleteTrainer(trainerId);
    }

    // Delete a member
    @DeleteMapping("/members/{memberId}")
    public void deleteMember(@PathVariable Long memberId) {
        adminService.deleteMember(memberId);
    }
}