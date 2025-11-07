package com.wellpath.er.ui.model

import org.jetbrains.compose.resources.DrawableResource


/**
 * Data class for a menu item on the custom [TitleBar]
 * @param [action]: lambda function for menu item onClick action
 * @param [label]: label for in list display of the menu item
 * @param [iconResId]: drawable resource for in row display of the menu item
 * @param [contentDescription]: content description for talk back
 * @param [enabled]: whether the item's onClick action is enabled or not
 */
data class TitleBarMenuItem(
    val action: () -> Unit,
    val label: String? = null,
    val iconResId: DrawableResource? = null,
    val contentDescription: String? = null,
    val enabled: Boolean = true,
)
