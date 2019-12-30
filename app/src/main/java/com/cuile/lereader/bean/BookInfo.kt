package com.cuile.lereader.bean

data class BookInfo (
    // 书名
    val title: String,

    // 标签
    val tag: String,

    // 作者
    val author: String,

    // 简介
    val introduction: String,

    // 评分
    val remarkScore: Float,

    // 封面图片url
    val coverImgUrl: String,

    // 如果在线，是图书根地址，否则小说本地MD5，作为图书ID使用
    val noteUrl: String,

    // 如果在线，是图书章节目录地址，否则目录正则
    val chapterUrl: String,

    // 最后更新时间
    val finalRefreshDate: Long,

    // 来源
    val origin: String,

    val bookSourceType: String,
    val charset: String,
    val rank: Int)

data class BookChapter (
    val noteUrl: String,
    val tag: String,
    val curChapterIndex: Int,
    val curChapterUrl: String,
    val curChapterName: String,
    val start: Long,
    val end: Long
)