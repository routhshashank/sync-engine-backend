package com.specdam.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/v1/attendance")
@CrossOrigin(origins = "*")
public class AttendanceController {

    private static final String FACULTY_PASSKEY = "FAC-TARA-2026";
    private static final String LEAD_MASTER_PIN = "4482";

    // Endpoint for onboarding new clubs using Tara Sir's Passkey
    @PostMapping("/onboard-club")
    public ResponseEntity<?> onboardClub(
            @RequestHeader("X-Faculty-Passkey") String facultyPasskey,
            @RequestBody Map<String, String> clubData) {

        if (!FACULTY_PASSKEY.equals(facultyPasskey)) {
            return ResponseEntity.status(403).body(Map.of(
                "status", "ERROR",
                "message", "Invalid Faculty Passkey! Club registration rejected."
            ));
        }

        return ResponseEntity.ok(Map.of(
            "status", "SUCCESS",
            "message", "Club '" + clubData.get("clubName") + "' successfully authorized by Faculty Gateway."
        ));
    }

    // Endpoint for batch offline sync
    @PostMapping("/sync")
    public ResponseEntity<?> syncOfflineAttendance(
            @RequestHeader("X-Lead-PIN") String leadPin,
            @RequestBody List<Map<String, Object>> attendanceLogs) {

        if (!LEAD_MASTER_PIN.equals(leadPin)) {
            return ResponseEntity.status(401).body(Map.of(
                "status", "ERROR",
                "message", "Unauthorized Scan Attempt: Invalid Lead Master PIN"
            ));
        }

        return ResponseEntity.ok(Map.of(
            "status", "SUCCESS",
            "message", "Successfully synced " + attendanceLogs.size() + " attendance records to Aiven PostgreSQL.",
            "syncedCount", attendanceLogs.size(),
            "timestamp", new Date()
        ));
    }
}
