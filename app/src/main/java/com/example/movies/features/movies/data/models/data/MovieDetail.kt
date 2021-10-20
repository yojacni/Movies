package com.example.movies.features.movies.data.models.data

data class MovieDetail (
    val adult: Boolean? = null,
    val backdropPath: String? = null,
    val belongsToCollection: BelongsToCollection? = null,
    val budget: Long? = null,
    val genres: List<Genre>? = null,
    val homepage: String? = null,
    val id: Long? = null,
    val imdbID: String? = null,
    val originalLanguage: String? = null,
    val originalTitle: String? = null,
    val overview: String? = null,
    val popularity: Double? = null,
    val posterPath: String? = null,
    val productionCompanies: List<ProductionCompany>? = null,
    val productionCountries: List<ProductionCountry>? = null,
    val releaseDate: String? = null,
    val revenue: Long? = null,
    val runtime: Long? = null,
    val spokenLanguages: List<SpokenLanguage>? = null,
    val status: String? = null,
    val tagline: String? = null,
    val title: String? = null,
    val video: Boolean? = null,
    val voteAverage: Double? = null,
    val voteCount: Long? = null
)

data class BelongsToCollection (
    val id: Long? = null,
    val name: String? = null,
    val posterPath: String? = null,
    val backdropPath: String? = null
)

data class Genre (
    val id: Long? = null,
    val name: String? = null
)

data class ProductionCompany (
    val id: Long? = null,
    val logoPath: String? = null,
    val name: String? = null,
    val originCountry: String? = null
)

data class ProductionCountry (
    val iso3166_1: String? = null,
    val name: String? = null
)

data class SpokenLanguage (
    val englishName: String? = null,
    val iso639_1: String? = null,
    val name: String? = null
)

