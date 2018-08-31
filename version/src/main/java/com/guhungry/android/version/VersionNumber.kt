package com.guhungry.android.version

class VersionNumber(val version: String) {
    val MAJOR: Int
    val MINOR: Int
    val PATCH: Int

    init {
        val matches = versionMatcher(version)
        MAJOR = versionAt(matches, 1)
        MINOR = versionAt(matches, 3)
        PATCH = versionAt(matches, 5)
    }

    //////////////////
    // Version Extract
    //////////////////
    companion object {
        private val PATTERN = """^(\d+)(\.(\d+))?(\.(\d+))?$""".toRegex()
        private fun versionMatcher(version: String) = PATTERN.matchEntire(version)?.groupValues.orEmpty()
        private fun versionAt(matches: List<String>, position: Int): Int {
            return matches.getOrElse(position) { "0" }.toInt()
        }
    }
}
