package empDAO;

import emps.T_User;
import linkToDBTool.DBTool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpDAO {

    public T_User findEmp(String empNo) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            conn = DBTool.getInstance().getConnection();
            //select ename,job,hiredate,sal,nvl(comm,0),deptno from Emp
            //where EMPNO ='7369';
            ps = conn.prepareStatement("SELECT ename,job,hiredate,sal,nvl(comm,0) com,deptno FROM Emp WHERE EMPNO=? ");
            ps.setString(1, empNo);
            rs = ps.executeQuery();
            while (rs.next()) {
                T_User user = new T_User();
                user.setEmpName(rs.getString("ename"));
                user.setEmpJob(rs.getString("job"));
                user.setEmpDate(rs.getDate("hiredate"));
                user.setEmpSal(rs.getDouble("sal"));
                user.setEmpComm(rs.getDouble("com"));
                user.setEmpComm(rs.getInt("deptno"));
                return user;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBTool.closeAll(rs, ps, conn);
        }
        System.out.println("错误");
        return null;
    }

    public int update(T_User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        int row = 0;
        try {
            conn = DBTool.getInstance().getConnection();
            //UPDATE Emp SET ename='SMith', job='clck' WHERE empNo='7369';
            ps = conn.prepareStatement("UPDATE Emp SET ename=?, job=?, sal=?, comm=? WHERE empno=?");
            ps.setString(1, user.getEmpName());
            ps.setString(2, user.getEmpJob());
            ps.setDouble(3, user.getEmpSal());
            ps.setDouble(4, user.getEmpComm());
            ps.setInt(5, user.getEmpNo());
            row = ps.executeUpdate(); //插入数据库，返回SQL语句执行后受影响的行数

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBTool.closeAll(null, ps, conn);
        }
        return row;
    }

    public int delete(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        int row = 0;
        try {
            conn = DBTool.getInstance().getConnection();
            ps = conn.prepareStatement("DELETE emp WHERE empno=?");
            ps.setInt(1, id);
            row = ps.executeUpdate(); //插入数据库，返回SQL语句执行后受影响的行数
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBTool.closeAll(null, ps, conn);
        }
        return row;
    }
}
//    public List<String> getDepart() {
//        List<String> departmentName = new ArrayList<>();
//        return
//    }
//}
