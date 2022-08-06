package sample;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

/** �t�@�C���쐬�����T���v�� */
public class OutputStreamSample {

	public static void main(String[] args) throws IOException, URISyntaxException {
		// �t�@�C���̒��g���L��
		String exampleString = "Hello World";
		InputStream inputStream = new ByteArrayInputStream(exampleString.getBytes(StandardCharsets.UTF_8));

		// �����点�̂��ߑ�ʂ̃t�@�C���𐶐�����
		for (int i = 0; i < 1000; i++) {
			// �t�@�C������
			FileOutputStream outputStream = new FileOutputStream(new File("�o�J" + i + "��.txt"));
			// �t�@�C���������ݏ���
			int mojiIndex;
			while ((mojiIndex = inputStream.read()) != -1) {
				char getSingleChar = (char) mojiIndex;
				outputStream.write(getSingleChar);
			}
		}
	}
}
