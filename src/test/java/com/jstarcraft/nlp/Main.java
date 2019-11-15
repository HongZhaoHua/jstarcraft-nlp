package com.jstarcraft.nlp;

import org.junit.Assert;
import org.junit.Test;
import org.nlpcn.commons.lang.tire.GetWord;
import org.nlpcn.commons.lang.tire.SmartGetWord;
import org.nlpcn.commons.lang.tire.domain.Forest;
import org.nlpcn.commons.lang.tire.domain.SmartForest;
import org.nlpcn.commons.lang.util.StringUtil;

public class Main {

    @Test
    public void test() throws Exception {

        Forest f = new Forest();

        f.addBranch("5", null);
        f.addBranch("2", null);
        f.addBranch("0", null);
        f.addBranch("12", null);
        f.addBranch("23", null);
        f.addBranch("abc12", null);
        f.addBranch("abc", null);
        f.addBranch("解放军", null);
        f.addBranch("解放", null);
        f.addBranch("解放军强渡长江", null);

        String temp;
        GetWord word = f.getWord("　　5月20日，解放军强渡渭河 12 3 abc 1 23");
        while ((temp = word.getFrontWords()) != null) {
            System.out.println(temp + "\t" + word.getParam());
        }

        GetWord udg = f.getWord("　　5月20日，解放军强渡渭河 12 3 abc 1 23");
        while ((temp = udg.getAllWords()) != null) {
            System.out.println(temp + "\t" + udg.getParam());
        }

    }

//    public static void main(String[] args) {
//        /**
//         * 词典的构造.一行一个词后面是参数.可以从文件读取.可以是read流.
//         */
//        long start = System.currentTimeMillis();
//        SmartForest<Integer> forest = new SmartForest<Integer>();
//
//        forest.add("中国", 3);
//
//        forest.add("android", 3);
//
//        forest.add("java", 3);
//        
//        forest.add("jav", 3);
//
//        forest.add("中国人", 3);
//        forest.add("国人", 3);
//        
//        forest.add("0",3);
//        forest.add("3",3);
//
//        String content = " Android-java-中国人00000000000000 1230 013 33333";
//        
//        
//        content = StringUtil.rmHtmlTag(content);
//
//        for (int i = 0; i < 1; i++) {
//            SmartGetWord<Integer> udg = forest.getWord(content.toLowerCase().toCharArray());
//
//            String temp;
//            while ((temp = udg.getAllWords()) != null) {
//                System.out.println(temp + "\t" + udg.getParam());
//            }
//        }
//        System.out.println(System.currentTimeMillis() - start);
//    }

}
