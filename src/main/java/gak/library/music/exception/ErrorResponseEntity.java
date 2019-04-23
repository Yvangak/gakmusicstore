package gak.library.music.exception;

import java.util.Objects;

public final class ErrorResponseEntity {

    private String errorType;
    private String uri;
    private String errorMessage;
    private long errorTimeStamp;

    public ErrorResponseEntity(String errorType, String uri, String errorMessage, long errorTimeStamp) {
        this.errorType = errorType;
        this.uri = uri;
        this.errorMessage = errorMessage;
        this.errorTimeStamp = errorTimeStamp;
    }

    public String getErrorType() {
        return errorType;
    }

    public String getUri() {
        return uri;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public long getErrorTimeStamp() {
        return errorTimeStamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorResponseEntity that = (ErrorResponseEntity) o;
        return errorTimeStamp == that.errorTimeStamp &&
                Objects.equals(errorType, that.errorType) &&
                Objects.equals(uri, that.uri) &&
                Objects.equals(errorMessage, that.errorMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorType, uri, errorMessage, errorTimeStamp);
    }
}
