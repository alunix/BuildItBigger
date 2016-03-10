# BuildItBigger
Udacity Build It Bigger's Final Project

## Banner Ad Unit ID
In order to setup the code to properly working it's mandatory to put 
your personal CA-APP-PUB code for the Banner in the file Strings.xml at the following path:

BuildItBigger\app\src\free\res\values\strings.xml

You will find this explicit content:

	<resources>
	    <string name="app_name">Build it Bigger</string>
	    <string name="jokelib_name">Joke</string>
	    <string name="instructions">Press the button for a delicious joke!</string>
	    <string name="button_text">Tell Joke</string>
	    <string name="action_settings">Settings</string>
	    <string name="banner_ad_unit_id">ca-app-pub-INSERT_YOUR_CODE_HERE</string>
	</resources>

## Application Build
To build this application you need to install the following project 
dependencies:
```
 classpath 'com.android.tools.build:gradle:1.2.3'
```

You need to have in your environment the following build tool version:
 compileSdkVersion 23
 buildToolsVersion "23.0.1"

and all the following dependencies:
```
 compile project(':jokelib')
 compile project(':androidjokelib')
 compile 'com.android.support:appcompat-v7:23.1.0'
 compile 'com.android.support:multidex:1.0.0'
 // Added for AdMob
 freeCompile 'com.google.android.gms:play-services:8.1.0'
 testCompile 'junit:junit:4.12'
```

## Backend Build
To build the Backend you need to install:
```
 classpath 'com.google.appengine:gradle-appengine-plugin:1.9.18'
```

and be sure to have properly installed in your system the following 
dependencies:
```
 appengineSdk 'com.google.appengine:appengine-java-sdk:1.9.18'
 compile 'com.google.appengine:appengine-endpoints:1.9.18'
 compile 'com.google.appengine:appengine-endpoints-deps:1.9.18'
 compile 'javax.servlet:servlet-api:2.5'
 compile project(':jokelib')
```

## AndroidJokeLib Build
You need to have in your environment the following build tool version:
```
 compileSdkVersion 23
 buildToolsVersion "23.0.1"
```

and be sure to have properly installed in your system the following 
dependencies:
```
 testCompile 'junit:junit:4.12'
 compile 'com.android.support:appcompat-v7:23.1.0'
 compile 'com.android.support:design:23.1.0'
```


## Install
To install the App on your device/emulator, you have to ensure your 
Android API versione is 18 or above.

The following permissions will be needed:
```
 android.permission.INTERNET
 android.permission.ACCESS_NETWORK_STATE
```

## Support
Patches are encouraged, and may be submitted by forking this project 
and submitting a pull request through GitHub. Please see 
CONTRIBUTING.md for more details.

## License
Copyright 2015 The Android Open Source Project, Inc.

Licensed to the Apache Software Foundation (ASF) under one or more 
contributor license agreements.  See the NOTICE file distributed with
this work for additional information regarding copyright ownership. 
The ASF licenses this file to you under the Apache License, 
Version 2.0 (the "License"); you may not use this file except in 
compliance with the License.  You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, 
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or 
implied.  See the License for the specific language governing 
permissions and limitations under the License.

## Contact
For any questions, complaints and so on, please contact me. 
Any contact info is available on my profile.