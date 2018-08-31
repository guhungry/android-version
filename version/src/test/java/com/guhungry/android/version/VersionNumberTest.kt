package com.guhungry.android.version

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object VersionNumberTest : Spek({
    given("version 12.2.3") {
        val sut = VersionNumber("12.2.3")

        on("all values") {
            it("have correct vesion number") {
                assertThat(sut.version, equalTo("12.2.3"))
                assertThat(sut.MAJOR, equalTo(12))
                assertThat(sut.MINOR, equalTo(2))
                assertThat(sut.PATCH, equalTo(3))
                assertThat(sut.version, equalTo("12.2.3"))
            }
        }
    }
})