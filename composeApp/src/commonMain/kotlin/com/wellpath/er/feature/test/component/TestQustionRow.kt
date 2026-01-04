package com.wellpath.er.feature.test.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.wellpath.er.feature.test.model.TestQuestionResponse
import com.wellpath.er.ui.theme.Pds
import org.jetbrains.compose.resources.stringResource

/**
 * Row for question model with [label] and a selection row of [TestQuestionResponseButton]
 */
@Composable
fun TestQuestionRow(
    label: String,
    selectedResponse: TestQuestionResponse?,
    onResponseClick: (TestQuestionResponse) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(Pds.spacing.Medium)
    ) {
        Text(
            text = label,
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.titleMedium
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TestQuestionResponse.entries.forEach { formQuestionResponse ->
                Column(
                    verticalArrangement = Arrangement.spacedBy(Pds.spacing.Small),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.weight(0.2f)
                ) {
                    TestQuestionResponseButton(
                        isSelected = formQuestionResponse == selectedResponse,
                        selectedColor = formQuestionResponse.selectedColor,
                        unselectedColor = formQuestionResponse.unselectedColor,
                        onClick = { onResponseClick(formQuestionResponse) },
                    )

                    Text(
                        text = stringResource(formQuestionResponse.labelRes),
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.labelMedium,
                        textAlign = TextAlign.Center,
                        maxLines = 2
                    )
                }
            }
        }
    }
}
