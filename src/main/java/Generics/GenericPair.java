package Generics;

// 1. Generic Class
public class  GenericPair<T , V>{
   T first;
   V second;

   public void setFirst(T first){
       this.first = first;
   }

    public T getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    public void setSecond(V second) {
        this.second = second;
    }

// 2. Generic Method
    // S: Denotes the type of the parameter 'data'
    // K: Denotes the type of the parameter 'data2' as well as the return type of the method.
    public static <S, K> K doSomething(S data , K data2){
        System.out.println(data);
        return data2;
    }
}
