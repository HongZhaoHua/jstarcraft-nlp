package com.jstarcraft.nlp.detection;

import java.util.Locale;
import java.util.Objects;

public class LocaleLanguage implements Comparable<LocaleLanguage> {

    private Locale locale;

    private double score;

    LocaleLanguage(Locale locale, double score) {
        this.locale = locale;
        this.score = score;
    }

    public Locale getLocale() {
        return locale;
    }

    public double getScore() {
        return score;
    }

    void setScore(double score) {
        this.score = score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(locale, score);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null)
            return false;
        if (getClass() != object.getClass())
            return false;
        LocaleLanguage that = (LocaleLanguage) object;
        return this.score == that.score && Objects.equals(this.locale, that.locale);
    }

    @Override
    public int compareTo(LocaleLanguage that) {
        if (this == that) {
            return 0;
        }
        double score = that.score - this.score;
        if (score == 0D) {
            return that.locale.getLanguage().compareTo(this.locale.getLanguage());
        } else {
            return score > 0 ? -1 : 1;
        }
    }

}
