package com.jstarcraft.nlp.analysis.lexical.tag.chinses;

import com.jstarcraft.nlp.tokenization.NlpTag;

public class PekingUniversity {

    private static final NlpTag[] tags = new NlpTag[Byte.MAX_VALUE];

    static {
        /** 形容词-实词 */
        tags['A'] = NlpTag.A;
        tags['a'] = NlpTag.A;
        /** 区别词-形容词 */
        tags['B'] = NlpTag.A;
        tags['b'] = NlpTag.A;
        /** 连词-虚词 */
        tags['C'] = NlpTag.C;
        tags['c'] = NlpTag.C;
        /** 副词-虚词 */
        tags['D'] = NlpTag.D;
        tags['d'] = NlpTag.D;
        /** 叹词-虚词 */
        tags['E'] = NlpTag.E;
        tags['e'] = NlpTag.E;
        /** 方位词-名词 */
        tags['F'] = NlpTag.N;
        tags['f'] = NlpTag.N;
        /** 语素 */
        tags['G'] = NlpTag.X;
        tags['g'] = NlpTag.X;
        /** 前缀 */
        tags['H'] = NlpTag.X;
        tags['h'] = NlpTag.X;
        /** 成语 */
        tags['I'] = NlpTag.X;
        tags['i'] = NlpTag.X;
        /** 简称 */
        tags['J'] = NlpTag.N;
        tags['j'] = NlpTag.N;
        /** 后缀 */
        tags['K'] = NlpTag.X;
        tags['k'] = NlpTag.X;
        /** 习惯用语 */
        tags['L'] = NlpTag.X;
        tags['l'] = NlpTag.X;
        /** 数词-实词 */
        tags['M'] = NlpTag.M;
        tags['m'] = NlpTag.M;
        /** 名词-实词 */
        tags['N'] = NlpTag.N;
        tags['n'] = NlpTag.N;
        /** 拟声词-虚词 */
        tags['O'] = NlpTag.O;
        tags['o'] = NlpTag.O;
        /** 介词-虚词 */
        tags['P'] = NlpTag.P;
        tags['p'] = NlpTag.P;
        /** 量词-实词 */
        tags['Q'] = NlpTag.Q;
        tags['q'] = NlpTag.Q;
        /** 代词-实词 */
        tags['R'] = NlpTag.R;
        tags['r'] = NlpTag.R;
        /** 处所词-名词 */
        tags['S'] = NlpTag.N;
        tags['s'] = NlpTag.N;
        /** 时间词-名词 */
        tags['T'] = NlpTag.N;
        tags['t'] = NlpTag.N;
        /** 助词-虚词 */
        tags['U'] = NlpTag.U;
        tags['u'] = NlpTag.U;
        /** 动词-实词 */
        tags['V'] = NlpTag.V;
        tags['v'] = NlpTag.V;
        /** 标点符号 */
        tags['W'] = NlpTag.W;
        tags['w'] = NlpTag.W;
        /** 非语素 */
        tags['X'] = NlpTag.X;
        tags['x'] = NlpTag.X;
        /** 语气词-助词 */
        tags['Y'] = NlpTag.U;
        tags['y'] = NlpTag.U;
        /** 状态词-形容词 */
        tags['Z'] = NlpTag.A;
        tags['z'] = NlpTag.A;
    }

    public static NlpTag getTag(String nature) {
        return tags[nature.charAt(0)];
    }

}
