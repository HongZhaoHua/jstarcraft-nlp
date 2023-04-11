package com.jstarcraft.nlp.algorithm;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import it.unimi.dsi.fastutil.ints.Int2FloatAVLTreeMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;

public class CorrelationTestCase {

    /** 外部键-内部索引映射 */
    private Object2IntOpenHashMap<String> indexes = new Object2IntOpenHashMap<>();;

    private int convert(String data) {
        int index = indexes.getOrDefault(data, -1);
        if (index == -1) {
            index = indexes.size();
            indexes.put(data, index);
        }
        return index;
    }

    private int[] convert(String[] document) {
        int size = document.length;
        int[] indexes = new int[size];
        for (int index = 0; index < size; index++) {
            indexes[index] = convert(document[index]);
        }
        return indexes;
    }

    @Test
    public void test() {
        String[][] documents = {

                { "框架", "框架", "框架", "框架", "框架" },

                { "目标", "提供", "通用", "Java", "核心", "编程", "框架", "搭建", "框架", "项目" },

                { "领域", "研发人员", "专注", "高层", "设计", "关注", "底层", "实现" },

                { "涵盖", "编解码", "资源", "脚本", "监控", "通讯", "事件", "事务" },

                {} };

        List<TermFrequency> tfs = new ArrayList<>(documents.length);
        for (String[] document : documents) {
            tfs.add(new CountTermFrequency(new Int2FloatAVLTreeMap(), convert(document)));
        }
        InverseDocumentFrequency idf = new NaturalInverseDocumentFrequency(new Int2FloatAVLTreeMap(), tfs);

        Tfidf tfidf = new Tfidf(idf, tfs.toArray(new TermFrequency[tfs.size()]));
        Bm25 bm25 = new Bm25(1.2F, 0.75F, idf, tfs.toArray(new TermFrequency[tfs.size()]));

        for (int index = 0, size = documents.length; index < size; index++) {
            int[] indexes = convert(new String[] { "框架", "领域", "框架" });
            float left = tfidf.getCorrelation(index, indexes);
            float right = bm25.getCorrelation(index, indexes);

            Assert.assertTrue(left >= right);
        }
    }

}
