package com.work.base.se;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Strings {
    private String string = "this, year is a great, year";

    public static void main(String[] args) {
        Strings strings = new Strings();
//        strings.regex();
//        strings.split();
//        strings.pattern();
        strings.pattern();
    }

    void regex() {
        System.out.println("\\");
        System.out.println("1234".matches("-?\\d+"));
        System.out.println("+1234".matches("(-|\\+)?\\d+"));
    }

    //split:将字符串从正则表达式匹配的地方切开
    void split() {
        System.out.println(Arrays.toString(string.split(" ")));
        System.out.println(Arrays.toString(string.split("\\W+")));
        System.out.println(Arrays.toString(string.split(",\\W+")));
    }

    /**
     * matches()
     * find()
     * lookingAt()
     */
    void regexMatches() {
        Pattern p = Pattern.compile("\\d+");
        System.out.println("matches：" + p.matcher("1234ab").matches());
        System.out.println("find：" + p.matcher("1234ab").find());
        System.out.println("lookingAt：" + p.matcher("1234ab").lookingAt());
    }

    /**
     * group()
     * start()
     * end()
     */
    void pattern() {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher("aaa2223bb");
        System.out.println("find(): " + m.find() + "m.start(): " + m.start() + "m.end(): " + m.end() + "m.group(): " + m.group());

        Matcher m2 = p.matcher("122223bb");
        System.out.println("lookingAt(): " + m2.lookingAt() + "start(): " + m2.start() + "end(): " + m2.end()+ "group(): " + m2.group());

        Matcher m3 = p.matcher("222322");
        System.out.println("matches(): " + m3.matches() + "start(): " + m3.start() + "end(): " + m3.end()+ "group(): " + m3.group());
    }

    void regexGroup() {
        System.out.println("-----------regexGroup----------");
        String str = "Twas brillig, and the slithy toves\n" +
                "Did gyre and gimble in the wabe;\n" +
                "All mimsy were the borogoves,\n" +
                "And the mome raths outgrabe.\n\n" +
                "Beware the Jabberwock, my son!\n" +
                "The jaws that bite, the claws that catch!\n" +
                "Beware the Jubjub bird, and shun\n" +
                "The frumious Bandersnatch!";
        Matcher m = Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$").matcher(str);
        System.out.println(m.groupCount());
        while (m.find()) {
            for (int i = 0; i <= m.groupCount(); i++) {
                System.out.println("[group: " + i + "  " + m.group(i) + "]");
            }
        }
    }
}
