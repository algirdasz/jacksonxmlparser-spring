package com.zalagaitis.springjacksonxmlparser.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.zalagaitis.springjacksonxmlparser.model.Report;

import java.io.*;
import java.time.LocalDateTime;
import java.util.List;
import com.zalagaitis.springjacksonxmlparser.repositories.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class XmlToMySqlJob {


    final ReportRepository reportRepository;

    @Autowired
    public XmlToMySqlJob(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }

    // Jackson reader from XML file
    @Scheduled(cron = "0 32 14 * * ?", zone = "Europe/Vilnius") // Scheduled time for specified time every day
    public void jacksonDataParser() throws IOException {
        File file = new File("src/main/resources/report.xml");

        XmlMapper xmlMapper = new XmlMapper();
        String xml = inputStreamToString(new FileInputStream(file));

        List<Report> list = xmlMapper.readValue(xml, new TypeReference<List<Report>>() {});

        System.out.println("Got totally elements: " + list.size());
        System.out.println("Imported at: " + LocalDateTime.now());

        // printing all records to the console
        list.forEach(System.out::println);

        // iterate through records and saving to db
        for ( Report report : list) {
             reportRepository.save(report);
        }
    }
}
