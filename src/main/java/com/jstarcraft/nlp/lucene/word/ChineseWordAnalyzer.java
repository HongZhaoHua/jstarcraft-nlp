package com.jstarcraft.nlp.lucene.word;

import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apdplat.word.segmentation.Segmentation;
import org.apdplat.word.segmentation.SegmentationAlgorithm;
import org.apdplat.word.segmentation.SegmentationFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lucene中文分析器
 * 
 * @author 杨尚川
 */
public class ChineseWordAnalyzer extends Analyzer {
    private static final Logger LOGGER = LoggerFactory.getLogger(ChineseWordAnalyzer.class);
    private Segmentation segmentation = null;

    public ChineseWordAnalyzer() {
        this.segmentation = SegmentationFactory.getSegmentation(SegmentationAlgorithm.BidirectionalMinimumMatching);
    }

    public ChineseWordAnalyzer(String segmentationAlgorithm) {
        try {
            SegmentationAlgorithm sa = SegmentationAlgorithm.valueOf(segmentationAlgorithm);
            this.segmentation = SegmentationFactory.getSegmentation(sa);
        } catch (Exception e) {
            this.segmentation = SegmentationFactory.getSegmentation(SegmentationAlgorithm.BidirectionalMinimumMatching);
        }
    }

    public ChineseWordAnalyzer(SegmentationAlgorithm segmentationAlgorithm) {
        this.segmentation = SegmentationFactory.getSegmentation(segmentationAlgorithm);
    }

    public ChineseWordAnalyzer(Segmentation segmentation) {
        this.segmentation = segmentation;
    }

    @Override
    protected TokenStreamComponents createComponents(String fieldName) {
        Tokenizer tokenizer = new ChineseWordTokenizer(segmentation);
        return new TokenStreamComponents(tokenizer);
    }

    public static void main(String args[]) throws IOException {
        Analyzer analyzer = new ChineseWordAnalyzer();
        TokenStream tokenStream = analyzer.tokenStream("text", "杨尚川是APDPlat应用级产品开发平台的作者");
        tokenStream.reset();
        while (tokenStream.incrementToken()) {
            CharTermAttribute charTermAttribute = tokenStream.getAttribute(CharTermAttribute.class);
            OffsetAttribute offsetAttribute = tokenStream.getAttribute(OffsetAttribute.class);
            PositionIncrementAttribute positionIncrementAttribute = tokenStream.getAttribute(PositionIncrementAttribute.class);
            LOGGER.info(charTermAttribute.toString() + " (" + offsetAttribute.startOffset() + " - " + offsetAttribute.endOffset() + ") " + positionIncrementAttribute.getPositionIncrement());
        }
        tokenStream.close();

        tokenStream = analyzer.tokenStream("text", "word是一个中文分词项目，作者是杨尚川，杨尚川的英文名叫ysc");
        tokenStream.reset();
        while (tokenStream.incrementToken()) {
            CharTermAttribute charTermAttribute = tokenStream.getAttribute(CharTermAttribute.class);
            OffsetAttribute offsetAttribute = tokenStream.getAttribute(OffsetAttribute.class);
            PositionIncrementAttribute positionIncrementAttribute = tokenStream.getAttribute(PositionIncrementAttribute.class);
            LOGGER.info(charTermAttribute.toString() + " (" + offsetAttribute.startOffset() + " - " + offsetAttribute.endOffset() + ") " + positionIncrementAttribute.getPositionIncrement());
        }
        tokenStream.close();

        tokenStream = analyzer.tokenStream("text", "5月初有哪些电影值得观看");
        tokenStream.reset();
        while (tokenStream.incrementToken()) {
            CharTermAttribute charTermAttribute = tokenStream.getAttribute(CharTermAttribute.class);
            OffsetAttribute offsetAttribute = tokenStream.getAttribute(OffsetAttribute.class);
            PositionIncrementAttribute positionIncrementAttribute = tokenStream.getAttribute(PositionIncrementAttribute.class);

            LOGGER.info(charTermAttribute.toString() + " (" + offsetAttribute.startOffset() + " - " + offsetAttribute.endOffset() + ") " + positionIncrementAttribute.getPositionIncrement());
        }
        tokenStream.close();
    }

}