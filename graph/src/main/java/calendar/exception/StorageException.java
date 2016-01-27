package calendar.exception;

public class StorageException extends Exception {

    private String problematicId;
    private String message;

    public StorageException(String problematicId, String message) {
        this.problematicId = problematicId;
        this.message = message;
    }

    public String getProblematicId() {
        return problematicId;
    }

    @Override
    public String toString() {
        return message;
    }
}
