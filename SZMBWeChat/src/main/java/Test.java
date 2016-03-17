import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	//@org.junit.Test
	public void test(){
		//ͨ��spring�����ļ�����Bean�Ĺ�������  
        BeanFactory factory = new ClassPathXmlApplicationContext("dataSource.xml");  
        //Bean����ͨ��Bean��id�õ�JavaBean  
        DataSource dataSource =  (DataSource) factory.getBean("dataSource");  
       
        try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("select sysdate from dual");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString(1));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
