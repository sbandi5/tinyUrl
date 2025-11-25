package com.url.shortner.service

import com.url.shortner.dto.UrlRequestDto
import com.url.shortner.dto.UrlResponseDto
import com.url.shortner.entity.UrlEntity
import com.url.shortner.repository.UrlRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class UrlShortenService(
    @Autowired()
    val urlRepo: UrlRepo
) {

    fun shortenUrl(urlRequestDto: UrlRequestDto): UrlResponseDto {

        val checkDetails: UrlEntity? = findUrl(urlRequestDto)

        if (checkDetails == null) {
            val newUrlEntity = UrlEntity(
                originalUrl = urlRequestDto.originalUrl,
                shortUrl = urlRequestDto.originalUrl, // TODO: replace with actual shortening logic
                createdAt = LocalDateTime.now()
            )
            val savedEntity = urlRepo.save(newUrlEntity)
            return toResponse(savedEntity)

        } else {
            return toResponse(checkDetails)
        }

    }

    fun findUrl(urlRequestDto: UrlRequestDto): UrlEntity? {
        return urlRepo.findByOriginalUrl(urlRequestDto.originalUrl)
    }

    private fun toResponse(urlEntity: UrlEntity): UrlResponseDto {
        return UrlResponseDto(
            shortUrl = urlEntity.shortUrl
        )
    }
}