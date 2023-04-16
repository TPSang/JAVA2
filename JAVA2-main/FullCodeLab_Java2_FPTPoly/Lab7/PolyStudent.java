package PS14885_NguyenDoDuyAn_Lab7;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Duy An
 */
enum Career {

    UDPM, TKTW, LTDD, TKĐH
}

public class PolyStudent {

    public String fullName;
    public Career career;

    public void print() {
        System.out.println("---------------------------");
        System.out.println(">Full Name:" + this.fullName);
        switch (this.career) {
            case UDPM:
                System.out.println(">Career: Ứng dụng phần mềm");
                break;
            case TKTW:
                System.out.println(">Career: Thiết kế trang Web");
                break;
            case LTDD:
                System.out.println(">Career: Lập Trình Di Dộng");
                break;
            case TKĐH:
                System.out.println(">Career: Thiết Kế Đồ Họa");
                break;

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PolyStudent sv = new PolyStudent();
        System.out.print("Full Name:");
        sv.fullName = sc.nextLine();
        System.out.print("Major:");
        String s = sc.nextLine();
        sv.career = Career.valueOf(s);

        sv.print();
    }
}
