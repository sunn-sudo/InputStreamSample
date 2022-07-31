package sample;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import model.DataBean;

public class InputStreamSample {

	public static void main(String[] args) {
		/* ファイル読み込み処理 */
		InputStream fileStream = getFile();

		/* ファイルよりIDと金額を金額管理モデルに設定して金額管理モデルリストに追加する */
		InputStreamReader fileStreamReader = new InputStreamReader(fileStream);
		Stream<String> streamOfString = new BufferedReader(fileStreamReader).lines();

		// TODO ファイル分割して一部を表示する

		// 金額管理モデルリストを生成する
		List<DataBean> dataList = new ArrayList<DataBean>();
		streamOfString.forEach(list -> {
			// CSVリストを生成する
			String[] csvList = list.split(",");
			// 金額管理モデルを生成する
			DataBean data = new DataBean();
			data.setId(csvList[0]);
			data.setMoney(csvList[1]);
			dataList.add(data);
		});

		// 処理結果
		for (int index = 0; index < dataList.size(); index++) {
			System.out.println(dataList.get(index).getId());
			System.out.println(dataList.get(index).getMoney());
		}
	}

	/* ファイル読み込み処理 */
	static InputStream getFile() {
		FileInputStream fileStream = null;
		try {
			fileStream = new FileInputStream("resource/data.csv");
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return fileStream;
	}

	/* ファイルを読み込んで参照する方法 */
	static void fileReder(InputStream file) {
		InputStreamReader fileStreamReader = new InputStreamReader(file);
		BufferedReader fileBufferedReader = new BufferedReader(fileStreamReader);
		String str;
		try {
			while ((str = fileBufferedReader.readLine()) != null) {
				System.out.println(str);
			}
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
