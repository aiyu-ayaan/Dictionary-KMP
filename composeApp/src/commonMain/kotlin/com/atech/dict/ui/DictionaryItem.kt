package com.atech.dict.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.atech.dict.network.model.DictionaryResponse

@Composable
fun DictionaryItem(
    modifier: Modifier = Modifier,
    item: DictionaryResponse = DictionaryResponse(
        word = "Hello",
        phonetic = "həˈləʊ",
        phonetics = emptyList(),
        meanings = emptyList()
    )
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = item.word,
                style = MaterialTheme.typography.h4.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colors.primary
            )
            item.phonetic?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.subtitle1,
                    fontStyle = FontStyle.Italic
                )
            }
            item.meanings.forEachIndexed { index, meaning ->
                if (index > 0) {
                    Divider(modifier = Modifier.padding(vertical = 8.dp))
                }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = meaning.partOfSpeech,
                        style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.SemiBold),
                        color = MaterialTheme.colors.secondary
                    )
                    meaning.definitions.forEachIndexed { defIndex, definition ->
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 16.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = "${defIndex + 1}. ${definition.definition}",
                                style = MaterialTheme.typography.body1
                            )
                            definition.example?.let {
                                Text(
                                    text = "Example: \"$it\"",
                                    style = MaterialTheme.typography.body2,
                                    fontStyle = FontStyle.Italic,
                                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.7f)
                                )
                            }
                            if (definition.synonyms.isNotEmpty()) {
                                Text(
                                    text = "Synonyms: ${definition.synonyms.joinToString()}",
                                    style = MaterialTheme.typography.body2,
                                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.7f)
                                )
                            }
                            if (definition.antonyms.isNotEmpty()) {
                                Text(
                                    text = "Antonyms: ${definition.antonyms.joinToString()}",
                                    style = MaterialTheme.typography.body2,
                                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.7f)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
