import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class Task5 {

    private static final Logger logger =
            LoggerFactory.getLogger(Task5.class);

    public ValidationResult validate(Document doc) {

        try {

            if (doc == null) {

                // FIX: Expected validation failure logged as warning
                logger.warn("Validation failed: Document is null");

                return null;
            }

            String content = doc.extractContent();

            if (content == null || content.isEmpty()) {

                // FIX: Expected validation failure logged as warning
                logger.warn("Validation failed: Empty content");

                return null;
            }

            return runValidationRules(content);

        } catch (Exception e) {

            // FIX: Replace printStackTrace with structured logging
            logger.error("Unexpected error during validation", e);

            // FIX: Return null after logging unexpected exception
            return null;
        }
    }

    public void validateBatch(List<Document> docs) {

        for (Document doc : docs) {

            try {

                ValidationResult r = validate(doc);

                // FIX: Prevent NullPointerException
                if (r != null && r.isValid()) {
                    saveResult(r);
                }

            } catch (Exception e) {

                // FIX: Do not swallow exceptions silently
                logger.error("Error while processing document", e);
            }
        }
    }

    private ValidationResult runValidationRules(String content) {
        return null;
    }

    private void saveResult(ValidationResult result) {
    }
}