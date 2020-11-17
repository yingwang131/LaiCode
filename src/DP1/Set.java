//package DP1;
//
//import java.util.Hashtable;
//
//public class Set<T> {
//
//
//    public Set()
//        //Initialize an empty hash table
//        table=HashTable<T>();
//
//
//    public void add(T x)
//        // check if the element already present
//        /*
//        1: if the element already exists, do nothing;
//        2: if the key not exists, add the element to the set
//         */
//        if (this.contains(x)) then
//            return;
//        else
//            table.add(x) //add x into hashtable
//        endif
//
//
//    public void remove(T x)
//        //if we find x in the set, we can remove it
//        /*
//        1: should check the element x, if x in the set, we should remove it
//        2:  if x is not in the set, we should throw the error which is not found
//
//         */
//        if (this.contains(x)) then
//            table.remove(x)
//        else
//            throw exception element not found
//        endif
//
//
//    public Set intersect(Set other)
//        resultSet <- new Set()
//        if(other.isEmpty()) then
//            return resultSet
//        else
//            // iterate the element in the other Set
//            for i <- 0 to other.size()-1
//                // if current set also contains the element in the position i of other Set
//                if(this.contains(other.get(i))) then
//                    resultSet.add(other.get(i))
//                else
//                    continue
//                endif
//            return resultSet
//        endif
//
//
//
//    public Set union(Set other)
//        // iterate the element in the other Set
//        // we simply add the two set together
//        resultSet <- new Set()
//        for i <- 0 to other.size()-1
//            resultSet.add(other.get(i))
//
//        for i <- 0 to this.size()-1
//            resultSet.add(this.get(i))
//        return resultSet
//
//    public Set diff(Set other)
//        // we find the difference between two set
//        resultSet <- new Set()
//        if(other.isEmpty()) then
//            return resultSet
//        else
//            // iterate the element in the other Set
//            for i <- 0 to other.size()-1
//            // if current set also contains the element in the position i of other Set
//            if(!this.contains(other.get(i))) then
//                resultSet.add(other.get(i))
//            else
//                continue
//            endif
//            return resultSet
//        endif
//
//
//    public bool contains(T x)
//        /*
//        1: if the set contain the element x, should return true
//        2: else return false
//         */
//        if table.contains(x)
//            return true
//        else
//            return false
//        endif
//
//    public bool subset(Set other)
//        // if the other is a proper subset of the current instance
//        for i <- 0 to other.size()-1
//            if(!this.contains(other.get(i))) then
//                return false
//            else
//                continue
//            endif
//        return true
//
//    public bool equals(Set other)
//        //assert all elements in 'other' set also in current set
//        for i <- 0 to other.size()-1
//            if(this.contains(other.get(i))) then
//                continue
//            else
//                return false
//            endif
//
//        //assert all elements in current set also in 'other' set
//        for i <- 0 to table.size()-1
//            if(other.contains(table.get(i))) then
//                continue
//            else
//                return false
//            endif
//
//        return true
//
//    public bool isEmpty()
//        /*
//        1: when the size is 0 we return  true
//         */
//        return table.size()==0
//
//    public int cardinality()
//        // the size of the set
//        return table.size()
//
//    public bool isDisjoint(Set other)
//        // two sets doesn't have any common element
//        for i <- 0 to other.size()-1
//            if(this.contains(other.get(i))) then
//                return false
//            else
//                continue
//            endif
//        return true
//
//    public T get(int index)
//        return table[index]
//
//}
