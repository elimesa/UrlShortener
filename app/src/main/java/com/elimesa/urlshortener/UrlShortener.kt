package com.elimesa.urlshortener

import java.math.BigInteger
import java.security.MessageDigest

class UrlShortener {

    private val urlToShortKeyMap = mutableMapOf<String, String>()
    private val shortKeyUrlMap = mutableMapOf<String, String>()
    private val shortKeyLength = 6

    //function to generate a fixed-length alphanumeric short key a given URL
    private fun generateShortKey(url: String): String {
        val messageDigest = MessageDigest.getInstance("MD5")
        val digest = messageDigest.digest(url.toByteArray())
        val bigInt = BigInteger(1, digest)
        return bigInt.toString(36).substring(0, shortKeyLength)
    }

    //function to shorten a URL
    fun shorten(url: String): String {
        if (url.isEmpty()) {
            return "Invalid URL"
        }
        if (urlToShortKeyMap.containsKey(url)) {
            return urlToShortKeyMap[url]!!
        }

        val shortKey = generateShortKey(url)
        urlToShortKeyMap[url] = shortKey
        shortKeyUrlMap[shortKey] = url
        return shortKey
    }

    fun expand(shortUrl: String): String {
        if(shortUrl.length != shortKeyLength) {
            return "Invalid Short URL"
        }

        if(shortKeyUrlMap.containsKey(shortUrl)) {
            return shortKeyUrlMap[shortUrl]!!
        }

        return "Short URL not found"
    }
}