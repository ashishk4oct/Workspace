package com.whatfix;

import java.io.*;
import java.util.*;

public class AirportTest {

    public static void main(String[] args) throws FileNotFoundException {

        AirportTest at = new AirportTest();
        List<String> list = at.mergeList();

        for (String s : list) {
            System.out.println(s);
        }
    }
    
    private List<String> mergeList() throws FileNotFoundException {

        Queue<MyList> priorityQueue = new PriorityQueue<>();

        for (int i = 1; i <= 3; i++) {
            priorityQueue.add(new MyCSVFile("D:\\whatFix\\test"+i+".txt"));
        }

        return merge(priorityQueue);


    }

    private List<String> merge(Queue<MyList> priorityQueue) {
        List<String> resultList = new ArrayList<>();

        while(!priorityQueue.isEmpty()){
            MyList mylist = priorityQueue.poll();
            if(mylist.hasNext()){
                resultList.add(mylist.getTop());
                if(mylist.hasNext()){
                    priorityQueue.add(mylist);
                }
            }
        }

        return resultList;
    }
}

interface MyList extends Comparable<MyList> {

    String getTop();
    String viewTop();
    boolean hasNext();


}

class MyCSVFile implements MyList{

    Iterator<String> iterator;
    String top;
    MyCSVFile(String filePath) throws FileNotFoundException {
        File inputF = new File(filePath);
        InputStream inputFS = new FileInputStream(inputF);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
        this.iterator = br.lines().iterator();

    }
    @Override
    public String getTop() {
        String t = top;
        if(hasNext()){
            top = this.iterator.next();
        }else{
            top = null;
        }

        return t;
    }

    @Override
    public String viewTop() {
        if(null == top){
            top = this.iterator.next();
        }
        return top;
    }

    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }


    @Override
    public int compareTo(MyList o) {
        return this.viewTop().compareTo(o.viewTop());
    }
}
class MyListList implements  MyList{

    List<String> list ;
    int top = 0;
    MyListList(List<String> list){
        this.list = list;

    }

    @Override
    public String getTop() {
        String s = list.get(top);
        top++;
        return s;
    }

    @Override
    public String viewTop() {
        return list.get(top);
    }

    @Override
    public boolean hasNext() {
        return top < list.size()-1;
    }


    @Override
    public int compareTo(MyList o) {
        return o.viewTop().compareTo(this.viewTop());
    }

}
