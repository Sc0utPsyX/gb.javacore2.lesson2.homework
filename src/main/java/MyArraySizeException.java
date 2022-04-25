public class MyArraySizeException extends RuntimeException {
    @Override
    public String toString() {
        return "Array size can be 4 x 4 only!";
    }
}