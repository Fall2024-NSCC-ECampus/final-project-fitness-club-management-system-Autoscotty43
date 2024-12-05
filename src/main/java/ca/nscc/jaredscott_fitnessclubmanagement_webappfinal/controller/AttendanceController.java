package ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.controller;

import ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    // Display the list of attendance records
    @GetMapping
    public String getAttendance(Model model) {
        model.addAttribute("attendanceRecords", attendanceService.getAllAttendanceRecords());
        return "attendance/list"; // View template for displaying attendance
    }

    // Mark attendance for a member with a specific trainer
    @PostMapping("/mark")
    public String markAttendance(@RequestParam Long trainerId, @RequestParam Long memberId, @RequestParam boolean isPresent) {
        attendanceService.markAttendance(trainerId, memberId, isPresent);
        return "redirect:/attendance"; // Redirect to the attendance list
    }
}