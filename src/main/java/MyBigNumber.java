import java.util.logging.Logger;
import java.util.logging.Level;

public class MyBigNumber {

    private static final Logger logger = Logger.getLogger(MyBigNumber.class.getName());

    public String sum(String stn1, String stn2) {

        StringBuilder num1 = new StringBuilder(stn1).reverse();
        StringBuilder num2 = new StringBuilder(stn2).reverse();
        StringBuilder result = new StringBuilder();

        int maxLength = Math.max(num1.length(), num2.length());
        int carry = 0;

        for (int i = 0; i < maxLength; i++) {
            int digit1 = (i < num1.length()) ? num1.charAt(i) - '0' : 0;
            int digit2 = (i < num2.length()) ? num2.charAt(i) - '0' : 0;
            int sum=digit1+digit2+carry;
            int resultDigit = sum % 10;
            carry =sum/10;
            logger.log(Level.INFO, "Bước {0}: Lấy {1} + {2} {3}= {4} → Lưu {5}{6}",
                new Object[]{
                    i + 1,
                    digit1,
                    digit2,
                    (carry > 0 ? "+ nhớ " + (sum - digit1 - digit2) + " " : ""),
                    sum,
                    resultDigit,
                    (carry > 0 ? ", nhớ " + carry : "")
                });

            result.append(resultDigit);
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
      MyBigNumber myBigNumber = new MyBigNumber();
      String result = myBigNumber.sum("1234", "897");
      System.out.println("Kết quả: " + result);
    }
}
