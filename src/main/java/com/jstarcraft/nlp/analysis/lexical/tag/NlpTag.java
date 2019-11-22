package com.jstarcraft.nlp.analysis.lexical.tag;

/**
 * NLP词性(核心)
 * 
 * @author Birdy
 *
 */
public enum NlpTag {

    /** 形容词-实词(取英语形容词adjective的第1个字母) */
    A,

    /** 连词-虚词(取英语连词conjunction的第1个字母) */
    C,

    /** 副词-虚词(取英语副词adverb的第2个字母) */
    D,

    /** 叹词-虚词(取英语叹词exclamation的第1个字母) */
    E,

    /** 数词-实词(取英语数词numeral的第3个字母) */
    M,

    /** 名词-实词(取英语名词noun的第1个字母) */
    N,

    /** 拟声词-虚词(取英语拟声词onomatopoeia的第1个字母) */
    O,

    /** 介词-虚词(取英语介词prepositional的第1个字母) */
    P,

    /** 量词-实词(取英语量词quantity的第1个字母) */
    Q,

    /** 代词-实词(取英语代词pronoun的第2个字母) */
    R,

    /** 冠词-虚词(取英语冠词article的第3个字母) */
    T,

    /** 助词-虚词(取英语助词auxiliary的第2个字母) */
    U,

    /** 动词-实词(取英语动词verb的第1个字母) */
    V,

    /** 标点符号 */
    W,

    /** 未知 */
    X,

}
