package com.wellpath.er.data.test.datasource

import com.wellpath.er.data.test.model.BFIDimension
import com.wellpath.er.data.test.model.BFIQuestion
import com.wellpath.er.data.test.model.BFIQuestionDTO
import kotlinx.serialization.json.Json

/**
 * Data source for providing the list of [BFIQuestion] from a json file or from in memory cache.
 */
class BFIQuestionsDataSourceImpl : BFIQuestionsDataSource {

    /**
     * In memory cache for list of [BFIQuestion]
     */
    private val bfiQuestions: MutableList<BFIQuestion> = mutableListOf()

    /**
     * Parses a json file into a list of [BFIQuestion] or retrieves it from in memory cache.
     */
    override fun getBfiQuestions(): List<BFIQuestion> {
        return when {
            this.bfiQuestions.isNotEmpty() -> this.bfiQuestions

            else -> {
                val bfiQuestionsFromFile = getLocalBfiQuestions()
                this.bfiQuestions.clear()
                this.bfiQuestions.addAll(bfiQuestionsFromFile)
                bfiQuestionsFromFile
            }
        }
    }

    /**
     * Maps a list of [BFIQuestionDTO] to a list of [BFIQuestion].
     */
    private fun mapBFIQuestionDTOtoBFIQuestion(
        bfiQuestionDTOs: List<BFIQuestionDTO>
    ): List<BFIQuestion> {
        return bfiQuestionDTOs.mapNotNull { bfiQuestionDTO ->
            val bfiDimensionId = bfiQuestionDTO.bfiDimensionId ?: return@mapNotNull null
            val bfiDimension = BFIDimension.getBFIDimensionById(bfiDimensionId)

            BFIQuestion(
                id = bfiQuestionDTO.id ?: return@mapNotNull null,
                text = bfiQuestionDTO.text ?: return@mapNotNull null,
                bfiDimension = bfiDimension ?: return@mapNotNull null,
                reverseScore = bfiQuestionDTO.reverseScore,
            )
        }
    }

    /**
     * Parses a json file into a list of [BFIQuestionDTO] and maps it to a list of [BFIQuestion].
     */
    private fun getLocalBfiQuestions(): List<BFIQuestion> {
        val bfiQuestionDTOs = Json.decodeFromString<List<BFIQuestionDTO>>(bfiQuestionsJsonString)
        return mapBFIQuestionDTOtoBFIQuestion(bfiQuestionDTOs)
    }
}
