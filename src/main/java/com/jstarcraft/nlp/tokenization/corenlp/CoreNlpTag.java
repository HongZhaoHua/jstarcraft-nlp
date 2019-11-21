package com.jstarcraft.nlp.tokenization.corenlp;

import com.jstarcraft.nlp.tokenization.NlpTag;

/**
 * CoreNLP词性(核心)
 * 
 * @author Birdy
 *
 */
public enum CoreNlpTag {

    /** 副词 */
    AD(NlpTag.D),

    /** 助词 */
    AS(NlpTag.U),

    /** 介词 */
    BA(NlpTag.P),

    /** 连词 */
    CC(NlpTag.C),

    /** 数词 */
    CD(NlpTag.M),

    /** 连词 */
    CS(NlpTag.C),

    /** 助词(的) */
    DEC(NlpTag.U),

    /** 助词(的) */
    DEG(NlpTag.U),

    /** 助词(得) */
    DER(NlpTag.U),

    /** 助词(地) */
    DEV(NlpTag.U),

    // TODO 相同框架在不同语言中可能映射不一样.(DT在汉语中为代词,在英语中为冠词)
    /** 代词 */
    DT(NlpTag.R),

    /** 助词(等) */
    ETC(NlpTag.U),

    /** 未知 */
    FW(NlpTag.X),

    /** 叹词 */
    IJ(NlpTag.E),

    /** 形容词 */
    JJ(NlpTag.A),

    /** 介词 */
    LB(NlpTag.P),

    /** 名词 */
    LC(NlpTag.N),

    /** 量词 */
    M(NlpTag.Q),

    /** 助词 */
    MSP(NlpTag.U),

    /** 名词 */
    NN(NlpTag.N),

    /** 名词 */
    NR(NlpTag.N),

    /** 名词 */
    NT(NlpTag.N),

    /** 数词 */
    OD(NlpTag.M),

    /** 拟声词 */
    ON(NlpTag.O),

    /** 介词 */
    P(NlpTag.P),

    /** 代词 */
    PN(NlpTag.R),

    /** 标点符号 */
    PU(NlpTag.W),

    /** 介词 */
    SB(NlpTag.P),

    /** 助词 */
    SP(NlpTag.U),

    /** 形容词 */
    VA(NlpTag.A),

    /** 动词 */
    VC(NlpTag.V),

    /** 动词 */
    VE(NlpTag.V),

    /** 动词 */
    VV(NlpTag.V),

    ;

    private final NlpTag tag;

    CoreNlpTag(NlpTag tag) {
        this.tag = tag;
    }

    public NlpTag getTag() {
        return tag;
    }

}
