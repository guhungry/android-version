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

    given("version 1.3.5 and 1.3.5") {
        val sut1 = VersionNumber("1.3.5")
        val sut2 = VersionNumber("1.3.5")

        on("compare") {
            it("should equal to") {
                assertThat(sut1 == sut2, equalTo(true))
                assertThat(sut1 > sut2, equalTo(false))
                assertThat(sut1 < sut2, equalTo(false))
            }
        }
    }

    given("version 2.4.1 and 1.2.2") {
        val sut1 = VersionNumber("2.4.1")
        val sut2 = VersionNumber("1.2.2")

        on("compare") {
            it("should more than") {
                assertThat(sut1 == sut2, equalTo(false))
                assertThat(sut1 > sut2, equalTo(true))
                assertThat(sut1 < sut2, equalTo(false))
            }
        }
    }

    given("version 2.1.4 and 5.7.1") {
        val sut1 = VersionNumber("2.1.4")
        val sut2 = VersionNumber("5.7.1")

        on("compare") {
            it("should less than") {
                assertThat(sut1 == sut2, equalTo(false))
                assertThat(sut1 > sut2, equalTo(false))
                assertThat(sut1 < sut2, equalTo(true))
            }
        }
    }
})