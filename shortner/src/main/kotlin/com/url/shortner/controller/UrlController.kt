package com.url.shortner.controller

import com.url.shortner.dto.UrlRequestDto
import com.url.shortner.dto.UrlResponseDto
import com.url.shortner.entity.UrlEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.url.shortner.service.UrlShortenService
import org.springframework.web.bind.annotation.GetMapping

@RestController
@RequestMapping("/api/url")
class UrlController(
    @Autowired
    var urlShortenService: UrlShortenService
) {


    @PostMapping("/shorten")
    fun shortenUrl(@RequestBody urlRequestDto: UrlRequestDto): ResponseEntity<UrlResponseDto> {
        val response = urlShortenService.shortenUrl(urlRequestDto)
                return ResponseEntity.ok()
            .header("Content-Type", "application/json")
            .header("Response-Code", "200")
            .body(response)
    }

    @GetMapping("/shorten")
    fun getOriginalUrl(@RequestBody urlRequestDto: UrlRequestDto): ResponseEntity<UrlEntity>{
        val response = urlShortenService.findUrl(urlRequestDto);

        return ResponseEntity.ok()
            .header("Content-Type", "application/json")
            .header("Response-Code", "200")
            .body(response)
    }
}