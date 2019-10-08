# AndroidReStudy

这个Android项目是在**半玩半学（其实认真学的时间算很少）**的状态下之后，打算重新照着《第一行代码》上的内容和自己的一些新的理解**实现的一个各种小知识点的聚合**，现在又已经荒废了好些天了，希望之后能慢慢补充吧。

也希望有兴趣的各位可以一起优化和补充知识点（虽然大概率入不了眼）。

如果感兴趣的话可以给个**star**

# AS基本配置

**对不太了解的同学：在as打开项目之前，先修改配置文件，如果和你使用的相差不是太大的话，可以将其改成你下载了的版本，就不需要再在as当中慢慢下载加载那么久了**

1. AS版本：3.5（这个可以不相同）

2. 最外层**build.gradle**文件修改：

   ```xml
   classpath 'com.android.tools.build:gradle:3.5.0'
   ```

3. **gradle/wrapper/gradle-wrapper.properties**文件中修改：

   ```xml
   distributionUrl=https\://services.gradle.org/distributions/gradle-5.4.1-all.zip
   ```

4. **app/build.gradle**文件中修改：

   ```java
   compileSdkVersion 28
       defaultConfig {
           ...
           minSdkVersion 15
           targetSdkVersion 28
           ...
       }
   ```

   