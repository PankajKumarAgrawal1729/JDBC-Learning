//@author Pankaj Kumar

import java.sql.*;
import java.util.Scanner;

public class InsertRecord {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Student";
        String uname = "root";
        String pass = "";
        // Insert one record(DML)
        String query = "Insert into record values (4, 'Krishna')";

        // data taking from user
        Scanner sc = new Scanner(System.in);
        int userId = sc.nextInt();
        sc.nextLine();
        String userName = sc.nextLine();

        String query1 = "Insert into record values(?, ?)";

        try (Connection con = DriverManager.getConnection(url, uname, pass)) {

            // INSERT ONE RECORD
            Statement st = con.createStatement();
            int count = st.executeUpdate(query);
            System.out.println(count + " row/s affected");

            // Insert multiple record
            PreparedStatement pst = con.prepareStatement(query1);
            // 1st arg : on which question mark
            // 2nd arg: value
            pst.setInt(1, userId);
            pst.setString(2, userName);
            int count1 = pst.executeUpdate();
            System.out.println(count1 + " row/s affected");

            st.close();
            pst.close();
            con.close();
            sc.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
