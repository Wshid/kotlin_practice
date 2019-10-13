fun main(args: Array<String>) {
    println(sum2(1, 2))
    stringInterpolation()
    println(maxOf(3, 4))
    println(describe("12"))
    rangeFunc(10)
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun sum2(a: Int, b: Int): Int = a + b

// java.void = kotlin.Unit
fun printKotlin(): Unit {
    println("hello Kotlin")
}

fun stringInterpolation(): Unit {
    var a = 1
    var s1 = "a is $a"
    val s2: String = "${s1.replace("is", "was")}, but now is $a"
    println(s2)
}

fun maxOf(a: Int, b: Int) = if (a > b) a else b

fun parseInt(str: String): Int? {
    // if not integer, return null
    return null
}

fun printProduct(arg1: String, arg2: String) {
    val x: Int? = parseInt(arg1)
    val y: Int? = parseInt(arg2)

    // nullable 타입의 경우 무조건 Null 체크를 하고 사용해야 함
    // 하지 않을경우, 컴파일 오류 발생
    if (x != null && y != null) {
        println(x * y)
    } else {
        println("either '$arg1' or '$arg2' is not a number")
    }
}

// 자동 타입 변환
fun getStringLength(obj: Any): Int? {
    // is => java.is instance of
    if (obj is String) { // 비교하는 순간 obj는 String으로 변환됨
        return obj.length
    }

    return null
}

// when Expression
fun describe(obj: Any): String =
    when (obj) {
        1 -> "One"
        "Hello" -> "Greeting"
        is Long -> "Long"
        !is String -> "Not a String"
        else -> "Unknown"
    }

fun rangeFunc(maxNumber: Int): Unit {
    for (x in 1..maxNumber)
        print(x)

    val items = listOf("apple", "banana", "kiwi")
    for (item in items) {
        println(item)
    }

    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }
}

fun lambdaFun(): Unit {
    val fruits = listOf("banana", "avocado", "apple", "kiwi")

    // 인자가 단일일 경우 `it`로 매핑하여 사용할 수 있음
    fruits
        .filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.toUpperCase() }
        .forEach { println(it) }
}