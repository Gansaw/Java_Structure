package chapter2_기본자료구조;

import java.util.Scanner;

public class N진수표현 {

    static int showData(int a, int b, char[] d) {
        int digits = 0;
        String decimal = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        do {
            d[digits++] = decimal.charAt(a % b);
            a /= b;
        } while (a != 0);

        // 배열 d 숫자 문자열 역순으로
        for (int i = 0; i < digits / 2; i++) {
            char temp = d[i];
            d[i] = d[digits - i - 1];
            d[digits - i - 1] = temp;
        }
        return digits;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 숫자 입력
        System.out.println("숫자를 입력하세요.");
        int n = sc.nextInt();
        if (n < 0) {
            System.out.println("표현할 수 없는 숫자입니다.");
            return;
        }

        // 진수 입력
        System.out.println("표현하고 싶은 진수를 입력하세요.");
        int decimalNum = sc.nextInt();
        if (decimalNum < 2 || decimalNum > 36) {
            System.out.println("표현할 수 없는 진수입니다.");
            return;
        }

        // 변환 후 문자배열
        char[] digits = new char[32];

        // n을 decimalNum진수로 변환
        int digitNum = showData(n, decimalNum, digits);

        // 변환 결과
        System.out.println(decimalNum + "진수 변환 결과입니다.");
        
        // 변환 결과 출력 (반복문을 통해 역순으로 출력)
        for (int i = 0; i < digitNum; i++) {
            System.out.print(digits[i]);
        }

    }
}
