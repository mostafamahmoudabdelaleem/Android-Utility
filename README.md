## Android-Utility
*This is a library for <b>Android</b> application projects.*
## *How to get a Git project into your build:*
<b>Step 1.</b> Add the JitPack repository to your build file
```gradle
	allprojects{
		repositories{
			...
			maven { url : 'https://jitpack.io' }
		}
	}
```
<b>Step 2.</b> Add the dependency
```gradle
	dependencies{
            implementation 'com.github.mostafamahmoudabdelaleem:Android-Utility:X.X.X'
	}
```
<b>Step 3.</b> Replace *<b>X.X.X</b>* with current version or any version you want.
