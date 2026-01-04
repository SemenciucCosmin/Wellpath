package com.wellpath.er.feature.test.viewmodel.model

import com.wellpath.er.data.test.model.BFIQuestion
import com.wellpath.er.ui.viewmodel.model.Event

/**
 * Ui state class for form flow
 * @param [bfiPages]: list of sublists of questions for each form page
 * @param [responses]: map of all registered answers for all questions
 */
data class TestUiState(
    val bfiPages: List<List<BFIQuestion>> = emptyList(),
    val responses: Map<Int, Int> = emptyMap()
) {

    /**
     * Enum class for all events in the form flow
     */
    enum class TestEvent : Event {
        NEXT_PAGE,
        FINISH_FORM
    }
}
