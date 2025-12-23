package com.wellpath.er.ui.navigation.model

import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import wellpath.composeapp.generated.resources.Res
import wellpath.composeapp.generated.resources.ic_explore
import wellpath.composeapp.generated.resources.ic_home
import wellpath.composeapp.generated.resources.ic_news
import wellpath.composeapp.generated.resources.lbl_exercises
import wellpath.composeapp.generated.resources.lbl_journal

/**
 * Represents the items in the bottom navigation bar of the timetable.
 *
 * @property labelRes The string resource for the label of the item.
 * @property icon The drawable resource for the icon of the item.
 * @property destination The navigation destination associated with the item.
 */
enum class BottomBarItem(
    val labelRes: StringResource,
    val icon: DrawableResource,
    val destination: Any,
) {
    DASHBOARD(
        labelRes = Res.string.lbl_journal,
        icon = Res.drawable.ic_home,
        destination = DashboardNavDestination.Dashboard,
    ),
    JOURNAL(
        labelRes = Res.string.lbl_journal,
        icon = Res.drawable.ic_news,
        destination = JournalNavDestination.Journal,
    ),
    EXERCISES(
        labelRes = Res.string.lbl_exercises,
        icon = Res.drawable.ic_explore,
        destination = ExercisesNavDestination.Exercises,
    )
}
