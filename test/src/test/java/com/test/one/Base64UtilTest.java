package com.test.one;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class Base64UtilTest {

	private static final String SIGN_ALGORITHMS = null;


	/**
	 * java.util.Base64
	 * @throws UnsupportedEncodingException 
	 */
	//Basic编码：是标准的BASE64编码，用于处理常规的需求
	@Test
	public void testBasic64Code() throws UnsupportedEncodingException{
		// 编码
		String asB64 = Base64.getEncoder().encodeToString("some string".getBytes("utf-8"));
		System.out.println(asB64); // 输出为: c29tZSBzdHJpbmc=
		// 解码
		byte[] asBytes = Base64.getDecoder().decode("c29tZSBzdHJpbmc=");
		System.out.println(new String(asBytes, "utf-8")); // 输出为: some string
	}

	//URL编码：使用下划线替换URL里面的反斜线“/”
	@Test
	public void testURLCode() throws UnsupportedEncodingException{
		String urlEncoded = Base64.getUrlEncoder().encodeToString("subjects?abcd".getBytes("utf-8"));
		System.out.println("Using URL Alphabet: " + urlEncoded);
		// 输出为:
		//		Using URL Alphabet: c3ViamVjdHM_YWJjZA==

	}

	//MIME编码：使用基本的字母数字产生BASE64输出，而且对MIME格式友好：每一行输出不超过76个字符，而且每行以“\r\n”符结束。
	@Test
	public void testMIMECode() throws UnsupportedEncodingException{
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < 10; ++t) {
			sb.append(UUID.randomUUID().toString());
		}
		byte[] toEncode = sb.toString().getBytes("utf-8");
		String mimeEncoded = Base64.getMimeEncoder().encodeToString(toEncode);
		System.out.println(mimeEncoded);
	}

	/**
	 * 第三方实现Base64的API
		首先便是常用的Apache Commons Codec library里面的org.apache.commons.codec.binary.Base64；

		第二个便是Google Guava库里面的com.google.common.io.BaseEncoding.base64() 这个静态方法；

		第三个是net.iharder.Base64，这个jar包就一个类；

		最后一个，号称Base64编码速度最快的MigBase64，而且是10年前的实现，到现在是否能保持这个称号，测一测便知道；
	 */

	//Base64编码性能测试

	/**
	 * 上面讲了一共7种实现Base64编码，Jdk里面3种，第三方实现4种，一旦有选择，则有必要将他们进行一次高低对比，性能测试是最直接的方式

		首先来定义两个接口
	 */
	private static interface Base64Codec
	{
		public String encode(final byte[] data);
		public byte[] decode(final String base64) throws IOException;
	}
	private static interface Base64ByteCodec
	{
		public byte[] encodeBytes(final byte[] data);
		public byte[] decodeBytes(final byte[] base64) throws IOException;
	}
	// 两个接口区别就是其中一个接口方法参数接收byte数组，返回byte数组，因为byte->byte相比String->byte或者byte->String性能上会快一点，所以区分两组来测试
	//    private static final Base64Codec[] m_codecs = { new GuavaImpl(), new JavaXmlImpl(),
	//            new Java8Impl(), new SunImpl(), new ApacheImpl(),new MiGBase64Impl(),new IHarderImpl() };
	//    private static final Base64ByteCodec[] m_byteCodecs = {
	//            new ApacheImpl(), new Java8Impl(),new MiGBase64Impl(),new IHarderImpl() };

}