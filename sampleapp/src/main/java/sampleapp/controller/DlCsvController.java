package sampleapp.controller;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/download")
public class DlCsvController {
    @Value("${app.tmpfile.folder}")
    private String tmpFilePath;
    
    @GetMapping("/csv")
    public void downloadCSV(HttpServletResponse rsp) {
        // encoding
        rsp.setContentType(MimeTypeUtils.APPLICATION_OCTET_STREAM_VALUE + ";charset=utf-8");
        // filename
        rsp.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"test.csv\"");
        
        try (PrintWriter pw = rsp.getWriter()) {
            pw.print("no,title,content\n");
            pw.print("1,test,sample\n");
            pw.print("2,attempt,example\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
