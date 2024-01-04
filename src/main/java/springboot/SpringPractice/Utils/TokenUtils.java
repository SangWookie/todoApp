//package springboot.SpringPractice.Utils;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//import java.util.Date;
//
//public class TokenUtils {
//    private static final String SECRET_KEY = "secret";
//
//    public static String createToken(String userId) {
//        return Jwts.builder()
//                .setSubject(userId)
//                .setExpiration(new Date(System.currentTimeMillis() + 30 * 60 * 1000)) // 30분 만료
//                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
//                .compact();
//    }
//
//    public static boolean validateToken(String token) {
//        try {
//            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public static String createRefreshToken(String userId) {
//        return Jwts.builder()
//                .setSubject(userId)
//                .setExpiration(new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000)) // 1주일 만료
//                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
//                .compact();
//    }
//
//    public static boolean validateRefreshToken(String token) {
//        try {
//            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//}