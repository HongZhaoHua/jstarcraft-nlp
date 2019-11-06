package com.jstarcraft.nlp.lucene.mmseg;

import java.io.File;

import org.apache.lucene.analysis.util.ResourceLoader;

import com.chenlb.mmseg4j.Dictionary;

public class Utils {

    public static Dictionary getDict(String dicPath, ResourceLoader loader) {
        Dictionary dic = null;
        if (dicPath != null) {
            File f = new File(dicPath);
            dic = Dictionary.getInstance(f);
        } else {
            dic = Dictionary.getInstance();
        }
        return dic;
    }
}
