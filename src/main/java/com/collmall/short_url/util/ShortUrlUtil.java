package com.collmall.short_url.util;

import java.util.Random;
import java.util.UUID;

/**
 * Generator ShortUrl
 * 数据库中需要保存长链与短链之间的关系，通过访问短链跳转到长链接
 *
 * @version v1.0.0
 * @author:
 * Date: 2019-9-19 Time: 15:42
 */
public class ShortUrlUtil {

    public static String[] shortUrl(String url) {
        // 可以自定义生成 MD5 加密字符传前的混合 KEY
        String key = "wangyang";
        // 要使用生成 URL 的字符
        String[] chars = new String[]{"a", "b", "c", "d", "e", "f", "g", "h",
                "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
                "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
                "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H",
                "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
                "U", "V", "W", "X", "Y", "Z"
        };
        // 对传入网址进行 MD5 加密
        String sMD5EncryptResult = (Encript.md5(key + url));
        String hex = sMD5EncryptResult;
        String[] resUrl = new String[4];
        //得到 4组短链接字符串
        for (int i = 0; i < 4; i++) {
            // 把加密字符按照 8 位一组 16 进制与 0x3FFFFFFF 进行位与运算
            String sTempSubString = hex.substring(i * 8, i * 8 + 8);
            // 这里需要使用 long 型来转换，因为 Inteper .parseInt() 只能处理 31 位 , 首位为符号位 , 如果不用 long ，则会越界
            long lHexLong = 0x3FFFFFFF & Long.parseLong(sTempSubString, 16);
            String outChars = "";
            //循环获得每组6位的字符串
            for (int j = 0; j < 6; j++) {
                // 把得到的值与 0x0000003D 进行位与运算，取得字符数组 chars 索引(具体需要看chars数组的长度   以防下标溢出，注意起点为0)
                long index = 0x0000003D & lHexLong;
                // 把取得的字符相加
                outChars += chars[(int) index];
                // 每次循环按位右移 5 位
                lHexLong = lHexLong >> 5;
            }
            // 把字符串存入对应索引的输出数组
            resUrl[i] = outChars;
        }
        return resUrl;
    }

    /**
     * 生成7位的短连接
     */
    public static String shortUrl2() {

        /** 网址长度为7 */
        final int LENGTH = 7;

        /** 每右移5位，生成一个字符 */
        final int PER_VARCHAR = 5;

        char[] c = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
                'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
                'V', 'W', 'X', 'Y', 'Z' };

        // 2的35次方，每五位一个字符，可生成7个字符
        // 11111111111111111111111111111111111
        long long16 = (long) Math.pow(2, PER_VARCHAR * LENGTH) - 1;

        String a = UUID.randomUUID().toString().replace("-", "");

        // 生成随机数，使之成为35长度
        // 每8字符=32位，加3位=111
        Random random = new Random();
        int nextInt = random.nextInt(8);

        int subIndexStart = 0;
        StringBuffer sb = new StringBuffer();
        while (subIndexStart < a.length()) {
            // 8位一组，使用16进行转换，可转换成 4*8=32长度二进制
            String substring = a.substring(subIndexStart, subIndexStart += 8);
            long parseLong = Long.parseLong(nextInt + substring, 16);
            long x = long16 & parseLong;
            for (int j = 0; j < LENGTH; j++) {
                long x2 = (c.length - 1) & x;
                sb.append(c[(int) x2]);
                x = x >> PER_VARCHAR;
            }
            System.out.println(sb);
        }
        return  sb.toString();
    }
}