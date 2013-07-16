package zju.ccnt.tcm.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.hp.hpl.jena.ontology.OntModel;
import zju.ccnt.tcm.query.QueryManager;

public class Herbal {
	private ArrayList<FangjZy> herbalArray;
	
	public Herbal() {
		herbalArray = new ArrayList<FangjZy>();
		String mahuangtang = "麻黄9g,桂枝6g,杏仁6g,甘草3g";
		String guizhitang = "桂枝9g,芍药9g,甘草9g,生姜9g,大枣3枚";
		String xingsusan = "苏叶9g,半夏9g,茯苓9g,前胡9g,苦桔梗g,枳壳6g,甘草3g,大枣3枚,杏仁9g,橘皮6g";
		String yinqiaosan = "连翘一两,银花一两,苦桔梗6钱,薄荷6钱,竹叶4钱,生甘草5钱,芥穗4钱,淡豆豉5钱,牛蒡子6钱";
		String sangxingtang = "桑叶1钱,杏仁1钱5分,沙参2钱,象贝1钱,香豉1钱,橘皮1钱,梨皮1钱";
		String xiangruyin = "香薷2钱,银花3钱,鲜扁豆花3钱,厚朴2钱,连翘2钱";
		String longdanxiegan = "龙胆草酒炒6g,黄芩炒9g,栀子酒炒9g,泽泻12g,木通6g,当归酒炒3g,生地黄酒炒9g,柴胡6g,生甘草6g,车前子9g";
		String daochisan = "生地、木通、生甘草各6g,竹叶";
		String xiebaisan = "桑白皮2两,地骨皮2两,生甘草1两";
		String daihesan = "青黛30g,蛤壳300g";
		FangjZy fangjMH = new FangjZy("麻黄汤", mahuangtang, "伤寒论");
		FangjZy fangjGZ = new FangjZy("桂枝汤", guizhitang, "伤寒论");
		FangjZy fangjXS = new FangjZy("杏苏散", xingsusan, "温病条辨");
		FangjZy fangjYQ = new FangjZy("银翘散", yinqiaosan, "温病条辨");
		FangjZy fangjSX = new FangjZy("桑杏汤", sangxingtang, "温病条辨");
		FangjZy fangjXX = new FangjZy("新加香薷饮", xiangruyin, "温病条辨");
		FangjZy fangjLX = new FangjZy("龙胆泻肝汤",longdanxiegan, "医方集解");
		FangjZy fangjDC = new FangjZy("导赤散", daochisan, "小儿药证直诀");
		FangjZy fangjXB = new FangjZy("泻白散", xiebaisan, "杏苑");
		FangjZy fangjDH = new FangjZy("黛蛤散", daihesan, "中国药典");
		
		herbalArray.add(fangjMH);
		herbalArray.add(fangjGZ);
		herbalArray.add(fangjXS);
		herbalArray.add(fangjYQ);
		herbalArray.add(fangjSX);
		herbalArray.add(fangjXX);
		herbalArray.add(fangjLX);
		herbalArray.add(fangjDC);
		herbalArray.add(fangjXB);
		herbalArray.add(fangjDH);
		
	}
	public String getHerbal(String fangj) {
		String herbList = "";
		
		for (int i = 0; i < herbalArray.size(); i++) {
			if (herbalArray.get(i).getMedicine().equals(fangj)) {
				herbList = herbalArray.get(i).getZyArr();
				System.out.println(herbList);
				break;
			}
		}

		return herbList;
	}
}
