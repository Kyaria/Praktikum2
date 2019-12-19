import java.lang.IllegalStateException

sealed class List <T> {

    class Node <T> ( val head : T , val tail : List<T>) : List<T> ()
    object Nil : List<Nothing> ()
        // Nothing ist eine Klasse ohne Instanzen. Wird benutzt um einen Wert zu repräsentieren der nie existiert.

    companion object {
        operator
        fun <T> invoke (vararg values : T ) : List<T>{
            val empty = Nil as List<T>
            val res = values.foldRight( empty , { v, l -> l.addFirst(v)   })
            return res
        }
    } // Überlädt den ()-Operator um es zu erlauben eine Liste mit Werten zu erstellen ohne addFirst() aufrufen zu müssen.

    fun addFirst ( head : T ) : List<T> = Node (head , this)

    fun removeFirst ()  : List <T> = when (this) {
        is Nil -> throw IllegalStateException()
        is Node<T> -> this.tail
    }

    override fun toString(): String = when(this) {
        is Nil -> "Nil"
        is Node<T> -> "${head.toString()}\n$tail"
    }
}