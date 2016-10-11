---
title: JAVA中的GUI技术
tags: AWT,Swing,SWT
grammar_cjkRuby: true
---
# AWT
* AWT（Abstract Window Toolkit）抽象窗口工具包库，包含于所有的Java SDK中。
## 优点
* 更少的启动事件，响应速度快，占用内存小。
* 比较稳定。
## 缺点
* 组件类型少。AWT组件满足最大公约数原则，也就是说只拥有所有平台上都支持的组件。无法获取表或树等高级组件。
* 组件特性少。比如按钮不支持图片附着。
* 没有扩展性。
* 不支持look and feel。


# Swing
* Swing的一些底层类是借用了AWT的Component、Container、Window等少数几个基础类。
* Swing是纯JAVA实现的，而SWT和AWT是Java和JNI的混合。
## 优点
* 丰富的组件类型。
* 丰富的组件特性。
*   Swing拥有很好的Look And Feel支持。Swing遵循MVC模式，这种方式是其允许分离组件视图和它的数据模型。（UIManager.setLookAndFeel）
*   2D 编程。
*   可扩展性和灵活性。它提供了许多扩展组件的方法。让我们来列举一下：
   A.继承已有组件；
   B.靠复合组件的方式扩展；
   C.从零开始使用JComponent编写自定义组件；
   D.使用渲染器和编辑器机制扩展复制的Swing组件，如JList，JComboBox，JTable，JTree等；
   E.基于已有Look And Feel 或从零开始创建新的Look And Feel；
  F.使用LayeredPane，GlassPane或拖放机制开发高级的组件，例如浮动的固定组件，自定义弹出窗口，自定义菜单等。
  ## 缺点
  消耗更多内存，加载速度慢。在运行时装载了大量的类。
# SWT
IBM Eclipse开源项目的SWT（Standard Widget Toolkit）标准窗口部件库，不包含于JDK中。
## 优点
* 丰富的组件类型。
*  相对丰富的组件特性。
*  更快的响应时间。由于SWT组件包装了本地组件，由操作系统实现渲染。
*  更少的内存消耗。
## 缺点
*  非Windows平台下性能不好。
*  不属于标准类库。
*  没有look and feel支持。
*  不能扩展。
# 小结
  类别 | 组件类型|组件特性
------------- | ------------- | -------------
AWT |最大公约数|最大公约数
Swing | 最大公约数|最小公倍数
SWT | 最小公倍数|最小公倍数

## 差异补充：
* AWT和SWT都持有对本地组件的引用，但是释放内存的方法不一样。前者是绝大多数资源管理任务交给系统，这种方式实现比较复杂；后者需要显式调用dispose方法释放。
* SWT和Swing都使用了模拟。前者只模拟平台缺失的组件。
* 将组件捆绑在操作系统上，有其优势和劣势。其中的一个劣势是它们不支持可插拔的Look And Feel。
