package com.jstarcraft.nlp;

import java.util.List;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;

import com.hankcs.hanlp.collection.trie.DoubleArrayTrie;
import com.hankcs.hanlp.corpus.tag.Nature;
import com.hankcs.hanlp.dictionary.CoreDictionary.Attribute;
import com.hankcs.hanlp.seg.Segment;
import com.xkzhangsan.time.nlp.TimeNLP;
import com.xkzhangsan.time.nlp.TimeNLPUtil;

public class NlpTestCase {

    @Test
    public void test() {
        TreeMap<String, Attribute> tree = new TreeMap<>();

        // 查询物品的特征
        Nature attributeNature = Nature.create("feature");
        Attribute featureAttribute = new Attribute(attributeNature);
        tree.put("数量", featureAttribute);
        tree.put("价格", featureAttribute);
        tree.put("类型", featureAttribute);
        tree.put("位置", featureAttribute);
        tree.put("日期", featureAttribute);
        // TODO 获取分组
        Nature groupNature = Nature.create("group");

        Nature itemNature = Nature.create("item");
        Nature typeNature = Nature.create("type");
        Attribute typeAttribute = new Attribute(typeNature);
        tree.put("衣服", typeAttribute);

        Nature tagNature = Nature.create("tag");
        Nature spaceNature = Nature.create("space");
        Nature positionNature = Nature.create("position");
        Nature matterNature = Nature.create("matter");
        Nature compositeNature = Nature.create("composite");

        DoubleArrayTrie<Attribute> trie = new DoubleArrayTrie<>(tree);
        Segment segment = new HanlpDictionaryTrieSegment(trie);
//        Segment segment = HanLP.newSegment("dat");
        segment.enableOffset(true);
        segment.enablePartOfSpeechTagging(true);
//        segment.enableCustomDictionary(false);

        List<TimeNLP> timeNLPList = TimeNLPUtil.parse("五个月后购买的衣服的数量？");
        System.out.println("五个月后购买的衣服的数量？");
        System.out.println(timeNLPList);

//        System.out.println(segment.seg("最近五天购买的衣服的数量？"));
//        System.out.println(segment.seg("最近五天购买的衣服有哪些？"));
    }

}
