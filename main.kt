fun main(){

    println("\n ---------- A STARTS HERE ---------- \n")

    var listTest = List<Int>()

    listTest = listTest.addFirst(10)
    listTest = listTest.addFirst(20)
    listTest = listTest.addFirst(43)
    listTest = listTest.addFirst(11)
    listTest = listTest.addFirst(420)
    listTest = listTest.addFirst(53)
    listTest = listTest.addFirst(9)

    println("ORIGINAL: " + listTest)

    val testFunctions = ListFunctions<Int>()

    val repList = testFunctions.replaceIf(listTest, {x : Int -> 420}, {x : Int -> x < 20})
    println("replaceIf: " + repList)

    val filList = testFunctions.filter(listTest, {x : Int -> x < 20})
    println("filter: " + filList)

    val mapList = testFunctions.map(listTest, {x : Int -> x * 420 + 69})
    println("map: " + mapList)

    val anyList = testFunctions.any(listTest, {x : Int -> x == 420})
    println("any: " + anyList)

    val foldRekList = testFunctions.foldREKURSION(listTest, 0 ,{x : Int, y : Int -> x + y})
    println("foldREKURSION: " + foldRekList)

    val foldItaList = testFunctions.foldITERATION(listTest, 0 ,{x : Int, y : Int -> x + y})
    println("foldITERATION: " + foldItaList)

    val foldFolList = testFunctions.foldFOLD(listTest, 0 ,{x : Int, y : Int -> x + y})
    println("foldFOLD: " + foldFolList)

    println("\n ---------- B STARTS HERE ---------- \n")

    main2point0()

    println("\n ---------- C STARTS HERE ---------- \n")

    val kaeseFactory = productFactory("Käse", 5)

    val teurerKaese = kaeseFactory(4.99)
    val billigerKaese = kaeseFactory(0.99)

    println(teurerKaese.productName + ", " + teurerKaese.price + ", " + teurerKaese.rating)
    println(billigerKaese.productName + ", " + billigerKaese.price + ", " + billigerKaese.rating)
}

