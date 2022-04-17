package SecondLesson.HW;

public class SecondHW {
    public static void main(String[] args) {

        String[][] rightArray = new String[][] {
                {"8", "1", "2", "8"},
                {"7", "6", "3", "1"},
                {"2", "3", "1", "1"},
                {"4", "6", "9", "5"} };

        String[][] wrongSize = new String[][] {
                {"8", "1", "2", "u"},
                {"7", "6", "3", "1"},
                {"2", "3", "1", "1"},
                {"4", "6", "9"} };

        String[][] wrongSymbol = new String[][] {
                {"8", "1", "2", "u"},
                {"7", "6", "3", "1"},
                {"2", "3", "1", "1"},
                {"4", "6", "9", "5"} };

        try {
            method(rightArray);
//            method(wrongSize);
//            method(wrongSymbol);
        } catch (MyArraySizeException e) {
            System.out.println("Неправильный размер массива.");
        } catch (MyArrayDataException e) {
            System.out.printf("Неправильное значение в ячейке: %s x %s", e.i, e.j);
        }

    }

    public static void method(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (array.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum = sum + Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        System.out.println(sum);
    }
}
