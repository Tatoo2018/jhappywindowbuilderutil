# 🤖 WindowBuilder Bean Aligner (JHappy WBUtil)

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Eclipse](https://img.shields.io/badge/Eclipse-Plugin-purple.svg)](https://www.eclipse.org/)
[![WindowBuilder](https://img.shields.io/badge/WindowBuilder-Compatible-blue.svg)](https://www.eclipse.org/windowbuilder/)

*[Read this in [Japanese (日本語)](#日本語) | [Chinese (简体中文)](#chinese)]*

**WindowBuilder Bean Aligner** is an Eclipse plugin designed to keep your WindowBuilder design canvas organized. [cite_start]It automatically rearranges the icons of "Non-Visual Beans" (components marked with `@wbp.nonvisual`) based on your customizable layout and sorting preferences. [cite: 32, 43, 65]

## ✨ Key Features
* [cite_start]**Auto-Alignment:** Instantly repositions all non-visual bean icons into a clean grid. [cite: 13, 53]
* [cite_start]**Vertical/Horizontal Wrapping:** Supports wrapping by a fixed number of rows, filling columns vertically before moving to the next column. [cite: 21, 54]
* [cite_start]**Smart Sorting:** Sort beans alphabetically by **Field Name** or by **Class Type** to find your components faster. [cite: 23, 47, 48]
* [cite_start]**Project-Specific Settings:** Configure different layout coordinates (X, Y) and spacing (Gap X, Gap Y) for each project via Property Pages. [cite: 66, 70, 73]
* [cite_start]**Multilingual UI:** Fully supports English, Japanese, and Chinese environments. [cite: 1, 77, 80]

## 📥 Installation

1. In Eclipse, go to **Help** > **Install New Software...**.
2. Click the **Add...** button.
3. Enter `JHappy WBUtil` in the Name field and paste the following URL into the Location field:
   `https://tatoo2018.github.io/jhappywindowbuilderutil/updatesite/main/`
4. Select **WindowBuilder Bean Aligner** from the list and follow the prompts.
5. Restart Eclipse to complete the installation.

## 🚀 How to Use
1. Open a Java class with the **WindowBuilder Editor**.
2. Switch to the **Design** tab (or stay in the **Source** tab).
3. [cite_start]Right-click anywhere in the editor and select **🤖 Align Non-Visual Beans**. [cite: 2]
4. [cite_start]The `@wbp.nonvisual` Javadoc tags in your source code will be updated with new `location` coordinates. [cite: 56, 60]

## ⚙️ Configuration
[cite_start]Right-click your project in the Project Explorer and select **Properties** > **WindowBuilder Bean Sort Property**. [cite: 2]
You can adjust:
* [cite_start]**Starting Coordinates:** Where the first icon appears. [cite: 15, 17]
* [cite_start]**Spacing:** Horizontal and vertical gaps between icons. [cite: 18, 20]
* [cite_start]**Rows before Wrapping:** How many icons to stack vertically before starting a new column. [cite: 22]
* [cite_start]**Sort Strategy:** Field Name or Class Name. [cite: 24, 25]

## 📄 License & Credits
* This project is licensed under the **MIT License**.
* [cite_start]It utilizes libraries from the Eclipse Foundation licensed under the **EPL-2.0**. [cite: 1]
* The icon `icons/ChooseComponent.gif` is redistributable from the official [Eclipse WindowBuilder repository](https://github.com/eclipse-windowbuilder/windowbuilder) under the EPL-2.0.

---

<h1 id="日本語">🤖 WindowBuilder Bean Aligner (日本語)</h1>

[cite_start]**WindowBuilder Bean Aligner** は、WindowBuilderエディタの非可視コンポーネント（`@wbp.nonvisual`）の配置を劇的に整理するプラグインです。アイコンが重なって見えなくなったBeanを、設定したルールに基づいて一括整列させます。 [cite: 32, 43, 60]

## ✨ 主な機能
* [cite_start]**一括整列:** デザイン画面上の非可視Beanアイコンを、綺麗なグリッド状に再配置します。 [cite: 13, 53, 56]
* [cite_start]**柔軟な折り返し:** 指定した「行数」に達すると次の列へ移動する垂直優先レイアウトを採用。 [cite: 21, 54]
* [cite_start]**高度なソート:** 「変数名順」または「クラス型順」で並び替えが可能。 [cite: 23, 47, 48]
* [cite_start]**プロジェクト別設定:** プロジェクトの「プロパティ」から、開始座標、間隔、整列ルールを個別に保存できます。 [cite: 66, 70, 73]
* [cite_start]**多言語対応:** メニュー、設定画面ともに日本語・英語・中国語に対応しています。 [cite: 1, 77, 80]

## 📥 インストール方法
1. Eclipseを起動し、 **[ヘルプ]** > **[新規ソフトウェアのインストール...]** を選択します。
2. **[追加...]** をクリックし、ロケーションに以下を入力します：
   `https://tatoo2018.github.io/jhappywindowbuilderutil/updatesite/main/`
3. **WindowBuilder Bean Aligner** を選択してインストールし、Eclipseを再起動してください。

## 🚀 使い方
1. WindowBuilderエディタでJavaファイルを開きます。
2. **[Design]** タブまたは **[Source]** タブで右クリックします。
3. [cite_start]**🤖 Non-Visual Beanを整列** を選択します。 [cite: 2]

---

<h1 id="chinese">🤖 WindowBuilder Bean Aligner (简体中文)</h1>

[cite_start]**WindowBuilder Bean Aligner** 是一款用于优化 WindowBuilder 设计画布的 Eclipse 插件。它可以根据您自定义的布局和排序偏好，自动排列“非可视化 Bean”（带有 `@wbp.nonvisual` 标记的组件）的图标。 [cite: 32, 43, 65]

## ✨ 主要功能
* [cite_start]**自动整列:** 瞬间将所有非可视化 Bean 图标排列成整齐的网格。 [cite: 13, 53, 56]
* [cite_start]**垂直换行:** 支持按固定行数换行，在进入下一列之前先垂直填充行。 [cite: 21, 54]
* [cite_start]**智能排序:** 支持按 **变量名**（字母顺序）或 **类类型** 进行排序，助您快速定位组件。 [cite: 23, 47, 48]
* [cite_start]**项目专属设置:** 可通过项目属性页为不同项目配置不同的起始坐标 (X, Y) 和间距 (Gap X, Gap Y)。 [cite: 66, 70, 73]
* [cite_start]**多语言支持:** UI 完全支持中文、英文和日文环境。 [cite: 1, 77, 80]

## 📥 安装方法
1. 在 Eclipse 中，前往 **Help (帮助)** > **Install New Software... (安装新软件...)**。
2. 点击 **Add... (添加...)**，在 Location (位置) 栏输入：
   `https://tatoo2018.github.io/jhappywindowbuilderutil/updatesite/main/`
3. 选择 **WindowBuilder Bean Aligner** 并按照提示完成安装，随后重启 Eclipse。

## 🚀 如何使用
1. 使用 **WindowBuilder 编辑器** 打开 Java 类。
2. 切换到 **Design (设计)** 选项卡（或保留在 **Source (源码)** 选项卡）。
3. [cite_start]在编辑器中右键点击，选择 **🤖 整列非可视化 Bean**。 [cite: 2]
