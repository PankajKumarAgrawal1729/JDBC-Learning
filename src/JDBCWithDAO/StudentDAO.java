package JDBCWithDAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {
    Connection con = null;
    public void connect(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/Student", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Student getStudent(int rollno) {
        String query = "select Name from record where Roll_No=" + rollno;
        Student s = new Student();
        s.rollno = rollno;
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            String name = rs.getString(1);
            s.sname = name;
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return s;
    }

    public void addStudent(Student st){
        String query = "Insert into record values(?, ?)";
        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, st.rollno);
            pst.setString(2, st.sname);
            int count = pst.executeUpdate();
            System.out.println(count + " row/s affected successfully!!");

        } catch (SQLException e) {   
            e.printStackTrace();
        }
    }
}
