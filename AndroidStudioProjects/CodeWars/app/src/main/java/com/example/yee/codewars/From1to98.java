package com.example.yee.codewars;

import android.app.Activity;
import android.os.Bundle;
import android.text.BoringLayout;
import android.widget.TextView;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by Yee on 9/3/15.
 */
public class From1to98 extends Activity {
    TextView mOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        mOutput = (TextView) findViewById(R.id.text);
        mOutput.setText(String.valueOf(testReg("[+2014]")));
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public class Person {
        String name;

        public Person(String personName) {
            name = personName;
        }

        public String greet(String name) {
            return String.format("Hi %1$s, my name is %2$s", name, this.name);
        }
    }

    public static String calculate(final String n1, final String n2, final String o) {
        int a = Integer.parseInt(n1, 2);
        int b = Integer.parseInt(n2, 2);
        switch (o) {
            case "add":
                return Integer.toBinaryString(a + b);
            case "subtract":
                return Integer.toBinaryString(a - b);
            case "multiply":
                return Integer.toBinaryString(a * b);
            default:
                return "try again";
        }
    }

    public static int getCount(String str) {
        return str.replaceAll("[^aeiou]", "").length();
    }

    public String toJadenCase(String phrase) {
        if (phrase == null || phrase.equals("")) return null;
        char[] array = phrase.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (i == 0 || array[i - 1] == ' ') array[i] = Character.toUpperCase(array[i]);
        }
        return new String(array);
    }

    public int countSheeps(Boolean[] arrayofSheeps) {
        int count = 0;
        for (Boolean b : arrayofSheeps) {
            if (b.equals(true)) count++;
        }
        return count;
    }

    public static int stringToNumber(String str) {
        return Integer.parseInt(str);
    }

    public String[] greetingForAllFriends(String... friends) {
        if (friends == null || friends.length == 0) return null;
        String[] greeting = new String[friends.length];
        for (int i = 0; i < friends.length; i++) {
            greeting[i] = String.format("Hello, %s!", friends[i]);
        }
        return greeting;
    }

    public int solution(int number) {
        int[] array = new int[number];
        for (int i = 1; i < number; i++) if (i % 3 == 0 || i % 5 == 0) array[i] = i;
        int sum = 0;
        for (int i : array) sum += i;
        return sum;
    }

    public static int multiply(int a, int b) {
        int result = a * b;
        if (result != (long) a * b) throw new ArithmeticException();
        else return result;
    }

    public static int nthterm(int first, int n, int c) {
        return first + n * c;
    }

    //TODO: can't get it totally!!
    public static int findIt(int[] A) {
        int xor = 0;
        for (int a : A) {
            xor ^= a;
        }
        return xor;
    }

    public static int digital_root(int n) {
        String str = Integer.toBinaryString(n);
        int bufferInt = n;
        for (int i = 0; i < str.length() - 1; i++) {
            str = Integer.toString(bufferInt);
            int length = str.length();
            if (length > 1) {
                int[] array = new int[length];
                int buffer = 0;
                for (int j = 0; j < length; j++) {
                    array[j] = str.charAt(j) - '0';
                    buffer += array[j];
                }
                bufferInt = buffer;
            }
        }
        return bufferInt;
    }

    public static int evaporator(double content, double evap_per_Day, double threshold) {
        int count = 0;
        double full = 1d;
        while (full >= 1 * (threshold / 100)) {
            full *= 1 - evap_per_Day / 100;
            count++;
        }
        return count;
    }

    public static String showRalationship(String male, String female) {
        char[] boy = male.toCharArray();
        char[] girl = female.toCharArray();
        char[] outputBoy = male.toCharArray();
        char[] outputGirl = female.toCharArray();
        int indexBoy, indexGirl;
        String output = "";
        char[] valueInCommon = new char[Math.min(male.length(), female.length())];
        int countCommon = 0;
        for (char aBoy : boy) {
            for (char aGirl : girl) {
                if (aBoy == aGirl) {
                    valueInCommon[countCommon] = aBoy;
                    countCommon++;
                }
            }
        }
        int countBoy = 0, countGirl = 0;
        for (char aBoy : boy) {
            int innerCount = 0;
            for (char aValueInCommon : valueInCommon) if (aBoy != aValueInCommon) innerCount++;
            if (innerCount == valueInCommon.length) {
                outputBoy[countBoy] = aBoy;
                countBoy++;
            }
        }
        for (char aGirl : girl) {
            int innerCount = 0;
            for (char aValueInCommon : valueInCommon) if (aGirl != aValueInCommon) innerCount++;
            if (innerCount == valueInCommon.length) {
                outputGirl[countGirl] = aGirl;
                countGirl++;
            }
        }
        indexBoy = countBoy;
        indexGirl = countGirl;
        if (countCommon == 0) {
            outputBoy = male.toCharArray();
            outputGirl = female.toCharArray();
        }
        output = (new String(outputBoy, 0, indexBoy)) + (new String(outputGirl, 0, indexGirl));
        switch (output.length() % 6) {
            case 1:
                return "Friendship";
            case 2:
                return "Love";
            case 3:
                return "Affection";
            case 4:
                return "Marriage";
            case 5:
                return "Enemies";
            case 0:
                return "Siblings";
        }
        return output;
    }

    public static long DigPow(int n, int p) {
        String str = Integer.toString(n);
        int result = 0;
        for (char number : str.toCharArray()) {
            result += Math.pow((double) (number - '0'), (double) p);
            p++;
        }
        if (result % n == 0) return (long) result / n;
        return -1;
    }

    public static String greet() {
        return "hello world!";
    }

    public static String makeReadable1(int seconds) {
        if (seconds > 0 && seconds <= 359999) {
            int hour = seconds / 3600, minute = (seconds % 3600) / 60, sec = (seconds % 3600) % 60;
            String hours = Integer.toString(hour), minutes = Integer.toString(minute), secs =
                    Integer.toString(sec);
            return String.format("%1$s:%2$s:%3$s", hours.length() < 2 ? "0" + hours : hours,
                    minutes.length() < 2 ? "0" + minutes : minutes, secs.length() < 2 ? "0" +
                            secs : secs);
        }
        return "00:00:00";
    }

    public static String makeReadable(int seconds) {
        return String.format("%1$02d:%2$02d:%3$02d", seconds / 3600, (seconds / 60) % 60, seconds
                % 60);
    }

    public static String greet(String name) {
        if (name.equals("Johnny")) return "Hello, my love";
        if (!name.isEmpty()) return "Hello, " + name;
        return "empty";
    }

    static String row(int n, int i) {
        String str = "";
        for (int j = 0; j < (n - i) / 2; ++j) str += " ";
        for (int j = 0; j < i; ++j) str += "*";
        return str + "\n";
    }

    public static String print(int n) {
        if (n < 1 || n % 2 == 0) return null;
        String str = row(n, n);
        for (int i = n - 2; i >= 1; i -= 2) {
            String temp = row(n, i);
            str = temp + str + temp;
        }
        return str;
    }

    public static long conjecture(long x) {
        int count = 1;
        if (x > 0) {
            while (x != 1) {
                if (x % 2 == 0) {
                    x /= 2;
                    count++;
                } else {
                    x = x * 3 + 1;
                    count++;
                }
            }
        }
        return (long) count;
    }

    public static String Tickets(int[] peopleInLine) {
        int n = peopleInLine.length;
        boolean ok = true;
        int[] cnt = new int[5];
        for (int i = 0; i < n; i++) {
            int a = peopleInLine[i] / 25, t = a;
            for (int j = 3; j > 0; --j) {
                while (a > 1 && j != a && cnt[j] > 0) {
                    a -= j;
                    --cnt[j];
                }
            }
            if (a > 1) ok = false;
            else ++cnt[t];
        }
        return ok ? "YES" : "NO";
    }

    public static int calculateAngle(int hour, int minute) {
        return (hour == 12 && minute == 0) ? 0 : Math.abs((30 * minute / 60 + hour * 30) - 6 *
                minute);
    }

    public static String makeComplement(String dna) {
        char[] array = dna.toCharArray();
        for (int i = 0; i < array.length; i++) {
            switch (array[i]) {
                case 'A':
                    array[i] = 'T';
                    break;
                case 'T':
                    array[i] = 'A';
                    break;
                case 'G':
                    array[i] = 'C';
                    break;
                case 'C':
                    array[i] = 'G';
                    break;
            }
        }
        return new String(array);
    }

    public static Serializable findWord(String x, String[] y) {
        List<String> result = new ArrayList<>();
        for (String s : y) if (s.toLowerCase().contains(x.toLowerCase())) result.add(s);
        return result.isEmpty() ? "Empty" : result.toArray(new String[result.size()]);
    }

    public static boolean isSquare(int n) {
        return Math.sqrt(n) % 1 == 0;
    }

    public static int sorDesc(final int num) {
        String str = Integer.toString(num);
        char[] array = str.toCharArray();
        Integer[] array1 = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            array1[i] = array[i] - '0';
        }
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(array1));
        Collections.sort(arrayList);
        Collections.reverse(arrayList);
        int[] intArray = new int[arrayList.size()];
        int i = 0;
        for (Integer a : arrayList) {
            intArray[i++] = a;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int a : intArray) stringBuilder.append(a);
        return Integer.parseInt(stringBuilder.toString());
    }

    public boolean isPalindrome(String str) {
        str = str.replaceAll("[^A-z0-9]", "").toLowerCase();
        return new StringBuilder(str).reverse().toString().equals(str);
    }

    public static int findSmallest(final int[] numbers, final String toReturn) {
        int lowest = 0;
        for (int i = 0; i < numbers.length; ++i) {
            if (numbers[i] < numbers[lowest]) lowest = i;
        }
        return toReturn.charAt(0) == 'v' ? numbers[lowest] : lowest;
    }

    public int squareDigits(int n) {
        String str = Integer.toString(n);
        char[] array = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : array) stringBuilder.append((int) Math.pow((c - '0'), 2));
        return Integer.parseInt(stringBuilder.toString());
    }

    public static double area(double radius) {
        if (radius <= 0) throw new IllegalArgumentException("false");
        return Math.PI * Math.pow(radius, 2);
    }

    public static String caffeineBuzz(int n) {
        String str = "mocha_missing";
        boolean d3 = (n % 3 == 0);
        boolean d4 = (n % 4 == 0);
        boolean even = (n % 2 == 0);
        if (d3) str = "Java";
        if (d4) str = "Coffee";
        if (even && (d3 || d4)) return str + "Script";
        return str;
    }

    public String sortGiftCode(String code) {
        char[] array = code.toCharArray();
        Character[] array1 = new Character[array.length];
        for (int i = 0; i < array.length; i++) array1[i] = array[i];
        Arrays.sort(array1, new Comparator<Character>() {
            @Override
            public int compare(Character lhs, Character rhs) {
                return rhs.compareTo(lhs);
            }
        });
        return Arrays.toString(array1);
    }

    public static List<Integer> sqInRect(int lng, int wdth) {
        List<Integer> list = new LinkedList<>();
        if (lng == wdth) return null;
        while (lng != wdth) {
            int big = Math.max(lng, wdth);
            int small = Math.min(lng, wdth);
            list.add(small);
            if (big == lng) lng = big - small;
            else wdth = big - small;
            if (lng == wdth) list.add(lng);
        }
        return list;
    }

    static String encode(String word) {
        char[] array = word.toCharArray();
        int length = array.length;
        char[] countArray = new char[length];
        for (int i = 0; i < length; i++) {
            int count = 0;
            for (char m : array)
                if (String.valueOf(m).equalsIgnoreCase(String.valueOf(array[i]))) count++;
            countArray[i] = (char) count;
        }
        for (int i = 0; i < length; i++) countArray[i] = (countArray[i] > (char) 1) ? ')' : '(';
        return Arrays.toString(countArray);
    }

    static String[] shadesOfGrey(int num) {
        num = Math.max(0, Math.min(254, num));
        String[] result = new String[num];
        for (int i = 1; i <= num; ++i) result[i - 1] = String.format("#%02d%02d%02d", i, i, i);
        return result;
    }

    public static int[] sumOfN(int n) {
        int[] result = new int[Math.abs(n) + 1];
        int sum = 0;
        int sign = (int) Math.signum(n);
        for (int i = 0; i < result.length; i++) {
            result[i] = sum + sign * i;
            sum += sign * i;
        }
        return result;
    }

    class Ghost {
        private String[] m_colorCodes = new String[]{"white", "yellow", "purple", "red"};
        private String m_color = "";

        Ghost() {
            m_color = m_colorCodes[new Random().nextInt(m_colorCodes.length - 1)];
        }

        public String getColor() {
            return m_color;
        }
    }

    public String spinWords(String sentence) {
        String[] words = sentence.split(" ");
        String result = "";
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() >= 5) words[i] = new StringBuffer(words[i]).reverse().toString();
            result += words[i] + " ";
        }
        return String.valueOf(Arrays.copyOfRange(result.toCharArray(), 0, sentence.length()));
    }

    public boolean isCircleSorted(int[] a) {
        int disorder = 0;
        for (int i = 0; i < a.length; ++i) if (a[i == 0 ? a.length : i - 1] > a[i]) ++disorder;
        return disorder <= 1;
    }

    public static int presses(String phrase) {
        phrase = phrase.toUpperCase().replaceAll("[^A-Z0-9*#\\s]", "");
        String[] phoneKey = new String[]{"1", "ABC2", "DEF3", "GHI4", "JKL5", "MNO6", "PQRS",
                "TUV8", "WXYZ", "*", " 0", "#"};
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < phoneKey.length; i++) map.put(i + 1, phoneKey[i]);
        int totalPress = 0;
        for (char c : phrase.toCharArray()) {
            totalPress += map.get(c == '1' ? 1 : (c == '2' || c == 'A' || c == 'B' || c == 'C' ?
                    2 : (c == '3' || c == 'D' || c == 'E' || c == 'F' ? 3 : (c == '4' || c == 'G'
                    || c == 'H' || c == 'I' ? 4 : (c == '5' || c == 'J' || c == 'K' || c == 'L' ?
                    5 : (c == '6' || c == 'M' || c == 'N' || c == 'O' ? 6 : (c == '7' || c == 'P'
                    || c == 'Q' || c == 'R' || c == 'S' ? 7 : (c == '8' || c == 'T' || c == 'U'
                    || c == 'V' ? 8 : (c == '9' || c == 'W' || c == 'X' || c == 'Y' || c == 'Z' ?
                    9 : (c == '*' ? 10 : (c == '0' || c == ' ' ? 11 : 12))))))))))).indexOf(c) + 1;
        }
        return totalPress;
    }

    public String winner(String[] deckSteve, String[] deckJosh) {
        List<String> Steve = Arrays.asList(deckSteve);
        List<String> Josh = Arrays.asList(deckJosh);
        int s = 0, j = 0;
        for (int i = 0; i < Steve.size(); i++) {
            int[] arrayInt = new int[2];
            String[] temp = new String[]{Steve.get(i), Josh.get(i)};
            for (int m = 0; m < 2; m++) {
                arrayInt[m] = Integer.parseInt(temp[m].equals("T") ? "10" : (temp[m].equals("J")
                        ? "11" : (temp[m].equals("Q") ? "12" : (temp[m].equals("K") ? "13" :
                        (temp[m].equals("A") ? "14" : temp[m])))));
            }
            if (arrayInt[0] > arrayInt[1]) s++;
            else if (arrayInt[0] < arrayInt[1]) j++;
        }
        return s > j ? "Steve wins " + s + " to " + j : (s == j ? "Tie" : "Josh wins " + j + " to" +
                " " + s);
    }

    public static String iterPi2String(Double epsion) {
        double PI = 1 - 1d / 3d, i = 5, dif = Math.PI - PI * 4;
        int numberOfIterations = 2;
        while (dif > epsion) {
            if (numberOfIterations % 2 == 0) PI += 1 / i;
            else PI -= 1 / i;
            numberOfIterations++;
            dif = Math.abs(PI * 4 - Math.PI);
            i += 2;
        }
        return String.format("%1$d,%2$.10f", numberOfIterations, PI * 4);
    }

    public static int gcdBinary(int x, int y) {
        BigInteger a = BigInteger.valueOf(x), b = BigInteger.valueOf(y), gcd = a.gcd(b);
        return count_one(gcd.intValue());
    }

    //TODO: Learn the behind
    static int count_one(int x) {
        x = (x & (0x55555555)) + ((x >> 1) & (0x55555555));
        x = (x & (0x33333333)) + ((x >> 2) & (0x33333333));
        x = (x & (0x0f0f0f0f)) + ((x >> 4) & (0x0f0f0f0f));
        x = (x & (0x00ff00ff)) + ((x >> 8) & (0x00ff00ff));
        x = (x & (0x0000ffff)) + ((x >> 16) & (0x0000ffff));
        return x;
    }

    public static String getWinner(final List<String> listOfBallots) {
        for (String str : new HashSet<>(listOfBallots))
            if (Collections.frequency(listOfBallots, str) > listOfBallots.size() / 2) return str;
        return null;
    }

    public static boolean groupCheck(String s) {
        if (s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        char[] array = s.toCharArray();
        for (char a : array) {
            switch (a) {
                case '[':
                    stack.push(']');
                    break;
                case '(':
                    stack.push(')');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case ']':
                case ')':
                case '}':
                    if (stack.pop() != a) return false;
                default:
                    break;
            }
        }
        return stack.isEmpty();
    }

    public static String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0) return "";
        int length = lstOfArt.length, indexOfTotal = 0;
        int outputLength = lstOf1stLetter.length;
        int[] total = new int[outputLength];
        String[] name = lstOfArt.clone();
        int[] number = new int[length];
        for (int i = 0; i < length; i++) {
            name[i] = name[i].replaceAll("[^A-Za-z]", "");
            number[i] = Integer.parseInt(lstOfArt[i].replaceAll("[^0-9]", ""));
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) map.put(name[i], number[i]);
        for (String str : lstOf1stLetter) {
            int count = 0;
            for (String key : name) {
                char[] array = key.toCharArray();
                for (char c : array) if (c == str.charAt(0)) count += map.get(key);
            }
            total[indexOfTotal] = count;
            indexOfTotal++;
        }
        String output = String.format("(%1$s:%2$d) ", lstOf1stLetter[0], total[0]);
        for (int i = 1; i < outputLength; i++)
            output += String.format("-(%1$s:%2$d)", lstOf1stLetter[i], total[i]);
        return output.substring(0, output.length() - 1);
    }

    class Binder<T, I> {
        public List<I> bind(List<T> list) {
            return null;
        }
    }

    public static String test0(String str) {
        return Arrays.toString(str.split("[He]"));
    }

    public static String boolToWord(boolean b) {
        return b ? "Yes" : "No";
    }

    public static String message(String rwy, int windDriection, int windSpeed) {
        int runWay = Integer.parseInt(rwy.replaceAll("[^0-9]", "")) * 10;
        double sinCrossWind = Math.sin(Math.toRadians(runWay - windDriection)), cosHeadWind =
                Math.cos(Math.toRadians(runWay - windDriection));
        int crossWind = Math.abs((int) Math.round(sinCrossWind * windSpeed)), headWind = Math.abs
                ((int) Math.round(cosHeadWind * windSpeed));
        String headWindDirection = "", crossWindDirection = "";
        if (runWay >= 180) {
            if (windDriection < runWay && windDriection > runWay - 180) crossWindDirection = "left";
            else if (windDriection > runWay || windDriection < runWay - 180)
                crossWindDirection = "right";
        }
        if (runWay < 180) {
            if (windDriection > runWay && windDriection < runWay + 180)
                crossWindDirection = "right";
            else if (windDriection < runWay || windDriection > runWay + 180)
                crossWindDirection = "left";
        }
        if (runWay < 90) {
            if (windDriection > 360 + (runWay - 90) || windDriection < runWay + 90)
                headWindDirection = "Head";
            else headWindDirection = "tail";
        }
        if (runWay >= 90 && runWay < 270) {
            if (windDriection > runWay - 90 && windDriection < runWay + 90)
                headWindDirection = "Head";
            else headWindDirection = "Tail";
        }
        if (runWay >= 270) {
            if (windDriection > runWay - 90 || windDriection < runWay - 270)
                headWindDirection = "Head";
            else headWindDirection = "Tail";
        }
        if (cosHeadWind == 0) crossWindDirection = "right";
        if (headWind == 0) headWindDirection = "Head";
        return String.format("%1$swind %2$d knots. Crosswind %3$d knots from your %4$s.",
                headWindDirection, headWind, crossWind, crossWindDirection);
    }

    private int sum = 0;

    private String findSumOfCubes(int number) {
        int result = 0, save = number;
        while (number != 0) {
            int rem = number % 10;
            result = result + (int) Math.pow(rem, 3);
            number = number / 10;
        }
        if (save == result) {
            sum += save;
            return Integer.toString(save);
        }
        return "";
    }

    public String isSumOfCubes(String str) {
        LinkedList<Integer> numbers = new LinkedList<>();
        String res = "";
        Pattern p = Pattern.compile("\\d{1,3}");
        Matcher m = p.matcher(str);
        while (m.find()) numbers.add(Integer.parseInt(m.group()));
        for (int n : numbers) {
            String a = findSumOfCubes(n);
            if (!a.equals("")) res = res + a + " ";
        }
        if (!res.equals("")) return res + Integer.toString(sum) + "Lucky";
        else return "Unlucky";
    }

    class BatmanQuotes {
        public String getQuote(String[] quotes, String hero) {
            return String.format("%1$s: %2$s", new BatmanQuotes().nameFilter(hero), quotes[Integer
                    .parseInt(hero.replaceAll("[^0-9]", ""))]);
        }

        String nameFilter(String hero) {
            char[] array = hero.toUpperCase().toCharArray();
            char a = array[0];
            switch (a) {
                case 'B':
                    return "Batman";
                case 'R':
                    return "Robin";
                case 'J':
                    return "Joker";
                default:
                    return "Someone";
            }
        }
    }

    //TODO:under start() end() group()
    public static int find(String needle, String haystack) {
        String regNeedle = "\\Q" + needle.replaceAll("_", "\\\\E.\\\\Q") + "\\E";
        Matcher m = Pattern.compile(regNeedle).matcher(haystack);
        if (m.find()) return m.start();
        else return -1;
    }

    public static String fromNb2Str(int n, int[] sys) {
        String result = "";
        int multiply = 1, length = sys.length;
        boolean coPrime = true;
        for (int i = 0; i < length; i++) {
            multiply *= sys[i];
            for (int j = i + 1; j < length; j++) {
                if (BigInteger.valueOf(sys[j]).gcd(BigInteger.valueOf(sys[i])).intValue() != 1) {
                    coPrime = false;
                    break;
                }
            }
        }
        if (coPrime) for (int sy : sys) result += String.format("-%d-", n % sy);
        return !coPrime || multiply < n ? "Not applicable" : result;
    }


    public static boolean isValid(char[] walk) {
        float multiply = 1;
        for (int i = 0; i < walk.length; i++) {
            multiply *= (walk[i] == 'n') ? 2 : (walk[i] == 's' ? 0.5f : (walk[i] == 'w' ? -2 :
                    -0.5f));
        }
        return walk.length == 10 && multiply == 1;
    }

    boolean isPrime(long input) {
        if (input != 0 && input != 1) return false;
        for (long j = 2; j <= input / 2; j++) if (input % j == 0) return false;
        return true;
    }

    String backwardsPrime(long start, long end) {
        TreeSet<Long> output = new TreeSet<>();
        long prime, primeReverse;
        for (long i = start; i <= end; i++) {
            if (isPrime(i)) {
                prime = i;
                char[] array = Long.toString(i).toCharArray();
                int m = 0, n = array.length - 1;
                char temp;
                while (n > m) {
                    temp = array[n];
                    array[n] = array[m];
                    array[m] = temp;
                    m++;
                    n++;
                }
                primeReverse = Long.parseLong(String.valueOf(array));
                if (primeReverse != prime && isPrime(primeReverse)) {
                    output.add(prime);
                    if (primeReverse >= start && primeReverse <= end) output.add(primeReverse);
                }
            }
        }
        return output.toString().replaceAll("[\\[\\]]", "");
    }

    public static final int VOWEL = 1;
    public static final int CONSONANT = 2;
    public static final int NO_VOWEL = 3;

    public boolean isVowel(char a) {
        switch (a) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }

    public int consonantCount(char[] array) {
        if (array.length >= 1) {
            char str = array[0];
            char[] one = {'m', 'y', 'w', 'h'};
            for (char a : one) if (a == str) return 1;
        }
        if (array.length >= 2) {
            //TODO:remember subString counts the head not the tail.0 not 2
            String str = String.copyValueOf(array).substring(0, 2);
            String[] two = {"bl", "br", "cl", "cr", "dr", "fl", "ch", "fr", "gl", "gr", "kn", "pl"};
            for (String temp : two) if (str.equals(temp)) return 2;
        }
        if (array.length >= 3) {
            String str = String.copyValueOf(array).substring(0, 3);
            String[] three = {"squ", "dge", "tch", "xyz"};
            for (String temp : three) if (str.equals(temp)) return 3;
        }
        return 0;
    }


    public String translate(String str) {
        int outputStatus = 0, consonantCount = 0;
        str = str.toLowerCase();
        char[] array = str.toCharArray();
        for (char a : array) if (!Character.isLetter(a) || str.isEmpty()) return null;
        for (char anArray : array) {
            if (isVowel(array[0])) outputStatus = VOWEL;
            else {
                consonantCount = consonantCount(str.toCharArray());
                outputStatus = consonantCount == 0 ? NO_VOWEL : CONSONANT;
            }
        }
        switch (outputStatus) {
            case VOWEL:
                return str + "way";
            case CONSONANT:
                String tempConsonant = str.substring(0, consonantCount);
                String tempStr = str.substring(consonantCount);
                return tempStr + tempConsonant + "ay";
            case NO_VOWEL:
                return str + "ay";
            default:
                return "NONE";
        }
    }

    public static int[] nbMonths(int startPriceOld, int startPriceNew, int savingperMonth, double
            percentLossByMonth) {
        int month = 0, save = 0, counter = 1;
        double oldPrice = (double) startPriceOld, newPrice = (double) startPriceNew, have = (double)
                startPriceOld;
        for (month = 0; have < newPrice; month++) {
            save += savingperMonth;
            oldPrice = oldPrice * (1 - (percentLossByMonth / 100));
            newPrice = newPrice * (1 - (percentLossByMonth / 100));
            have = oldPrice + save;
            counter++;
            if (counter == 2) {
                percentLossByMonth += 0.5;
                counter = 0;
            }
        }
        return new int[]{month, (int) Math.round(have - newPrice)};
    }

    public static int NumberOfSteps(int n, int m) {
        int inCase = n / 2, start = n % 2, stepNumber = inCase + start, i = 1;
        while (stepNumber % m != 0 && i <= inCase) {
            stepNumber += 1;
            i++;
        }
        return stepNumber % m == 0 ? stepNumber : -1;
    }

    public static String SongDecoder(String song) {
        int startPoint = 0, endPoint = 0;
        song = song.replaceAll("WUB", "1");
        for (int i = 0; i < song.length(); i++) {
            if (Character.isLetter(song.charAt(i))) {
                endPoint = i;
                break;
            }
        }
        for (int i = song.length() - 1; i > 0; i--) {
            if (Character.isLetter(song.charAt(i))) {
                endPoint = i;
                break;
            }
        }
        song = song.substring(startPoint, endPoint + 1);
        song = song.replaceAll("\\d{1,70}", " ");
        return song;
    }

    public static final int NORTH = 1;
    public static final int SOUTH = -1;
    public static final int WEST = 2;
    public static final int EAST = -2;

    public static String[] dirReduc(String[] arr) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (String str : arr)
            arrayList.add(str.equals("NORTH") ? NORTH : (str.equals("SOUTH") ? SOUTH : (str
                    .equals("WEST") ? WEST : EAST)));

        int newListSize = arrayList.size();
        int oldListSize = arrayList.size();
        do {
            for (int i = 0; i < newListSize; i++) {
                oldListSize = newListSize;
                if (i + 1 < arrayList.size()) {
                    if (arrayList.get(i) + arrayList.get(i + 1) == 0) {
                        arrayList.remove(i);
                        arrayList.remove(i);
                    }
                }
            }
            if (arrayList.size() == 0) return new String[]{};
            else newListSize = arrayList.size();
        } while (newListSize != oldListSize);
        String[] result = new String[arrayList.size()];
        int r = 0;
        for (int a : arrayList)
            result[r++] = a == NORTH ? "NORTH" :
                    (a == SOUTH ? "SOUTH" : a == WEST ? "WEST" : "EAST");
        return result;
    }

    public static int sequence(int[] arr) {
        HashMap<int[], Integer> map = new HashMap<>();
        int lenth = arr.length;
        for (int i = 1; i < lenth; i++) {
            for (int j = 0; j < lenth; j++) {
                if (j + i <= lenth) {
                    int[] key = Arrays.copyOfRange(arr, j, j + 1);
                    int value = 0;
                    for (int m : key) value += m;
                    map.put(key, value);
                }
            }
        }
        int max = 0;
        for (int i : map.values()) if (i > max) max = 1;
        return max;
    }

    public static Object[] rotate(Object[] data, int n) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(Arrays.copyOf(data, data
                        .length,
                Integer[].class)));
        ArrayList<Integer> output = new ArrayList<>(arrayList);
        int index, length = arrayList.size();
        if (n > 0) {
            for (int i = 0; i < length; i++) {
                index = i + n % length;
                if (index > length - 1) output.set(index - length, arrayList.get(i));

            }
        } else if (n < 0) {
            for (int i = 0; i < length; i++) {
                index = i + n % length;
                if (index < 0) output.set(length + index, arrayList.get(i));
                else output.set(index,
                        arrayList.get(i));
            }
        } else output = arrayList;
        return output.toArray();
    }

    public static String[] inArray(String[] array1, String[] array2) {
        TreeSet<String> result = new TreeSet<>();
        for (String str1 : array1) {
            for (String str2 : array2)
                if (!str2.equals(str1) && str2.contains(str1)) {
                    result.add(str1);
                    break;
                }
        }
        String[] strArr = new String[result.size()];
        strArr = result.toArray(strArr);
        return strArr;
    }

    public static boolean comp(int[] a, int[] b) {
        if (a.length == 0 && b.length == 0) return true;
        if (a.length == 0 || b.length == 0 || a.length != b.length) return false;
        List<Double> A = new LinkedList<>(), B = new LinkedList<>();
        for (int i = 0; i < a.length; i++) {
            A.add(Math.pow((double) a[i], 2));
            B.add((double) b[i]);
        }
        Collections.sort(A);
        Collections.sort(B);
        return A.equals(B);
    }

    public static String repeat(String s, int n) {
        if (s == null) return null;
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) stringBuilder.append(s);
        return stringBuilder.toString();
    }

    public static String toRoman(int arabic) {
        LinkedHashMap<String, Integer> roman_numerals = new LinkedHashMap<>();
        int[] numbers = {900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        if (arabic > 0 && arabic < 1000) {
            for (int i = 0; i < numbers.length; i++)
                roman_numerals.put(roman[i],
                        numbers[i]);
            String res = "";
            for (Map.Entry<String, Integer> entry : roman_numerals.entrySet()) {
                int matches = arabic / entry.getValue();
                res += repeat(entry.getKey(), matches);
                arabic = arabic % entry.getValue();
            }
            return res;
        } else return "NaR";
    }

    class PaginationHelper<I> {
        List<I> collection;
        int itemsPerPage, itemsTotal;
        int[] array;

        public PaginationHelper(List<I> collection, int itemsPerPage) {
            this.collection = collection;
            this.itemsPerPage = itemsPerPage;
        }

        public int itemCount() {
            return itemsTotal = collection.size();
        }

        public int pageCount() {
            int refer = itemsTotal / itemsPerPage;
            int count = itemsTotal < itemsPerPage ? 1 : itemsTotal % itemsPerPage == 0 ? refer :
                    refer + 1;
            int rest = itemsTotal;
            array = new int[count];
            for (int i = 0; i < count; i++)
                array[i] = (rest - itemsPerPage)
                        > rest ? itemsPerPage : rest - itemsPerPage;
            return count <= 3 ? 3 : count;
        }

        public int pageItemCount(int pageIndex) {
            return array[pageIndex];
        }

        public int pageIndex(int itemIndex) {
            int refer = (itemIndex + 1) / itemsPerPage;
            return collection.isEmpty() || itemIndex > collection.size() || itemIndex < 0 ? -1 :
                    (itemIndex + 1) % itemsPerPage == 0 ? refer - 1 : refer;
        }
    }

    private int uniqueNumberLength;

    private boolean isPrime1(long n) {
        if (n == 0 || n == 1) return false;
        for (int i = 2; i <= n / 2; i++) if (n % i == 0) return false;
        return true;
    }

    private Long[] Primes(long n) {
        ArrayList<Long> arrayList = new ArrayList<>();
        for (long l = 2; l <= n / 2; l++) if (isPrime1(l) && n % l == 0) arrayList.add(l);
        uniqueNumberLength = arrayList.size();
        Long[] temp = arrayList.toArray(new Long[arrayList.size()]);
        Arrays.sort(temp);
        return temp;
    }

    public Long[] getAllPrimeFactors(long n) {
        if (n < 0 || n == 0) return new Long[]{};
        if (n == 1) return new Long[]{(long) 1};
        if (isPrime1(n)) return new Long[]{n};
        Long[] array = Primes(n);
        ArrayList<Long> arrayList = new ArrayList<>();
        while (n != 1) {
            for (Long anArray : array) {
                if (n % anArray == 0) {
                    n /= anArray;
                    arrayList.add(anArray);
                    break;
                }
            }
        }
        Long[] temp = arrayList.toArray(new Long[arrayList.size()]);
        Arrays.sort(temp);
        return temp;
    }

    public Long[][] getUniquePRimeFactorsWithCount(long n) {
        if (n < 0 || n == 0) return new Long[][]{{}, {}};
        if (n == 1) return new Long[][]{{(long) 1}, {(long) 1}};
        if (isPrime1(n)) return new Long[][]{{n}, {(long) 1}};
        ArrayList<Long[]> arrayList = new ArrayList<>(2);
        arrayList.add(0, Primes(n));
        arrayList.add(1, new Long[uniqueNumberLength]);
        Long[] primes = arrayList.get(0);
        if (Arrays.equals(primes, new Long[]{(long) 0})) arrayList.set(0, new Long[]{(long) 2});
        Long[] power = arrayList.get(1), array = getAllPrimeFactors(n);
        for (int j = 0; j < uniqueNumberLength; j++) {
            long count = 0;
            for (Long anArray : array) if (Objects.equals(anArray, primes[j])) count++;
            power[j] = count;
        }
        return arrayList.toArray(new Long[][]{});
    }

    public Long[] getPrimeFactorPotencies(long n) {
        if (n < 0 || n == 0) return new Long[]{};
        if (n == 1) return new Long[]{(long) 1};
        if (isPrime1(n)) return new Long[]{n};
        Long[][] arrayMulti = getUniquePRimeFactorsWithCount(n);
        Long[] array = new Long[uniqueNumberLength];
        for (int i = 0; i < uniqueNumberLength; i++)
            array[i] = (long) Math.pow((double) arrayMulti[0][i],
                    (double) arrayMulti[1][i]);
        return array;
    }

    public static BigInteger powers(int[] list) {
        BigInteger result = BigInteger.valueOf(1);
        for (int aList : list) result = result.multiply(BigInteger.valueOf(2));
        return result;
    }

    public String reverse(String str) {
        if (str.length() <= 1) return str;
        return reverse(str
                .substring(1)) + str.charAt(0);
    }

    public static int[] minMax(int[] arr) {
        Arrays.sort(arr);
        return new int[]{arr[0], arr[arr.length - 1]};
    }

    public double[] tribonacci(double[] s, int n) {
        double first = s[0], second = s[1], third = s[2], forth, count = 1;
        int index = 3;
        double[] output = Arrays.copyOf(s, n);
        while ((n - 3) >= count) {
            forth = first + second + third;
            first = second;
            second = third;
            third = forth;
            output[index++] = forth;
            count++;
        }
        return output;
    }

    public double[] xbonacci(double[] signature, int n) {
        int length = signature.length, count = 1, index = length;
        double[] output = Arrays.copyOf(signature, n);
        while (count <= n - length) {
            double sum = 0;
            for (double d : signature) sum += d;
            System.arraycopy(Arrays.copyOfRange(signature, 1, length), 0, signature, 0, length - 1);
            signature[length - 1] = sum;
            output[index++] = sum;
            count++;
        }
        return output;
    }

    public static float mpToKPM(final float mpg) {
        return Math.round(mpg * 1.609344f / 4.54609188f * 100) / 100f;
    }

    public static int numberOfRetangles(int m, int n) {
        int output = 0;
        for (int i = 1; i <= m; i++) for (int j = 1; j <= n; j++) output += i * j;
        return output;
    }

    public static String howmuch(int m, int n) {
        String elementStr = "";
        int max = Math.max(m, n), min = Math.max(Math.min(m, n), 9);
        for (int i = min; i <= max; i++)
            if ((i - 2) % 7 == 0 && (i - 1) % 9 == 0) elementStr += String.format("[M: %1$d " +
                    "B: %2$d C: %3$d]", i, (i - 2) / 7, (i - 1) / 9);
        return String.format("[%s]", elementStr);
    }

    private static class Node {
        int marker;
        Node next;

        Node(int n) {
            this.marker = n;
        }
    }

    public static int josephusSurvivor(final int n, final int k) {
        Node header = new Node(1);
        Node pointer = header;
        for (int i = 2; i <= n; i++) pointer = pointer.next = new Node(i);
        pointer.next = header;
        while (pointer.next != pointer) {
            for (int i = 1; i < k; i++) pointer = pointer.next;
            pointer.next = pointer.next.next;
        }
        return pointer.next.marker;
    }

    public static String game(long n) {
        return String.format("[%s]", (n * n) % 2 == 0 ? String.valueOf(n * n / 2) : String
                .format("%1$s, " +
                        "%2$s", n * n, 2));
    }

    public static int[][] pascal(int depth) {
        int[][] output = new int[depth][];
        if (depth == 1 || depth == 0) {
            output[0] = new int[]{1};
            return output;
        }
        if (depth == 2) {
            output[1] = new int[]{1, 1};
            return output;
        } else {
            output[0] = new int[]{1};
            output[1] = new int[]{1, 1};
            int[] current = new int[]{1, 1};
            int length = 3;
            for (int i = 3; i <= depth; i++) {
                int[] temp = new int[length];
                temp[0] = 1;
                temp[length - 1] = 1;
                length++;
                for (int j = 0; j < length - 3; j++) {
                    temp[j + 1] = current[j] + current[j + 1];
                }
                current = output[i - 1] = temp;
            }
        }
        return output;
    }

    public static int breakChocolate(int n, int m) {
        return m == 0 || n == 0 ? 0 : m * n - 1;
    }

    public static boolean isMerge(String s, String part1, String part2) {
        return (s.length() == (part1 + part2).length()) && (s.length() == 0 || (part1.length() >
                0 && part1
                .charAt(0) == s.charAt(0) && isMerge(s.substring(1), part1.substring(1), part2)) ||
                (part2.length() > 0 && part2.charAt(0) == s.charAt(0) && isMerge(s.substring(1),
                        part1,
                        part2.substring(1))));
    }

    public static LinkedList<long[]> removNb(long n) {
        LinkedList<long[]> output = new LinkedList<>();
        double b;
        for (long a = 1, sum = (1 + n) * n / 2; a < n; a++) {
            b = (double) (sum - 1) / (double) (a + 1);
            if (b <= n && b % 1 == 0) output.add(new long[]{
                    a, (long) b});
        }
        return output;
    }

    public static int persistence(long n) {
        String str = String.valueOf(n);
        int length = str.length(), count = 0;
        while (length > 1) {
            long temp = 1;
            for (int index = 0; index < length; index++) temp *= (str.charAt(index) - '0');
            length = (str = String.valueOf(temp)).length();
            count++;
        }
        return count;
    }

    private static int getPrime(int start) {
        boolean isPrime = true;
        int i = 3;
        for (; i <= start / 2; i += 2) {
            if (start % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime ? start : getPrime(++start);
    }

    public static String factors(int n) {
        String output = "";
        Set<Integer> primeUnique = new TreeSet<>();
        ArrayList<Integer> primeData = new ArrayList<>();
        int prime = 2, quotient = n;
        while (quotient != 1) {
            if (quotient % prime == 0) {
                primeUnique.add(prime);
                primeData.add(prime);
                quotient /= prime;
            } else prime = getPrime(++prime);
        }
        for (Integer i : primeData) {
            int count = 0;
            for (Integer j : primeData) if (i.equals(j)) count++;
            output += count > 1 ? String.format("(%1$d**%2$d)", i, count) : String.format("(%d)",
                    i);
        }
        return output;
    }

    public static String factors1(int n) {
        String result = "";
        int prime = 2;
        for (; prime <= n; ++prime) {
            int count = 0;
            for (; n % prime == 0; count++) n /= prime;
            if (count > 0) result += "(" + prime + (count > 1 ? "**" + count : "") + ")";
        }
        return result;
    }

    static long[] array;
    static long previous, current;

    static void fibGenerator() {
        previous = array[1];
        current = array[1] = array[0] + array[1];
        array[0] = previous;
    }

    public static long[] productFib(long prod) {
        array = new long[]{0, 1};
        previous = 0;
        current = 1;
        while (previous * current < prod) fibGenerator();
        return new long[]{previous, current, (previous * current == prod ? 1 : 0)};
    }

    public static Pattern mod4 = Pattern.compile(".*\\[(\\+|-)?([048]|(\\d*" +
            "(0[048]|[2468][048]|[13579][26])))(^.)?\\].*");

    public static boolean testReg(String input) {
        return mod4.matcher(input).matches();
    }

    public static int bouncingBall(double h, double bonuce, double window) {
        int count = (int) (Math.log(window / h) / Math.log(bonuce));
        return count < 1 ? -1 : count * 2 + 1;
    }

    public static Boolean isTriangleNumber(long number) {
        long a = 0;
        for (long i = 1; a < number; i++) a = (1 + i) * i / 2;
        return a == number;
    }

    public static int lucasnum(int n) {
        if (n == 0) return 2;
        if (n == 1) return 1;
        return n > 0 ? lucasnum(n - 1) + lucasnum(n - 2) : lucasnum(n + 2)-lucasnum(n + 1);
    }
}
