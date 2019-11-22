package com.jstarcraft.nlp.analysis.lexical.tag;

public class PekingUniversityTagger implements NlpTagger {

    public static final PekingUniversityTagger CHINESE_TAGGER;

    private final NlpTag[] tags;

    static {
        NlpTag[] chineseTags = new NlpTag[Byte.MAX_VALUE];
        /** 形容词-实词 */
        chineseTags['A'] = NlpTag.A;
        chineseTags['a'] = NlpTag.A;
        /** 区别词-形容词 */
        chineseTags['B'] = NlpTag.A;
        chineseTags['b'] = NlpTag.A;
        /** 连词-虚词 */
        chineseTags['C'] = NlpTag.C;
        chineseTags['c'] = NlpTag.C;
        /** 副词-虚词 */
        chineseTags['D'] = NlpTag.D;
        chineseTags['d'] = NlpTag.D;
        /** 叹词-虚词 */
        chineseTags['E'] = NlpTag.E;
        chineseTags['e'] = NlpTag.E;
        /** 方位词-名词 */
        chineseTags['F'] = NlpTag.N;
        chineseTags['f'] = NlpTag.N;
        /** 语素 */
        chineseTags['G'] = NlpTag.X;
        chineseTags['g'] = NlpTag.X;
        /** 前缀 */
        chineseTags['H'] = NlpTag.X;
        chineseTags['h'] = NlpTag.X;
        /** 成语 */
        chineseTags['I'] = NlpTag.X;
        chineseTags['i'] = NlpTag.X;
        /** 简称 */
        chineseTags['J'] = NlpTag.N;
        chineseTags['j'] = NlpTag.N;
        /** 后缀 */
        chineseTags['K'] = NlpTag.X;
        chineseTags['k'] = NlpTag.X;
        /** 习惯用语 */
        chineseTags['L'] = NlpTag.X;
        chineseTags['l'] = NlpTag.X;
        /** 数词-实词 */
        chineseTags['M'] = NlpTag.M;
        chineseTags['m'] = NlpTag.M;
        /** 名词-实词 */
        chineseTags['N'] = NlpTag.N;
        chineseTags['n'] = NlpTag.N;
        /** 拟声词-虚词 */
        chineseTags['O'] = NlpTag.O;
        chineseTags['o'] = NlpTag.O;
        /** 介词-虚词 */
        chineseTags['P'] = NlpTag.P;
        chineseTags['p'] = NlpTag.P;
        /** 量词-实词 */
        chineseTags['Q'] = NlpTag.Q;
        chineseTags['q'] = NlpTag.Q;
        /** 代词-实词 */
        chineseTags['R'] = NlpTag.R;
        chineseTags['r'] = NlpTag.R;
        /** 处所词-名词 */
        chineseTags['S'] = NlpTag.N;
        chineseTags['s'] = NlpTag.N;
        /** 时间词-名词 */
        chineseTags['T'] = NlpTag.N;
        chineseTags['t'] = NlpTag.N;
        /** 助词-虚词 */
        chineseTags['U'] = NlpTag.U;
        chineseTags['u'] = NlpTag.U;
        /** 动词-实词 */
        chineseTags['V'] = NlpTag.V;
        chineseTags['v'] = NlpTag.V;
        /** 标点符号 */
        chineseTags['W'] = NlpTag.W;
        chineseTags['w'] = NlpTag.W;
        /** 非语素 */
        chineseTags['X'] = NlpTag.X;
        chineseTags['x'] = NlpTag.X;
        /** 语气词-助词 */
        chineseTags['Y'] = NlpTag.U;
        chineseTags['y'] = NlpTag.U;
        /** 状态词-形容词 */
        chineseTags['Z'] = NlpTag.A;
        chineseTags['z'] = NlpTag.A;

        CHINESE_TAGGER = new PekingUniversityTagger(chineseTags);
    }

    PekingUniversityTagger(NlpTag[] tags) {
        this.tags = tags;
    }

    @Override
    public NlpTag getTag(String nature) {
        return tags[nature.charAt(0)];
    }

}
