package com.url.shortner.entity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "url_entity")
class UrlEntity(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,

    var originalUrl: String? = null,

    var shortUrl: String? = null,

    var createdAt: LocalDateTime? = null
)