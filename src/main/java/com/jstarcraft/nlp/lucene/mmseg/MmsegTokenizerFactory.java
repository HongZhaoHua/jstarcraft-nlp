package com.jstarcraft.nlp.lucene.mmseg;

import java.util.Map;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.util.ResourceLoader;
import org.apache.lucene.analysis.util.ResourceLoaderAware;
import org.apache.lucene.analysis.util.TokenizerFactory;
import org.apache.lucene.util.AttributeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chenlb.mmseg4j.ComplexSeg;
import com.chenlb.mmseg4j.Dictionary;
import com.chenlb.mmseg4j.MaxWordSeg;
import com.chenlb.mmseg4j.Seg;
import com.chenlb.mmseg4j.SimpleSeg;

@Deprecated
public class MmsegTokenizerFactory extends TokenizerFactory implements ResourceLoaderAware {

    private static final Logger logger = LoggerFactory.getLogger(MmsegTokenizerFactory.class);
    /* 线程内共享 */
    private ThreadLocal<MmsegTokenizer> tokenizerLocal = new ThreadLocal<MmsegTokenizer>();
    // protected dic for test
    protected Dictionary dic = null;

    public MmsegTokenizerFactory(Map<String, String> configuration) {
        super(configuration);
    }

    private Seg newSeg(Map<String, String> configuration) {
        Seg seg = null;
        logger.info("create new Seg ...");
        // default max-word
        String mode = configuration.get("mode");
        if ("simple".equals(mode)) {
            logger.info("use simple mode");
            seg = new SimpleSeg(dic);
        } else if ("complex".equals(mode)) {
            logger.info("use complex mode");
            seg = new ComplexSeg(dic);
        } else {
            logger.info("use max-word mode");
            seg = new MaxWordSeg(dic);
        }
        return seg;
    }

    @Override
    public Tokenizer create(AttributeFactory factory) {
        MmsegTokenizer tokenizer = tokenizerLocal.get();
        if (tokenizer == null) {
            tokenizer = newTokenizer();
        }

        return tokenizer;
    }

    private MmsegTokenizer newTokenizer() {
        MmsegTokenizer tokenizer = new MmsegTokenizer(newSeg(getOriginalArgs()));
        tokenizerLocal.set(tokenizer);
        return tokenizer;
    }

    @Override
    public void inform(ResourceLoader loader) {
        String dicPath = getOriginalArgs().get("dicPath");

        dic = Utils.getDict(dicPath, loader);

        logger.info("dic load... in={}", dic.getDicPath().toURI());
    }

}
