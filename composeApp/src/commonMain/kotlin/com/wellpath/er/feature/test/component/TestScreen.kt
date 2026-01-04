package com.wellpath.er.feature.test.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.wellpath.er.data.test.model.BFIQuestion
import com.wellpath.er.feature.test.model.TestQuestionResponse
import com.wellpath.er.ui.components.PrimaryButton
import com.wellpath.er.ui.theme.Pds
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import wellpath.composeapp.generated.resources.Res
import wellpath.composeapp.generated.resources.ic_arrow_left_large
import wellpath.composeapp.generated.resources.lbl_form_questions_message
import wellpath.composeapp.generated.resources.lbl_next
import wellpath.composeapp.generated.resources.lbl_page_counter

/**
 * Reusable screen for onboarding form flow
 */
@Composable
fun TestScreen(
    pageCount: Int,
    selectedPageIndex: Int,
    questions: List<BFIQuestion>,
    responses: Map<Int, Int>,
    isNextButtonEnabled: Boolean,
    onResponseClick: (Int, Int) -> Unit,
    onNextClick: () -> Unit,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold { paddingValues ->
        Column(modifier = modifier.padding(paddingValues)) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(Pds.spacing.XXLarge),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBack) {
                    Icon(
                        painter = painterResource(Res.drawable.ic_arrow_left_large),
                        tint = MaterialTheme.colorScheme.onPrimary,
                        contentDescription = null,
                    )
                }

                Text(
                    modifier = Modifier.weight(1f),
                    text = stringResource(Res.string.lbl_page_counter, selectedPageIndex + 1, pageCount),
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.titleLarge,
                )
            }

            Spacer(modifier = Modifier.height(Pds.spacing.XLarge))

            Text(
                text = stringResource(Res.string.lbl_form_questions_message),
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(Pds.spacing.Medium))

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                questions.forEach { question ->
                    TestQuestionRow(
                        modifier = Modifier.fillMaxWidth(),
                        label = question.text,
                        onResponseClick = { onResponseClick(question.id, it.score) },
                        selectedResponse = TestQuestionResponse.getByScore(
                            score = responses.entries.firstOrNull { it.key == question.id }?.value
                        )
                    )
                }
            }

            PrimaryButton(
                text = stringResource(Res.string.lbl_next),
                onClick = onNextClick,
                enabled = isNextButtonEnabled,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
