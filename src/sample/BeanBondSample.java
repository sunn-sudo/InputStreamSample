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

/** ������Bean���X�g�����T���v�� */
public class BeanBondSample {

	public static void main(String[] args) {
		differentDataBond();
		SameDataBond();
	}

	static void differentDataBond() {
		// Bean���X�g�̍쐬
		List<DataBond1Bean> dataBond1List = new ArrayList<DataBond1Bean>();
		List<DataBond2Bean> dataBond2List = new ArrayList<DataBond2Bean>();

		// DataBond1�̃f�[�^�ݒ�
		for (int i = 0; i < 10; i++) {
			DataBond1Bean dataBond1 = new DataBond1Bean();
			dataBond1.setId(String.valueOf(i));
			dataBond1.setMoney("1000");
			dataBond1List.add(dataBond1);
		}
		// DataBond2�̃f�[�^�ݒ�
		for (int i = 10; i < 20; i++) {
			DataBond2Bean dataBond2 = new DataBond2Bean();
			dataBond2.setId(String.valueOf(i));
			dataBond2.setMoney("1000");
			dataBond2List.add(dataBond2);
		}
		Collection<Object> DataBondResultList = Stream.concat(dataBond1List.stream(), dataBond2List.stream())
				.collect(Collectors.toList());

		// �f�[�^�̒��g��\������
		System.out.println("�قȂ�Bean����̃��X�g�Ɋi�[�����ꍇ");
		DataBondResultList.forEach(list -> {
			System.out.println(list);
		});
	}

	static void SameDataBond() {
		// Bean���X�g�̍쐬
		List<DataBean> dataList = new ArrayList<DataBean>();

		// Data�̃f�[�^�ݒ�
		for (int i = 0; i < 10; i++) {
			DataBean dataBean = new DataBean();
			dataBean.setId("000" + String.valueOf(i));
			dataBean.setMoney("1000");
			dataList.add(dataBean);
		}

		// dataBean:Id���~���ɂ��ĕ\������
		Stream<DataBean> dataStremDesc = dataList.stream().sorted(Comparator.comparing(DataBean::getId).reversed());
		// dataBean:Id�������ɂ��ĕ\������
		Stream<DataBean> dataStremAsc = dataList.stream().sorted(Comparator.comparing(DataBean::getId));

		// �f�[�^�̒��g��\������
		System.out.println("Id���~���ɂȂ��Ă��邩�m�F");
		dataStremDesc.forEach(list -> {
			System.out.println(list.getId());
		});
		System.out.println("Id���W���ɂȂ��Ă��邩�m�F");
		dataStremAsc.forEach(list -> {
			System.out.println(list.getId());
		});
	}

}
