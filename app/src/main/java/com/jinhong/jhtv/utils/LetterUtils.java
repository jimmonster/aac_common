package com.jinhong.jhtv.utils;

import java.util.LinkedList;

/**
 * @author :  Jim
 * @date :  2019-07-26
 * @description :字母工具
 */
public class LetterUtils {
    /**
     * 按照顺序获取所有字母
     *
     * @return 字母集合
     */
    public static LinkedList<String> getAllLetter() {
        LinkedList<String> mLetters = new LinkedList<>();
        for (int i = 97; i <= 122; i++) {
            mLetters.add("" + (char) i);
        }
        return mLetters;
    }

}
