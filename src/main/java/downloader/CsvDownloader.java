package downloader;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by matthiaspiehl on 18.03.15.
 */

/*
@Configuration
@EnableWebMvc
@Controller
@ComponentScan(basePackages = { "com.mycompany.myproject.web.controller" })
*/

@Configuration
@Controller
@RequestMapping("/downloadCSV")
public class CsvDownloader {
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String downloadCSV() throws IOException {
 //   public String downloadCSV(HttpServletResponse response) throws IOException {
        HttpServletResponse response = null;
        String csvFileName = "books.csv";

        response.setContentType("text/csv");

        // creates mock data
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                csvFileName);
        response.setHeader(headerKey, headerValue);
        response.getWriter().print("output from writer");
        response.flushBuffer();
        return "abc";

    }
}