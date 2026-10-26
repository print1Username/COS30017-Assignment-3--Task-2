# COS30017 Assignment 3 - Task 2 工作指引

## 依据与范围

- 以项目上一级的 `../Assignment-3.pdf` 第 5-7 页的 Task 2 为功能依据，以第 8-9 页为评分、报告和演示依据。
- 本仓库只做 **Task 2: Data Presentation using ViewPager2（5 分，ULO2）**。不要把第 1-4 页的 Task 1 三明治订购功能混进来。
- `../data.txt` 是题目提供的原始事件数据。PDF 明确要求将其放进 `assets`，并且**不得修改内容或重新排列内容**。
- 用户要求遇到资料缺失或需求歧义时先询问，不要擅自猜测、替换资源或扩展功能。修改现有代码时只改完成 Task 2 必需的内容。

## Task 2 必须完成什么

1. 用 `TabLayout` + `ViewPager2` 展示两个分页：`Social Events` 和 `Professional Events`。
2. 使用 `FragmentStateAdapter` 为分页创建 Fragment；两个分类分别有自己的 Fragment。
3. 从 `app/src/main/assets/data.txt` 读取事件资料，按 `type` 分到对应分页。保持各事件在原始文件中的出现顺序。
4. 每个分页用 `RecyclerView` + `StaggeredGridLayoutManager` 展示事件，每项放在 `CardView` 中，显示事件文字和对应图片。图片资源放在 `app/src/main/res/drawable/`。
5. 用户点击任一事件时，打开一个新的 Fragment，并用其中的 `WebView` 加载该事件的 `url`。
6. 应用须能正确显示、响应点击，并方便本人在 sign-off 时解释数据读取、分类、分页、点击和网页加载的流程。

当前 `data.txt` 有 10 条事件：6 条 `social`、4 条 `professional`。每条包含 `type`、`title`、`date`、`location`、`url`、`image`；**字段出现顺序并不固定**，读取时按键名解析，不要按固定行号或字段顺序解析。个别值在冒号后有空格，解析时处理值两端空白，但不要改动原文件。

## 文件准备清单

下表是满足任务的一种简洁文件安排；Kotlin 类名和布局名属于实现建议，不是 PDF 指定的文件名。

| 文件或路径 | 状态 | 作用 |
| --- | --- | --- |
| `app/src/main/assets/data.txt` | 待建立；从 `../data.txt` 原样复制 | 运行时读取的原始事件数据。不可改写、重排或手工补事件。 |
| `app/src/main/res/drawable/` 中的事件图片 | 多数已放入 | 根据 `data.txt` 的 `image` 值显示各事件的图片。`anime.png` 仍未看到，用户表示稍后补上。 |
| `app/src/main/java/com/example/cos30017assignment3_task2/MainActivity.kt` | 已有模板；待修改 | 放置 TabLayout、ViewPager2，连接分页，并在点击事件后切换到网页 Fragment。 |
| `EventPagerAdapter.kt` | 待建立 | `FragmentStateAdapter`：为两个 tab 分别创建 Social 和 Professional Fragment。 |
| `SocialEventsFragment.kt` | 待建立 | Social Events 分页，展示 `social` 事件。 |
| `ProfessionalEventsFragment.kt` | 待建立 | Professional Events 分页，展示 `professional` 事件。 |
| `Event.kt` | 待建立 | 表示一条事件的字段，供列表和点击处理共用。 |
| `EventData.kt` | 待建立 | 从 assets 读取并解析事件，按 `type` 提供数据；保持原始顺序。实现应简洁，避免与界面类重复解析逻辑。 |
| `EventAdapter.kt` | 待建立 | RecyclerView 适配器：把事件文字、图片绑定到 CardView，并把点击的 URL 交给界面层。两个分页可共用。 |
| `EventWebViewFragment.kt` | 待建立 | 接收所选事件的 URL，在 WebView 中打开网站。 |
| `app/src/main/res/layout/activity_main.xml` | 已有 Hello World 模板；待修改 | 主界面的 TabLayout、ViewPager2，以及网页 Fragment 的容器或导航位置。 |
| `fragment_event_list.xml` | 待建立 | 两个分类 Fragment 可共用的 RecyclerView 布局。 |
| `item_event.xml` | 待建立 | 单个事件的 CardView：图片、标题、日期、地点等。 |
| `fragment_event_webview.xml` | 待建立 | WebView 页面布局。 |
| `app/src/main/AndroidManifest.xml` | 已有；待检查 | 网页加载需要网络权限，并保留 MainActivity 的入口配置。 |
| `app/build.gradle.kts`、`gradle/libs.versions.toml` | 已有；待检查 | 确认 ViewPager2、RecyclerView、CardView、Fragment 等所需依赖；项目已含 Material Components。只增加实际缺少的依赖。 |
| `app/src/main/res/values/strings.xml` | 已有；按需修改 | 放置 tab 标题和可见界面文字，避免重复硬编码。 |

`../task 2 images/` 和 `../task 2 images.zip` 是参考资源。当前 `drawable` 中已有 `acg_concert.png`、`afa.png`、`bagfest.png`、`bts.png`、`cyber_summit.png`、`idecs.png`、`wak.png`、`icsw.PNG`、`taylor_swift.PNG`，以及未被 `data.txt` 引用的 `career_fair.PNG`、`location.png`；当前没有 `anime.png`。不要用其他图片冒充 AnimeXcess。图片文件名或扩展名如需调整以满足 Android 资源规则，先核对实际构建结果及 `data.txt` 的映射，且不得修改 `data.txt` 的内容。

## 建议的实施顺序与验收

1. **确认资料**：核对 `data.txt` 的 10 条记录、两个分类和 10 个 `image` 值；等用户补齐 `anime.png` 后，再检查每条记录都能找到对应图片。核对 `assets` 副本与原文件完全一致。
2. **建立读取层**：实现 `Event` 与数据读取。验证 10 条记录均能解析，分类结果为 6/4，且每类的显示顺序与 `data.txt` 一致。不要依赖字段行的固定顺序。
3. **建立分页**：完成 MainActivity、TabLayout、ViewPager2、FragmentStateAdapter 和两个分类 Fragment。验证切换 tab 时类别正确。
4. **建立卡片列表**：在两个 Fragment 中使用 RecyclerView + StaggeredGridLayoutManager，用共用的 EventAdapter 将每条数据绑定到 CardView。验证标题、日期、地点、图片与原始记录一一对应。
5. **建立网页页面**：点击任一卡片，在新的 WebView Fragment 加载该条记录的 URL；检查返回或切换后的界面行为，并在有网络的设备或模拟器上验证网页加载。
6. **构建并演示**：运行 Android 构建和实际设备或模拟器检查。检查两个分类、全部卡片、图片及点击后的网页。准备解释每个类的职责和数据流。

## 报告与提交

- PDF 第 9 页要求通过 Canvas 提交报告软拷贝；报告必须有标题、姓名和学生证号码，不需要目录。报告会在 sign-off 中评估。
- PDF 第 4 页写有“在报告中包含应用截图和 Kotlin 源代码”，这句话位于 Task 1 部分；准备 Task 2 报告时可包含 Task 2 页面、卡片和 WebView 的截图及关键 Kotlin 代码，但不要将这条误写为 Task 2 独有的明文要求。
- 第 8 页评分关注功能与交互（2.5 分）、代码质量与可维护性（1.5 分）、理解和解释（1 分）。演示时需能说明代码、数据流、相关条件和用户点击后的行为。
- 若报告的具体格式、截止时间或 AI 使用范围需要确认，查 unit outline 或询问用户；本 PDF 未在 Task 2 处给出更具体的格式和截止日期。
