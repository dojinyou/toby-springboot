package com.dojinyou.inflearn.tobyspringboot.example

interface MemberRepository {

    fun findMember(name: String): Member?

    fun increaseCount(name: String)

    fun countOf(name: String): Int {
        return findMember(name)?.getCount() ?: return 0
    }
}
