package com.jstarcraft.nlp.tokenization;

/**
 * NLP词性
 * 
 * @author Birdy
 *
 */
public enum NlpTag {

    /** 形容词-实词 */
    A,
    /** 区别词-形容词 */
    B,
    /** 连词-虚词 */
    C,
    /** 副词-虚词 */
    D,
    /** 叹词-虚词 */
    E,

    /** 方位词-名词 */
    F,
    /** 语素 */
    G,
    /** 前缀 */
    H,
    /** 成语 */
    I,
    /** 简称 */
    J,
    /** 后缀 */
    K,
    /** 习惯用语 */
    L,

    /** 数词-实词 */
    M,
    /** 名词-实词 */
    N,
    /** 拟声词-虚词 */
    O,
    /** 介词-虚词 */
    P,
    /** 量词-实词 */
    Q,
    /** 代词-实词 */
    R,

    /** 处所词-名词 */
    S,
    /** 时间词-名词 */
    T,

    /** 助词-虚词 */
    U,
    /** 动词-实词 */
    V,

    /** 标点符号 */
    W,
    /** 非语素 */
    X,
    /** 语气词-助词 */
    Y,
    /** 状态词-形容词 */
    Z

}
