package org.javastudy.documents;


import lombok.RequiredArgsConstructor;
import org.javastudy.documents.service.AnalysesService;
import org.javastudy.documents.service.AnalysesSaver;
import org.javastudy.documents.service.DocumentsSource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication
public class Main implements CommandLineRunner {
    private final DocumentsSource documentsSource;
    private final AnalysesService analysesService;
    private final AnalysesSaver analysesSaver;


    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }

    @Override
    public void run(String... args) throws Exception {
        var documents = documentsSource.getSourceDocuments();
        var analyses = analysesService.calculateAnalytics(documents);
        analysesSaver.saveAnalytics(analyses);
    }
}
