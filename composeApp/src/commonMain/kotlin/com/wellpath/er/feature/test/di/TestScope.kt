package com.wellpath.er.feature.test.di

import com.wellpath.er.feature.test.viewmodel.TestViewModel
import org.koin.core.Koin
import org.koin.core.qualifier.named

/**
 * Object for managing the koin score for [TestViewModel]
 */
object TestScope {

    const val ID = "TEST_SCOPE"

    /**
     * Creates the scope
     */
    fun create(koin: Koin) {
        delete(koin)
        koin.createScope(ID, named(ID))
    }

    /**
     * Deletes the scope
     */
    fun delete(koin: Koin) {
        koin.getScopeOrNull(ID)?.close()
    }
}
