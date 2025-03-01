# Software Development for Mobile Devices
Projects that were constructed with Kotlin, Swift, &amp; Java Programming Languages via Android Studio &amp; XCode


Don't download the project directly from github, you need to clone it, to do this, in the project repository in github click "code" than copy the link that ends with "git" , in Android studio head to File->New->Project from Version Control and past the link there, this way you will clone the project with it's original configuration, and you wont need to do much configuration


# How to run code on Phyical Device

(1) Check the minimum SDK of your Android device
(2) Find the build.gradle.kts within the Gradle Scripts section of your project folder
(3) Check the 'compileSDK' & 'targetSDK' to the respective version of your device
(4) Find the libs.versions.toml & change all conflicting properties
  (i) For example, for I would change the "android" attribute to a lower version & "constraintlayout"
  (ii) In turn, my set up would look something like this:

    android {
    namespace = "homework1.q2"
    compileSdk = 34

    defaultConfig {
        applicationId = "homework1.q2"
        minSdk = 33
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
        -
        -
        -

        [versions]
        agp = "8.8.0"
        junit = "4.13.2"
        junitVersion = "1.2.1"
        espressoCore = "3.6.1"
        appcompat = "1.7.0"
        material = "1.12.0"
        activity = "1.8.0"
        constraintlayout = "1.8.0"
          -
          -
          -

          
(5) Run your application!
