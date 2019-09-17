public class ArrayMax {
    public static void main(String[] args) {
        int[] array = {56,67,23,89,666};
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max){
                max = array[i];
            }
        }
        System.out.println(max);
        for (int min = 0, maxx = array.length - 1; min < maxx; min++ , maxx--){
            int temp = array[min];
            array[min] = array[maxx];
            array[maxx] = temp;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        arrayPrint(array);

        int[] result = calculate(2,4,6);
        System.out.println(result[0]+ " " + result[1]);
    }

    public static void arrayPrint(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static int[] calculate(int a,int b,int c){
        int sum = a + b + c;
        int avg = sum / 3;
        int[] array = {sum,avg};
        return array;
    }
}
