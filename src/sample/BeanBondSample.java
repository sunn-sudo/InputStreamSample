package sample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.DataBean;
import model.DataBond1Bean;
import model.DataBond2Bean;

/** 複数のBeanリスト結合サンプル */
public class BeanBondSample {

	public static void main(String[] args) {
		differentDataBond();
		SameDataBond();
	}

	static void differentDataBond() {
		// Beanリストの作成
		List<DataBond1Bean> dataBond1List = new ArrayList<DataBond1Bean>();
		List<DataBond2Bean> dataBond2List = new ArrayList<DataBond2Bean>();

		// DataBond1のデータ設定
		for (int i = 0; i < 10; i++) {
			DataBond1Bean dataBond1 = new DataBond1Bean();
			dataBond1.setId(String.valueOf(i));
			dataBond1.setMoney("1000");
			dataBond1List.add(dataBond1);
		}
		// DataBond2のデータ設定
		for (int i = 10; i < 20; i++) {
			DataBond2Bean dataBond2 = new DataBond2Bean();
			dataBond2.setId(String.valueOf(i));
			dataBond2.setMoney("1000");
			dataBond2List.add(dataBond2);
		}
		Collection<Object> DataBondResultList = Stream.concat(dataBond1List.stream(), dataBond2List.stream())
				.collect(Collectors.toList());

		// データの中身を表示する
		System.out.println("異なるBeanを一つのリストに格納した場合");
		DataBondResultList.forEach(list -> {
			System.out.println(list);
		});
	}

	static void SameDataBond() {
		// Beanリストの作成
		List<DataBean> dataList = new ArrayList<DataBean>();

		// Dataのデータ設定
		for (int i = 0; i < 10; i++) {
			DataBean dataBean = new DataBean();
			dataBean.setId("000" + String.valueOf(i));
			dataBean.setMoney("1000");
			dataList.add(dataBean);
		}

		// dataBean:Idを降順にして表示する
		Stream<DataBean> dataStremDesc = dataList.stream().sorted(Comparator.comparing(DataBean::getId).reversed());
		// dataBean:Idを昇順にして表示する
		Stream<DataBean> dataStremAsc = dataList.stream().sorted(Comparator.comparing(DataBean::getId));

		// データの中身を表示する
		System.out.println("Idが降順になっているか確認");
		dataStremDesc.forEach(list -> {
			System.out.println(list.getId());
		});
		System.out.println("Idが標準になっているか確認");
		dataStremAsc.forEach(list -> {
			System.out.println(list.getId());
		});
	}

}
