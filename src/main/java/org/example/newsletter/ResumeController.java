package org.example.newsletter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ResumeController {

    @Autowired
    private S3Service s3Service;

    @GetMapping("/resume-manager")
    public String resumeManager() {
        return "resume-manager"; // This will look for resume-manager.html
    }

    @PostMapping("/upload-resume")
    public String handleUpload(@RequestParam("file") MultipartFile file) {
        String fileName = file.getOriginalFilename();
        if (fileName == null || !fileName.endsWith(".json")) {
            return "redirect:/resume-manager?error=InvalidFileType";
        }

        try {
            s3Service.uploadResume(file);
            return "redirect:http://alexis-cloud-resume-2026.s3-website-us-east-1.amazonaws.com/";
        } catch (Exception e) {
            e.printStackTrace();

            System.out.println("DEBUG: The error message is: " + e.getMessage());
            return "redirect:/resume-manager?error=UploadFailed";
        }
    }
}
