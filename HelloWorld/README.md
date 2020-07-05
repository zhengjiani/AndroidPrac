# Android开发学习

## 入门

B站视频：[Android开发视频教程-天哥在奔跑!](https://www.bilibili.com/video/BV1Rt411e76H)

### 线性布局、相对布局
1. TextView
- 文字大小、颜色
- 显示不下使用...
- 文字+icon
- 中划线、下划线
- 跑马灯

2. EditText 输入控件
- 常用属性
- 监听事件
- 制作登录界面

3. Radio Button 单选框
- 常用属性
- 自定义样式
- 监听事件

4. CheckBox 复选框
- 常用属性
- 自定义样式
- 监听事件

5. ImageView
- Button的其他衍生控件：ToggleButton、Switch
- 常用属性
- 加载网络图片

scaleType

- fitXY:撑满控件，宽高比可能发生改变
- fitCenter:保持宽高比缩放，直至能够完全显示
- centerCrop:保持宽高比缩放，直至完全覆盖控件，裁剪显示

### 列表视图ListView

使用较少

- 常用属性
- Adapter接口

1. 滚动视图ScrollView

- 垂直滚动：ScrollView
- 水平滚动：HorizontalScollView

2.1 RecyclerView(一)

RecyclerView能够灵活实现大数据集的展示，视图的复用管理比ListView更好，能够显示列表、网格、瀑布流等形式，且不同的viewHolder能够实现item多元化的功能。

2.2 RecyclerView(二)

- 水平滚动
- 网格布局

2.3 RecyclerView(三)

- 瀑布流

2.4 RecyclerView(四)

- 不同的ViewHolder
- XRecyclerView: addHeadView、addFootView、下拉刷新、上拉加载

3. WebView

- 加载网页，加载URL，网络或本地assets文件夹下的html文件
- 加载html代码

- Native和JavaScript相互调用

4. 网页的前进后退

- webview.canGoBack()
- webview.goBack()
- webview.canGoForward()
- webview.goForward()

按下返回键，默认是退出当前Activity，如果希望是WebView内页面后退，则需要重写onKeyDown()方法。
有返回值的方法，true表示我已经处理完成，不需要继续处理。false表示还需要继续处理。

### 解决ERROR_NAME_NOT_RESOLVED

> 1. Check that you typed the correct site URL;
> 2. Reboot your Android device;
> 3. Try to open other sites. You need to understand if the ERR_NAME_NOT_RESOLVED error appears when accessing one or all sites;
> 4. If you are connected to the Internet via a Wi-Fi access point (router), check whether the error appears on all devices that are connected to it, or only on single one. If there is an error on all devices, most likely there is a problem with the access point settings (try restarting your Wi-Fi router), the provider’s DNS server is unavailable, or on a web server side;
> 5. There is no network connection (the cable is damaged, the router doesn’t work, your ISP has a crash, etc.);
> 6. If you are using applications to perform a VPN connection, proxy server or anonymizer apps, try to disable them;
> 7. Boot your Android device in safe mode. If the error in this mode doesn’t appear, the problem is most likely caused by some recently installed application.

------

> 1. Go to menu Settings > Wi-Fi;
> 2. Long press your Wi-Fi network name, then in the menu **Modify this network**;
> 3. Mark the check box **Show advanced options**;
> 4. Change “IP settings” to “Static”;
> 5. Set the static IP for the DNS1—*8.8.8.8* and DNS2—*8.8.4.4* (on different versions of Android, the path and the names of the menu items may differ);

好吧，模拟器依旧没解决

换真机

[Android Studio真机调试!](https://blog.csdn.net/qq876704116/article/details/70176570)

### UI组件之弹出组件

1. Toast

- Toast是一个消息提示组件
- 设置显示的位置
- 自定义显示内容（示例：添加一个图片）
- 简单封装

2. AlertDialog

- 默认样式
- 单选样式
- 多选样式

3. 自定义

4. ProgressBar 和 ProgressDialog

5. 自定义Dialog

6. PopupWindow

### 不可不会的Activity和Fragment

1.Activity的创建三部曲

- 新建类继承Activity或其子类
- 在AndroidManifest中声明
- 创建layout并在Activity的onCreate中设置

2. Activity的跳转和数据传递

- 显式跳转和隐式跳转
- Activity之间的数据传递
- startActivityForResult:启动Activity,结束后返回结果

3. Activity的4种启动模式

Activity的**android:launchMode**属性

- standard：标准模式、默认

Activity是由任务栈管理的，每启动一个Activity，就会被放入栈中，按返回键，就会从栈顶移除一个Activity。standard是默认的启动模式，即标准模式。每启动一个Activity，都会创建一个新的实例。

- singleTop：Task栈顶复用模式

当要启动的目标Activity已经位于栈顶时，不会创建新的实例，会复用栈顶的Activity，并且其onNewIntent()方法会被调用；如果目标Activity不在栈顶，则跟standard一样创建新的实例。

- singleTask：Task栈内复用模式

在同一个任务栈中，如果要启动的目标Activity已经在栈中，则会复用该Activity，并调用其onNewIntent()方法，并且该Activity上面的Activity会被清除；如果栈中没有，则会创建新的实例。

- singleInstance：全局单例模式

全局复用，不管哪个Task栈，只要存在目标Activity，就复用。每个Activity占有一个新的Task栈。

4. Fragment详解

- Fragment有自己的生命周期
- 依赖于Activity
- Fragment通过getActivity()可以获取所在的Activity;Activity通过FragmentManager的findFragmentById()或findFragmentByTag()获取Fragment
- Fragment和Activity是多对多关系
- Fragment中getActivity()为null的问题
- 向Fragment中传递参数

> [Android启动提示安装失败问题!](https://stackoverflow.com/questions/42687607/application-installation-failed-in-android-studio)
> [当启动无显示画面时!](https://stackoverflow.com/questions/28581211/how-to-project-clean-in-android-studio)

- Fragment中getActivity()为null的问题
- 向Fragment传递参数

4.1 Fragment和Activity的通信

### 实现监听事件的方法
- 通过内部类实现
- 通过匿名内部类实现
- 通过事件源所在类实现
- 通过外部类实现
- 布局文件中onClick属性（针对点击事件）

### 基于回调的事件处理机制
- 回调机制与监听机制的区别
- 基于回调的事件传播

### 源码剖析，了解View事件分发
dispatchTouchEvent->setOnTouchListener->onTouchEvent
onClick/onLongClick来自onTouchEvent的处理

### Handler消息处理
- 未来某时做某事
- 线程间通信

### 数据存储
1.SharedPreferences 轻量数据存储
- xml文件，K-V形式
- SharedPreferences
- SharedPreferences.Editor

### Flie
1. Java的I/O流
2. Android存储概念
内部存储->随应用卸载被删除
- `/data/data/<applicationId>/shared_prefs`
- `/data/data/<applicationId>/databases`
- `/data/data/<applicationId>/files`
- `/data/data/<applicationId>/cache`
获取内容的方法：context.getCacheDir() context.getFilesDir()
Android存储->
外部存储：
公有目录`Environment.getExternalStoragePublic Directory(int type)`
私有目录`/mnt/sdcard/Android/data/data/<applicationId>/cache`,
`/mnt/sdcard/Android/data/data/<applicationId>/files`

### LocalBroadcastManager
### 补间动画和属性动画
补间动画没有改变值
属性动画真正改变了值
补充：水波纹效果
 `android:foreground="?selectableItemBackground"`
 <ripple>标签
 2020-04-27
 - [x] 完成上述内容
 - [ ] 参考官网文档进行 代码补充、完善
 - [ ] 阅读书籍《第一行代码》

