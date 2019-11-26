import java.lang.IllegalStateException

sealed class List <T> {

    class Node <T> ( val head : T , val tail : List<T>) : List<T> () {
        override fun toString () =
            "${head.toString()} , ${tail.toString()}"
    }
    object Nil : List<Nothing> ()  {
        override fun toString () = "NIL"
    }

    companion object {
        operator
        fun <T> invoke (vararg values : T ) : List<T>{
            val empty = Nil as List<T>
            val res = values.foldRight( empty , { v, l -> l.addFirst(v)   })
            return res
        }
    }

    fun addFirst ( head : T ) : List<T> = Node (head , this)

    fun removeFirst ()  : List <T> = when (this) {
        is Nil -> throw IllegalStateException()
        is Node<T> -> this.tail
    }

}

class ListFunctions <T>{

    fun <T,R> map ( list : List<T> , f : (T)-> R) : List<R> = when (list) {
        is List.Nil -> List.Nil as List<R>
        is List.Node -> List.Node(f(list.head), map(list.tail, f))
    }

    fun <T> replaceIf (list : List<T> , f : (T)-> T , p : (T)-> Boolean ) : List<T> = when (list){
        is List.Nil -> List.Nil as List<T>
        is List.Node -> List.Node(if(p(list.head)) f(list.head) else list.head, replaceIf(list.tail, f, p))
    }

    fun <T> filter ( list : List<T> , p : (T)-> Boolean ) : List<T> = when (list){
        is List.Nil -> List.Nil as List<T>
        is List.Node -> {
            if(!p(list.head))
                List.Node(list.head, filter(list.tail, p))
            else
                filter(list.tail, p)
        }
    }

    fun <T> any ( list : List<T> , p : (T)-> Boolean ) : Boolean = when (list){
        is List.Nil -> false
        is List.Node -> p(list.head) || any(list.tail, p)
    }

    fun <T,R> foldREKURSION( list : List <T> , accumulated : R , f : (R,T)->R ) : R = when (list){
        is List.Nil -> accumulated
        is List.Node<T> -> foldREKURSION(list.tail, f(accumulated, list.head), f)
    }

    fun <T,R> foldITERATION( list : List <T> , accumulated : R , f : (R,T)->R ) : R{

        var acc = accumulated
        var tempList = list

        while (tempList is List.Node<T>){
            acc = f(acc, tempList.head)
            tempList = tempList.tail
        }

        return acc
    }

    fun <T,R> foldFOLD( list : List<T> , accumulated : R , f : (R,T)->R ) : R{

        val mutableList = mutableListOf<T>()
        var tempList = list

        while (tempList is List.Node<T>){
            mutableList.add(tempList.head)
            tempList = tempList.tail
        }

        return mutableList.fold(accumulated, f)
    }
}