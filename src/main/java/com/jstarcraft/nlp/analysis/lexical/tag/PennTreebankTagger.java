package com.jstarcraft.nlp.analysis.lexical.tag;

import java.util.HashMap;

public class PennTreebankTagger implements NlpTagger {

    public static final PennTreebankTagger CHINESE_TAGGER;

    private final HashMap<String, NlpTag> tags;

    static {
        HashMap<String, NlpTag> chineseTags = new HashMap<>();
        /** 副词 */
        chineseTags.put("AD", NlpTag.D);
        /** 助词 */
        chineseTags.put("AS", NlpTag.U);
        /** 介词 */
        chineseTags.put("BA", NlpTag.P);
        /** 连词 */
        chineseTags.put("CC", NlpTag.C);
        /** 数词 */
        chineseTags.put("CD", NlpTag.M);
        /** 连词 */
        chineseTags.put("CS", NlpTag.C);
        /** 助词(的) */
        chineseTags.put("DEC", NlpTag.U);
        /** 助词(的) */
        chineseTags.put("DEG", NlpTag.U);
        /** 助词(得) */
        chineseTags.put("DER", NlpTag.U);
        /** 助词(地) */
        chineseTags.put("DEV", NlpTag.U);
        // TODO 相同框架在不同语言中可能映射不一样.(DT在汉语中为代词,在英语中为冠词)
        /** 代词 */
        chineseTags.put("DT", NlpTag.R);
        /** 助词(等) */
        chineseTags.put("ETC", NlpTag.U);
        /** 未知 */
        chineseTags.put("FW", NlpTag.X);
        /** 叹词 */
        chineseTags.put("IJ", NlpTag.E);
        /** 形容词 */
        chineseTags.put("JJ", NlpTag.A);
        /** 介词 */
        chineseTags.put("LB", NlpTag.P);
        /** 名词 */
        chineseTags.put("LC", NlpTag.N);
        /** 量词 */
        chineseTags.put("M", NlpTag.Q);
        /** 助词 */
        chineseTags.put("MSP", NlpTag.U);
        /** 名词 */
        chineseTags.put("NN", NlpTag.N);
        /** 名词 */
        chineseTags.put("NR", NlpTag.N);
        /** 名词 */
        chineseTags.put("NT", NlpTag.N);
        /** 数词 */
        chineseTags.put("OD", NlpTag.M);
        /** 拟声词 */
        chineseTags.put("ON", NlpTag.O);
        /** 介词 */
        chineseTags.put("P", NlpTag.P);
        /** 代词 */
        chineseTags.put("PN", NlpTag.R);
        /** 标点符号 */
        chineseTags.put("PU", NlpTag.W);
        /** 介词 */
        chineseTags.put("SB", NlpTag.P);
        /** 助词 */
        chineseTags.put("SP", NlpTag.U);
        /** 形容词 */
        chineseTags.put("VA", NlpTag.A);
        /** 动词 */
        chineseTags.put("VC", NlpTag.V);
        /** 动词 */
        chineseTags.put("VE", NlpTag.V);
        /** 动词 */
        chineseTags.put("VV", NlpTag.V);

        CHINESE_TAGGER = new PennTreebankTagger(chineseTags);
    }

    PennTreebankTagger(HashMap<String, NlpTag> tags) {
        this.tags = tags;
    }

    @Override
    public NlpTag getTag(String nature) {
        return tags.get(nature);
    }

}
