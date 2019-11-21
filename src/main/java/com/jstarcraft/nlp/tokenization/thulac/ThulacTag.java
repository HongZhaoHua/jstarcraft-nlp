package com.jstarcraft.nlp.tokenization.thulac;

import com.jstarcraft.nlp.tokenization.NlpTag;

/**
 * THULAC词性(核心)
 * 
 * @author Birdy
 *
 */
public enum ThulacTag {

    /** 形容词-实词 */
    A(NlpTag.A),
    /** 区别词-形容词 */
    B(NlpTag.A),
    /** 连词-虚词 */
    C(NlpTag.C),
    /** 副词-虚词 */
    D(NlpTag.D),
    /** 叹词-虚词 */
    E(NlpTag.E),
    /** 方位词-名词 */
    F(NlpTag.N),
    /** 学术词 */
    G(NlpTag.N),
    /** 前缀 */
    H(NlpTag.X),
    /** 成语 */
    I(NlpTag.X),
    /** 简称 */
    J(NlpTag.N),
    /** 后缀 */
    K(NlpTag.X),
    /** 习惯用语 */
    L(NlpTag.X),
    /** 数词-实词 */
    M(NlpTag.M),
    /** 名词-实词 */
    N(NlpTag.N),
    /** 拟声词-虚词 */
    O(NlpTag.O),
    /** 介词-虚词 */
    P(NlpTag.P),
    /** 量词-实词 */
    Q(NlpTag.Q),
    /** 代词-实词 */
    R(NlpTag.R),
    /** 处所词-名词 */
    S(NlpTag.N),
    /** 时间词-名词 */
    T(NlpTag.N),
    /** 助词-虚词 */
    U(NlpTag.U),
    /** 动词-实词 */
    V(NlpTag.V),
    /** 标点符号 */
    W(NlpTag.W),
    /** 非语素 */
    X(NlpTag.X),
    /** 语气词-助词 */
    Y(NlpTag.U),
    /** 状态词-形容词 */
    Z(NlpTag.A);

    private final NlpTag tag;

    ThulacTag(NlpTag tag) {
        this.tag = tag;
    }

    public NlpTag getTag() {
        return tag;
    }

}
