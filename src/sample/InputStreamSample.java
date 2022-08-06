package sample;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.DataBean;

/** �t�@�C���ǂݍ��ݏ����T���v�� */
public class InputStreamSample {

	public static void main(String[] args) {
		/* �t�@�C���ǂݍ��ݏ��� */
		InputStream fileStream = getFile();
		InputStreamReader fileStreamReader = new InputStreamReader(fileStream);
		Stream<String> streamOfString = new BufferedReader(fileStreamReader).lines();
		List<String> items = streamOfString.collect(Collectors.toList());

		/* �t�@�C���������� */
		List<List<String>> partitions = new ArrayList<List<String>>();
		int partitionSize = 10;
		for (int i = 0; i < items.size(); i += partitionSize) {
			partitions.add(items.subList(i, Math.min(i + partitionSize, items.size())));
		}
		System.out.println(partitions);

		/* �t�@�C�����ID�Ƌ��z�����z�Ǘ����f���ɐݒ肵�ċ��z�Ǘ����f�����X�g�ɒǉ����� */
		List<DataBean> dataList = new ArrayList<DataBean>();
		for(String item :partitions.get(0)) {
			// CSV���X�g�𐶐�����
			String[] csvList = item.split(","); 
			// ���z�Ǘ����f���𐶐�����
			DataBean data = new DataBean();
			data.setId(csvList[0]);
			data.setMoney(csvList[1]);
			dataList.add(data);
		};

		// ��������
		for (int index = 0; index < dataList.size(); index++) {
			System.out.println(dataList.get(index).getId());
			System.out.println(dataList.get(index).getMoney());
		}
	}

	/* �t�@�C���ǂݍ��ݏ��� */
	static InputStream getFile() {
		FileInputStream fileStream = null;
		try {
			fileStream = new FileInputStream("resource/data.csv");
		} catch (FileNotFoundException e) {
			// TODO �����������ꂽ catch �u���b�N
			e.printStackTrace();
		}
		return fileStream;
	}

	/* �t�@�C����ǂݍ���ŎQ�Ƃ�����@ */
	static void fileReder(InputStream file) {
		InputStreamReader fileStreamReader = new InputStreamReader(file);
		BufferedReader fileBufferedReader = new BufferedReader(fileStreamReader);
		String str;
		try {
			while ((str = fileBufferedReader.readLine()) != null) {
				System.out.println(str);
			}
		} catch (IOException e) {
			// TODO �����������ꂽ catch �u���b�N
			e.printStackTrace();
		}
	}

}
