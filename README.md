# MyRecorderTest
这是一个使用Android Studio制作的Demo

##特点：

* 只需输入文件名，自动在sdCard下建立Recorder文件夹，并保存该音频文件。文件后缀默认为 ".amr"，如果错误，返回false，停止播放
* 只需输入文件名，自动在sdCard下Recorder文件夹找寻文件并播放，如果错误，返回false，停止播放。
* 使用Log.d 显示方法的执行程度
* 提供三个按钮（三个方法），可以随意点击这三个按钮，而不会崩溃。

<img src="https://github.com/dyslove123/MyRecorderTest/blob/master/device-2015-04-22-021156.png" Width=40% Height=40%/>
ps:界面是瞎布置的，左边是录制按钮，右边是播放按钮，下方是停止录制和播放

##遇到的问题：

* 需要添加两种权限，一个是RECORD_AUDIO 一个是SDCard的写权限。可以参考 MyRecorderTest/app/src/main/AndroidManifest.xml
* 一开始是抄网上的教程，发现根本不知道文件名应该是什么样的，所以一直报错，加上没有使用好调试工具，所以一直找不到错误原因。
尝试了很久才发现是文件路径错误，或者没有读写权限，或者文件不存在，文件夹不存在。
* 该demo中的DocumentName是sdCard下的一个文件夹，通过获取sdCard的路径，加上DocumentName 加上FileName 确定最后的保存文件。
* Recorder时，自动确认未有同名文件（否则删除该文件），然后记录。Player时，自动确认有该文件（否则返回False），之后才会进行播放。
