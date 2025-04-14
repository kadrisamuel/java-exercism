import java.util.Optional;

class ErrorHandling {

    void handleErrorByThrowingIllegalArgumentException() {
        throw new IllegalArgumentException();
    }

    void handleErrorByThrowingIllegalArgumentExceptionWithDetailMessage(String message) {
        throw new IllegalArgumentException(message);
    }

    void handleErrorByThrowingAnyCheckedException() throws InterruptedException {
        throw new InterruptedException();
    }

    void handleErrorByThrowingAnyCheckedExceptionWithDetailMessage(String message) throws InterruptedException {
        throw new InterruptedException(message);
    }

    void handleErrorByThrowingAnyUncheckedException() {
        handleErrorByThrowingIllegalArgumentException();
    }

    void handleErrorByThrowingAnyUncheckedExceptionWithDetailMessage(String message) {
        handleErrorByThrowingIllegalArgumentExceptionWithDetailMessage(message);
    }

    void handleErrorByThrowingCustomCheckedException() throws CustomCheckedException {
        throw new CustomCheckedException();
    }

    void handleErrorByThrowingCustomCheckedExceptionWithDetailMessage(String message) throws CustomCheckedException {
        throw new CustomCheckedException(message);
    }

    void handleErrorByThrowingCustomUncheckedException() {
        throw new CustomUncheckedException();
    }

    void handleErrorByThrowingCustomUncheckedExceptionWithDetailMessage(String message) {
        throw new CustomUncheckedException(message);
    }

    Optional<Integer> handleErrorByReturningOptionalInstance(String integer) {
        try {
            return Optional.ofNullable(Integer.valueOf(integer));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

}
