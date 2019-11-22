package com.jstarcraft.nlp.analysis.lexical.tag.chinses;

import java.util.HashMap;

import com.jstarcraft.nlp.tokenization.NlpTag;

public class PennTreebank {

    private static final HashMap<String, NlpTag> tags = new HashMap<>();

    static {
        /** 副词 */
        tags.put("AD", NlpTag.D);
        /** 助词 */
        tags.put("AS", NlpTag.U);
        /** 介词 */
        tags.put("BA", NlpTag.P);
        /** 连词 */
        tags.put("CC", NlpTag.C);
        /** 数词 */
        tags.put("CD", NlpTag.M);
        /** 连词 */
        tags.put("CS", NlpTag.C);
        /** 助词(的) */
        tags.put("DEC", NlpTag.U);
        /** 助词(的) */
        tags.put("DEG", NlpTag.U);
        /** 助词(得) */
        tags.put("DER", NlpTag.U);
        /** 助词(地) */
        tags.put("DEV", NlpTag.U);
        // TODO 相同框架在不同语言中可能映射不一样.(DT在汉语中为代词,在英语中为冠词)
        /** 代词 */
        tags.put("DT", NlpTag.R);
        /** 助词(等) */
        tags.put("ETC", NlpTag.U);
        /** 未知 */
        tags.put("FW", NlpTag.X);
        /** 叹词 */
        tags.put("IJ", NlpTag.E);
        /** 形容词 */
        tags.put("JJ", NlpTag.A);
        /** 介词 */
        tags.put("LB", NlpTag.P);
        /** 名词 */
        tags.put("LC", NlpTag.N);
        /** 量词 */
        tags.put("M", NlpTag.Q);
        /** 助词 */
        tags.put("MSP", NlpTag.U);
        /** 名词 */
        tags.put("NN", NlpTag.N);
        /** 名词 */
        tags.put("NR", NlpTag.N);
        /** 名词 */
        tags.put("NT", NlpTag.N);
        /** 数词 */
        tags.put("OD", NlpTag.M);
        /** 拟声词 */
        tags.put("ON", NlpTag.O);
        /** 介词 */
        tags.put("P", NlpTag.P);
        /** 代词 */
        tags.put("PN", NlpTag.R);
        /** 标点符号 */
        tags.put("PU", NlpTag.W);
        /** 介词 */
        tags.put("SB", NlpTag.P);
        /** 助词 */
        tags.put("SP", NlpTag.U);
        /** 形容词 */
        tags.put("VA", NlpTag.A);
        /** 动词 */
        tags.put("VC", NlpTag.V);
        /** 动词 */
        tags.put("VE", NlpTag.V);
        /** 动词 */
        tags.put("VV", NlpTag.V);
    }

    public static NlpTag getTag(String nature) {
        return tags.get(nature);
    }

}
