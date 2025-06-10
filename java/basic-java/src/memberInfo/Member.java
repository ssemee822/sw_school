package memberInfo;

public class Member {
    private static String school = "school";
    private int num;
    private String name;
    private String addr;

    public Member() {
        num = 100;
        name = "none";
        addr = "none";
    }

    public Member(int num, String name, String addr) {
        this.num = num;
        this.name = name;
        this.addr = addr;
    }

    public static String getSchool() {
        return school;
    }

    public static void setSchool(String school) {
        Member.school = school;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
