package com.cuile.lereader

data class BookInfo (
    // 图书id
    val id: Int,

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

    // 如果在线，是图书根地址，否则小说本地MD5
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

fun getWrongBooks(): List<BookInfo> {
    val books = mutableListOf<BookInfo>()
    for (i in 0..99) {
        books.add(
            BookInfo(
                i,
                "Book Name $i",
                "TAG $i",
                "Author is $i",
                "This book has not introduction $i",
                5.5f,
                "",
                "",
                "",
                System.currentTimeMillis(),
                "来源： $i",
                "online",
                "utf-8",
                i + 1 )
        )
    }
    return books;
}