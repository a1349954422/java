package studentsStore;

import javax.swing.*;

public class teacherOperate {
    public static void main(String[] args) {
        Students[] store = new Students[5];
        for (int i = 0; i < store.length; i++) {
            store[i] = new Students();
        }
        for (int i = 0; i < store.length; i++) {
            store[i].setFirst_name(JOptionPane.showInputDialog("please input student's first_name"));
            store[i].setLast_name(JOptionPane.showInputDialog("please input student's last_name"));
            String score = JOptionPane.showInputDialog("please input student's score");
            store[i].setScore(Double.parseDouble(score));
        }
        for (int i = 0; i < store.length; i++) {
            if(i > 1){
                if(store[i].getScore() < store[i - 1].getScore()){
                    double t = store[i].getScore();
                    store[i].setScore(store[i - 1].getScore());
                    store[i - 1].setScore(t);
                }
            }
        }
        for (int i = 0; i < store.length; i++) {
            System.out.print(store[i].getFirst_name() + "  ");
            System.out.print(store[i].getLast_name() + "  ");
            System.out.println(store[i].getScore());
        }

    }
}
