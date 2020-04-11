/*
 * Copyright 2011 Nicole Torres
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.optimaize.langdetect.profiles;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.google.common.collect.ImmutableList;

/**
 * @author Nicole Torres
 */
public class BuiltInLanguages {

    private static final List<Locale> languages;
    private static final List<String> shortTextLanguages;

    static {
        List<Locale> names = new ArrayList<>();

        // sorted alphabetically
        names.add(Locale.forLanguageTag("af"));
        names.add(Locale.forLanguageTag("an"));
        names.add(Locale.forLanguageTag("ar"));
        names.add(Locale.forLanguageTag("ast"));
        names.add(Locale.forLanguageTag("be"));
        names.add(Locale.forLanguageTag("bg"));
        names.add(Locale.forLanguageTag("bn"));
        names.add(Locale.forLanguageTag("br"));
        names.add(Locale.forLanguageTag("ca"));
        names.add(Locale.forLanguageTag("cs"));
        names.add(Locale.forLanguageTag("cy"));
        names.add(Locale.forLanguageTag("da"));
        names.add(Locale.forLanguageTag("de"));
        names.add(Locale.forLanguageTag("el"));
        names.add(Locale.forLanguageTag("en"));
        names.add(Locale.forLanguageTag("es"));
        names.add(Locale.forLanguageTag("et"));
        names.add(Locale.forLanguageTag("eu"));
        names.add(Locale.forLanguageTag("fa"));
        names.add(Locale.forLanguageTag("fi"));
        names.add(Locale.forLanguageTag("fr"));
        names.add(Locale.forLanguageTag("ga"));
        names.add(Locale.forLanguageTag("gl"));
        names.add(Locale.forLanguageTag("gu"));
        names.add(Locale.forLanguageTag("he"));
        names.add(Locale.forLanguageTag("hi"));
        names.add(Locale.forLanguageTag("hr"));
        names.add(Locale.forLanguageTag("ht"));
        names.add(Locale.forLanguageTag("hu"));
        names.add(Locale.forLanguageTag("id"));
        names.add(Locale.forLanguageTag("is"));
        names.add(Locale.forLanguageTag("it"));
        names.add(Locale.forLanguageTag("ja"));
        names.add(Locale.forLanguageTag("km"));
        names.add(Locale.forLanguageTag("kn"));
        names.add(Locale.forLanguageTag("ko"));
        names.add(Locale.forLanguageTag("lt"));
        names.add(Locale.forLanguageTag("lv"));
        names.add(Locale.forLanguageTag("mk"));
        names.add(Locale.forLanguageTag("ml"));
        names.add(Locale.forLanguageTag("mr"));
        names.add(Locale.forLanguageTag("ms"));
        names.add(Locale.forLanguageTag("mt"));
        names.add(Locale.forLanguageTag("ne"));
        names.add(Locale.forLanguageTag("nl"));
        names.add(Locale.forLanguageTag("no"));
        names.add(Locale.forLanguageTag("oc"));
        names.add(Locale.forLanguageTag("pa"));
        names.add(Locale.forLanguageTag("pl"));
        names.add(Locale.forLanguageTag("pt"));
        names.add(Locale.forLanguageTag("ro"));
        names.add(Locale.forLanguageTag("ru"));
        names.add(Locale.forLanguageTag("sk"));
        names.add(Locale.forLanguageTag("sl"));
        names.add(Locale.forLanguageTag("so"));
        names.add(Locale.forLanguageTag("sq"));
        names.add(Locale.forLanguageTag("sr"));
        names.add(Locale.forLanguageTag("sv"));
        names.add(Locale.forLanguageTag("sw"));
        names.add(Locale.forLanguageTag("ta"));
        names.add(Locale.forLanguageTag("te"));
        names.add(Locale.forLanguageTag("th"));
        names.add(Locale.forLanguageTag("tl"));
        names.add(Locale.forLanguageTag("tr"));
        names.add(Locale.forLanguageTag("uk"));
        names.add(Locale.forLanguageTag("ur"));
        names.add(Locale.forLanguageTag("vi"));
        names.add(Locale.forLanguageTag("wa"));
        names.add(Locale.forLanguageTag("yi"));
        names.add(Locale.forLanguageTag("zh-CN"));
        names.add(Locale.forLanguageTag("zh-TW"));

        languages = ImmutableList.copyOf(names);
    }

    static {
        List<String> texts = new ArrayList<>();
        texts.add("cs");
        texts.add("da");
        texts.add("de");
        texts.add("en");
        texts.add("es");
        texts.add("fi");
        texts.add("fr");
        texts.add("id");
        texts.add("it");
        texts.add("nl");
        texts.add("no");
        texts.add("pl");
        texts.add("pt");
        texts.add("ro");
        texts.add("sv");
        texts.add("tr");
        texts.add("vi");
        shortTextLanguages = ImmutableList.copyOf(texts);
    }

    /**
     * Returns the languages for which the library provides full profiles. Full provides are generated from regular text, usually Wikipedia abstracts.
     * 
     * @return immutable
     */
    public static List<Locale> getLanguages() {
        return languages;
    }

    /**
     * Returns the languages for which the library provides profiles created from short text. Twitter was used as source by @shuyo. Much less languages have short text profiles as of now.
     * 
     * @return immutable
     */
    public static List<String> getShortTextLanguages() {
        return shortTextLanguages;
    }
}
