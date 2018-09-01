# android-version
[![Build Status](https://travis-ci.org/guhungry/android-version.svg?branch=master)](https://travis-ci.org/guhungry/android-version)
[![codecov](https://codecov.io/gh/guhungry/android-version/branch/master/graph/badge.svg)](https://codecov.io/gh/guhungry/android-version)

Simple version number compare in MAJOR(.MINOR)?(.PATCH)? format

## Examples
```
import com.guhungry.android.version.VersionNumber

VersionNumber("1.2.3") > VersionNumber("1.5.3")
false

VersionNumber("1.2.3") < VersionNumber("1.5.3")
true

VersionNumber("1.2.3") == VersionNumber("1.5.3")
false

VersionNumber("4.1.7") < VersionNumber("2.5.2")
false

VersionNumber("4.1.7") > VersionNumber("2.5.2")
true

VersionNumber("4.1.7") == VersionNumber("2.5.2")
false

VersionNumber("9.1.2") < VersionNumber("9.1.5")
true

VersionNumber("9.1.2") > VersionNumber("9.1.5")
false

VersionNumber("9.1.2") == VersionNumber("9.1.5")
false

VersionNumber("2.3.1") > VersionNumber("2.3.1")
false

VersionNumber("2.3.1") < VersionNumber("2.3.1")
false

VersionNumber("2.3.1") == VersionNumber("2.3.1")
true
```
