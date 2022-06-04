package org.javastudy.documents;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.javastudy.documents.service.AnalysesService;
import org.javastudy.documents.service.AnalyticsSaver;
import org.javastudy.documents.service.DocumentsSource;
import org.javastudy.documents.util.TestDocumentLoader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
public class Main implements CommandLineRunner {
    private final DocumentsSource documentsSource;
    private final AnalysesService analysesService;
    private final AnalyticsSaver analyticsSaver;


    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Persist test documents");
        log.info("Loading documents");
        documentsSource.getSourceDocuments().forEach(System.out::println);
    }
}
