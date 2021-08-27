public class Solution {

    public String multiply(String num1, String num2) {

        int[] num_01 = stringToIntegerArray(num1);
        int[] num_02 = stringToIntegerArray(num2);
        int[] product = multuply(num_01, num_02);

        return turnProductIntoString(product);
    }

    public int[] stringToIntegerArray(String num) {
        int[] array = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            array[i] = num.charAt(i) - '0';
        }
        return array;
    }

    public int[] multuply(int[] num_01, int[] num_02) {

        int[] product = new int[num_01.length + num_02.length];
        int index = product.length - 1;
        int level = 0;

        for (int i = num_01.length - 1; i >= 0; i--) {
            level = index--;
            for (int j = num_02.length - 1; j >= 0; j--) {
                product[level--] += num_01[i] * num_02[j];
            }
        }

        int carry = 0;
        for (int i = product.length - 1; i >= 0; i--) {
            int current = product[i] + carry;
            product[i] = current % 10;
            carry = current / 10;
        }
        return product;
    }

    public String turnProductIntoString(int[] product) {

        int index = 0;
        while (index < product.length && product[index] == 0) {
            index++;
        }

        if (index == product.length) {
            return "0";
        }

        int index_result = 0;
        char[] result = new char[product.length - index];
        for (int i = index; i < product.length; i++) {
            result[index_result++] = (char) (product[i] + '0');
        }

        return String.valueOf(result);
    }
}
