package cn.itsource.ssm.util;

import cn.itsource.ssm.domain.Condition;

public class GetSQLUtil {

	public static String getSQL(String sql, Condition con, Boolean flag) {
		//拼接字符串
		//判断是前台还是后台
		StringBuffer sb = new StringBuffer();
		sb.append(sql);
		if (con.getFlag()) {
			//为true代表前台
			sb.append("where isenabled=true");
			//首先确定职位的搜索
			String title = con.getTitle();
			if (title != null) {
				title = title.trim();
				//当字符串不为0，就表示输入了职位
				if (title.length() != 0) {
					sb.append(" and title like '%").append(title).append("%' ");
				}
			}
			//判断工作时间
			Integer time = con.getWorkingTime();
			if (time == 2) {
				//time为2的时候是全职
				sb.append(" and positiontype=true ");
			} else if (time == 3) {
				sb.append(" and positiontype=true ");
			}
		}

		//flag为true代表需要拼接limit false代表查询的可能是总数
		if (flag) {
			sb.append(" limit ?,? ");
		}

		return sb.toString();
	}
}
