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
public class LuceneAdapter extends Analyzer {

    private Analyzer analyzer;

    public LuceneAdapter(Analyzer analyzer) {
        this.analyzer = analyzer;
    }

    @Override
    public TokenStreamComponents createComponents(String name) {
        return analyzer.createComponents(name);
    }

}
