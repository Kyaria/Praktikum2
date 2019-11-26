class Produkt (val productName : String, val price : Double, val rating : Int)

fun productFactory (productName : String, rating : Int) : (Double) -> Produkt =
    {x : Double -> Produkt(productName, x, rating)}

fun main2point0(){

    val kaffee = Produkt("Kaffee", 12.99, 9)
    val milch = Produkt("BMilch", 0.69, 7)
    val gebaeck = Produkt("Gebäck", 2.99, 2)
    val tasse = Produkt("ATasse", 4.99, 6)
    val untertasse = Produkt("Untertasse", 3.99, 5)

    val productList = List<Produkt>(kaffee, milch, gebaeck, tasse, untertasse)

    val func = ListFunctions<Produkt>()

    val mapPL = func.map(productList, {x : Produkt -> x.productName})
    println(mapPL)  // K

    val filterMapPL = func.map(func.filter(productList, {x : Produkt -> x.price > 10}), {x : Produkt -> x.productName})
    println(filterMapPL)    // K

    val mapPL19 = func.map(productList, {x : Produkt -> x.price * 1.19})
    println(mapPL19)    // K

    val worseThan3 = func.filter(productList, {x : Produkt -> x.rating < 3})

    var tempList = worseThan3
    println("\n ---------- worseThan3 STARTS HERE ---------- \n")
    while (tempList is List.Node){
        println(tempList.head.productName + ", " + tempList.head.price + ", " + tempList.head.rating)
        tempList = tempList.tail
    }   // K

    val replaceAandB = func.replaceIf(productList, {x : Produkt -> Produkt("Angebot: " + x.productName, x.price, x.rating)},
        {x : Produkt -> x.productName.startsWith("A") || x.productName.startsWith("B")})

    tempList = replaceAandB
    println("\n ---------- replaceAandB STARTS HERE ---------- \n")
    while (tempList is List.Node){
        println(tempList.head.productName + ", " + tempList.head.price + ", " + tempList.head.rating)
        tempList = tempList.tail
    }   // K

    val isStuffOver100 = func.any(productList, {x: Produkt -> x.price > 100})
    println("\n$isStuffOver100\n")  // K

    val foldSum = func.foldREKURSION(productList, 0.0, {x : Double, y : Produkt -> x + y.price})
    println("\n$foldSum\n") // K

    val foldMaxPrice = func.foldREKURSION(productList, 0.0,
        {x : Double, y : Produkt -> if(y.price > x) y.price else x})
    println("\n$foldMaxPrice\n") // K
}