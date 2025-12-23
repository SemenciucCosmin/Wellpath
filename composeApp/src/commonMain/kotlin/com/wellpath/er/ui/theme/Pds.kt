package com.wellpath.er.ui.theme

import com.wellpath.er.ui.theme.dimension.DefaultIcon
import com.wellpath.er.ui.theme.dimension.DefaultSpacing
import com.wellpath.er.ui.theme.dimension.DefaultStroke
import com.wellpath.er.ui.theme.dimension.Icon
import com.wellpath.er.ui.theme.dimension.Spacing
import com.wellpath.er.ui.theme.dimension.Stroke

/**
 * Provides access to the default dimensions used in the application.
 */
object Pds {
    val spacing: Spacing
        get() = DefaultSpacing()

    val icon: Icon
        get() = DefaultIcon()

    val stroke: Stroke
        get() = DefaultStroke()
}
