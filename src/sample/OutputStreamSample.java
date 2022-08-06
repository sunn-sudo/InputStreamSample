package sample;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;

/** ファイル作成処理サンプル */
public class OutputStreamSample {

	public static void main(String[] args) throws IOException, URISyntaxException {
		OutputStreamSample001();
		OutputStreamSample002();
	}

	/**
	 * 手法１
	 * 
	 * @throws IOException
	 */
	private static void OutputStreamSample001() throws IOException {
		// ファイルの中身を記載
		String exampleString = "Hello World";
		InputStream inputStream = new ByteArrayInputStream(exampleString.getBytes(StandardCharsets.UTF_8));

		// 嫌がらせのため大量のファイルを生成する
		for (int i = 0; i < 100; i++) {
			// ファイル生成
			FileOutputStream outputStream = new FileOutputStream(new File("バカ" + i + "号.txt"));
			// ファイル書き込み処理
			int mojiIndex;
			while ((mojiIndex = inputStream.read()) != -1) {
				char getSingleChar = (char) mojiIndex;
				outputStream.write(getSingleChar);
			}
		}
	}

	/**
	 * 手法2
	 * 
	 * @throws IOException
	 */
	private static void OutputStreamSample002() throws IOException {
		// ファイルの中身を記載
		String exampleString = "Hello World";
		InputStream inputStream = IOUtils.toInputStream(exampleString);

		// 嫌がらせのため大量のファイルを生成する
		for (int i = 100; i < 200; i++) {
			// ファイル生成
			FileOutputStream outputStream = new FileOutputStream(new File("バカ" + i + "号.txt"));
			// ファイル書き込み処理
			int mojiIndex;
			while ((mojiIndex = inputStream.read()) != -1) {
				char getSingleChar = (char) mojiIndex;
				outputStream.write(getSingleChar);
			}
		}
	}
}
