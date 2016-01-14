package com.pzpwr.core.configurator;

import com.pzpwr.core.appenum.JobEnum;
import com.pzpwr.core.appenum.VisitTypeEnum;
import com.pzpwr.core.connection.VisitTypeToJobConnection;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import javax.annotation.PostConstruct;

@Configuration
public class VisitTypeToJobConnectionConfigurator {

    @Value("${visit_to_job_connection_file_path}")
    private String filePath;

    @Autowired
    private VisitTypeToJobConnection visitTypeToJobConnection;

    private Logger logger = Logger.getLogger("VisitTypeToJobConnectionConfigurator");

    @PostConstruct
    public void initialize() {
        Map<VisitTypeEnum, JobEnum> vTJConnectionMap = getVisitToJobConnectionMap();
        visitTypeToJobConnection.setVisitTypeEnumToJobEnumConnectionMap(getVisitToJobConnectionMap());
    }

    private Map<VisitTypeEnum, JobEnum> getVisitToJobConnectionMap() {
        Map<VisitTypeEnum, JobEnum> map = new HashMap<>();
        logger.debug("getAvailableRooms() called");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(
                new File(filePath)), "UTF-8"))) {
            String line = reader.readLine();
            while (line != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, "=");
                VisitTypeEnum visit = VisitTypeEnum.valueOf(tokenizer.nextToken());
                JobEnum job = JobEnum.valueOf(tokenizer.nextToken());
                map.put(visit, job);
                line = reader.readLine();
            }
            logger.info(filePath + " file loaded");
        } catch (IOException e) {
            logger.warn("Problems with loading rooms file: " + e.getMessage());
        }
        logger.debug("getAvailableRooms() executed");
        return map;
    }
}
