public class ActivitySelection {
    int Start;
    int finish;
    ActivitySelection(int s, int f){
        Start = s;
        finish = f;
    }
void display(){
    System.out.println(Start + " " + finish);
}
    public static void main(String[] args) {
        ActivitySelection as=new ActivitySelection(0 , 6);
    }
}
public class Participation {
    public static void main(String[] args) {
        ArrayList<ActivitySelection> list = new ArrayList<>();
        list.add(new ActivitySelection(1, 2));
        list.add(new ActivitySelection(3, 4));
        list.add(new ActivitySelection(0, 6));
        list.add(new ActivitySelection(5, 7));
        list.add(new ActivitySelection(5, 9));
        //custom sort:comparator , which is an interface
        //Anonymous class
//        Collections.sort(list, new Comparator<ActivitySelection>()// sort is method under collections
//        {
//            @Override
//            public int compare(ActivitySelection o1, ActivitySelection o2) { // compare is method under sort
//                return o1.finish - o2.finish; // if 10-20=-10 then b comes first ,if 30-20=10 then a comes first
//            }
//        });
Collections.sort(list,
                (o1, o2) -> o1.finish - o2.finish
       );

        for (ActivitySelection a : list) {
            a.display();
        }
        System.out.println(list.get(0).Start+" "+list.get(0).finish);
        int count=1;
        int lastend=list.get(0).finish;
        for(int i=1;i<list.size();i++){
            if(list.get(i).Start>=lastend){
                System.out.println(list.get(i).Start+" "+list.get(i).finish);
                count++;
                lastend=list.get(i).finish;
            }
        }
        System.out.println("The count is: " +count);
    }
}
