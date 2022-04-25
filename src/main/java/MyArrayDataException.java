public class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(int[] i) {
        super();
        System.err.printf("Проблемное значение в массиве, которое невозможно преобразовать " +
                "находится в ячейке %s %s\n", i[0], i[1]);
    }
}