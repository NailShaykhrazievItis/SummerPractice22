package com.test.summerpractice22.first

data class Test(
    val name: String,
    var pass: String = ""
) {

}

fun sdsad() {
    val test1 = Test("test")
    test1.pass = "pass"
    val test2 = Test("test")
    test2.pass = "pass2"

    val b: Boolean = test1 == test2
}
