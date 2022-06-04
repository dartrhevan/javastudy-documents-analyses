package org.javastudy.documents.service.impl;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.javastudy.documents.model.analyses.AnalyticalReport;
import org.javastudy.documents.service.AnalysesSaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Slf4j
@Service
public class JsonAnalysesSaver implements AnalysesSaver {
    private final String reportFilePath;
    private final ObjectMapper objectMapper;

    @Autowired
    public JsonAnalysesSaver(@Value("${application.report-file-path:./report.json}") String reportFilePath) {
        this.reportFilePath = reportFilePath;
        objectMapper = new ObjectMapper();
    }

    @Override
    public void saveAnalytics(AnalyticalReport analytics) {
        log.info("Saving analyses to {}", reportFilePath);
        try {
            objectMapper.writeValue(new File(reportFilePath), analytics);
        } catch (StreamWriteException | DatabindException e) {
            log.error("Error serializing {}", analytics);
        } catch (IOException exception) {
            log.error("Can't save file", exception);
        }
    }
}
