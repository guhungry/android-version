package com.guhungry.android.version

data class VersionNumber(val version: String): Comparable<VersionNumber> {
    val MAJOR: Int
    val MINOR: Int
    val PATCH: Int

    //////////////
    // Constructor
    //////////////
    init {
        val matches = versionMatcher(version)
        MAJOR = versionAt(matches, 1)
        MINOR = versionAt(matches, 3)
        PATCH = versionAt(matches, 5)
    }

    /////////////
    // Comparable
    /////////////
    override fun compareTo(other: VersionNumber): Int {
        if (MAJOR > other.MAJOR) return 1
        if (MAJOR < other.MAJOR) return -1
        if (MINOR > other.MINOR) return 1
        if (MINOR < other.MINOR) return -1
        if (PATCH > other.PATCH) return 1
        if (PATCH < other.PATCH) return -1
        return 0
    }

    //////////////////
    // Version Extract
    //////////////////
    companion object {
        private val PATTERN = """^(\d+)(\.(\d+))?(\.(\d+))?$""".toRegex()
        private fun versionMatcher(version: String) = PATTERN.matchEntire(version)?.groupValues.orEmpty()
        private fun versionAt(matches: List<String>, position: Int): Int {
            return matches.getOrElse(position) { "0" }.toIntOrNull() ?: 0
        }
    }
}
