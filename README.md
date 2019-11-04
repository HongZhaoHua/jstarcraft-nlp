# JStarCraft RNS

****

[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)
[![Total lines](https://tokei.rs/b1/github/HongZhaoHua/jstarcraft-nlp?category=lines)](https://tokei.rs/b1/github/HongZhaoHua/jstarcraft-nlp?category=lines)

希望路过的同学,顺手给JStarCraft框架点个Star,算是对作者的一种鼓励吧!

****

## 目录

* [介绍](#介绍)
* [特性](#特性)
* [安装](#安装)
    * [安装JStarCraft Core框架](#安装JStarCraft-Core框架)
    * [安装JStarCraft AI框架](#安装JStarCraft-AI框架)
    * [安装JStarCraft NLP引擎](#安装JStarCraft-NLP引擎)
* [使用](#使用)
* [架构](#架构)
* [概念](#概念)
* [示例](#示例)
* [对比](#对比)
* [版本](#版本)
* [参考](#参考)
* [协议](#协议)
* [作者](#作者)
* [致谢](#致谢)

****

## 介绍

**JStarCraft NLP是一个面向自然语言处理领域的轻量级引擎.遵循Apache 2.0协议.**

****

## 特性

* 1.文本相关性
    * 词语相关性
    * 短语相关性
    * 句子相关性
    * 文档相关性
* 2.文本哈希
    * 局部敏感哈希
    * 布隆过滤器
* 3.词法分析(Lexical Analysis)
    * 分词
    * 词性标注
* 4.句法分析(Sentence Analysis)
    * 句法结构分析
    * 依存关系分析
* 5.语义分析(Semantic Analysis)
* 6.信息抽取(Information Extraction)
    * 实体抽取(Entity Extraction)
    * 关系抽取(Relation Extraction)
    * 事件抽取(Event Extraction)
* 7.文本聚类
* 8.文本分类

****

## 安装

JStarCraft RNS要求使用者具备以下环境:
* JDK 8或者以上
* Maven 3

#### 安装JStarCraft-Core框架

```shell
git clone https://github.com/HongZhaoHua/jstarcraft-core.git

mvn install -Dmaven.test.skip=true
```

#### 安装JStarCraft-AI框架

```shell
git clone https://github.com/HongZhaoHua/jstarcraft-ai.git

mvn install -Dmaven.test.skip=true
```

####  安装JStarCraft-NLP引擎

```shell
git clone https://github.com/HongZhaoHua/jstarcraft-nlp.git

mvn install -Dmaven.test.skip=true
```

****

## 使用

#### 设置依赖

* 设置Maven依赖

```maven
<dependency>
    <groupId>com.jstarcraft</groupId>
    <artifactId>nlp</artifactId>
    <version>1.0</version>
</dependency>
```

* 设置Gradle依赖

```gradle
compile group: 'com.jstarcraft', name: 'nlp', version: '1.0'
```

****

## 架构

****

## 概念

****

## 示例

****

## 对比

****

## 版本

****

## 参考

****

## 协议

JStarCraft NLP遵循[Apache 2.0协议](https://www.apache.org/licenses/LICENSE-2.0.html),一切以其为基础的衍生作品均属于衍生作品的作者.

****

## 作者

| 作者 | 洪钊桦 |
| :----: | :----: |
| E-mail | 110399057@qq.com, jstarcraft@gmail.com |

****

## 致谢

****

