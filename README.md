# 🤖 WindowBuilder Bean Aligner (JHappy WBUtil)

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Eclipse](https://img.shields.io/badge/Eclipse-Plugin-purple.svg)](https://www.eclipse.org/)
[![WindowBuilder](https://img.shields.io/badge/WindowBuilder-Compatible-blue.svg)](https://www.eclipse.org/windowbuilder/)

*[Read this in [Japanese (日本語)](#日本語) | [Chinese (简体中文)](#chinese)]*

**WindowBuilder Bean Aligner** is an Eclipse plugin designed to keep your WindowBuilder design canvas organized. It automatically rearranges the icons of "Non-Visual Beans" (components marked with `@wbp.nonvisual`) based on your customizable layout and sorting preferences. 

## ✨ Key Features
**Auto-Alignment:** Instantly repositions all non-visual bean icons into a clean grid. 
**Vertical/Horizontal Wrapping:** Supports wrapping by a fixed number of rows, filling columns vertically before moving to the next column. 
**Smart Sorting:** Sort beans alphabetically by **Field Name** or by **Class Type** to find your components faster. 
**Project-Specific Settings:** Configure different layout coordinates (X, Y) and spacing (Gap X, Gap Y) for each project via Property Pages. 
**Multilingual UI:** Fully supports English, Japanese, and Chinese environments. 

<a href="https://www.youtube.com/watch?v=Dg_lI96hBig" style="width:500px;display:block;">
  <img src="https://img.youtube.com/vi/Dg_lI96hBig/0.jpg" alt="Watch the video" style="width:400px; max-width:500px;">
</a>

[Click here to watch](https://www.youtube.com/watch?v=Dg_lI96hBig)

## 📥 Installation

1. In Eclipse, go to **Help** > **Install New Software...**.
2. Click the **Add...** button.
3. Enter `JHappy WBUtil` in the Name field and paste the following URL into the Location field:
   `https://tatoo2018.github.io/jhappywindowbuilderutil/updatesite/main/`
4. Select **WindowBuilder Bean Aligner** from the list and follow the prompts.
5. Restart Eclipse to complete the installation.

## 🚀 How to Use
1. Open a Java class with the **WindowBuilder Editor**.
2. Switch to the **Source** tab.
3. Right-click anywhere in the editor and select **🤖 Align Non-Visual Beans**. 
4. The `@wbp.nonvisual` Javadoc tags in your source code will be updated with new `location` coordinates. 

## ⚙️ Configuration
Right-click your project in the Project Explorer and select **Properties** > **WindowBuilder Bean Sort Property**. 
You can adjust:
**Starting Coordinates:** Where the first icon appears. 
**Spacing:** Horizontal and vertical gaps between icons. 
**Rows before Wrapping:** How many icons to stack vertically before starting a new column. 
**Sort Strategy:** Field Name or Class Name. 

## 📄 License & Credits
* This project is licensed under the **MIT License**.
It utilizes libraries from the Eclipse Foundation licensed under the **EPL-2.0**. 
* The icon `icons/ChooseComponent.gif` is redistributable from the official [Eclipse WindowBuilder repository](https://github.com/eclipse-windowbuilder/windowbuilder) under the EPL-2.0.

---

<h1 id="日本語">🤖 WindowBuilder Bean Aligner (日本語)</h1>

**WindowBuilder Bean Aligner** は、WindowBuilderエディタの非可視コンポーネント（`@wbp.nonvisual`）の配置を劇的に整理するプラグインです。アイコンが重なって見えなくなったBeanを、設定したルールに基づいて一括整列させます。 

## ✨ 主な機能
**一括整列:** デザイン画面上の非可視Beanアイコンを、綺麗なグリッド状に再配置します。 
**柔軟な折り返し:** 指定した「行数」に達すると次の列へ移動する垂直優先レイアウトを採用。 
**高度なソート:** 「変数名順」または「クラス型順」で並び替えが可能。 
**プロジェクト別設定:** プロジェクトの「プロパティ」から、開始座標、間隔、整列ルールを個別に保存できます。 
**多言語対応:** メニュー、設定画面ともに日本語・英語・中国語に対応しています。 


<a href="https://www.youtube.com/watch?v=Dg_lI96hBig" style="width:500px;display:block;">
  <img src="https://img.youtube.com/vi/Dg_lI96hBig/0.jpg" alt="Watch the video" style="width:400px; max-width:500px;">
</a>

[Click here to watch a video on YouTube](https://www.youtube.com/watch?v=Dg_lI96hBig)

## 📥 インストール方法
1. Eclipseを起動し、 **[ヘルプ]** > **[新規ソフトウェアのインストール...]** を選択します。
2. **[追加...]** をクリックし、ロケーションに以下を入力します：
   `https://tatoo2018.github.io/jhappywindowbuilderutil/updatesite/main/`
3. **WindowBuilder Bean Aligner** を選択してインストールし、Eclipseを再起動してください。

## 🚀 使い方
1. WindowBuilderエディタでJavaファイルを開きます。
2. **[Source]** タブで右クリックします。
3. **🤖 Non-Visual Beanを整列** を選択します。 

---

<h1 id="chinese">🤖 WindowBuilder Bean Aligner (简体中文)</h1>

**WindowBuilder Bean Aligner** 是一款用于优化 WindowBuilder 设计画布的 Eclipse 插件。它可以根据您自定义的布局和排序偏好，自动排列“非可视化 Bean”（带有 `@wbp.nonvisual` 标记的组件）的图标。 

## ✨ 主要功能
**自动整列:** 瞬间将所有非可视化 Bean 图标排列成整齐的网格。 
**垂直换行:** 支持按固定行数换行，在进入下一列之前先垂直填充行。 
**智能排序:** 支持按 **变量名**（字母顺序）或 **类类型** 进行排序，助您快速定位组件。
**项目专属设置:** 可通过项目属性页为不同项目配置不同的起始坐标 (X, Y) 和间距 (Gap X, Gap Y)。
**多语言支持:** UI 完全支持中文、英文和日文环境。 

<a href="https://www.youtube.com/watch?v=Dg_lI96hBig" style="width:500px;display:block;">
  <img src="https://img.youtube.com/vi/Dg_lI96hBig/0.jpg" alt="Watch the video" style="width:400px; max-width:500px;">
</a>

[Click here to watch a video on YouTube](https://www.youtube.com/watch?v=Dg_lI96hBig)

## 📥 安装方法
1. 在 Eclipse 中，前往 **Help (帮助)** > **Install New Software... (安装新软件...)**。
2. 点击 **Add... (添加...)**，在 Location (位置) 栏输入：
   `https://tatoo2018.github.io/jhappywindowbuilderutil/updatesite/main/`
3. 选择 **WindowBuilder Bean Aligner** 并按照提示完成安装，随后重启 Eclipse。

## 🚀 如何使用
1. 使用 **WindowBuilder 编辑器** 打开 Java 类。
2. 切换到 **Source (源码)** 选项卡
3. 在编辑器中右键点击，选择 **🤖 整列非可视化 Bean**。 
