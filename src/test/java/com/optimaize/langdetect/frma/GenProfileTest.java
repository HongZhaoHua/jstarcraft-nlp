/*
 * Copyright 2011 Francois ROLAND
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

package com.optimaize.langdetect.frma;

import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Map;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import com.optimaize.langdetect.cybozu.util.LangProfile;

public class GenProfileTest extends GenProfile {

    @Test
    public void generateProfile() throws IOException {
        File inputFile = File.createTempFile("profileInput", ".txt");
        try {
            try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(inputFile), Charset.forName("utf-8")))) {
                writer.println("Salut tout le monde.");
                writer.println("Bonjour toi tout seul.");
                writer.println("Ca va ?");
                writer.println("Oui ça va. Et toi ?");
            }

            LangProfile trucProfile = generate("truc", inputFile);
            Map<String, Integer> freqs = trucProfile.getFreq();
            assertThat(freqs, CoreMatchers.is(CoreMatchers.notNullValue()));
            assertThat(freqs.get("t"), CoreMatchers.is(CoreMatchers.equalTo(8)));
            assertThat(freqs.get("to"), CoreMatchers.is(CoreMatchers.equalTo(4)));
            assertThat(freqs.get("out"), CoreMatchers.is(CoreMatchers.equalTo(2)));
            assertThat(freqs.get("o"), CoreMatchers.is(CoreMatchers.equalTo(7)));
            assertThat(freqs.get("ou"), CoreMatchers.is(CoreMatchers.equalTo(3)));
            assertThat(freqs.get("toi"), CoreMatchers.is(CoreMatchers.equalTo(2)));
            assertThat(freqs.get("u"), CoreMatchers.is(CoreMatchers.equalTo(6)));
            assertThat(freqs.get("ut"), CoreMatchers.is(CoreMatchers.equalTo(3)));
            assertThat(freqs.get("tou"), CoreMatchers.is(CoreMatchers.equalTo(2)));
            assertThat(freqs.get("a"), CoreMatchers.is(CoreMatchers.equalTo(5)));
            assertThat(freqs.get("oi"), CoreMatchers.is(CoreMatchers.equalTo(2)));
            assertThat(freqs.get("alu"), CoreMatchers.is(CoreMatchers.equalTo(1)));
            assertThat(freqs.get("on"), CoreMatchers.is(CoreMatchers.equalTo(2)));
            assertThat(freqs.get("Bon"), CoreMatchers.is(CoreMatchers.equalTo(1)));
            assertThat(freqs.get("e"), CoreMatchers.is(CoreMatchers.equalTo(3)));
            assertThat(freqs.get("va"), CoreMatchers.is(CoreMatchers.equalTo(2)));
            assertThat(freqs.get("i"), CoreMatchers.is(CoreMatchers.equalTo(3)));
            assertThat(freqs.get("jou"), CoreMatchers.is(CoreMatchers.equalTo(1)));
        } finally {
            // noinspection ResultOfMethodCallIgnored
            inputFile.delete();
        }
    }

}
