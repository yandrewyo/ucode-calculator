import java.util.Scanner;
import java.io.*;
import java.lang.*;
class Main {
  public static void main(String[] args) {
    //TODO: TEST ALL SECTIONS!!! ONCE ALL SECTIONS TESTED, REPORT TO JEREMIAH
    Scanner scan = new Scanner(System.in);
    double[] history = {0,0,0,0,0};
    boolean flag = true;
    while (flag) {
      System.out.println("------------------------------\n\nWelcome to the Advanced Calculator Menu");
      System.out.println("Sections include:\n1. Scientific\n2. Graphing\n3. Statistics\n4. Physics\n5. history\nOr 6. Exit");
      System.out.println("Please pick a section to go to:");
      switch (scan.nextInt()) {
        case (1):
          Scientific(history);
          break;
        case (2):
          Graphing(history);
          break;
        case (3):
          Statistics(history);
          break;
        case (4):
          Physics(history);
          break;
        case (5):
          accessHistory(history);
          break;
        case (6):
          System.out.println("Thank you for calculating!");
          flag = false;
          break;
        default:
          System.out.println("This is not a section...Remember that everything is case sensitive!");
          break;
      }
    }
  }

  //Get Input
  static double getDouble() {
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter a double");
    return scan.nextDouble();
  }
  static int getInt() {
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter an integer");
    return scan.nextInt();
  }
  static String getString() {
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter an operand");
    return scan.nextLine();
  }
  static double[] getArr() {
    Scanner scan = new Scanner(System.in);
    System.out.println("How many numbers in the list?");
    int len = getInt();
    double[] arr = new double[len];
    for (int i = 0; i < len; i++) {
      System.out.println("What is num " + (i+1) + "?");
      arr[i] = scan.nextDouble();
    }
    return arr;
  }

  static boolean exit() {
    String e = "";
    while (!e.equals("y") || !e.equals("n")) {
      e = getString();
      if (e.equals("y")) {
        return false;
      } else if (e.equals("n")) {
        return true;
      } else {
        System.out.println("Invalid");
      }
    }
    return true;
  }
  static double getInput(double[] history, double num) {
    int c1 = 0;
    while (c1 == 0) {
      System.out.println("Would you like\n1. An operand from your calculator history or\n2. A new operand");
      c1 = getInt();
      switch (c1) {
        case 1:
          System.out.println("Pick one:");
          System.out.println("1: " + history[0] + "\n2: " + history[1] + "\n3: " + history[2] + "\n4: " + history[3] + "\n5: " + history[4]);
          int c2 = getInt();
          switch (c2) {
            case 1:
              num = history[0];
              break;
            case 2:
              num = history[1];
              break;
            case 3:
              num = history[2];
              break;
            case 4:
              num = history[3];
              break;
            case 5:
              num = history[4];
              break;
            default:
              System.out.println("Invalid Option, try again");
              c1 = 0;
          }
          break;
        case 2:
          num = getDouble();
          break;
        default:
          System.out.println("Invalid Option");
          c1 = 0;
      }
    }
    return num;
  }

  //print output
  static void readStrings(String[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }
  static void readDoubles(double[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println((i+1) + ": " + arr[i]);
    }
  }


  //create flowchart+seperate function of decimal cutoff for graphing increment (ex. 1.2000000000000000002 -> 1.2 if increment=0.1)
  //round to decimal place of increment

  //Scientific Section
  static void Scientific(double[] history) {
    Scanner scan = new Scanner(System.in);
    System.out.println("\n------------------------------\nWelcome to the Scientific Section");
    boolean flag = true;
    while (flag) {
      System.out.println("Operators:");
      System.out.println("1. LOG BASE OF 10\n2. LOG BASE E\n3. SINE\n4. COSINE\n5. TANGENT\n6. ARC SINE\n7. ARC COSINE\n8. ARC TANGENT\n9. FACTORIAL\n10. ADDITION\n11. SUBTRACTION\n12. MULTIPLICATION\n13. DIVISION\n14. EXPONENT");
      System.out.println("\nWhat is the operator?");
      // String[] oneOperand = {"log", "ln", "sin", "cos", "tan", "asin", "acos", "atan", "factorial"};
      // String[] twoOperand = {"+", "-", "*", "/", "^"};
      int operator = getInt();
      double num = 0;
      double[] nums = {0,0};

      if (1<=operator && operator<=9) {
        num = getInput(history, num);
      } else if (10<=operator && operator<=14) {
        for (int i = 0; i < 2; i++) {
          nums[i] = getInput(history, num);
        }
      }
      double answer = 0;
      boolean io = false;
      switch (operator){
        case 1:
          answer = Math.log10(num);
          System.out.println("log base 10 of " + num + " is " + answer);
          break;
        case 2:
          answer = Math.log(num);
          System.out.println("natural log of " + num + " is " + answer);
          break;
        case 3:
          answer = Math.sin(num);
          System.out.println("sine of " + num + " is " + answer);
          break;
        case 4:
          answer = Math.cos(num);
          System.out.println("cosine of " + num + " is " + answer);
          break;
        case 5:
          answer = Math.tan(num);
          System.out.println("tangent of " + num + " is " + answer);
          break;
        case 6:
          answer = Math.asin(num);
          System.out.println("arc sine of " + num + " is " + answer);
          break;
        case 7:
          answer = Math.acos(num);
          System.out.println("arc cosine of " + num + " is " + answer);
          break;
        case 8:
          answer = Math.atan(num);
          System.out.println("arc tangent of " + num + " is " + answer);
          break;
        case 9:
          answer = factorial(num);
          System.out.println("factorial of " + num + " is " + factorial(num));
          break;
        case 10:
          answer = add(nums[0], nums[1]);
          System.out.println(nums[0] + " + " + nums[1] + " = " + answer);
          break;
        case 11:
          answer = subtract(nums[0], nums[1]);
          System.out.println(nums[0] + " - " + nums[1] + " = " + answer);
          break;
        case 12:
          answer = multiply(nums[0], nums[1]);
          System.out.println(nums[0] + " * " + nums[1] + " = " + answer);
          break;
        case 13:
          answer = divide(nums[0], nums[1]);
          System.out.println(nums[0] + " / " + nums[1] + " = " + answer);
          break;
        case 14:
          answer = power(nums[0], nums[1]);
          System.out.println(nums[0] + " ^ " + nums[1] + " = " + answer);
          break;
        default:
          System.out.println("Invalid Operator");
          io = true;
      }
      if (flag && !io) {
        updateHistory(answer, history);
      }
      System.out.println("\nExit? (y/n)");
      flag = exit();
      System.out.println();
    }
      
  }
  //addition
  static double add(double num1, double num2) {
    return num1 + num2;
  }
  //subtraction
  static double subtract(double num1, double num2) {
    return num1 - num2;
  }
  //multiplication
  static double multiply(double num1, double num2) {
    return num1 * num2;
  }
  //division
  static double divide(double num1, double num2) {
    return num1 / num2;
  }
  //exponent
  static double power(double num1, double num2) {
    return Math.pow(num1, num2);
  }
  //factorial
  static double factorial(double num) {
    int total = 1;
    for (int i = 1; i <= num; i++) {
      total *= i;
    }
    return total;
  }

  //------------------------------------------------------------------------------

  //Graphing Section
  static void Graphing(double[] history) {
    Scanner scan = new Scanner(System.in);
    boolean flag = true;
    System.out.println("\n------------------------------\nWelcome to the Graphing Section");
    while (flag) {
      System.out.println("\nFor the equation Ax^3 + Bx^2 + Cx + D\nWith minimum, maximum, and increment\n");
      String answer = "";
      System.out.println("What is the minimum?");
      int min = getInt();
      System.out.println("What is the maximum?");
      int max = getInt();
      System.out.println("What is the increment?");
      double increment = getInput(history, 0);
      System.out.println("What is A?");
      double a = getInput(history, 0);
      System.out.println("What is B?");
      double b = getInput(history, 0);
      System.out.println("What is C?");
      double c = getInput(history, 0);
      System.out.println("What is D?");
      double d = getInput(history, 0);
      String[] output = new String[(int)((max - min) / increment) + 1];

      double i = min;
      while (i <= max) {
        double y = a*Math.pow(i,3)+b*Math.pow(i,2)+c*i+d;
        System.out.println("(" + String.format("%."+(Double.toString(increment).length() - Double.toString(increment).indexOf('.')-1)+"f", i) + ", " + String.format("%."+(Double.toString(increment).length() - Double.toString(increment).indexOf('.')-1)+"f", y) + ")");
        i = Double.parseDouble(String.format("%."+(Double.toString(increment).length() - Double.toString(increment).indexOf('.')-1)+"f", i+increment));
      }

      System.out.println("\nExit? (y/n)");
      flag = exit();
      System.out.println();
    }
  }


  static double round(double num, int places) {
    return (double)(Math.round(num*Math.pow(10, places))/Math.pow(10, places));
  } 

  //----------------------------------------------------------------------------

  //Statistics Section
  static void Statistics(double[] history) {
    Scanner scan = new Scanner(System.in);
    boolean flag = true;
    System.out.println("\n------------------------------\nWelcome to the Statistics Section");
    double[] prevArr = {};
    while (flag) {
      double answer = 0;
      boolean io = false;
      //create array before asking for mean median etc
      System.out.println("Would you like to:\n1. create a new array or\n2. use the previous?");
      int choice = 0;
      double[] arr;
      while (true) {
        choice = getInt();
        if (choice == 1) {
          arr = getArr();
          prevArr = arr;
          break;
        } else if (choice == 2) {
          arr = prevArr;
          break;
        } else {
          System.out.println("Invalid");
        }
      }
      System.out.println("\nFind the following for a list of numbers of your choice:\n1. MEAN\n2. MEDIAN\n3. SUMMATION\n4. STANDARD DEVIATION\n");
      System.out.println("What would you like to do?");
      int operator = getInt();
      switch (operator) {
        case 1:
          answer = mean(arr);
          System.out.println("Mean is " + answer);
          break;
        case 2:
          answer = median(arr);
          System.out.println("Median is " + answer);
          break;
        case 3:
          answer = summation(arr);
          System.out.println("Sum is " + answer);
          break;
        case 4:
          answer = standardDev(arr);
          System.out.println("Standard deviation is " + answer);
          break;
        default:
          System.out.println("Invalid operator");
          io = true;
      }
      if (flag && !io) {
        updateHistory(answer, history);
      }
      System.out.println("\nExit? (y/n)");
      flag = exit();
      System.out.println();
    }
  }
  //sort
  static double[] sort(double[] arr) {
    boolean swapped = true;
    while (swapped) {
      swapped = false;
      for (int i = 0; i < arr.length-1; i++) {
        if (arr[i] > arr[i+1]) {
          double copy = arr[i+1];
          arr[i+1] = arr[i];
          arr[i] = copy;
          swapped = true;
        }
      }
    }
    return arr;
  }
  //summation
  static double summation(double[] arr) {
    double sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
    }
    return sum;
  }
  //mean
  static double mean(double[] arr) {
    return summation(arr) / arr.length;
  }
  //median
  static double median(double[] arr) {
    arr = sort(arr);
    if (arr.length % 2 == 1) {
      return arr[arr.length/2];
    } else {
      return (double)((arr[arr.length/2-1] + arr[arr.length/2]))/2;
    }
  }
  //standard deviation
  static double standardDev(double[] arr) {
    double mean = mean(arr);
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Math.pow(Math.abs(arr[i] - mean), 2);
    }
    return Math.sqrt(summation(arr) / arr.length);
  }



  static void Physics(double[] history) {
    Scanner scan = new Scanner(System.in);
    boolean flag = true;
    System.out.println("\n------------------------------\nWelcome to the Physics Section");
    while (flag) {
      double answer = 0;
      //change inputs to ints instead of strings (EX: gf -> 1, ef -> 2)
      System.out.println("Calculate the following:");
      System.out.println("1. Gravitational Force\n2. Electric Force\n3. Distance Moved\n4. Heat Expansion\n5. Force Calculation");
      System.out.println("\nWhat would you like to do?");
      int operator = getInt();
      switch(operator) {
        case 1:
          System.out.println("What is the mass of object 1 in kg?");
          double m1 = getInput(history, 0);
          System.out.println("What is the mass of object 2 in kg?");
          double m2 = getInput(history,0);
          System.out.println("What is the distance between the two objects in km?");
          double d = getInput(history,0);
          answer = gf(m1, m2, d);
          System.out.println(answer + " Newtons of Gravitational Force");
          break;
        case 2:
          System.out.println("What is the charge of point 1?");
          double q1 = getInput(history,0);
          System.out.println("What is the charge of point 2?");
          double q2 = getInput(history,0);
          System.out.println("What is the distance between the 2 points in meters?");
          double r = getInput(history,0);
          answer = ef(q1,q2,r);
          System.out.println(answer + " Newtons of Electrical Force");
          break;
        case 3:
          System.out.println("What is the initial velocity(m/s)?");
          double v = getInput(history, 0);
          System.out.println("How much time(s)?");
          double t = getInput(history,0);
          answer = dm(v,t);
          System.out.println(answer + " Meters moved");
          break;
        case 4:
          System.out.println("What was the original length in meters?");
          double L0 = getInput(history,0);
          System.out.println("What is the coefficient of thermal linear expansion (*E-6)?");
          double a = getInput(history,0)*1E-6;
          System.out.println("What is the final temperature in celcius?");
          double t1 = getInput(history,0);
          System.out.println("What was the initial temperature in celcius?");
          double t0 = getInput(history,0);
          answer = he(L0,a,t1,t0);
          System.out.println(answer + " Meters Expanded");
          break;
        case 5:
          System.out.println("Would you like to calculate for 1. force,\n2. mass, or\n3. acceleration?");
          switch(getInt()) {
            case 1:
              answer = fma(true, false, false, history);
              System.out.println(answer + " Newtons");
              break;
            case 2:
              answer = fma(false, true, false, history);
              System.out.println(answer + " Kilograms");
              break;
            case 3:
              answer = fma(false, false, true, history);
              System.out.println(answer + " Meters/Second");
              break;
          }
        default:
          System.out.println("Invalid operator");

      }

      updateHistory(answer, history);
      System.out.println("\nExit? (y/n)");
      flag = exit();
      System.out.println();
    }
  }

  static double gf(double m1, double m2, double d) {
    return 6.67 * Math.pow(10,-11) *m1*m2/Math.pow(d,2);
  }
  static double ef(double q1, double q2, double r) {
    return 8.99*Math.pow(10, 9) * (q1*q2/Math.pow(r,2));
  }
  static double dm(double v, double t) {
    return (v*t)+0.5*-9.8*Math.pow(t,2);
  }
  static double he(double L0, double a, double t1, double t0) {
    return L0 * a * (t1 - t0);
  }
  static double fma(boolean sf, boolean sm, boolean sa, double[] history) {
    if (sf) {
      System.out.println("What was the mass in kg?");
      double m = getInput(history, 0);
      System.out.println("What was the acceleration in m/s?");
      double a = getInput(history, 0);
      return m*a;
    } else if (sm) {
      System.out.println("What was the force in Newtons?");
      double f = getInput(history, 0);
      System.out.println("What was the acceleration in m/s?");
      double a = getInput(history,0);
      return f/a;
    } else {
      System.out.println("What was the force in Newtons?");
      double f = getInput(history, 0);
      System.out.println("What was the mass in kg?");
      double m = getInput(history, 0);
      return f/m;
    }
  }

  //------------------------------------------------------------------------
  //history
  static void accessHistory(double[] history) {
    System.out.println("\n------------------------------\nWelcome to Calculator History");
    System.out.println("The following values are the last five answers, from most recent to oldest (Graphing history is not saved)\n");
    readDoubles(history);
    String e = "";
    while (!e.equals("y") || !e.equals("n")) {
      System.out.println("\nWould you like to manually add a value to history (y/n)?");
      e = getString();
      if (e.equals("y")) {
        System.out.println("Which value would you like to change?");
        boolean flag = true;
        int change = 0;
        while (flag) {
          change = getInt();
          if (change < 0 || change > 5) {
            System.out.println("Invalid");
          } else {
            flag = false;
          }
        }
        System.out.println("What would you like to change it to?");
        history[change-1] = getDouble();
        System.out.println("\nNew history:");
        readDoubles(history);
      } else if (e.equals("n")) {
        break;
      } else {
        System.out.println("Invalid");
      }
    }
    System.out.println();
  }
  static void updateHistory(double val, double[] history) {
    history[4] = history[3];
    history[3] = history[2];
    history[2] = history[1];
    history[1] = history[0];
    history[0] = val;
  }
}