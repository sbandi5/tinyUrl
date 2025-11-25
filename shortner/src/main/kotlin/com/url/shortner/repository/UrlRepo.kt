package com.url.shortner.repository

import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository
import com.url.shortner.entity.UrlEntity
@Repository
interface UrlRepo : JpaRepository<UrlEntity, Long> {
    fun findByShortUrl(shortUrl: String): UrlEntity?

    fun findByOriginalUrl(originalUrl: String): UrlEntity?
}