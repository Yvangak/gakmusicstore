package gak.library.music.exception;

import java.util.Objects;

public final class ErrorResponseEntity {

    private String errorCode;
    private String errorMessage;
    private String errorType;
    private long errorTimeStamp;

    public ErrorResponseEntity(String errorCode, String errorMessage, String errorType, long errorTimeStamp) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorType = errorType;
        this.errorTimeStamp = errorTimeStamp;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorType() {
        return errorType;
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
                Objects.equals(errorCode, that.errorCode) &&
                Objects.equals(errorMessage, that.errorMessage) &&
                Objects.equals(errorType, that.errorType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorCode, errorMessage, errorType, errorTimeStamp);
    }
}
