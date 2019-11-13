package com.jstarcraft.nlp.solr.mynlp;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jstarcraft.nlp.solr.NlpSegmentFactory;
import com.jstarcraft.nlp.tokenization.NlpToken;
import com.jstarcraft.nlp.tokenization.NlpTokenizer;
import com.jstarcraft.nlp.tokenization.mynlp.MynlpTokenizer;
import com.mayabot.nlp.segment.FluentLexerBuilder;
import com.mayabot.nlp.segment.Lexer;
import com.mayabot.nlp.segment.Lexers;

/**
 * MYNLP工厂
 * 
 * <pre>
 * MYNLP配置说明
 * https://github.com/mayabot/mynlp/wiki
 * </pre>
 * 
 * @author Birdy
 *
 */
public class MynlpSegmentFactory extends NlpSegmentFactory<Lexer> {

    private static final Logger LOGGER = LoggerFactory.getLogger(MynlpSegmentFactory.class);

    public MynlpSegmentFactory(Map<String, String> configurations) {
        super(configurations);
    }

    @Override
    protected NlpTokenizer<? extends NlpToken> getNlpTokenizer(Map<String, String> configurations) {
        Lexer lexer = build(configurations);

        MynlpTokenizer tokenizer = new MynlpTokenizer(lexer);
        return tokenizer;
    }

    @Override
    public Lexer build(Map<String, String> configurations) {
        FluentLexerBuilder builder;

        // 设置模式
        String algorithm = get(configurations, "algorithm", "core");
        switch (algorithm) {
        case "core":
            builder = Lexers.coreBuilder();
            break;
        case "perceptron":
            builder = Lexers.perceptronBuilder();
            break;
        default:
            throw new IllegalArgumentException();
        }

        // 是否保留字符
        if (getBoolean(configurations, "keepCharacter", false)) {
            builder.keepOriCharOutput();
        }

        if (getBoolean(configurations, "enableCustomDictionary", false)) {
            builder.withCustomDictionary();
        }

        // 是否标注词性
        if (getBoolean(configurations, "enablePOS", false)) {
            builder.withPos();
        }

        // 是否识别实体
        if (getBoolean(configurations, "enableNER", false)) {
            builder.withNer();
        }

        // 是否识别人名
        if (getBoolean(configurations, "enablePersonName", false)) {
            builder.withPersonName();
        }

        Lexer lexer = builder.build();
        return lexer;
    }

}
