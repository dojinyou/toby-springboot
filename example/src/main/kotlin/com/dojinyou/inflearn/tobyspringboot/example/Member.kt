package com.dojinyou.inflearn.tobyspringboot.example

class Member(
    private val name:String,
    private var count: Int = 0
) {
    fun getName() = name

    fun getCount() = count
}
