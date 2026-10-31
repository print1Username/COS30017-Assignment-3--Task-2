# COS30017 Assignment-3: Task 2

  COS 30017 移动设备软件开发 - Assignment 3: Task 2

[简体中文](README.zh-CN.md) | [English](README.md)

## 程序介绍

这是为 COS30017 Assignment 3 Task 2 开发的 Android 应用程序。程序会从文本文件读取活动资料，并分成 Social Event（社交活动）和 Professional Event（专业活动）两个类别。

用户可以切换活动类别，以两列卡片方式查看活动资料，并点击卡片在程序内打开活动网站。

## 主要功能

- 从 `app/src/main/assets/data.txt` 读取活动资料。
- 保留活动的原始顺序，并按照类型分类。
- 使用 `TabLayout` 和 `ViewPager2` 切换活动类别。
- 为每个活动类别使用独立的 Fragment。
- 使用 `RecyclerView`、`StaggeredGridLayoutManager` 和 `CardView` 显示活动。
- 显示活动图片、日期、标题和地点。
- 在新的 Fragment 中使用 `WebView` 打开活动网站。
- 使用 Android 系统返回键回到活动列表。

## 环境需求

- Android Studio
- Android SDK 37
- Android 7.0（API 24）或更高版本的模拟器或实体设备
- 用于下载 Gradle 依赖和打开活动网站的网络连接
- Git（如果通过命令行克隆项目）

项目使用 Gradle 9.6.0、Android Gradle Plugin 9.4.1 和 Java 11 源代码兼容性。

## 克隆项目

```bash
git clone https://github.com/COS30017-Software-Development/COS30017-Assignment-3--Task-2.git
cd COS30017-Assignment-3--Task-2
```

也可以在 GitHub 上将项目下载为 ZIP 文件，然后解压到本地文件夹。

## 在 Android Studio 中打开和配置

1. 打开 Android Studio，选择 **Open**。
2. 选择克隆后的 `COS30017-Assignment-3--Task-2` 文件夹。
3. 如果出现提示，允许 Android Studio 信任该项目。
4. 等待 Gradle Sync 完成。
5. 如果缺少 Android SDK 37，通过 **Tools > SDK Manager** 安装。
6. 保留 Android Studio 默认选择的 Gradle JDK，除非 IDE 显示兼容性错误。
7. 通过 **Tools > Device Manager** 创建 API 24 或更高版本的模拟器，或连接已开启 USB 调试的 Android 设备。

## 运行程序

1. 选择 `app` 运行配置。
2. 选择模拟器或已连接的 Android 设备。
3. 点击 **Run**。
4. 使用两个标签切换活动类别。
5. 点击活动卡片，在程序内的 WebView 打开网站。
6. 按 Android 系统返回键回到活动列表。

WebView 需要网络连接。如果原始资料中的网址已经失效，网站可能会显示自己的错误页面。

## 程序运作方式

1. `EventData` 从 assets 文件夹读取 `data.txt`。
2. 每条完整记录会被存入一个 `Event` 对象。
3. 活动会被分成 `social` 和 `professional` 两个类别。
4. `EventPagerAdapter` 为当前标签创建对应的 Fragment。
5. 每个 Fragment 将活动列表传给 `EventAdapter`。
6. `EventAdapter` 将活动资料显示在卡片中。
7. 点击卡片时，URL 会被传给 `MainActivity`。
8. `MainActivity` 打开 `EventWebViewFragment`，然后由 WebView 加载 URL。

## 项目结构

```text
app/src/main/
|-- assets/
|   `-- data.txt                         # 原始活动资料
|-- java/com/example/cos30017assignment3_task2/
|   |-- Event.kt                         # 活动资料模型
|   |-- EventData.kt                     # 读取和分类资料
|   |-- EventAdapter.kt                  # 将资料绑定到卡片
|   |-- EventPagerAdapter.kt             # 创建类别 Fragment
|   |-- SocialEventsFragment.kt          # 显示社交活动
|   |-- ProfessionalEventsFragment.kt    # 显示专业活动
|   |-- EventWebViewFragment.kt          # 加载活动网站
|   `-- MainActivity.kt                  # 控制标签和页面导航
|-- res/
|   |-- drawable/                        # 活动图片和 Drawable 资源
|   |-- layout/                          # 页面和卡片布局
|   `-- values/                          # 文字、颜色和主题
`-- AndroidManifest.xml                  # 应用配置和网络权限
```

## 资料和图片说明

作业提供的 `data.txt` 不可修改或重新排列。该文件包含 10 个活动：6 个社交活动和 4 个专业活动。

程序根据 `data.txt` 中的图片名称，从 `app/src/main/res/drawable/` 加载图片。本仓库目前没有 AnimeXcess 所需的 `anime.png`，因此该活动可能会显示空白图片区域。不应使用其他活动图片作为替代。

## 作业范围

本仓库只包含 Task 2: Data Presentation using ViewPager2，不包含 Task 1 的三明治订购程序。
