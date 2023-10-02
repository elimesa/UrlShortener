package com.elimesa.urlshortener

fun main() {
    val urlShortener = UrlShortener()

    val longUrl1 = "https://www.example.com/page1"
    val longUrl2 = "https://www.example.com/page2"

    // Test URL shortening
    val shortUrl1 = urlShortener.shorten(longUrl1)
    val shortUrl2 = urlShortener.shorten(longUrl2)

    println("Shortened URL 1: $shortUrl1")
    println("Shortened URL 2: $shortUrl2")

    // Test URL expansion
    val expandedUrl1 = urlShortener.expand(shortUrl1)
    val expandedUrl2 = urlShortener.expand(shortUrl2)

    println("Expanded URL 1: $expandedUrl1")
    println("Expanded URL 2: $expandedUrl2")
}
