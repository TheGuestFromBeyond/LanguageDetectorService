package com.beyond.languagedetectorservice.service;

import com.google.common.base.Optional;
import com.optimaize.langdetect.LanguageDetector;
import com.optimaize.langdetect.LanguageDetectorBuilder;
import com.optimaize.langdetect.i18n.LdLocale;
import com.optimaize.langdetect.ngram.NgramExtractors;
import com.optimaize.langdetect.profiles.LanguageProfile;
import com.optimaize.langdetect.profiles.LanguageProfileReader;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.List;

@Service
public class LanguageDetectorService {
    public String detectLanguageOf(String text) {
        if (!StringUtils.hasText(text)) {
            return "";
        }
        try {
            List<LanguageProfile> languageProfiles = new LanguageProfileReader().readAllBuiltIn();

            LanguageDetector languageDetector = LanguageDetectorBuilder.create(NgramExtractors.standard())
                    .withProfiles(languageProfiles)
                    .build();

            Optional<LdLocale> detected = languageDetector.detect(text);
            if (detected.isPresent()) {
                return detected.get().getLanguage();
            } else {
                return "Language cannot be detected";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
