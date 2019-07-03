package com.work.base.algorithms;

import java.util.ArrayList;
import java.util.List;

public class SubString {
    public static void main(String[] args) {
        String str="iareyouiam";
        System.out.println(spitString(str, 0,  null));

    }

    /**
     * 字符串分割
     * @param list

     * @return
     */
    private static Boolean spitString(String list,int start, List<String> data) {
        if (start == list.length()) {
            System.out.println(data);
            return true;
        } else {
            for (int i=start;i<list.length();i++){
                if (isWord(list,start,i)){
                    List<String> newData=new ArrayList<String>();
                    if (data!=null){
                        newData.addAll(data);
                    }
                    newData.add(list.substring(start,i+1));
                    return spitString(list,i+1,newData);
                }
            }
            return false;
        }
    }

    /**
     * 是否为单词
     * @param list
     * @param start
     * @param i
     * @return
     */
    private static boolean isWord(String list, int start, int i) {
        List<String> words=new ArrayList<String>();
        words.add("i");
        words.add("am");
        words.add("you");
        words.add("are");
        return words.contains(list.substring(start,i+1));
    }
}
