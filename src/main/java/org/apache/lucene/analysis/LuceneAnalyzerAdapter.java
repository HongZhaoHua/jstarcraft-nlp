package org.apache.lucene.analysis;

/**
 * Lucene适配器
 * 
 * <pre>
 * 专门用于获取TokenStreamComponents
 * </pre>
 * 
 * @author Birdy
 *
 */
public class LuceneAnalyzerAdapter extends Analyzer {

    private Analyzer analyzer;

    public LuceneAnalyzerAdapter(Analyzer analyzer) {
        this.analyzer = analyzer;
    }

    @Override
    public TokenStreamComponents createComponents(String name) {
        return analyzer.createComponents(name);
    }

}
