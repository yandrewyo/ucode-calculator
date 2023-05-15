import java.util.Scanner;
import javax.swing.JOptionPane;

class Main {
  public static void main(String[] args) {
    // Message types:
      // ERROR_MESSAGE INFORMATION_MESSAGE WARNING_MESSAGE QUESTION_MESSAGE PLAIN_MESSAGE
    JOptionPane.showMessageDialog(null, "WELCOME TO CALCULATOR USING JFRAME!", "JFRAME CALCULATOR", JOptionPane.INFORMATION_MESSAGE);

    boolean exit = false;
    while (!exit) {
      int operator = strictAnswer(14);
      // TODO
      // get checked
      
      double num1 = 0;
      num1 = getDouble();
      double num2 = 0;
      if (operator > 9) {
        num2 = getDouble();
      }

      double ans = 0;
      switch (operator) {
        case 1:
          ans = Math.log10(num1);
          JOptionPane.showMessageDialog(null, "Log base 10 of " + num1 + " is " + ans, "JFRAME CALCULATOR", JOptionPane.INFORMATION_MESSAGE);
          break;
        case 2:
          ans = Math.log(num1);
          JOptionPane.showMessageDialog(null, "Natural log of " + num1 + " is " + ans, "JFRAME CALCULATOR", JOptionPane.INFORMATION_MESSAGE);
          break;
        case 3:
          ans = Math.sin(num1);
          JOptionPane.showMessageDialog(null, "Sine of " + num1 + " is " + ans, "JFRAME CALCULATOR", JOptionPane.INFORMATION_MESSAGE);
          break;
        case 4:
          ans = Math.cos(num1);
          JOptionPane.showMessageDialog(null, "Cosine of " + num1 + " is " + ans, "JFRAME CALCULATOR", JOptionPane.INFORMATION_MESSAGE);
          break;
        case 5:
          ans = Math.tan(num1);
          JOptionPane.showMessageDialog(null, "Tangent of " + num1 + " is " + ans, "JFRAME CALCULATOR", JOptionPane.INFORMATION_MESSAGE);
          break;
        case 6:
          ans = Math.asin(num1);
          JOptionPane.showMessageDialog(null, "Arc sine of " + num1 + " is " + ans, "JFRAME CALCULATOR", JOptionPane.INFORMATION_MESSAGE);
          break;
        case 7:
          ans = Math.acos(num1);
          JOptionPane.showMessageDialog(null, "Arc cosine of " + num1 + " is " + ans, "JFRAME CALCULATOR", JOptionPane.INFORMATION_MESSAGE);
          break;
        case 8:
          ans = Math.atan(num1);
          JOptionPane.showMessageDialog(null, "Arc tangent of " + num1 + " is " + ans, "JFRAME CALCULATOR", JOptionPane.INFORMATION_MESSAGE);
          break;
        case 9:
          ans = factorial(num1);
          JOptionPane.showMessageDialog(null, "Factorial of " + num1 + " is " + ans, "JFRAME CALCULATOR", JOptionPane.INFORMATION_MESSAGE);
          break;
        case 10:
          ans = num1 + num2;
          JOptionPane.showMessageDialog(null, num1 + " + " + num2 + " = " + ans, "JFRAME CALCULATOR", JOptionPane.INFORMATION_MESSAGE);
          break;
        case 11:
          ans = num1 - num2;
          JOptionPane.showMessageDialog(null, num1 + " - " + num2 + " = " + ans, "JFRAME CALCULATOR", JOptionPane.INFORMATION_MESSAGE);
          break;
        case 12:
          ans = num1 * num2;
          JOptionPane.showMessageDialog(null, num1 + " * " + num2 + " = " + ans, "JFRAME CALCULATOR", JOptionPane.INFORMATION_MESSAGE);
          break;
        case 13:
          ans = num1 / num2;
          JOptionPane.showMessageDialog(null, num1 + " / " + num2 + " = " + ans, "JFRAME CALCULATOR", JOptionPane.INFORMATION_MESSAGE);
          break;
        case 14:
          ans = Math.pow(num1, num2);
          JOptionPane.showMessageDialog(null, num1 + " ^ " + num2 + " = " + ans, "JFRAME CALCULATOR", JOptionPane.INFORMATION_MESSAGE);
          break;
      }
      if (JOptionPane.showConfirmDialog(null, "Exit?", "JFRAME CALCULATOR", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
        exit = true;
      }
    }
  }
  
  static double factorial(double num) {
    int total = 1;
    for (int i = 1; i <= num; i++) {
      total *= i;
    }
    return total;
  }

  static int strictAnswer(int max) {
    int input = 0;
    while (input < 1 || input > max) {
      input = Integer.valueOf(JOptionPane.showInputDialog(null, "Please enter an operation.\nOperators:\n1. LOG BASE OF 10\n2. LOG BASE E\n3. SINE\n4. COSINE\n5. TANGENT\n6. ARC SINE\n7. ARC COSINE\n8. ARC TANGENT\n9. FACTORIAL\n10. ADDITION\n11. SUBTRACTION\n12. MULTIPLICATION\n13. DIVISION\n14. EXPONENT", "JFRAME CALCULATOR", JOptionPane.INFORMATION_MESSAGE));
      if (input < 1 || input > max) {
        JOptionPane.showMessageDialog(null, "Not a valid option, please type a number 1 through 14", "JFRAME CALCULATOR", JOptionPane.WARNING_MESSAGE);
      }
    }
    return input;
  }

  static double getDouble() {
    return Double.valueOf(JOptionPane.showInputDialog(null, "Enter a double", "JFRAME CALCULATOR", JOptionPane.INFORMATION_MESSAGE));
  }
}