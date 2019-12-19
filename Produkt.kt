class Produkt (val productName : String, val price : Double, val rating : Int){

    override fun toString(): String =
            "${this.productName} , ${"%.2f".format(this.price)}, ${this.rating}"
}

fun productFactory (productName : String, rating : Int) : (Double) -> Produkt =
    {x : Double -> Produkt(productName, x, rating)}

// Closures; Wenn man lokale Variabeln in einem Lambda Ausdruck verwendet.
// Diese werden in ihrem aktuellen Stand in dem Ausdruck gebunden.