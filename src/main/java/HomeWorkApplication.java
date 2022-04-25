public class HomeWorkApplication {
    public static void main(String[] args) {
        String[][] s = {{"1","2","3","4"},{"2","3","a","5"},{"1","2","3","4"},{"2","5","a","5"}};
        String[][] s1 = {{"1","2","3","4"},{"2","3","a","5"},{"1","2","3","4"},{"2","5","a","e"}};
        String[][] s2 = new String[1][1];
        String[][] s3 = {{"1","2","3","4"},{"2","3","a"},{"1","2","3","4"},{"2","5","a","e"}};
        SumStringArrayOptimized(s);
        SumStringArrayOptimized(s1);
        try {
            SumStringArray(s2);
        } catch (MyArraySizeException e){
            System.out.println("Размер массива не равен 4 х 4");
        }
        try {
            SumStringArray(s3);
        } catch (MyArraySizeException e){
            System.out.println("Размер массива не равен 4 х 4");
        }
        try {
            SumStringArray(s1);
        } catch (MyArrayDataException e) {
            System.out.println("Catched");
        }
    }

    private static void SumStringArray(String[][] arr) throws MyArrayDataException, MyArraySizeException{
        final int MAX_ARRAY_SIZE = 4;
        for (int i = 0; i < MAX_ARRAY_SIZE; i++) {
            if (arr[i].length != MAX_ARRAY_SIZE || arr.length != MAX_ARRAY_SIZE) {
                throw new MyArraySizeException();
            }
        }
        int sum = 0;
        int[] num = {0, 0};
        try {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    num[0] = i;
                    num[1] = j;
                    sum += Integer.parseInt(arr[i][j]);
                }
            }
        } catch (NumberFormatException e) {
            throw new MyArrayDataException(num);
        } finally {
            System.out.printf("Сумма полученная до получения ошибки равна %s\n", sum);
        }
    }

    private static void SumStringArrayOptimized(String[][] arr) throws MyArraySizeException{
        int sum = 0;
        int[] num = {0, 0};
        boolean doSum = true;
        final int MAX_ARRAY_SIZE = 4;
        for (int i = 0; i < MAX_ARRAY_SIZE; i++) {
            if (arr[i].length != MAX_ARRAY_SIZE || arr.length != MAX_ARRAY_SIZE) {
                throw new MyArraySizeException();
            }
        }
        while (doSum){
            try {
                for (int i = num[0]; i < arr.length; i++) {
                    for (int j = num[1]; j < arr[i].length; j++) {
                        num[0] = i;
                        num[1] = j;
                        sum += Integer.parseInt(arr[i][j]);
                    }
                    if (num[0] == arr.length - 1) {
                        doSum = false;
                        System.out.printf("Сумма равна %s\n", sum);
                        break;
                    } else {
                        num[1] = 0;
                    }
                }
            } catch (NumberFormatException e) {
                if (num[1] != arr[0].length - 1 | num[0] != arr.length - 1) {
                    System.out.printf("Значение в ячейке %s %s не является числом, и не было " +
                            "учитано в сумме\n", num[0], num[1]);
                    num[1] = num[1] + 1;
                } else {
                    System.out.printf("Значение в ячейке %s %s не является числом, и не было " +
                            "учитано в сумме\n", num[0], num[1]);
                    System.out.printf("Сумма равна %s\n", sum);
                    doSum = false;
                }
            }
        }
    }

}