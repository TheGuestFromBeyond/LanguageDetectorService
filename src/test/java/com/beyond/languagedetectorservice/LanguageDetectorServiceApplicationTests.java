package com.beyond.languagedetectorservice;

import com.beyond.languagedetectorservice.service.LanguageDetectorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class LanguageDetectorServiceApplicationTests {
	private LanguageDetectorService languageDetectorService;

	@BeforeEach
	void setUp() {
		languageDetectorService = new LanguageDetectorService();
	}

	@Test
	void testDetectLanguage_EnglishText() {
		String text = "This is an English text.";

		String detectedLanguage = languageDetectorService.detectLanguageOf(text);
		assertEquals("en", detectedLanguage);
	}

	@Test
	void testDetectLanguage_FrenchText() {
		String text = "Ceci est un texte en français.";

		String detectedLanguage = languageDetectorService.detectLanguageOf(text);
		assertEquals("fr", detectedLanguage);
	}

	@Test
	void testDetectLanguage_NullText() {
		String text = null;

		String detectedLanguage = languageDetectorService.detectLanguageOf(text);
		assertEquals("", detectedLanguage);
	}

	@Test
	void testDetectLanguage_EmptyText() {
		String text = "";

		String detectedLanguage = languageDetectorService.detectLanguageOf(text);
		assertEquals("", detectedLanguage); // Return null or handle it as needed.
	}

	@Test
	void testDetectLanguage_UnsupportedLocale() {
		String text = "!@#$%^&";

		String detectedLanguage = languageDetectorService.detectLanguageOf(text);
		assertEquals("Language cannot be detected", detectedLanguage);
	}
}
