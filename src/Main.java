
public class Main {
    public static void main(String[] args) {
        int[] my_num = {9, 1, 5, 5};
        int result = 10;
        int temp_result;
        int first_number = 0;
        int second_number = 0;
        int third_number = 0;
        int fourth_number = 0;
        int number;
        String[] my_operator = {"+", "-", "*", "/"};
        String[] gen_combination = new String[]{
                "1234", "1243", "1324", "1342", "1423", "1432",
                "2134", "2143", "2314", "2341", "2413", "2431",
                "3124", "3142", "3214", "3241", "3412", "3421",
                "4123", "4132", "4213", "4231", "4312", "4321"
        };

        for (String comb : gen_combination) {
            for (int i = 0; i < comb.length(); i++) {
                number = Integer.parseInt(String.valueOf(comb.charAt(i))) - 1;
                switch (i){
                    case 0:
                        first_number = my_num[number];
                        break;
                    case 1:
                        second_number = my_num[number];
                        break;
                    case 2:
                        third_number = my_num[number];
                    case 3:
                        fourth_number = my_num[number];
                }
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    for (int k = 0; k < 4; k++) {
                        temp_result = calculate(first_number, second_number, my_operator[i]);
                        temp_result = calculate(temp_result, third_number, my_operator[j]);
                        temp_result = calculate(temp_result, fourth_number, my_operator[k]);
                        if (result == temp_result) {
                            System.out.println(first_number +" "+ my_operator[i] + " "+ second_number + " "+
                                    my_operator[j] + " " +third_number +" "+ my_operator[k] +
                                    " " + fourth_number + " = " + temp_result);
//                            System.exit(1);
                        }
                    }
                }
            }
        }
    }

    public static int add(int num1, int num2) {
        return num1 + num2;
    }
    public static int sub(int num1, int num2) {
        return num1 - num2;
    }
    public static int multiply(int num1, int num2) {
        return num1 * num2;
    }
    public static int divide(int num1, int num2) throws Exception {
        if (num2 == 0)
            throw new Exception("zero");
        return num1 / num2;
    }
    public static int calculate(int num1, int num2, String operator) {
        int solution = 0;
        switch (operator) {
            case "+":
                solution = add(num1, num2);
                break;
            case "-":
                solution = sub(num1, num2);
                break;
            case "*":
                solution =  multiply(num1, num2);
                break;
            case "/":
                try {
                    solution =  divide(num1, num2);
                } catch (Exception ignored){}
                break;
        }
        return solution;
    }
}