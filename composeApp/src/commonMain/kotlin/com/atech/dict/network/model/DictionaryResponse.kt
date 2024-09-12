package com.atech.dict.network.model

import kotlinx.serialization.Serializable

@Serializable
data class DictionaryResponse(
    val word: String,
    val phonetic: String? = null,
    val phonetics: List<Phonetic>,
    val meanings: List<Meaning>,
)

@Serializable
data class Phonetic(
    val text: String? = null,
    val audio: String? = null
)

@Serializable
data class Meaning(
    val partOfSpeech: String,
    val definitions: List<Definition>
)

@Serializable
data class Definition(
    val definition: String,
    val example: String? = null,
    val synonyms: List<String> = emptyList(),
    val antonyms: List<String> = emptyList()
)