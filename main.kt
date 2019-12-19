fun main(){
    println("\n ---------- TESTRUN STARTS HERE ---------- \n")

        val original = List<Int>(10, 219370, 43, 11934, 420, 53, 930948)
        println("ORIGINAL: \n$original\n")

        println("\tAlle Tests werden auf der originalen Liste ausgeführt.\n")

        val test1 = replaceIf(original, { 1337 }, { it < 1337 })
        println("replaceIf: \n$test1\n")

        val test2 = filter(original) { it < 1337 }
        println("filter: \n$test2\n")

        val test3 = map(original) { it + 1 }
        println("map: \n$test3\n")

        val test4 = any(original) { it == 420 }
        println("any: \n$test4\n")

        val test5 = fold(original, 0, { x: Int, y: Int -> x + y })
        println("fold: \n$test5\n")

        val test6 = foldITERATION(original, 0, { x: Int, y: Int -> x + y })
        println("foldITERATION: \n$test6\n")

        val test7 = foldFOLD(original, 0, { x: Int, y: Int -> x + y })
        println("foldFOLD: \n$test7\n")

    println("\n ---------- B STARTS HERE ----------")

        val kaffee = Produkt("Kaffee", 12.99, 9)
        val milch = Produkt("Brot", 0.69, 7)
        val gebaeck = Produkt("Gebäck", 2.99, 2)
        val tasse = Produkt("Asbestos", 4.99, 6)
        val untertasse = Produkt("Untertasse", 3.99, 5)

        val productList = List<Produkt>(kaffee, milch, gebaeck, tasse, untertasse)

    println("\n ---------- Nummer 1 OUTPUT ---------- \n")
            // Mappen Sie die Liste auf die Produktnamen.
        val number1 : List<String> = map(productList) { it.productName }
        println(number1)  // K

    println("\n ---------- Nummer 2 OUTPUT ---------- \n")
            // Filtern Sie alle Produkte, die teurer sind als 10 Euro und mappen Sie die gefilterte Liste auf die Produktnamen.
        val number2 : List<String> = map(filter(productList) { it.price > 10 }) { it.productName }
        println(number2)    // K

    println("\n ---------- Nummer 3 OUTPUT ---------- \n")
            // Mappen Sie die Liste auf eine neue Liste mit Produkten, die 19% teurer sind
        val number3 : List<Produkt> = map(productList) { Produkt(it.productName, it.price * 1.19, it.rating) }
        println(number3)    // K

    println("\n ---------- Nummer 4 OUTPUT ---------- \n")
            // Erstellen Sie eine Liste, in der alle Produkte, die schlechter als 3 bewertet sind, herausgefiltert sind.
        val number4 = filter(productList) { it.rating < 3 }
        println(number4)    // K

    println("\n ---------- Nummer 5 OUTPUT ---------- \n")
            // Erstellen Sie eine Liste, in der alle Produkte, deren Produktname mit dem Buchstaben „A“ oder „B“ beginnt,
            // ersetzt werden. Als Ersatz soll ein neues Produkt verwendet werden, bei dem der Produktname um „Angebot:“ ergänzt wird.
        val number5 = replaceIf(productList, { Produkt("Angebot: " + it.productName, it.price, it.rating) },
                { it.productName.startsWith("A") || it.productName.startsWith("B") })
        println(number5)    // K

    println("\n ---------- Nummer 6 OUTPUT ---------- \n")
            // Prüfen Sie mit any, ob ein mind. ein Produkt teurer als 100 Euro ist
        val number6 = any(productList) { it.price > 100 }
        println(number6)  // K

    println("\n ---------- Nummer 7 OUTPUT ---------- \n")
            // Nutzen Sie fold, um die Summe aller Produktpreise zu ermitteln
        val number7 = fold(productList, 0.0, { x: Double, y: Produkt -> x + y.price })
        println("%.2f".format(number7)) // K

    println("\n ---------- Nummer 8 OUTPUT ---------- \n")
            // Nutzen Sie fold, um den höchsten Preis (maximaler Preis) zu ermittel
        val number8 = fold(productList, 0.0, { x: Double, y: Produkt -> if (y.price > x) y.price else x })
        println(number8) // K

    println("\n ---------- C STARTS HERE ---------- \n")

        //val weinDiscount : Produkt = productFactory("Wein", 5) (7.99)
        val kaeseFactory = productFactory("Käse", 5)

        val teurerKaese = kaeseFactory(4.99)
        val billigerKaese = kaeseFactory(0.99)
            // Currying übersetzt eine Funktion mit mehreren Parameter in eine Sequenz von Funktionen mit jeweils einem Parameter.
            // Dadurch wird die partielle Anwendung möglich, es müssen also noch nicht alle Parameter angegeben werden.

        println(teurerKaese)
        println(billigerKaese)

}

