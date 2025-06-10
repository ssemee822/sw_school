package memberInfo;

public class OOP {
    public static void main(String[] args) {
        Member member1 = new Member();
        Member member2 = new Member(2, "mem2", "addr3");
        member1.setNum(1);
        member1.setName("mem1");
        member1.setAddr("addr1");

        System.out.println(member1.getName());
        System.out.println(member2.getName());
        System.out.println(Member.getSchool());
    }
}
