package ca.canadiantire.core.allure;

import io.qameta.allure.AllureResultsWriteException;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.Attachment;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import io.qameta.allure.model.TestResult;
import io.qameta.allure.util.PropertiesUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.Properties;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class AllureAttachmentsRemover implements TestLifecycleListener {

    private static final Properties properties = PropertiesUtils.loadAllureProperties();
    private static final Path outputDirectory = Paths.get(properties.getProperty("allure.results.directory", "allure-results"));
    private static final String patternForRemove = properties.getProperty("allure.report.remove.attachments", "");

    @Override
    public void beforeTestWrite(TestResult testResult) {
        if (testResult.getStatus().equals(Status.PASSED)) {
            removeMatchingAttachments(testResult.getAttachments());
            testResult.getSteps().stream()
                    .flatMap(this::getSubsteps)
                    .map(StepResult::getAttachments)
                    .forEach(this::removeMatchingAttachments);
        }
    }

    private Stream<StepResult> getSubsteps(StepResult step) {
        if (step.getSteps().isEmpty()) {
            return Stream.of(step);
        }
        return step.getSteps().stream().flatMap(this::getSubsteps);
    }

    private void removeMatchingAttachments(Collection<Attachment> attachments) {
        List<Attachment> attachmentsToRemove = attachments.stream()
                .filter(attachment -> attachment.getName().matches(patternForRemove))
                .collect(toList());
        attachmentsToRemove.forEach(this::deleteAttachmentFile);
        attachments.removeAll(attachmentsToRemove);
    }

    private void deleteAttachmentFile(Attachment attachment) {
        Path filePath = outputDirectory.resolve(attachment.getSource());
        try {
            Files.delete(filePath);
        } catch (IOException e) {
            throw new AllureResultsWriteException("Could not remove Allure attachment", e);
        }
    }

}