package com.guhungry.android.version

data class VersionNumber(val version: String): Comparable<VersionNumber> {
    val major: Int
    val minor: Int
    val patch: Int

    //////////////
    // Constructor
    //////////////
    init {
        val matches = versionMatcher(version)
        major = versionAt(matches, 1)
        minor = versionAt(matches, 3)
        patch = versionAt(matches, 5)
    }

    /////////////
    // Comparable
    /////////////
    override fun compareTo(other: VersionNumber) = COMPARATOR.compare(this, other)

    //////////////////
    // Version Extract
    //////////////////
    companion object {
        private val PATTERN = """^(\d+)(\.(\d+))?(\.(\d+))?$""".toRegex()
        private fun versionMatcher(version: String) = PATTERN.matchEntire(version)?.groupValues.orEmpty()
        private fun versionAt(matches: List<String>, position: Int): Int {
            return matches.getOrNull(position)?.toIntOrNull() ?: 0
        }

        private val COMPARATOR = compareBy(VersionNumber::major, VersionNumber::minor, VersionNumber::patch)
    }
}
