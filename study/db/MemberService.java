package study.db;//import org.mariadb.jdbc.export.Prepare;

import java.sql.*;

public class MemberService {
    public void dbSelect() {

        //DB에 접속하기 위해 필요한 5가지 정보
        //1. ip (domain)
        //2. port
        //3. 계정
        //4. 패스워드
        //5. 인스턴스

        String url = "jdbc:mariadb://192.168.0.18:3306/db1";
        String dbUserId = "testuser1";
        String dbPassword = "rlathdud5623";

        //DB에 접속하기 위한 5가지 단계
        //1. 드라이버 로드
        //2. DB 커넥션 객체 생성
        //3. SQL 스테이트먼트 객체 생성
        //4. 쿼리 실행
        //5. 결과 수행
        //6. 객체 연결 해제(close)

        //드라이버 로드
        try {
            Class.forName("org.mariadb.jdbc.Driver"); //예외처리: 감당이 되면 try catch로 처리, 감당 안되면 throw
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        //Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        //email, kakao, facebook
        String memberTypeValue = "email";
        //String memberTypeValue = "email' or 1 = 1"; //SQL injection 발생

        //DB 커넥션 객체 생성
        try {
            /*Connection*/ connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            //SQL statement 객체 3가지
            /*Statement*/ //statement = connection.createStatement();
            //CallableStatement callableStatement = null;

            String sql = "select member_type, user_id, password, name\n" +
                    "from member\n" +
                    "where member_type = ? ";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, memberTypeValue);

            /*ResultSet*/ //rs = statement.executeQuery(sql);
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String memberType = rs.getString("member_type");
                String userId = rs.getString("user_id");
                String password = rs.getString("password");
                String name = rs.getString("name");

                System.out.println(memberType + ", " + userId + ", " + password + ", " + name);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    /**
     * 회원가입 함수
     * @param member 회원 정보
     */
    public void register(Member member) {

        //DB에 접속하기 위해 필요한 5가지 정보
        //1. ip (domain)
        //2. port
        //3. 계정
        //4. 패스워드
        //5. 인스턴스

        String url = "jdbc:mariadb://192.168.0.15:3306/db1";
        String dbUserId = "testuser1";
        String dbPassword = "rlathdud5623";

        //DB에 접속하기 위한 5가지 단계
        //1. 드라이버 로드
        //2. DB 커넥션 객체 생성
        //3. SQL 스테이트먼트 객체 생성
        //4. 쿼리 실행
        //5. 결과 수행
        //6. 객체 연결 해제(close)

        //드라이버 로드
        try {
            Class.forName("org.mariadb.jdbc.Driver"); //예외처리: 감당이 되면 try catch로 처리, 감당 안되면 throw
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        //Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        //DB 커넥션 객체 생성
        try {
            /*Connection*/ connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            //SQL statement 객체 3가지
            /*Statement*/ //statement = connection.createStatement();
            //CallableStatement callableStatement = null;

            String sql = "INSERT INTO MEMBER (member_type, user_id, password, name) " +
            "VALUES (?, ?, ?, ?); ";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, member.getMemberType());
            preparedStatement.setString(2, member.getUserId());
            preparedStatement.setString(3, member.getPassword());
            preparedStatement.setString(4, member.getName());


            /*ResultSet*/ //rs = statement.executeQuery(sql);
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("저장 성공");
            } else {
                System.out.println("저장 실패");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
    public void dbUpdate() {

        //DB에 접속하기 위해 필요한 5가지 정보
        //1. ip (domain)
        //2. port
        //3. 계정
        //4. 패스워드
        //5. 인스턴스

        String url = "jdbc:mariadb://192.168.0.18:3306/db1";
        String dbUserId = "testuser1";
        String dbPassword = "rlathdud5623";

        //DB에 접속하기 위한 5가지 단계
        //1. 드라이버 로드
        //2. DB 커넥션 객체 생성
        //3. SQL 스테이트먼트 객체 생성
        //4. 쿼리 실행
        //5. 결과 수행
        //6. 객체 연결 해제(close)

        //드라이버 로드
        try {
            Class.forName("org.mariadb.jdbc.Driver"); //예외처리: 감당이 되면 try catch로 처리, 감당 안되면 throw
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        //Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;


        String memberTypeValue = "email";
        //String memberTypeValue = "email' or 1 = 1"; //SQL injection 발생
        String userIdValue = "zerobase@naver.com";
        String passwordValue = "9999";

        //DB 커넥션 객체 생성
        try {
            /*Connection*/ connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            //SQL statement 객체 3가지
            /*Statement*/ //statement = connection.createStatement();
            //CallableStatement callableStatement = null;

            String sql = " UPDATE MEMBER SET " +
            " password = ? " +
            " WHERE member_type = ? AND user_id = ? ";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, passwordValue);
            preparedStatement.setString(2, memberTypeValue);
            preparedStatement.setString(3, userIdValue);

            /*ResultSet*/ //rs = statement.executeQuery(sql);
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("수정 성공");
            } else {
                System.out.println("수정 실패");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    /**
     * 회원 탈퇴 함수
     */
    public void withdraw(Member member) {

        //DB에 접속하기 위해 필요한 5가지 정보
        //1. ip (domain)
        //2. port
        //3. 계정
        //4. 패스워드
        //5. 인스턴스

        String url = "jdbc:mariadb://192.168.0.18:3306/db1";
        String dbUserId = "testuser1";
        String dbPassword = "rlathdud5623";

        //DB에 접속하기 위한 5가지 단계
        //1. 드라이버 로드
        //2. DB 커넥션 객체 생성
        //3. SQL 스테이트먼트 객체 생성
        //4. 쿼리 실행
        //5. 결과 수행
        //6. 객체 연결 해제(close)

        //드라이버 로드
        try {
            Class.forName("org.mariadb.jdbc.Driver"); //예외처리: 감당이 되면 try catch로 처리, 감당 안되면 throw
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        //Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        //DB 커넥션 객체 생성
        try {
            /*Connection*/ connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            //SQL statement 객체 3가지
            /*Statement*/ //statement = connection.createStatement();
            //CallableStatement callableStatement = null;

            String sql = "DELETE FROM MEMBER" +
            " WHERE member_type = ? AND user_id = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, member.getMemberType());
            preparedStatement.setString(2, member.getUserId());

            /*ResultSet*/ //rs = statement.executeQuery(sql);
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("삭제 성공");
            } else {
                System.out.println("삭제 실패");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    // test
    }
}
