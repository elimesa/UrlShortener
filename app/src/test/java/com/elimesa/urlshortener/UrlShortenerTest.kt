package com.elimesa.urlshortener

import junit.framework.TestCase.assertEquals
import org.junit.Test

class UrlShortenerTest {

    @Test
    fun testShortenAndExpand() {
        val urlShortener = UrlShortener()

        val longUrl1 = "https://www.example.com/page1"
        val longUrl2 = "https://www.example.com/page2"

        // Test URL shortening
        val shortUrl1 = urlShortener.shorten(longUrl1)
        val shortUrl2 = urlShortener.shorten(longUrl2)

        // Verify that the short URLs are not empty and have the correct length
        assertEquals(6, shortUrl1.length)
        assertEquals(6, shortUrl2.length)

        // Test URL expansion
        val expandedUrl1 = urlShortener.expand(shortUrl1)
        val expandedUrl2 = urlShortener.expand(shortUrl2)

        // Verify that the expanded URLs match the original long URLs
        assertEquals(longUrl1, expandedUrl1)
        assertEquals(longUrl2, expandedUrl2)
    }

    @Test
    fun testInvalidURL() {
        val urlShortener = UrlShortener()

        // Test invalid URL
        val invalidUrl = ""
        val result = urlShortener.shorten(invalidUrl)

        // Verify that it returns an error message for invalid URL
        assertEquals("Invalid URL", result)
    }

    @Test
    fun testShortURLNotFound() {
        val urlShortener = UrlShortener()

        // Test expanding a short URL that doesn't exist
        val shortUrl = "abc123"
        val result = urlShortener.expand(shortUrl)

        // Verify that it returns an error message for not found
        assertEquals("Short URL not found", result)
    }
}
