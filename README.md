# JStarCraft NLP

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
    * [设置依赖](#设置依赖)
    * [配置第三方框架](#配置第三方框架)
        * [配置Ansj](#配置Ansj)
        * [配置Stanford CoreNLP](#配置Stanford-CoreNLP)
        * [配置HanLP](#配置HanLP)
        * [配置IK](#配置IK)
        * [配置Jcseg](#配置Jcseg)
        * [配置jieba](#配置jieba)
        * [配置MMSEG](#配置MMSEG)
        * [配置MYNLP](#配置MYNLP)
        * [配置THULAC](#配置THULAC)
        * [配置word](#配置word)
    * 分词
    * 词性识别
* [架构](#架构)
* [概念](#概念)
    * [信息熵](#信息熵)
    * [互信息](#互信息)
* [示例](#示例)
* [对比](#对比)
* [版本](#版本)
* [参考](#参考)
    * [词性标注集](#词性标注集)
    * [语种检测](#语种检测)
* [协议](#协议)
* [作者](#作者)
* [致谢](#致谢)

****

## 介绍

**JStarCraft NLP是一个面向自然语言处理领域的轻量级引擎.遵循Apache 2.0协议.**

专注于解决自然语言处理领域的几个核心问题:
* 词法分析
* 句法分析
* 语义分析
* 信息抽取
* 文本聚类
* 文本分类

涵盖了多种自然语言处理算法,整合了多个自然语言处理框架.为相关领域的研发人员提供提供满足工业级别场景要求的通用设计与参考实现,普及自然语言处理在Java领域的应用.

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
    * [语种检测(Language Detection)](#语种检测)
    * 实体抽取(Entity Extraction)
    * 关系抽取(Relation Extraction)
    * 事件抽取(Event Extraction)
* 7.文本聚类
* 8.文本分类
* 9.兼容Lucene,Solr,ElasticSearch
* 10.整合第三方框架
    * Ansj
    * Stanford CoreNLP
    * HanLP
    * IK
    * Jcseg
    * jieba
    * MMSEG
    * MYNLP
    * THULAC
    * word

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

#### 配置第三方框架

###### 配置Ansj

| 名称 | 功能 | 默认值 |
| :----: | :----: | :----: |
| 名称 | 功能 | 默认值 |

###### 配置Stanford-CoreNLP

| 名称 | 功能 | 默认值 |
| :----: | :----: | :----: |
| 名称 | 功能 | 默认值 |

###### 配置HanLP

| 名称 | 功能 | 默认值 |
| :----: | :----: | :----: |
| 名称 | 功能 | 默认值 |

###### 配置IK

| 名称 | 功能 | 默认值 |
| :----: | :----: | :----: |
| 名称 | 功能 | 默认值 |

###### 配置Jcseg

| 名称 | 功能 | 默认值 |
| :----: | :----: | :----: |
| 名称 | 功能 | 默认值 |

###### 配置jieba

| 名称 | 功能 | 默认值 |
| :----: | :----: | :----: |
| 名称 | 功能 | 默认值 |

###### 配置MMSEG

| 名称 | 功能 | 默认值 |
| :----: | :----: | :----: |
| 名称 | 功能 | 默认值 |

###### 配置MYNLP

| 名称 | 功能 | 默认值 |
| :----: | :----: | :----: |
| 名称 | 功能 | 默认值 |

###### 配置THULAC

| 名称 | 功能 | 默认值 |
| :----: | :----: | :----: |
| 名称 | 功能 | 默认值 |

###### 配置word

| 名称 | 功能 | 默认值 |
| :----: | :----: | :----: |
| 名称 | 功能 | 默认值 |

****

## 架构

****

## 概念

#### 信息熵

**信息熵(Information Entropy)**是指某个片段外部搭配的丰富程度;

#### 互信息

**互信息(Mutual Information)**是指某个片段内部搭配的固定程度;

****

## 示例

****

## 对比

****

## 版本

****

## 参考

#### 词性标注集

| 代码 | 名称 | 词类 | 说明 |
| :----: | :----: | :----: | :----: |
| A | 形容词 | 实词 | 取英语形容词adjective的第1个字母 |
| C | 连词 | 虚词 | 取英语连词conjunction的第1个字母 |
| D | 副词 | 虚词 | 取英语副词adverb的第2个字母 |
| E | 叹词 | 虚词 | 取英语叹词exclamation的第1个字母 |
| M | 数词 | 实词 | 取英语数词numeral的第3个字母 |
| N | 名词 | 实词 | 取英语名词noun的第1个字母 |
| O | 拟声词 | 虚词 | 取英语拟声词onomatopoeia的第1个字母 |
| P | 介词 | 虚词 | 取英语拟声词onomatopoeia的第1个字母 |
| Q | 量词 | 实词 | 取英语量词quantity的第1个字母 |
| R | 代词 | 实词 | 取英语代词pronoun的第2个字母 |
| T | 冠词 | 虚词 | 取英语冠词article的第3个字母 |
| U | 助词 | 虚词 | 取英语助词auxiliary的第2个字母 |
| V | 动词 | 实词 | 取英语动词verb的第1个字母 |
| W | 标点符号 |  |  |
| X | 未知 |  |  |

#### 语种检测

| 编码 | 名称 |
| :----: | :----: |
| [`cmn`](http://www-01.sil.org/iso639-3/documentation.asp?id=cmn) | Mandarin Chinese |
| [`spa`](http://www-01.sil.org/iso639-3/documentation.asp?id=spa) | Spanish |
| [`eng`](http://www-01.sil.org/iso639-3/documentation.asp?id=eng) | English |
| [`rus`](http://www-01.sil.org/iso639-3/documentation.asp?id=rus) | Russian |
| [`arb`](http://www-01.sil.org/iso639-3/documentation.asp?id=arb) | Standard Arabic |
| [`ben`](http://www-01.sil.org/iso639-3/documentation.asp?id=ben) | Bengali |
| [`hin`](http://www-01.sil.org/iso639-3/documentation.asp?id=hin) | Hindi |
| [`por`](http://www-01.sil.org/iso639-3/documentation.asp?id=por) | Portuguese |
| [`ind`](http://www-01.sil.org/iso639-3/documentation.asp?id=ind) | Indonesian |
| [`jpn`](http://www-01.sil.org/iso639-3/documentation.asp?id=jpn) | Japanese |
| [`fra`](http://www-01.sil.org/iso639-3/documentation.asp?id=fra) | French |
| [`deu`](http://www-01.sil.org/iso639-3/documentation.asp?id=deu) | German |
| [`jav`](http://www-01.sil.org/iso639-3/documentation.asp?id=jav) | Javanese |
| [`kor`](http://www-01.sil.org/iso639-3/documentation.asp?id=kor) | Korean |
| [`tel`](http://www-01.sil.org/iso639-3/documentation.asp?id=tel) | Telugu |
| [`vie`](http://www-01.sil.org/iso639-3/documentation.asp?id=vie) | Vietnamese |
| [`mar`](http://www-01.sil.org/iso639-3/documentation.asp?id=mar) | Marathi |
| [`ita`](http://www-01.sil.org/iso639-3/documentation.asp?id=ita) | Italian |
| [`tam`](http://www-01.sil.org/iso639-3/documentation.asp?id=tam) | Tamil |
| [`tur`](http://www-01.sil.org/iso639-3/documentation.asp?id=tur) | Turkish |
| [`urd`](http://www-01.sil.org/iso639-3/documentation.asp?id=urd) | Urdu |
| [`guj`](http://www-01.sil.org/iso639-3/documentation.asp?id=guj) | Gujarati |
| [`pol`](http://www-01.sil.org/iso639-3/documentation.asp?id=pol) | Polish |
| [`ukr`](http://www-01.sil.org/iso639-3/documentation.asp?id=ukr) | Ukrainian |
| [`fas`](http://www-01.sil.org/iso639-3/documentation.asp?id=fas) | Persian |
| [`kan`](http://www-01.sil.org/iso639-3/documentation.asp?id=kan) | Kannada |
| [`mai`](http://www-01.sil.org/iso639-3/documentation.asp?id=mai) | Maithili |
| [`mal`](http://www-01.sil.org/iso639-3/documentation.asp?id=mal) | Malayalam |
| [`mya`](http://www-01.sil.org/iso639-3/documentation.asp?id=mya) | Burmese |
| [`ori`](http://www-01.sil.org/iso639-3/documentation.asp?id=ori) | Oriya (macrolanguage) |
| [`gax`](http://www-01.sil.org/iso639-3/documentation.asp?id=gax) | Borana-Arsi-Guji Oromo |
| [`swh`](http://www-01.sil.org/iso639-3/documentation.asp?id=swh) | Swahili (individual language) |
| [`sun`](http://www-01.sil.org/iso639-3/documentation.asp?id=sun) | Sundanese |
| [`ron`](http://www-01.sil.org/iso639-3/documentation.asp?id=ron) | Romanian |
| [`pan`](http://www-01.sil.org/iso639-3/documentation.asp?id=pan) | Panjabi |
| [`bho`](http://www-01.sil.org/iso639-3/documentation.asp?id=bho) | Bhojpuri |
| [`amh`](http://www-01.sil.org/iso639-3/documentation.asp?id=amh) | Amharic |
| [`hau`](http://www-01.sil.org/iso639-3/documentation.asp?id=hau) | Hausa |
| [`fuv`](http://www-01.sil.org/iso639-3/documentation.asp?id=fuv) | Nigerian Fulfulde |
| [`bos`](http://www-01.sil.org/iso639-3/documentation.asp?id=bos) | Bosnian (Cyrillic) |
| [`bos`](http://www-01.sil.org/iso639-3/documentation.asp?id=bos) | Bosnian (Latin) |
| [`hrv`](http://www-01.sil.org/iso639-3/documentation.asp?id=hrv) | Croatian |
| [`nld`](http://www-01.sil.org/iso639-3/documentation.asp?id=nld) | Dutch |
| [`srp`](http://www-01.sil.org/iso639-3/documentation.asp?id=srp) | Serbian (Cyrillic) |
| [`srp`](http://www-01.sil.org/iso639-3/documentation.asp?id=srp) | Serbian (Latin) |
| [`tha`](http://www-01.sil.org/iso639-3/documentation.asp?id=tha) | Thai |
| [`ckb`](http://www-01.sil.org/iso639-3/documentation.asp?id=ckb) | Central Kurdish |
| [`yor`](http://www-01.sil.org/iso639-3/documentation.asp?id=yor) | Yoruba |
| [`uzn`](http://www-01.sil.org/iso639-3/documentation.asp?id=uzn) | Northern Uzbek (Cyrillic) |
| [`uzn`](http://www-01.sil.org/iso639-3/documentation.asp?id=uzn) | Northern Uzbek (Latin) |
| [`zlm`](http://www-01.sil.org/iso639-3/documentation.asp?id=zlm) | Malay (individual language) (Arabic) |
| [`zlm`](http://www-01.sil.org/iso639-3/documentation.asp?id=zlm) | Malay (individual language) (Latin) |
| [`ibo`](http://www-01.sil.org/iso639-3/documentation.asp?id=ibo) | Igbo |
| [`nep`](http://www-01.sil.org/iso639-3/documentation.asp?id=nep) | Nepali (macrolanguage) |
| [`ceb`](http://www-01.sil.org/iso639-3/documentation.asp?id=ceb) | Cebuano |
| [`skr`](http://www-01.sil.org/iso639-3/documentation.asp?id=skr) | Saraiki |
| [`tgl`](http://www-01.sil.org/iso639-3/documentation.asp?id=tgl) | Tagalog |
| [`hun`](http://www-01.sil.org/iso639-3/documentation.asp?id=hun) | Hungarian |
| [`azj`](http://www-01.sil.org/iso639-3/documentation.asp?id=azj) | North Azerbaijani (Cyrillic) |
| [`azj`](http://www-01.sil.org/iso639-3/documentation.asp?id=azj) | North Azerbaijani (Latin) |
| [`sin`](http://www-01.sil.org/iso639-3/documentation.asp?id=sin) | Sinhala |
| [`koi`](http://www-01.sil.org/iso639-3/documentation.asp?id=koi) | Komi-Permyak |
| [`ell`](http://www-01.sil.org/iso639-3/documentation.asp?id=ell) | Modern Greek (1453-) |
| [`ces`](http://www-01.sil.org/iso639-3/documentation.asp?id=ces) | Czech |
| [`run`](http://www-01.sil.org/iso639-3/documentation.asp?id=run) | Rundi |
| [`bel`](http://www-01.sil.org/iso639-3/documentation.asp?id=bel) | Belarusian |
| [`plt`](http://www-01.sil.org/iso639-3/documentation.asp?id=plt) | Plateau Malagasy |
| [`qug`](http://www-01.sil.org/iso639-3/documentation.asp?id=qug) | Chimborazo Highland Quichua |
| [`mad`](http://www-01.sil.org/iso639-3/documentation.asp?id=mad) | Madurese |
| [`nya`](http://www-01.sil.org/iso639-3/documentation.asp?id=nya) | Nyanja |
| [`zyb`](http://www-01.sil.org/iso639-3/documentation.asp?id=zyb) | Yongbei Zhuang |
| [`pbu`](http://www-01.sil.org/iso639-3/documentation.asp?id=pbu) | Northern Pashto |
| [`kin`](http://www-01.sil.org/iso639-3/documentation.asp?id=kin) | Kinyarwanda |
| [`zul`](http://www-01.sil.org/iso639-3/documentation.asp?id=zul) | Zulu |
| [`bul`](http://www-01.sil.org/iso639-3/documentation.asp?id=bul) | Bulgarian |
| [`swe`](http://www-01.sil.org/iso639-3/documentation.asp?id=swe) | Swedish |
| [`lin`](http://www-01.sil.org/iso639-3/documentation.asp?id=lin) | Lingala |
| [`som`](http://www-01.sil.org/iso639-3/documentation.asp?id=som) | Somali |
| [`hms`](http://www-01.sil.org/iso639-3/documentation.asp?id=hms) | Southern Qiandong Miao |
| [`hnj`](http://www-01.sil.org/iso639-3/documentation.asp?id=hnj) | Hmong Njua |
| [`ilo`](http://www-01.sil.org/iso639-3/documentation.asp?id=ilo) | Iloko |
| [`kaz`](http://www-01.sil.org/iso639-3/documentation.asp?id=kaz) | Kazakh |
| [`uig`](http://www-01.sil.org/iso639-3/documentation.asp?id=uig) | Uighur (Arabic) |
| [`uig`](http://www-01.sil.org/iso639-3/documentation.asp?id=uig) | Uighur (Latin) |
| [`hat`](http://www-01.sil.org/iso639-3/documentation.asp?id=hat) | Haitian |
| [`khm`](http://www-01.sil.org/iso639-3/documentation.asp?id=khm) | Khmer |
| [`aka`](http://www-01.sil.org/iso639-3/documentation.asp?id=aka) | Akan |
| [`hil`](http://www-01.sil.org/iso639-3/documentation.asp?id=hil) | Hiligaynon |
| [`sna`](http://www-01.sil.org/iso639-3/documentation.asp?id=sna) | Shona |
| [`tat`](http://www-01.sil.org/iso639-3/documentation.asp?id=tat) | Tatar |
| [`xho`](http://www-01.sil.org/iso639-3/documentation.asp?id=xho) | Xhosa |
| [`hye`](http://www-01.sil.org/iso639-3/documentation.asp?id=hye) | Armenian |
| [`min`](http://www-01.sil.org/iso639-3/documentation.asp?id=min) | Minangkabau |
| [`afr`](http://www-01.sil.org/iso639-3/documentation.asp?id=afr) | Afrikaans |
| [`lua`](http://www-01.sil.org/iso639-3/documentation.asp?id=lua) | Luba-Lulua |
| [`sat`](http://www-01.sil.org/iso639-3/documentation.asp?id=sat) | Santali |
| [`bod`](http://www-01.sil.org/iso639-3/documentation.asp?id=bod) | Tibetan |
| [`tir`](http://www-01.sil.org/iso639-3/documentation.asp?id=tir) | Tigrinya |
| [`fin`](http://www-01.sil.org/iso639-3/documentation.asp?id=fin) | Finnish |
| [`slk`](http://www-01.sil.org/iso639-3/documentation.asp?id=slk) | Slovak |
| [`tuk`](http://www-01.sil.org/iso639-3/documentation.asp?id=tuk) | Turkmen (Cyrillic) |
| [`tuk`](http://www-01.sil.org/iso639-3/documentation.asp?id=tuk) | Turkmen (Latin) |
| [`dan`](http://www-01.sil.org/iso639-3/documentation.asp?id=dan) | Danish |
| [`nob`](http://www-01.sil.org/iso639-3/documentation.asp?id=nob) | Norwegian Bokmål |
| [`suk`](http://www-01.sil.org/iso639-3/documentation.asp?id=suk) | Sukuma |
| [`als`](http://www-01.sil.org/iso639-3/documentation.asp?id=als) | Tosk Albanian |
| [`sag`](http://www-01.sil.org/iso639-3/documentation.asp?id=sag) | Sango |
| [`nno`](http://www-01.sil.org/iso639-3/documentation.asp?id=nno) | Norwegian Nynorsk |
| [`heb`](http://www-01.sil.org/iso639-3/documentation.asp?id=heb) | Hebrew |
| [`mos`](http://www-01.sil.org/iso639-3/documentation.asp?id=mos) | Mossi |
| [`tgk`](http://www-01.sil.org/iso639-3/documentation.asp?id=tgk) | Tajik |
| [`cat`](http://www-01.sil.org/iso639-3/documentation.asp?id=cat) | Catalan |
| [`sot`](http://www-01.sil.org/iso639-3/documentation.asp?id=sot) | Southern Sotho |
| [`kat`](http://www-01.sil.org/iso639-3/documentation.asp?id=kat) | Georgian |
| [`bcl`](http://www-01.sil.org/iso639-3/documentation.asp?id=bcl) | Central Bikol |
| [`glg`](http://www-01.sil.org/iso639-3/documentation.asp?id=glg) | Galician |
| [`lao`](http://www-01.sil.org/iso639-3/documentation.asp?id=lao) | Lao |
| [`lit`](http://www-01.sil.org/iso639-3/documentation.asp?id=lit) | Lithuanian |
| [`umb`](http://www-01.sil.org/iso639-3/documentation.asp?id=umb) | Umbundu |
| [`tsn`](http://www-01.sil.org/iso639-3/documentation.asp?id=tsn) | Tswana |
| [`vec`](http://www-01.sil.org/iso639-3/documentation.asp?id=vec) | Venetian |
| [`nso`](http://www-01.sil.org/iso639-3/documentation.asp?id=nso) | Pedi |
| [`ban`](http://www-01.sil.org/iso639-3/documentation.asp?id=ban) | Balinese |
| [`bug`](http://www-01.sil.org/iso639-3/documentation.asp?id=bug) | Buginese |
| [`knc`](http://www-01.sil.org/iso639-3/documentation.asp?id=knc) | Central Kanuri |
| [`kng`](http://www-01.sil.org/iso639-3/documentation.asp?id=kng) | Koongo |
| [`ibb`](http://www-01.sil.org/iso639-3/documentation.asp?id=ibb) | Ibibio |
| [`lug`](http://www-01.sil.org/iso639-3/documentation.asp?id=lug) | Ganda |
| [`ace`](http://www-01.sil.org/iso639-3/documentation.asp?id=ace) | Achinese |
| [`bam`](http://www-01.sil.org/iso639-3/documentation.asp?id=bam) | Bambara |
| [`tzm`](http://www-01.sil.org/iso639-3/documentation.asp?id=tzm) | Central Atlas Tamazight |
| [`ydd`](http://www-01.sil.org/iso639-3/documentation.asp?id=ydd) | Eastern Yiddish |
| [`kmb`](http://www-01.sil.org/iso639-3/documentation.asp?id=kmb) | Kimbundu |
| [`lun`](http://www-01.sil.org/iso639-3/documentation.asp?id=lun) | Lunda |
| [`shn`](http://www-01.sil.org/iso639-3/documentation.asp?id=shn) | Shan |
| [`war`](http://www-01.sil.org/iso639-3/documentation.asp?id=war) | Waray (Philippines) |
| [`dyu`](http://www-01.sil.org/iso639-3/documentation.asp?id=dyu) | Dyula |
| [`wol`](http://www-01.sil.org/iso639-3/documentation.asp?id=wol) | Wolof |
| [`kir`](http://www-01.sil.org/iso639-3/documentation.asp?id=kir) | Kirghiz |
| [`nds`](http://www-01.sil.org/iso639-3/documentation.asp?id=nds) | Low German |
| [`fuf`](http://www-01.sil.org/iso639-3/documentation.asp?id=fuf) | Pular |
| [`mkd`](http://www-01.sil.org/iso639-3/documentation.asp?id=mkd) | Macedonian |
| [`vmw`](http://www-01.sil.org/iso639-3/documentation.asp?id=vmw) | Makhuwa |
| [`zgh`](http://www-01.sil.org/iso639-3/documentation.asp?id=zgh) | Standard Moroccan Tamazight |
| [`ewe`](http://www-01.sil.org/iso639-3/documentation.asp?id=ewe) | Ewe |
| [`khk`](http://www-01.sil.org/iso639-3/documentation.asp?id=khk) | Halh Mongolian |
| [`slv`](http://www-01.sil.org/iso639-3/documentation.asp?id=slv) | Slovenian |
| [`ayr`](http://www-01.sil.org/iso639-3/documentation.asp?id=ayr) | Central Aymara |
| [`bem`](http://www-01.sil.org/iso639-3/documentation.asp?id=bem) | Bemba (Zambia) |
| [`emk`](http://www-01.sil.org/iso639-3/documentation.asp?id=emk) | Eastern Maninkakan |
| [`bci`](http://www-01.sil.org/iso639-3/documentation.asp?id=bci) | Baoulé |
| [`bum`](http://www-01.sil.org/iso639-3/documentation.asp?id=bum) | Bulu (Cameroon) |
| [`epo`](http://www-01.sil.org/iso639-3/documentation.asp?id=epo) | Esperanto |
| [`pam`](http://www-01.sil.org/iso639-3/documentation.asp?id=pam) | Pampanga |
| [`tiv`](http://www-01.sil.org/iso639-3/documentation.asp?id=tiv) | Tiv |
| [`tpi`](http://www-01.sil.org/iso639-3/documentation.asp?id=tpi) | Tok Pisin |
| [`ven`](http://www-01.sil.org/iso639-3/documentation.asp?id=ven) | Venda |
| [`ssw`](http://www-01.sil.org/iso639-3/documentation.asp?id=ssw) | Swati |
| [`nyn`](http://www-01.sil.org/iso639-3/documentation.asp?id=nyn) | Nyankole |
| [`kbd`](http://www-01.sil.org/iso639-3/documentation.asp?id=kbd) | Kabardian |
| [`iii`](http://www-01.sil.org/iso639-3/documentation.asp?id=iii) | Sichuan Yi |
| [`yao`](http://www-01.sil.org/iso639-3/documentation.asp?id=yao) | Yao |
| [`lav`](http://www-01.sil.org/iso639-3/documentation.asp?id=lav) | Latvian |
| [`quz`](http://www-01.sil.org/iso639-3/documentation.asp?id=quz) | Cusco Quechua |
| [`src`](http://www-01.sil.org/iso639-3/documentation.asp?id=src) | Logudorese Sardinian |
| [`sco`](http://www-01.sil.org/iso639-3/documentation.asp?id=sco) | Scots |
| [`tso`](http://www-01.sil.org/iso639-3/documentation.asp?id=tso) | Tsonga |
| [`rmy`](http://www-01.sil.org/iso639-3/documentation.asp?id=rmy) | Vlax Romani |
| [`men`](http://www-01.sil.org/iso639-3/documentation.asp?id=men) | Mende (Sierra Leone) |
| [`fon`](http://www-01.sil.org/iso639-3/documentation.asp?id=fon) | Fon |
| [`nhn`](http://www-01.sil.org/iso639-3/documentation.asp?id=nhn) | Central Nahuatl |
| [`dip`](http://www-01.sil.org/iso639-3/documentation.asp?id=dip) | Northeastern Dinka |
| [`kde`](http://www-01.sil.org/iso639-3/documentation.asp?id=kde) | Makonde |
| [`snn`](http://www-01.sil.org/iso639-3/documentation.asp?id=snn) | Siona |
| [`kbp`](http://www-01.sil.org/iso639-3/documentation.asp?id=kbp) | Kabiyè |
| [`tem`](http://www-01.sil.org/iso639-3/documentation.asp?id=tem) | Timne |
| [`toi`](http://www-01.sil.org/iso639-3/documentation.asp?id=toi) | Tonga (Zambia) |
| [`est`](http://www-01.sil.org/iso639-3/documentation.asp?id=est) | Estonian |
| [`snk`](http://www-01.sil.org/iso639-3/documentation.asp?id=snk) | Soninke |
| [`cjk`](http://www-01.sil.org/iso639-3/documentation.asp?id=cjk) | Chokwe |
| [`ada`](http://www-01.sil.org/iso639-3/documentation.asp?id=ada) | Adangme |
| [`aii`](http://www-01.sil.org/iso639-3/documentation.asp?id=aii) | Assyrian Neo-Aramaic |
| [`quy`](http://www-01.sil.org/iso639-3/documentation.asp?id=quy) | Ayacucho Quechua |
| [`rmn`](http://www-01.sil.org/iso639-3/documentation.asp?id=rmn) | Balkan Romani |
| [`bin`](http://www-01.sil.org/iso639-3/documentation.asp?id=bin) | Bini |
| [`gaa`](http://www-01.sil.org/iso639-3/documentation.asp?id=gaa) | Ga |
| [`ndo`](http://www-01.sil.org/iso639-3/documentation.asp?id=ndo) | Ndonga |
| [`nym`](http://www-01.sil.org/iso639-3/documentation.asp?id=nym) | Nyamwezi |
| [`sus`](http://www-01.sil.org/iso639-3/documentation.asp?id=sus) | Susu |
| [`tly`](http://www-01.sil.org/iso639-3/documentation.asp?id=tly) | Talysh |
| [`srr`](http://www-01.sil.org/iso639-3/documentation.asp?id=srr) | Serer |
| [`kha`](http://www-01.sil.org/iso639-3/documentation.asp?id=kha) | Khasi |
| [`hea`](http://www-01.sil.org/iso639-3/documentation.asp?id=hea) | Northern Qiandong Miao |
| [`gkp`](http://www-01.sil.org/iso639-3/documentation.asp?id=gkp) | Guinea Kpelle |
| [`hni`](http://www-01.sil.org/iso639-3/documentation.asp?id=hni) | Hani |
| [`fry`](http://www-01.sil.org/iso639-3/documentation.asp?id=fry) | Western Frisian |
| [`yua`](http://www-01.sil.org/iso639-3/documentation.asp?id=yua) | Yucateco |
| [`fij`](http://www-01.sil.org/iso639-3/documentation.asp?id=fij) | Fijian |
| [`fur`](http://www-01.sil.org/iso639-3/documentation.asp?id=fur) | Friulian |
| [`tet`](http://www-01.sil.org/iso639-3/documentation.asp?id=tet) | Tetum |
| [`wln`](http://www-01.sil.org/iso639-3/documentation.asp?id=wln) | Walloon |
| [`eus`](http://www-01.sil.org/iso639-3/documentation.asp?id=eus) | Basque |
| [`oss`](http://www-01.sil.org/iso639-3/documentation.asp?id=oss) | Ossetian |
| [`nbl`](http://www-01.sil.org/iso639-3/documentation.asp?id=nbl) | South Ndebele |
| [`pov`](http://www-01.sil.org/iso639-3/documentation.asp?id=pov) | Upper Guinea Crioulo |
| [`cym`](http://www-01.sil.org/iso639-3/documentation.asp?id=cym) | Welsh |
| [`lus`](http://www-01.sil.org/iso639-3/documentation.asp?id=lus) | Lushai |
| [`dag`](http://www-01.sil.org/iso639-3/documentation.asp?id=dag) | Dagbani |
| [`dga`](http://www-01.sil.org/iso639-3/documentation.asp?id=dga) | Southern Dagaare |
| [`bre`](http://www-01.sil.org/iso639-3/documentation.asp?id=bre) | Breton |
| [`kek`](http://www-01.sil.org/iso639-3/documentation.asp?id=kek) | Kekchí |
| [`lij`](http://www-01.sil.org/iso639-3/documentation.asp?id=lij) | Ligurian |
| [`pcd`](http://www-01.sil.org/iso639-3/documentation.asp?id=pcd) | Picard |
| [`roh`](http://www-01.sil.org/iso639-3/documentation.asp?id=roh) | Romansh |
| [`bfa`](http://www-01.sil.org/iso639-3/documentation.asp?id=bfa) | Bari |
| [`kri`](http://www-01.sil.org/iso639-3/documentation.asp?id=kri) | Krio |
| [`cnh`](http://www-01.sil.org/iso639-3/documentation.asp?id=cnh) | Hakha Chin |
| [`lob`](http://www-01.sil.org/iso639-3/documentation.asp?id=lob) | Lobi |
| [`arn`](http://www-01.sil.org/iso639-3/documentation.asp?id=arn) | Mapudungun |
| [`bba`](http://www-01.sil.org/iso639-3/documentation.asp?id=bba) | Baatonum |
| [`dzo`](http://www-01.sil.org/iso639-3/documentation.asp?id=dzo) | Dzongkha |
| [`kea`](http://www-01.sil.org/iso639-3/documentation.asp?id=kea) | Kabuverdianu |
| [`sah`](http://www-01.sil.org/iso639-3/documentation.asp?id=sah) | Yakut |
| [`smo`](http://www-01.sil.org/iso639-3/documentation.asp?id=smo) | Samoan |
| [`koo`](http://www-01.sil.org/iso639-3/documentation.asp?id=koo) | Konzo |
| [`nzi`](http://www-01.sil.org/iso639-3/documentation.asp?id=nzi) | Nzima |
| [`maz`](http://www-01.sil.org/iso639-3/documentation.asp?id=maz) | Central Mazahua |
| [`pis`](http://www-01.sil.org/iso639-3/documentation.asp?id=pis) | Pijin |
| [`ctd`](http://www-01.sil.org/iso639-3/documentation.asp?id=ctd) | Tedim Chin |
| [`cos`](http://www-01.sil.org/iso639-3/documentation.asp?id=cos) | Corsican |
| [`ltz`](http://www-01.sil.org/iso639-3/documentation.asp?id=ltz) | Luxembourgish |
| [`lia`](http://www-01.sil.org/iso639-3/documentation.asp?id=lia) | West-Central Limba |
| [`mlt`](http://www-01.sil.org/iso639-3/documentation.asp?id=mlt) | Maltese |
| [`hna`](http://www-01.sil.org/iso639-3/documentation.asp?id=hna) | Mina (Cameroon) |
| [`zdj`](http://www-01.sil.org/iso639-3/documentation.asp?id=zdj) | Ngazidja Comorian |
| [`guc`](http://www-01.sil.org/iso639-3/documentation.asp?id=guc) | Wayuu |
| [`qwh`](http://www-01.sil.org/iso639-3/documentation.asp?id=qwh) | Huaylas Ancash Quechua |
| [`quc`](http://www-01.sil.org/iso639-3/documentation.asp?id=quc) | K'iche' |
| [`div`](http://www-01.sil.org/iso639-3/documentation.asp?id=div) | Dhivehi |
| [`isl`](http://www-01.sil.org/iso639-3/documentation.asp?id=isl) | Icelandic |
| [`kqn`](http://www-01.sil.org/iso639-3/documentation.asp?id=kqn) | Kaonde |
| [`pap`](http://www-01.sil.org/iso639-3/documentation.asp?id=pap) | Papiamento |
| [`gle`](http://www-01.sil.org/iso639-3/documentation.asp?id=gle) | Irish |
| [`dyo`](http://www-01.sil.org/iso639-3/documentation.asp?id=dyo) | Jola-Fonyi |
| [`hns`](http://www-01.sil.org/iso639-3/documentation.asp?id=hns) | Caribbean Hindustani |
| [`gjn`](http://www-01.sil.org/iso639-3/documentation.asp?id=gjn) | Gonja |
| [`njo`](http://www-01.sil.org/iso639-3/documentation.asp?id=njo) | Ao Naga |
| [`hus`](http://www-01.sil.org/iso639-3/documentation.asp?id=hus) | Huastec |
| [`mag`](http://www-01.sil.org/iso639-3/documentation.asp?id=mag) | Magahi |
| [`xsm`](http://www-01.sil.org/iso639-3/documentation.asp?id=xsm) | Kasem |
| [`ote`](http://www-01.sil.org/iso639-3/documentation.asp?id=ote) | Mezquital Otomi |
| [`qxn`](http://www-01.sil.org/iso639-3/documentation.asp?id=qxn) | Northern Conchucos Ancash Quechua |
| [`tyv`](http://www-01.sil.org/iso639-3/documentation.asp?id=tyv) | Tuvinian |
| [`gag`](http://www-01.sil.org/iso639-3/documentation.asp?id=gag) | Gagauz |
| [`san`](http://www-01.sil.org/iso639-3/documentation.asp?id=san) | Sanskrit |
| [`shk`](http://www-01.sil.org/iso639-3/documentation.asp?id=shk) | Shilluk |
| [`nba`](http://www-01.sil.org/iso639-3/documentation.asp?id=nba) | Nyemba |
| [`miq`](http://www-01.sil.org/iso639-3/documentation.asp?id=miq) | Mískito |
| [`mam`](http://www-01.sil.org/iso639-3/documentation.asp?id=mam) | Mam |
| [`tah`](http://www-01.sil.org/iso639-3/documentation.asp?id=tah) | Tahitian |
| [`nav`](http://www-01.sil.org/iso639-3/documentation.asp?id=nav) | Navajo |
| [`ami`](http://www-01.sil.org/iso639-3/documentation.asp?id=ami) | Amis |
| [`lot`](http://www-01.sil.org/iso639-3/documentation.asp?id=lot) | Otuho |
| [`cak`](http://www-01.sil.org/iso639-3/documentation.asp?id=cak) | Kaqchikel |
| [`tzh`](http://www-01.sil.org/iso639-3/documentation.asp?id=tzh) | Tzeltal |
| [`tzo`](http://www-01.sil.org/iso639-3/documentation.asp?id=tzo) | Tzotzil |
| [`lns`](http://www-01.sil.org/iso639-3/documentation.asp?id=lns) | Lamnso' |
| [`ton`](http://www-01.sil.org/iso639-3/documentation.asp?id=ton) | Tonga (Tonga Islands) |
| [`tbz`](http://www-01.sil.org/iso639-3/documentation.asp?id=tbz) | Ditammari |
| [`lad`](http://www-01.sil.org/iso639-3/documentation.asp?id=lad) | Ladino |
| [`vai`](http://www-01.sil.org/iso639-3/documentation.asp?id=vai) | Vai |
| [`mto`](http://www-01.sil.org/iso639-3/documentation.asp?id=mto) | Totontepec Mixe |
| [`ady`](http://www-01.sil.org/iso639-3/documentation.asp?id=ady) | Adyghe |
| [`abk`](http://www-01.sil.org/iso639-3/documentation.asp?id=abk) | Abkhazian |
| [`ast`](http://www-01.sil.org/iso639-3/documentation.asp?id=ast) | Asturian |
| [`tsz`](http://www-01.sil.org/iso639-3/documentation.asp?id=tsz) | Purepecha |
| [`swb`](http://www-01.sil.org/iso639-3/documentation.asp?id=swb) | Maore Comorian |
| [`cab`](http://www-01.sil.org/iso639-3/documentation.asp?id=cab) | Garifuna |
| [`krl`](http://www-01.sil.org/iso639-3/documentation.asp?id=krl) | Karelian |
| [`zam`](http://www-01.sil.org/iso639-3/documentation.asp?id=zam) | Miahuatlán Zapotec |
| [`top`](http://www-01.sil.org/iso639-3/documentation.asp?id=top) | Papantla Totonac |
| [`cha`](http://www-01.sil.org/iso639-3/documentation.asp?id=cha) | Chamorro |
| [`crs`](http://www-01.sil.org/iso639-3/documentation.asp?id=crs) | Seselwa Creole French |
| [`ddn`](http://www-01.sil.org/iso639-3/documentation.asp?id=ddn) | Dendi (Benin) |
| [`loz`](http://www-01.sil.org/iso639-3/documentation.asp?id=loz) | Lozi |
| [`mri`](http://www-01.sil.org/iso639-3/documentation.asp?id=mri) | Maori |
| [`hsb`](http://www-01.sil.org/iso639-3/documentation.asp?id=hsb) | Upper Sorbian |
| [`cri`](http://www-01.sil.org/iso639-3/documentation.asp?id=cri) | Sãotomense |
| [`pbb`](http://www-01.sil.org/iso639-3/documentation.asp?id=pbb) | Páez |
| [`alt`](http://www-01.sil.org/iso639-3/documentation.asp?id=alt) | Southern Altai |
| [`qva`](http://www-01.sil.org/iso639-3/documentation.asp?id=qva) | Ambo-Pasco Quechua |
| [`mxv`](http://www-01.sil.org/iso639-3/documentation.asp?id=mxv) | Metlatónoc Mixtec |
| [`gla`](http://www-01.sil.org/iso639-3/documentation.asp?id=gla) | Scottish Gaelic |
| [`kjh`](http://www-01.sil.org/iso639-3/documentation.asp?id=kjh) | Khakas |
| [`csw`](http://www-01.sil.org/iso639-3/documentation.asp?id=csw) | Swampy Cree |
| [`qvm`](http://www-01.sil.org/iso639-3/documentation.asp?id=qvm) | Margos-Yarowilca-Lauricocha Quechua |
| [`fao`](http://www-01.sil.org/iso639-3/documentation.asp?id=fao) | Faroese |
| [`kal`](http://www-01.sil.org/iso639-3/documentation.asp?id=kal) | Kalaallisut |
| [`cni`](http://www-01.sil.org/iso639-3/documentation.asp?id=cni) | Asháninka |
| [`chk`](http://www-01.sil.org/iso639-3/documentation.asp?id=chk) | Chuukese |
| [`mah`](http://www-01.sil.org/iso639-3/documentation.asp?id=mah) | Marshallese |
| [`rar`](http://www-01.sil.org/iso639-3/documentation.asp?id=rar) | Rarotongan |
| [`evn`](http://www-01.sil.org/iso639-3/documentation.asp?id=evn) | Evenki |
| [`qvn`](http://www-01.sil.org/iso639-3/documentation.asp?id=qvn) | North Junín Quechua |
| [`wwa`](http://www-01.sil.org/iso639-3/documentation.asp?id=wwa) | Waama |
| [`buc`](http://www-01.sil.org/iso639-3/documentation.asp?id=buc) | Bushi |
| [`qvh`](http://www-01.sil.org/iso639-3/documentation.asp?id=qvh) | Huamalíes-Dos de Mayo Huánuco Quechua |
| [`toj`](http://www-01.sil.org/iso639-3/documentation.asp?id=toj) | Tojolabal |
| [`lue`](http://www-01.sil.org/iso639-3/documentation.asp?id=lue) | Luvale |
| [`qvc`](http://www-01.sil.org/iso639-3/documentation.asp?id=qvc) | Cajamarca Quechua |
| [`ojb`](http://www-01.sil.org/iso639-3/documentation.asp?id=ojb) | Northwestern Ojibwa |
| [`jiv`](http://www-01.sil.org/iso639-3/documentation.asp?id=jiv) | Shuar |
| [`qud`](http://www-01.sil.org/iso639-3/documentation.asp?id=qud) | Calderón Highland Quichua |
| [`lld`](http://www-01.sil.org/iso639-3/documentation.asp?id=lld) | Ladin |
| [`hlt`](http://www-01.sil.org/iso639-3/documentation.asp?id=hlt) | Matu Chin |
| [`que`](http://www-01.sil.org/iso639-3/documentation.asp?id=que) | Quechua |
| [`pon`](http://www-01.sil.org/iso639-3/documentation.asp?id=pon) | Pohnpeian |
| [`agr`](http://www-01.sil.org/iso639-3/documentation.asp?id=agr) | Aguaruna |
| [`qxa`](http://www-01.sil.org/iso639-3/documentation.asp?id=qxa) | Chiquián Ancash Quechua |
| [`quh`](http://www-01.sil.org/iso639-3/documentation.asp?id=quh) | South Bolivian Quechua |
| [`tca`](http://www-01.sil.org/iso639-3/documentation.asp?id=tca) | Ticuna |
| [`chj`](http://www-01.sil.org/iso639-3/documentation.asp?id=chj) | Ojitlán Chinantec |
| [`ike`](http://www-01.sil.org/iso639-3/documentation.asp?id=ike) | Eastern Canadian Inuktitut |
| [`kwi`](http://www-01.sil.org/iso639-3/documentation.asp?id=kwi) | Awa-Cuaiquer |
| [`rgn`](http://www-01.sil.org/iso639-3/documentation.asp?id=rgn) | Romagnol |
| [`oki`](http://www-01.sil.org/iso639-3/documentation.asp?id=oki) | Okiek |
| [`tob`](http://www-01.sil.org/iso639-3/documentation.asp?id=tob) | Toba |
| [`guu`](http://www-01.sil.org/iso639-3/documentation.asp?id=guu) | Yanomamö |
| [`qxu`](http://www-01.sil.org/iso639-3/documentation.asp?id=qxu) | Arequipa-La Unión Quechua |
| [`pau`](http://www-01.sil.org/iso639-3/documentation.asp?id=pau) | Palauan |
| [`shp`](http://www-01.sil.org/iso639-3/documentation.asp?id=shp) | Shipibo-Conibo |
| [`gld`](http://www-01.sil.org/iso639-3/documentation.asp?id=gld) | Nanai |
| [`gug`](http://www-01.sil.org/iso639-3/documentation.asp?id=gug) | Paraguayan Guaraní |
| [`mzi`](http://www-01.sil.org/iso639-3/documentation.asp?id=mzi) | Ixcatlán Mazatec |
| [`cjs`](http://www-01.sil.org/iso639-3/documentation.asp?id=cjs) | Shor |
| [`mic`](http://www-01.sil.org/iso639-3/documentation.asp?id=mic) | Mi'kmaq |
| [`haw`](http://www-01.sil.org/iso639-3/documentation.asp?id=haw) | Hawaiian |
| [`eve`](http://www-01.sil.org/iso639-3/documentation.asp?id=eve) | Even |
| [`yap`](http://www-01.sil.org/iso639-3/documentation.asp?id=yap) | Yapese |
| [`cbt`](http://www-01.sil.org/iso639-3/documentation.asp?id=cbt) | Chayahuita |
| [`ame`](http://www-01.sil.org/iso639-3/documentation.asp?id=ame) | Yanesha' |
| [`gyr`](http://www-01.sil.org/iso639-3/documentation.asp?id=gyr) | Guarayu |
| [`vep`](http://www-01.sil.org/iso639-3/documentation.asp?id=vep) | Veps |
| [`cpu`](http://www-01.sil.org/iso639-3/documentation.asp?id=cpu) | Pichis Ashéninka |
| [`acu`](http://www-01.sil.org/iso639-3/documentation.asp?id=acu) | Achuar-Shiwiar |
| [`not`](http://www-01.sil.org/iso639-3/documentation.asp?id=not) | Nomatsiguenga |
| [`sme`](http://www-01.sil.org/iso639-3/documentation.asp?id=sme) | Northern Sami |
| [`yad`](http://www-01.sil.org/iso639-3/documentation.asp?id=yad) | Yagua |
| [`ura`](http://www-01.sil.org/iso639-3/documentation.asp?id=ura) | Urarina |
| [`cbu`](http://www-01.sil.org/iso639-3/documentation.asp?id=cbu) | Candoshi-Shapra |
| [`huu`](http://www-01.sil.org/iso639-3/documentation.asp?id=huu) | Murui Huitoto |
| [`cof`](http://www-01.sil.org/iso639-3/documentation.asp?id=cof) | Colorado |
| [`boa`](http://www-01.sil.org/iso639-3/documentation.asp?id=boa) | Bora |
| [`ztu`](http://www-01.sil.org/iso639-3/documentation.asp?id=ztu) | Güilá Zapotec |
| [`piu`](http://www-01.sil.org/iso639-3/documentation.asp?id=piu) | Pintupi-Luritja |
| [`cbr`](http://www-01.sil.org/iso639-3/documentation.asp?id=cbr) | Cashibo-Cacataibo |
| [`mcf`](http://www-01.sil.org/iso639-3/documentation.asp?id=mcf) | Matsés |
| [`bis`](http://www-01.sil.org/iso639-3/documentation.asp?id=bis) | Bislama |
| [`orh`](http://www-01.sil.org/iso639-3/documentation.asp?id=orh) | Oroqen |
| [`ykg`](http://www-01.sil.org/iso639-3/documentation.asp?id=ykg) | Northern Yukaghir |
| [`ese`](http://www-01.sil.org/iso639-3/documentation.asp?id=ese) | Ese Ejja |
| [`nio`](http://www-01.sil.org/iso639-3/documentation.asp?id=nio) | Nganasan |
| [`cic`](http://www-01.sil.org/iso639-3/documentation.asp?id=cic) | Chickasaw |
| [`csa`](http://www-01.sil.org/iso639-3/documentation.asp?id=csa) | Chiltepec Chinantec |
| [`mcd`](http://www-01.sil.org/iso639-3/documentation.asp?id=mcd) | Sharanahua |
| [`amc`](http://www-01.sil.org/iso639-3/documentation.asp?id=amc) | Amahuaca |
| [`amr`](http://www-01.sil.org/iso639-3/documentation.asp?id=amr) | Amarakaeri |
| [`cot`](http://www-01.sil.org/iso639-3/documentation.asp?id=cot) | Caquinte |
| [`oaa`](http://www-01.sil.org/iso639-3/documentation.asp?id=oaa) | Orok |
| [`ajg`](http://www-01.sil.org/iso639-3/documentation.asp?id=ajg) | Aja (Benin) |
| [`arl`](http://www-01.sil.org/iso639-3/documentation.asp?id=arl) | Arabela |
| [`ppl`](http://www-01.sil.org/iso639-3/documentation.asp?id=ppl) | Pipil |
| [`bax`](http://www-01.sil.org/iso639-3/documentation.asp?id=bax) | Bamun |
| [`nku`](http://www-01.sil.org/iso639-3/documentation.asp?id=nku) | Bouna Kulango |
| [`cbi`](http://www-01.sil.org/iso639-3/documentation.asp?id=cbi) | Chachi |
| [`ccp`](http://www-01.sil.org/iso639-3/documentation.asp?id=ccp) | Chakma |
| [`chr`](http://www-01.sil.org/iso639-3/documentation.asp?id=chr) | Cherokee (Cherokee) |
| [`chr`](http://www-01.sil.org/iso639-3/documentation.asp?id=chr) | Cherokee (Cherokee) |
| [`duu`](http://www-01.sil.org/iso639-3/documentation.asp?id=duu) | Drung |
| [`cfm`](http://www-01.sil.org/iso639-3/documentation.asp?id=cfm) | Falam Chin |
| [`fat`](http://www-01.sil.org/iso639-3/documentation.asp?id=fat) | Fanti |
| [`ido`](http://www-01.sil.org/iso639-3/documentation.asp?id=ido) | Ido |
| [`ina`](http://www-01.sil.org/iso639-3/documentation.asp?id=ina) | Interlingua (International Auxiliary Language Association) |
| [`kkh`](http://www-01.sil.org/iso639-3/documentation.asp?id=kkh) | Khün |
| [`ktu`](http://www-01.sil.org/iso639-3/documentation.asp?id=ktu) | Kituba (Democratic Republic of Congo) |
| [`fkv`](http://www-01.sil.org/iso639-3/documentation.asp?id=fkv) | Kven Finnish |
| [`lat`](http://www-01.sil.org/iso639-3/documentation.asp?id=lat) | Latin |
| [`glv`](http://www-01.sil.org/iso639-3/documentation.asp?id=glv) | Manx |
| [`mfq`](http://www-01.sil.org/iso639-3/documentation.asp?id=mfq) | Moba |
| [`mnw`](http://www-01.sil.org/iso639-3/documentation.asp?id=mnw) | Mon |
| [`mxi`](http://www-01.sil.org/iso639-3/documentation.asp?id=mxi) | Mozarabic |
| [`pcm`](http://www-01.sil.org/iso639-3/documentation.asp?id=pcm) | Nigerian Pidgin |
| [`niu`](http://www-01.sil.org/iso639-3/documentation.asp?id=niu) | Niuean |
| [`kqs`](http://www-01.sil.org/iso639-3/documentation.asp?id=kqs) | Northern Kissi |
| [`sey`](http://www-01.sil.org/iso639-3/documentation.asp?id=sey) | Secoya |
| [`ekk`](http://www-01.sil.org/iso639-3/documentation.asp?id=ekk) | Standard Estonian |
| [`lvs`](http://www-01.sil.org/iso639-3/documentation.asp?id=lvs) | Standard Latvian |
| [`blt`](http://www-01.sil.org/iso639-3/documentation.asp?id=blt) | Tai Dam |
| [`kdh`](http://www-01.sil.org/iso639-3/documentation.asp?id=kdh) | Tem |
| [`tdt`](http://www-01.sil.org/iso639-3/documentation.asp?id=tdt) | Tetun Dili |
| [`twi`](http://www-01.sil.org/iso639-3/documentation.asp?id=twi) | Twi (Latin) |
| [`twi`](http://www-01.sil.org/iso639-3/documentation.asp?id=twi) | Twi (Latin) |
| [`auc`](http://www-01.sil.org/iso639-3/documentation.asp?id=auc) | Waorani |
| [`gaz`](http://www-01.sil.org/iso639-3/documentation.asp?id=gaz) | West Central Oromo |
| [`pnb`](http://www-01.sil.org/iso639-3/documentation.asp?id=pnb) | Western Panjabi |
| [`zro`](http://www-01.sil.org/iso639-3/documentation.asp?id=zro) | Záparo |

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

