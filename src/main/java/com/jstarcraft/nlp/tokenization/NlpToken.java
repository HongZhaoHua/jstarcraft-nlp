package com.jstarcraft.nlp.tokenization;

import com.jstarcraft.nlp.analysis.lexical.tag.NlpTag;

/**
 * NLP词元
 * 
 * @author Birdy
 *
 */
public interface NlpToken {

    /**
     * 获取词项
     * 
     * @return
     */
    String getTerm();

    /**
     * 获取开始位置
     * 
     * @return
     */
    int getBegin();

    /**
     * 获取结束位置
     * 
     * @return
     */
    int getEnd();

    /**
     * 获取标注
     * 
     * @return
     */
    default NlpTag getTag() {
        throw new UnsupportedOperationException();
    }

    /**
     * 获取词性
     * 
     * @return
     */
    default String getNature() {
        throw new UnsupportedOperationException();
    }

}
