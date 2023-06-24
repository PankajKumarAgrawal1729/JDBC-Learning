package JDBCWithDAO;

public class JdbcDaoDemo {
    public void displayStudent(StudentDAO dao){

        Student s1 = dao.getStudent(4);
        System.out.println(s1.sname);
    }
    public void addStudent(StudentDAO dao){
        Student st = new Student();
        st.rollno = 6;
        st.sname = "Radha";
        dao.addStudent(st);
    }
    public static void main(String[] args) {
        JdbcDaoDemo obj = new JdbcDaoDemo();
        StudentDAO dao = new StudentDAO();
        dao.connect();
        obj.displayStudent(dao);
        obj.addStudent(dao);
    }
}
