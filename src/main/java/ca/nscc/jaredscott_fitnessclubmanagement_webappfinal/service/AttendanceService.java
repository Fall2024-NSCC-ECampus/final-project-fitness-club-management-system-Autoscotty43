package ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.service;

import ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.model.Attendance;
import ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.model.Member;
import ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.model.Trainer;
import ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private TrainerService trainerService;

    @Autowired
    private MemberService memberService;

    public void markAttendance(Long trainerId, Long memberId, boolean isPresent) {
        Trainer trainer = trainerService.getTrainerById(trainerId);
        Member member = memberService.getMemberById(memberId);

        if (trainer == null) {
            throw new RuntimeException("Trainer not found with id: " + trainerId);
        }

        if (member == null) {
            throw new RuntimeException("Member not found with id: " + memberId);
        }

        Attendance attendance = new Attendance();
        attendance.setTrainer(trainer);
        attendance.setMember(member);
        attendance.setPresent(isPresent);
        attendanceRepository.save(attendance);
    }

    public List<Attendance> getAllAttendanceRecords() {
        return attendanceRepository.findAll();
    }

}