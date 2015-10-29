package com.example.yee.codewars;

import android.opengl.Matrix;
import android.os.Bundle;

import org.w3c.dom.Node;

import java.math.BigInteger;
import java.security.Key;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Yee on 9/3/15.
 */
public class Extend3500 extends From1to98 {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mOutput.setText(String.valueOf(test4()));

    }

    static class Node {
        Object marker;
        Node next;

        Node(Object n) {
            this.marker = n;
        }
    }

    public static <T> List<T> josephusPermutation(final List<T> items, final int k) {
        int dataLength = items.size();
        if (dataLength == 0) return new LinkedList<>();
        Node header = new Node(items.get(0));
        Node pointer = header;
        List<T> output = new LinkedList<>();
        for (int i = 1; i < dataLength; i++) {
            pointer.next = new Node(items.get(i));
            pointer = pointer.next;
        }
        pointer.next = header;
        while (pointer != pointer.next) {
            for (int i = 1; i < k; i++) pointer = pointer.next;
            output.add((T) pointer.next.marker);
            pointer.next = pointer.next.next;
        }
        output.add((T) pointer.next.marker);
        return output;
    }

    public static int findSmallestInt(int[] args) {
        Arrays.sort(args);
        return args[0];
    }

    public static long getScore(long n) {
        long result = 0;
        for (long i = 0; i < n; i++) result += 50 * (i + 1);
        return result;
    }

    public class Guesser {
        Guesser g = new Guesser();

        class LittleClass {
            void isMySecret(String str) {

            }
        }

        public void guess() {
            new LittleClass().isMySecret("thatILoveUnicorns");
        }
    }

    public static int convertBits(int a, int b) {
        return Integer.toBinaryString(a ^= b).replaceAll("0", "").length();
    }

    public static BigInteger[] zeros1(int n) {
        BigInteger[] output = new BigInteger[n];
        BigInteger element = BigInteger.valueOf(1);

        for (int i = 0; i < n; i++) {
            element = element.multiply(BigInteger.valueOf(i + 1));
            output[i] = element;
        }
        return output;
    }

    //TODO: figure out later
    public static int zeros(int n) {
        int count = 0;
        for (int i = 5; n / i >= 1; i *= 5) count += n / i;
        return count;
    }


    private static BigInteger getFactorial(int m) {
        BigInteger n = BigInteger.valueOf(m), initial = BigInteger.valueOf(1);
        if (n.equals(BigInteger.valueOf(0))) return initial;
        return n.equals(initial) ? initial : n.multiply(getFactorial(m - 1));
    }

    public static long checkchoose(long m, int n) {
        BigInteger reference = getFactorial(n).divide(BigInteger.valueOf(m));
        for (int i = 1; i <= n; i++)
            if (reference.equals(getFactorial(i).multiply(getFactorial(n - i)))) return i;
        return -1;
    }

//    BigInteger test0() {
//       getFactorial(BigInteger.valueOf(6)).divide()
//       getFactorial(BigInteger.valueOf(4)
//        return getFactorial(BigInteger.valueOf(4)).multiply(getFactorial(BigInteger.valueOf(2)));
//    }

    public static long calculateRoutes(int n) {
        int length = n + 1;
        long[] preArray = new long[length];
        for (int i = 0; i < length; i++)
            preArray[i] = 1;
        for (; n > 0; n--) {
            long[] currentArray = new long[length];
            currentArray[0] = 1;
            for (int i = 1; i < length; i++) currentArray[i] = currentArray[i - 1] + preArray[i];
            preArray = currentArray;
        }
        return preArray[length - 1];
    }

    private static int judgeTripleDouble(long num, int count) {
        String str = String.valueOf(num);
        int current, previous = str.charAt(0), countCurrent = 1;
        for (int i = 1; i < str.length(); i++) {
            current = str.charAt(i);
            if (previous == current) {
                countCurrent++;
                if (countCurrent == count) return 1;
            } else previous = current;
        }
        return 0;
    }

    public static int TripleDouble(long num1, long num2) {
        return judgeTripleDouble(num1, 3) + judgeTripleDouble(num2, 2) == 2 ? 1 : 0;
    }

    public static String playPass(String s, int n) {
        int length = s.length(), index = length - 1, position;
        char[] shiftArr = s.toUpperCase().toCharArray();
        char[] result = new char[length];
        for (int i = 0; i < length; i++) {
            result[index] = shiftArr[i];
            if (Character.isLetter(result[index])) {
                if ((position = (int) result[index] + n % 26) > 90)
                    position = position % 90 - 1 + 65;
                result[index] = (char) position;
                if (i % 2 != 0) result[index] = Character.toLowerCase(result[index]);
            } else if (Character.isDigit(result[index]))
                result[index] = (char) ((9 - (result[index] - '0')) + 48);
            index--;
        }
        return new String(result);
    }

    public static int maxPizza(int cut) {
        int pieces = 0;
        for (int i = 0; i <= cut; i++) {
            pieces += i;
        }
        return cut < 0 ? -1 : pieces;
    }

    public static int Ackermann(int m, int n) {
        return m == 0 ? n + 1 : n == 0 ? Ackermann(m - 1, 1) : Ackermann(m - 1, Ackermann(m, n -
                1));
    }

    public static int solution1(int[] a) {
        int length = a.length, position = 0, reference = a[0], turningPoint = -1;
        for (int i = 1; i < length; i++) {
            if (a[i] * reference < 0) {
                reference = a[i];
                turningPoint = i - 1;
            }
        }
        if (turningPoint > 0) {
            for (int i = 0; i <= turningPoint; i++) position += a[i];
            position++;
        }
        for (int i = turningPoint + 1; i < length; i++) {
            int temp = position += a[i];
            if (Math.abs(temp) >= length || temp < 0) return i + 1;
        }
        return -1;
    }

//    public static int solution(int[] a) {
//        int length = a.length, position = 1;
//        for (int anA : a) position += anA;
//        if (position > 0) {
//            if (position <= length) return -1;
//            else if (a[0] > length) return 1;
//        }
//        if (position < 0) if (a[0] < 0) return 1;
//        if (position >= length) {
//            for (int i = a.length - 1; i > -1; i--) {
//                if ((position -= a[i]) <= length) return i + 1;
//            }
//        } else if (position < 0)
//            for (int i = a.length - 1; i > -1; i--) if ((position -= a[i]) >= 0) return i + 1;
//        return -1;
//    }

    public static long IntRac(long n, long guess) {
        long error = 1, newGuess = (guess + n / guess) / 2, count = 1;
        while (Math.abs(newGuess - guess) >= error) {
            guess = newGuess;
            newGuess = (newGuess + n / newGuess) / 2;
            count++;
        }
        return count;
    }

    public static int[] race(int v1, int v2, int g) {
        if (v1 >= v2) return null;
        else {
            double d1 = (double) v1 / 3600;
            double d2 = (double) v2 / 3600;
            int time = (int) (g / (d2 - d1));
            return new int[]{time / 3600, (time = time % 3600) / 60, time % 60};
        }
    }

    public boolean isRotation(String s1, String s2) {
        int length = s1.length();
        if (length == 0 && s2.length() == 0) return true;
        if (length != s2.length()) return false;
        for (int i = 0; i < length; i++) {
            char temp = s2.charAt(i);
            for (int j = 0; j < length; j++) {
                if (temp == s1.charAt(j)) {
                    char[] newStr = new char[length];
                    int indexStr = 0, indexTemp = j;
                    for (int m = 1; m <= length; m++) {
                        if (indexTemp <= length - 1) newStr[indexStr++] = s1.charAt(indexTemp++);
                        else {
                            newStr[indexStr++] = s1.charAt(indexTemp -= length);
                            indexTemp++;
                        }
                    }
                    String str = new String(newStr);
                    if (str.equals(s2)) return true;
                }
            }
        }
        return false;
    }

    public static boolean pNum(long n) {
        if (n == 0) return false;
        long output = 0, index = 1;
        while (output < n) {
            output = index * (3 * index - 1) / 2;
            index++;
        }
        return output == n;
    }

    public static boolean gpNum(long n) {
        if (n == 0) return true;
        long output = 0, index = 1, change = -1;
        while (output < n) {
            if (index > 0) {
                output = index * (3 * index - 1) / 2;
                index *= -1;
            } else {
                output = index * (3 * index - 1) / 2;
                index *= -1;
                index++;
            }
        }
        return output == n;
    }

    public static boolean spNum(long n) {
        //Happy Coding ^_^
        if (n == 0) return false;
        double reference = Math.sqrt((double) n);
        if (Math.floor(reference) != reference) return false;
        long output = 0, index = 1;
        while (output < n) {
            output = index * (3 * index - 1) / 2;
            index++;
        }
        return output == n;
    }

    static int shiftedDiff(String first, String second) {
        int length = first.length();
        if (first.equals(second)) return 0;
        for (int i = 0; i < length; i++) {
            if ((first + first).regionMatches(i, second, 0, length)) return length - i;
        }
        return -1;
    }

//    public static int solution(int[] a) {
//        ArrayList<Integer>array = new ArrayList<>();
//        for (int anA : a) {
//            if (anA != 0) array.add(anA);
//        }
//        int position = 0, length = a.length, tempPosition, tempValue = [0];
//        for (int i = 0; i < length; i++) {
//            if ((position += a[i]) >= length) {
//                (tempValue / a[i])
//                tempPosition = i;
//                tempValue = a[i];
//            }
//
//        }
//    }

    public static String convertTime(int timeDiff) {
        return String.format("%1$d %2$d %3$d %4$d", timeDiff / 86400, (timeDiff %= 86400) / 3600,
                (timeDiff %= 3600) / 60, timeDiff % 60);
    }

    public static int Chameleon(int[] chameleons, int desiredColor) {
        // Your code goes here
        int[] temp = new int[2];
        for (int i = 0, index = 0; i < chameleons.length; i++) {
            if (i != desiredColor) temp[index++] = chameleons[i];
        }
        if (temp[0] == 0 && temp[1] == 0 && chameleons[desiredColor] == desiredColor) return 0;
        if (chameleons[desiredColor] == 0) {
            if (temp[0] == temp[1]) return temp.length;
            else return -1;
        }
        if (temp[0] == 0 || temp[1] == 0) return -1;
        if (temp[0] == temp[1]) return temp[0];
        else return Math.max(temp[0], temp[1]);
    }

    public String encode1(String source) {
        if (source.isEmpty() || source.equals("")) return "";
        ArrayList<String> input = new ArrayList<>();
        int length = source.length();
        for (int i = 0; i < length; i++) {
            input.add(String.valueOf(source.charAt(i)));
        }
        for (int i = 0; i < length; i++) {
            switch (input.get(i)) {
                case "a":
                case "A":
                    input.set(i, "4");
                    break;
                case "e":
                case "E":
                    input.set(i, "3");
                    break;
                case "l":
                case "L":
                    input.set(i, "1");
                    break;
                case "m":
                case "M":
                    input.set(i, "/^^\\");
                    break;
                case "o":
                case "O":
                    input.set(i, "0");
                    break;
                case "u":
                case "U":
                    input.set(i, "(_)");
                    break;
                default:
            }
        }
        String output = "";
        for (String str : input) output += str;
        return output;
    }

//    public class ShopInventoryManager {
//
//        private Item[] items;
//
//        public ShopInventoryManager(Item[] items) {
//            this.items = items;
//        }
//
//        public void updateQuality() {
//            for (int i = 0; i < items.length; i++) {
//                if (items[i].getName() != "Aged Brie" && items[i].getName() != "Backstage
// passes to a TAFKAL80ETC concert") {
//                    if (items[i].getQuality() > 0) {
//                        if (items[i].getName() != "Sulfuras, Hand of Ragnaros") {
//                            items[i].setQuality(items[i].getQuality() - 1);
//                        }
//                    }
//                } else {
//                    if (items[i].getQuality() < 50) {
//                        items[i].setQuality(items[i].getQuality() + 1);
//                        if (items[i].getName() == "Backstage passes to a TAFKAL80ETC concert") {
//                            if (items[i].getSellIn() < 11) {
//                                if (items[i].getQuality() < 50) {
//                                    items[i].setQuality(items[i].getQuality() + 1);
//                                }
//                            }
//                            if (items[i].getSellIn() < 6) {
//                                if (items[i].getQuality() < 50) {
//                                    items[i].setQuality(items[i].getQuality() + 1);
//                                }
//                            }
//                        }
//                    }
//                }
//                if (items[i].getName() != "Sulfuras, Hand of Ragnaros") {
//                    items[i].setSellIn(items[i].getSellIn() - 1);
//                }
//                if (items[i].getSellIn() < 0) {
//                    if (items[i].getName() != "Aged Brie") {
//                        if (items[i].getName() != "Backstage passes to a TAFKAL80ETC concert") {
//                            if (items[i].getQuality() > 0) {
//                                if (items[i].getName() != "Sulfuras, Hand of Ragnaros") {
//                                    items[i].setQuality(items[i].getQuality() - 1);
//                                }
//                            }
//                        } else {
//                            items[i].setQuality(items[i].getQuality() - items[i].getQuality());
//                        }
//                    } else {
//                        if (items[i].getQuality() < 50) {
//                            items[i].setQuality(items[i].getQuality() + 1);
//                        }
//                    }
//                }
//            }
//        }
//    }

    static String T_Rex = "VvvvV";
    static String brachiosaurus = "uuuuu";
    static String velociraptor = "vvvvv";
    static String triceratops = "uuUuu";

    String dead_dino = "_C     C}>";
    String flowers = "iii     iii";
    String leaves = "|||     |||";

    public static String lunchTime(String scene) {
        //return "Something is eating something.";
        scene = scene.replaceAll(" ", "");
        String dino, food = "";
        switch (scene.charAt(0)) {
            case ('_'):
                food = "a dead dino";
                break;
            case ('i'):
                food = "flowers";
                break;
            case ('|'):
                food = "leaves";
                break;
        }
        dino = scene.contains(T_Rex) ? "A T-Rex" : scene.contains(brachiosaurus) ? "A " +
                "brachiosaurus" : scene
                .contains(velociraptor) ? "A velociraptor" : scene.contains(triceratops)
                ? "A triceratops" : "Something";

        return String.format("%1$s is eating %2$s.", food.equals("a dead dino") && (dino.equals
                ("A " + "T-Rex") || dino.equals("A velociraptor")) ? dino : (food.equals("leaves")
                || food.equals("flowers")) && dino.equals("A brachiosaurus") ? dino : food.equals
                ("flowers") && dino.equals("A triceratops") ? dino : "Something", food);
    }

    public static boolean validate(String input) {
        input = input.toLowerCase();
        Pattern pattern = Pattern.compile("[a-z]{1,}[a-z0-9_]*@[a-z0-9_-]{1,}(\\.[a-z0-9_-]{1,})" +
                "{1,}");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static BigInteger diagonal(int n, int p) {
        BigInteger[] currentArr = new BigInteger[]{BigInteger.valueOf(1), BigInteger.valueOf(1)};
        n = n + 1;
        p = p + 1;
        for (int i = 2; i <= n; i++) {
            BigInteger[] newArr = new BigInteger[i + 1];
            newArr[0] = currentArr[0];
            newArr[newArr.length - 1] = currentArr[currentArr.length - 1];
            for (int j = 1; j < newArr.length - 1; j++) {
                newArr[j] = currentArr[j - 1].add(currentArr[j]);
            }
            currentArr = newArr;
        }
        return currentArr[p];
    }

    public static boolean hasTwoCubeSums(int n) {
        double c = Math.cbrt(n), reference = 0;
        if (Math.floor(c) == c) return true;
        int root = (int) Math.floor(Math.cbrt((double) n)), count = 0;
        for (int i = 0; i < root; i++) {
            double temp = Math.cbrt(n - Math.pow(i, 3));
            if (reference != temp) {
                if (Math.floor(temp) == temp) {
                    reference = temp;
                    count++;
                }
            }
            if (count == 2) return true;
        }
        return false;
    }

//    public static String solEquaStr(long n) {
//        // your code
//        long guess = n/2;
//
//        return ""
//    }

//    public static String WhoIsNext(String[] names, int n) {
//        long total = 5;
//        while (total <= n) {
//            total *= 2;
//        }
//        total *= 2;
//        long part = total / 5;
//        int index;
//        double offset = n / part;
//        if (offset <= 1) index = 0;
//        else if (offset > 1 && offset <= 2) index = 1;
//        else if (offset > 2 && offset <= 3)
//            index = 2;
//        else if (offset > 3 && offset <= 4) index = 3;
//        else index = 4;
//        return names[index];
//    }

    private class Kid {

    }

    public static String WhoIsNext(String[] names, int n) {
        Map<String, Long> map = new LinkedHashMap<>();
        String lastOne = "";
        for (String name : names) map.put(name, 1l);
        long temp;
        while (n > 0) {
            for (String key : map.keySet()) {
                temp = map.get(key);
                n -= temp;
                if (n <= 0) {
                    lastOne = key;
                    break;
                }
                map.put(key, temp * 2);
            }
        }
        return lastOne;
    }

    public static String order(String words) {
        int length = words.length();
        String[] input = words.split(" ");
        String[] output = new String[input.length];
        String result = "";
        for (String str : input) output[Integer.parseInt(str.replaceAll("[^0-9]", "")) - 1] = str;
        for (String str : output) result += str + " ";
        return result.substring(0, length);
    }

    public static BigInteger perimeter(BigInteger n) {
        BigInteger first = BigInteger.valueOf(0);
        BigInteger second = BigInteger.valueOf(1);
        BigInteger temp;
        for (BigInteger i = BigInteger.valueOf(0); i.compareTo(n) == -1; i = i.add(BigInteger
                .valueOf(1))) {
            temp = second;
            second = first.add(second).add(BigInteger.valueOf(1));
            first = temp;
        }
        return second.multiply(BigInteger.valueOf(4));
    }

    private static long getMinMulti(long[] array) {
        BigInteger gcd = BigInteger.valueOf(array[0]);
        for (int i = 1; i < array.length; i++) {
            BigInteger next = BigInteger.valueOf(array[i]);
            gcd = gcd.multiply(next).divide(gcd.gcd(next));
        }
        return gcd.longValue();
    }

    public static String convertFrac(long[][] lst) {
        // your code
        if (lst.length == 0) return "";
        int length = lst.length;
        long[] roots = new long[length];
        for (int i = 0; i < length; i++) roots[i] = lst[i][1];
        BigInteger a = BigInteger.valueOf(roots[0]);
        for (int i = 1; i < length; i++) {
            BigInteger b = BigInteger.valueOf(roots[i]);
            a = a.multiply(b).divide(a.gcd(b));
        }
        long gcd = a.longValue();
        String result = "";
        for (int i = 0; i < length; i++)
            result += String.format("(%1$d,%2$d)", gcd / roots[i] * lst[i][0], gcd);
        return result;
    }

    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    class Leetspeak extends Encoder {

        public String encode(String source) {
            if (source.isEmpty() || source.equals(null)) return "";
            ArrayList<String> input = new ArrayList<>();
            int length = source.length();
            for (int i = 0; i < length; i++) {
                input.add(String.valueOf(source.charAt(i)));
            }
            for (int i = 0; i < length; i++) {
                switch (input.get(i)) {
                    case "a":
                    case "A":
                        input.set(i, "4");
                        break;
                    case "e":
                    case "E":
                        input.set(i, "3");
                        break;
                    case "l":
                    case "L":
                        input.set(i, "1");
                        break;
                    case "m":
                    case "M":
                        input.set(i, "/^^\\");
                        break;
                    case "o":
                    case "O":
                        input.set(i, "0");
                        break;
                    case "u":
                    case "U":
                        input.set(i, "(_)");
                        break;
                    default:
                }
            }
            String output = "";
            for (String str : input) output += str;
            return output;
        }
    }

    abstract class Encoder {
        public abstract String encode(String source);
    }

    private static BigInteger getTheFactorial(int start, int end) {
        BigInteger a = BigInteger.valueOf(start);
        for (int i = start + 1; i <= end; i++) {
            a = a.multiply(BigInteger.valueOf(i));
        }
        return a;
    }

    public static BigInteger choose(int n, int p) {
        int pick = Math.min(p, n - p);
        return getTheFactorial(pick + 1, n).divide(getTheFactorial(1, n - pick));
    }

    //TODO: Interview

    public String getTable(int n) {
        boolean a = true;
        if (!a) return " ";
        String result = "";
        for (int i = 1; i <= n * n; i++) result += String.valueOf(i) + " " + (i % 3 == 0 ? "\n" : "");
        return result;
    }

    public String timeConvert(int n) {
        if (n == 0 || n == 24) return "12:00 AM";
        return String.format("%1$02d:00 %2$s", n % 12, n <= 12 ? "AM" : "PM");
    }

    public static int[] mPrevious = {0, 0, 0, 0};

    private static int getSpace(int[] recSample) {
        return Math.abs((recSample[0] - recSample[2]) * (recSample[1] - recSample[3]));
    }

    private static int[] getSample(int[] recSample) {

        return mPrevious = recSample;
    }

//    public static int calculateSpace(int[][] rectangles) {
//        int result = 0;
//        for (int[] recSample : rectangles) {
//            result += getSpace(recSample);
//        }
//    }

    public static String star(int a) {
        String star = "";
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= a - i; j++) star += " ";
            for (int k = 1; k <= i; k++) star += "*";
            star += "\n";
        }
//        Scanner scanner = new Scanner(System.in);
//        scanner.nextLine();
//        int temp;
        star = String.valueOf(Math.round((double) 2 / 3 * 1000) / 1000d);
        int temp = 1;
        star = String.valueOf(temp = 2);
        star = String.valueOf(temp * 2);
        return star;
    }

    public static String getTimeString() {
        String input = "12:40:22AM";
        switch (input) {
            case "12:00:00AM":
                return "00:00:00";
            case "12:00:00PM":
                return "12:00:00";
            default:
                int length = input.length(), time = Integer.parseInt(input.substring(0, 2));
                String mark = input.substring(length - 2, length);
                String rest = input.substring(2, length - 2);
                return String.format("%02d", mark.equals("PM") && time != 12 ? time + 12 : time) + rest;
        }
    }

    public static String getFac(int input) {
        BigInteger result = BigInteger.valueOf(input);
        for (int i = 1; i < input; i++) {
            result = result.multiply(BigInteger.valueOf(input).subtract(BigInteger.valueOf(i)));
        }
        Scanner scanner = new Scanner(System.in);
        int a = 2, b = 3;
        System.out.print(a < b);

        int c = Integer.parseInt("-1");
        return String.valueOf(c);
    }

    public static String shiftArray() {
        char[] arrA = {'1', '2', '3', '4', '5'};
        int length = arrA.length;
        char[] arrB = new char[arrA.length + 1];
        System.arraycopy(arrA, 0, arrB, 1, 5);
        arrB[0] = '0';
        if (arrA.equals("")) ;
        else if (arrA.equals("")) ;
        else {
            switch (arrA[1]) {
                case '0':
                    break;

            }
        }
        return Arrays.toString(arrB);
    }

    public static String getString() {
        int input = 69835;
        StringBuilder result = new StringBuilder();
        int three = input % 3 == 0 ? input / 3 : input % 3 == 1 ? input / 3 - 1 : input / 3 - 2;
        for (int i = 0; i < three; i++) result.append("5");
        for (int i = 0; i < (input % 3 == 1 ? 1 : 2); i++) result.append("3");
        boolean a = true;
        a = !a;
        return result.toString();
    }

    public static String getResult() {
        String input = "push 4";
        String[] data = input.split(" ");
        ArrayList<Integer> container = new ArrayList<>();
        String motion = data[0];
        int value = Integer.parseInt(data[data.length - 1]);
        switch (motion) {
            case "push":
                container.add(value);
                break;
            case "pop":
                container.remove(0);
                break;
            case "inc":
                for (int i = 0; i < container.size() - 2; i++) {
                    container.set(i, container.get(i) + value);
                }
        }
        String result = "";
        if (container.size() == 0) result = "EMPTY";
        else result = String.valueOf(result);
        return result;
    }

    public static String test1() {
        double[] arr = new double[10];
        for (double d : arr) d = 100 * Math.random();
        return String.valueOf(arr[10]);
    }

    public class Tree<T> {
        private Node<T> root;

        public Tree(T rootData) {
            root = new Node<>();
            root.data = rootData;
            root.children = new ArrayList<>();
        }

        public class Node<T> {
            private T data;
            private Node<T> parent;
            private List<Node<T>> children;
        }
    }

    class Box<T> {
        private T data;

        public Box() {

        }

        public Box(T data) {
            this.data = data;
        }

        public T getData() {
            return this.data;
        }
    }

    public String testGeneric() {
        Box<String> str = new Box<>("Hello");
        Box<Integer> num = new Box<>(123);
        return str.getData() + String.valueOf(num.getData());
    }

    public static String test2(){
        String str = "";
        return test3();
    }

    private static String test3(){
        return "H";
    }

    public static String test4(){
        Scanner sc = new Scanner (System.in);
        int size = sc.nextInt();
        for(int i = 0 ; i < size; i++ ){
            String str = sc.nextLine();
            int total = Integer.parseInt(str), count = 0;
            String [] strArr = str.split("");
            int a = Integer.parseInt("123");
            for(String dig : strArr){
                if(total % Integer.parseInt(dig) == 0)count++;
            }
            System.out.println(count);
        }
        return String.valueOf(size);
    }
}





