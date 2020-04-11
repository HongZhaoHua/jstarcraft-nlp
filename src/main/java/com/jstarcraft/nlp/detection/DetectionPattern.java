package com.jstarcraft.nlp.detection;

import java.io.DataInputStream;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import com.jstarcraft.core.common.conversion.json.JsonUtility;
import com.jstarcraft.core.common.reflection.TypeUtility;
import com.jstarcraft.core.utility.StringUtility;

/**
 * 检测规则
 * 
 * @author Birdy
 *
 */
public class DetectionPattern {

    public final static Map<String, DetectionPattern> LANGUAGE_82;

    public final static Map<String, DetectionPattern> LANGUAGE_187;

    public final static Map<String, DetectionPattern> LANGUAGE_406;

    static {
        try {
            try (InputStream stream = DetectionPattern.class.getResourceAsStream("regulation-82.json")) {
                LANGUAGE_82 = loadPatterns(stream);
            }
            try (InputStream stream = DetectionPattern.class.getResourceAsStream("regulation-187.json")) {
                LANGUAGE_187 = loadPatterns(stream);
            }
            try (InputStream stream = DetectionPattern.class.getResourceAsStream("regulation-406.json")) {
                LANGUAGE_406 = loadPatterns(stream);
            }
        } catch (Exception exception) {
            throw new IllegalStateException(exception);
        }
    }

    private String name;

    private Pattern pattern;

    public DetectionPattern(String name, Pattern pattern) {
        this.name = name;
        this.pattern = pattern;
    }

    public String getName() {
        return name;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public static final Map<String, DetectionPattern> loadPatterns(InputStream stream) {
        try (DataInputStream buffer = new DataInputStream(stream)) {
            Map<String, DetectionPattern> detections = new HashMap<>();
            byte[] data = new byte[buffer.available()];
            buffer.readFully(data);
            String json = new String(data, StringUtility.CHARSET);
            // 兼容\x转义ASCII字符
            json = StringUtility.unescapeJava(json);
            Type type = TypeUtility.parameterize(LinkedHashMap.class, String.class, String.class);
            LinkedHashMap<String, String> regulations = JsonUtility.string2Object(json, type);

            for (Entry<String, String> scriptTerm : regulations.entrySet()) {
                String script = scriptTerm.getKey();
                String regulation = scriptTerm.getValue();
                Pattern pattern = Pattern.compile(regulation, Pattern.MULTILINE);
                DetectionPattern detection = new DetectionPattern(script, pattern);
                detections.put(script, detection);
            }
            return Collections.unmodifiableMap(detections);
        } catch (Exception exception) {
            throw new IllegalArgumentException(exception);
        }
    }

}
