package ibm.com.core.main;

import ibm.com.core.pojo.AccessToken;
import ibm.com.core.pojo.Button;
import ibm.com.core.pojo.CommonButton;
import ibm.com.core.pojo.ComplexButton;
import ibm.com.core.pojo.Menu;
import ibm.com.core.pojo.ViewButton;
import ibm.com.core.util.WeixinUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 菜单管理器类
 * 
 * @author zoufan
 * @date 2014-04-04
 */
public class MenuManager {
	private static Logger log = LoggerFactory.getLogger(MenuManager.class);

	public static void main(String[] args) {
		// 第三方用户唯一凭证
		String appId = "1756abc40dda41209a1c10f2bfe96b6c";
		// 第三方用户唯一凭证密钥
		String appSecret = "3188178c98d246fa8b330e0ee8dfbb5e";

		// 调用接口获取access_token
		AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);

		if (null != at) {
			
			// 调用接口创建菜单
			int result = WeixinUtil.createMenu(getMenu(), at.getToken());

			// 判断菜单创建结果
			if (0 == result){
				log.info("菜单创建成功！");
				System.out.println("菜单创建成功！");
			}
				
			else{
				log.info("菜单创建失败，错误码：" + result);
				System.out.println("菜单创建失败，错误码：" + result);
			}
//			// 调用接口删除菜单
//			int result = WeixinUtil.deleteMenu(at.getToken());
//			
//			// 判断菜单删除结果
//			if (0 == result){
//				log.info("菜单删除成功！");
//				System.out.println("菜单删除成功！");
//			}
//				
//			
//			else{
//				log.info("菜单删除失败，错误码：" + result);
//				System.out.println("菜单删除失败，错误码：" + result);
//			}
				
		}
	}

	/**
	 * 组装菜单数据
	 * 
	 * @return
	 */
	private static Menu getMenu() {

		ViewButton btn11 = new ViewButton();
		btn11.setName("营销查询");
		btn11.setType("view");
		btn11.setUrl("http://zoufan.duapp.com/promoList.html");

		ViewButton btn12 = new ViewButton();
		btn12.setName("套餐查询");
		btn12.setType("view");
		btn12.setUrl("http://zoufan.duapp.com/taocanList.html");

		ViewButton btn13 = new ViewButton();
		btn13.setName("工单查询");
		btn13.setType("view");
		btn13.setUrl("http://zoufan.duapp.com/search.html");

		CommonButton btn21 = new CommonButton();
		btn21.setName("自助服务");
		btn21.setType("click");
		btn21.setKey("21");

		CommonButton btn31 = new CommonButton();
		btn31.setName("联系我们");
		btn31.setType("click");
		btn31.setKey("31");

		/**
		 * CommonButton btn12 = new CommonButton(); btn12.setName("公交查询");
		 * btn12.setType("click"); btn12.setKey("12");
		 * 
		 * CommonButton btn13 = new CommonButton(); btn13.setName("周边搜索");
		 * btn13.setType("click"); btn13.setKey("13");
		 * 
		 * CommonButton btn14 = new CommonButton(); btn14.setName("历史上的今天");
		 * btn14.setType("click"); btn14.setKey("14");
		 * 
		 * CommonButton btn21 = new CommonButton(); btn21.setName("歌曲点播");
		 * btn21.setType("click"); btn21.setKey("21");
		 * 
		 * CommonButton btn22 = new CommonButton(); btn22.setName("经典游戏");
		 * btn22.setType("click"); btn22.setKey("22");
		 * 
		 * CommonButton btn23 = new CommonButton(); btn23.setName("美女电台");
		 * btn23.setType("click"); btn23.setKey("23");
		 * 
		 * CommonButton btn24 = new CommonButton(); btn24.setName("人脸识别");
		 * btn24.setType("click"); btn24.setKey("24");
		 * 
		 * CommonButton btn25 = new CommonButton(); btn25.setName("聊天唠嗑");
		 * btn25.setType("click"); btn25.setKey("25");
		 * 
		 * CommonButton btn31 = new CommonButton(); btn31.setName("Q友圈");
		 * btn31.setType("click"); btn31.setKey("31");
		 * 
		 * ViewButton btn32 = new ViewButton(); btn32.setName("使用帮助");
		 * btn32.setType("view");
		 * btn32.setUrl("http://liufeng.gotoip2.com/xiaoqrobot/help.jsp");
		 * 
		 * CommonButton btn33 = new CommonButton(); btn33.setName("幽默笑话");
		 * btn33.setType("click"); btn33.setKey("33");
		 **/
		ComplexButton mainBtn1 = new ComplexButton();
		mainBtn1.setName("查询助手");
		mainBtn1.setSub_button(new Button[] { btn11, btn12, btn13 });

		/**
		 * ComplexButton mainBtn2 = new ComplexButton();
		 * mainBtn2.setName("休闲驿站"); mainBtn2.setSub_button(new CommonButton[] {
		 * btn21, btn22, btn23, btn24, btn25 });
		 * 
		 * ComplexButton mainBtn3 = new ComplexButton();
		 * mainBtn3.setName("更多体验"); mainBtn3.setSub_button(new Button[] {
		 * btn31, btn32, btn33 });
		 **/

		/**
		 * 
		 * 在某个一级菜单下没有二级菜单的情况，menu该如何定义呢？<br>
		 * 比如，第三个一级菜单项不是“更多体验”，而直接是“幽默笑话”，那么menu应该这样定义：<br>
		 * menu.setButton(new Button[] { mainBtn1, mainBtn2, btn33 });
		 */
		Menu menu = new Menu();
		menu.setButton(new Button[] { mainBtn1, btn21, btn31 });

		return menu;
	}
}