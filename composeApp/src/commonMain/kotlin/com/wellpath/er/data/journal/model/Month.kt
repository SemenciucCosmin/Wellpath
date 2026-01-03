package com.wellpath.er.data.journal.model

import org.jetbrains.compose.resources.StringResource
import wellpath.composeapp.generated.resources.Res
import wellpath.composeapp.generated.resources.lbl_april
import wellpath.composeapp.generated.resources.lbl_august
import wellpath.composeapp.generated.resources.lbl_december
import wellpath.composeapp.generated.resources.lbl_february
import wellpath.composeapp.generated.resources.lbl_january
import wellpath.composeapp.generated.resources.lbl_july
import wellpath.composeapp.generated.resources.lbl_june
import wellpath.composeapp.generated.resources.lbl_march
import wellpath.composeapp.generated.resources.lbl_may
import wellpath.composeapp.generated.resources.lbl_november
import wellpath.composeapp.generated.resources.lbl_october
import wellpath.composeapp.generated.resources.lbl_september

enum class Month(
    val id: Int,
    val days: Int,
    val labelRes: StringResource,
) {
    JANUARY(
        id = 1,
        days = 31,
        labelRes = Res.string.lbl_january,
    ),
    FEBRUARY(
        id = 2,
        days = 28,
        labelRes = Res.string.lbl_february,
    ),
    MARCH(
        id = 3,
        days = 31,
        labelRes = Res.string.lbl_march,
    ),
    APRIL(
        id = 4,
        days = 30,
        labelRes = Res.string.lbl_april,
    ),
    MAY(
        id = 5,
        days = 31,
        labelRes = Res.string.lbl_may,
    ),
    JUNE(
        id = 6,
        days = 30,
        labelRes = Res.string.lbl_june,
    ),
    JULY(
        id = 7,
        days = 31,
        labelRes = Res.string.lbl_july,
    ),
    AUGUST(
        id = 8,
        days = 31,
        labelRes = Res.string.lbl_august,
    ),
    SEPTEMBER(
        id = 9,
        days = 30,
        labelRes = Res.string.lbl_september,
    ),
    OCTOBER(
        id = 10,
        days = 31,
        labelRes = Res.string.lbl_october,
    ),
    NOVEMBER(
        id = 11,
        days = 30,
        labelRes = Res.string.lbl_november,
    ),
    DECEMBER(
        id = 12,
        days = 30,
        labelRes = Res.string.lbl_december,
    );

    companion object {
        fun getById(id: Int): Month {
            return Month.entries.firstOrNull { it.id == id } ?: JANUARY
        }
    }
}