package algorithms;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.*;
import java.util.stream.Collectors;

public class Testtt {
    private static boolean flag=false;
    public static void main( String[] args ){
        List<Key>list=new ArrayList<>();
        list.add(new Key("A","D"));
        list.add(new Key("D","A"));
        list.add(new Key("B","W"));
        list.add(new Key("A","C"));
        list.add(new Key("C","B"));
        list.add(new Key("D","E"));
        list.add(new Key("F","R"));
        list.add(new Key("H","Y"));
        list.add(new Key("U","J"));
        list.add(new Key("I","P"));
        list.add(new Key("O","L"));
        list.add(new Key("P","U"));
        list.add(new Key("Q","T"));
        list.add(new Key("S","B"));
        long t1=System.currentTimeMillis();
        Map<String, Set<String>> data=list.stream().collect(Collectors.groupingBy(Key::getKey,Collectors.mapping(Key::getValue,Collectors.toSet())));
        List<Set<String>> newData=new ArrayList<>();
        data.forEach((key,value)->{
            Set<String> temp=new HashSet<>();
            temp.add(key);
            temp.addAll(value);
            newData.add(temp);
        });
        Set<String> query=new HashSet<>();
        query.add("A");
        query.add("Q");
        getSetFromAll(newData,query);
        System.out.println(query);
        System.out.println(data);
        System.out.println(System.currentTimeMillis()-t1);
    }

    private static void getSetFromAll(List<Set<String>> newData, Set<String> query) {
        flag=false;
        newData.forEach(item->{
            if (existMixed(item,query)){
                query.addAll(item);
                item.clear();
                flag=true;
            }
        });
        if (!flag){
            return ;
        } else {
            getSetFromAll(newData,query);
        }
    }

    private static boolean existMixed(Set<String> item, Set<String> query) {
        Set<String> newQuery=new HashSet<>(query);
        newQuery.retainAll(item);
        return newQuery.size()>0;
    }

}

class Key{
    private String key;
    private String value;

    Key(String key,String value){
        this.key=key;
        this.value=value;
    }
    public String getKey(){
        return this.key;
    }
    public String getValue(){
        return this.value;
    }


}